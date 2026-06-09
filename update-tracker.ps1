# git 이력 기반 주간 풀이 수 집계 후 README.md 트래커 표 갱신

$rawLog = git log --pretty=format:"===DATE:%ad" --date=format:"%Y-%m-%d" --diff-filter=A --name-only -- "src/"

$currentDate = $null
$weekData = [System.Collections.Generic.SortedDictionary[string, hashtable]]::new()

foreach ($line in $rawLog) {
    if ($line -match "^===DATE:(\d{4}-\d{2}-\d{2})$") {
        $currentDate = [datetime]::ParseExact($Matches[1], "yyyy-MM-dd", $null)
    }
    elseif ($line -match "^src/.+\.java$") {
        $filename = [System.IO.Path]::GetFileName($line)
        # 제외: module-info.java, _ver02 스타일, 끝자리 숫자 (대체풀이) 파일
        if ($filename -eq "module-info.java") { continue }
        if ($filename -match "_ver\d+\.java$") { continue }
        if ($filename -match "[a-zA-Z]\d+\.java$") { continue }

        $dow = [int]$currentDate.DayOfWeek
        if ($dow -eq 0) { $dow = 7 }
        $monday = $currentDate.AddDays(1 - $dow)
        $key = $monday.ToString("yyyy-MM-dd")

        if (-not $weekData.ContainsKey($key)) {
            $weekData[$key] = @{ Monday = $monday; Sunday = $monday.AddDays(6); Count = 0 }
        }
        $weekData[$key].Count++
    }
}

# 이번 주가 없으면 0으로 추가
$today = [datetime]::Today
$dow = [int]$today.DayOfWeek
if ($dow -eq 0) { $dow = 7 }
$thisMonday = $today.AddDays(1 - $dow)
$thisKey = $thisMonday.ToString("yyyy-MM-dd")
if (-not $weekData.ContainsKey($thisKey)) {
    $weekData[$thisKey] = @{ Monday = $thisMonday; Sunday = $thisMonday.AddDays(6); Count = 0 }
}

# 표 생성
$tableLines = @(
    "| 주차 | 기간 | 풀이 수 | 달성 여부 | 누적 |"
    "|------|------|---------|----------|------|"
)

$weekNum = 1
$total = 0
foreach ($entry in $weekData.GetEnumerator()) {
    $w = $entry.Value
    $count = $w.Count
    $total += $count
    $period = "$($w.Monday.ToString('MM/dd')) ~ $($w.Sunday.ToString('MM/dd'))"

    if ($entry.Key -eq $thisKey) {
        $status = if ($count -ge 5) { "✅ 달성" } else { "🔄 진행중 ($count/5)" }
    } else {
        $status = if ($count -ge 5) { "✅ 달성" } else { "❌ 미달성" }
    }

    $tableLines += "| $($weekNum)주차 | $period | $count | $status | $total |"
    $weekNum++
}

$newTable = $tableLines -join "`n"

# README.md 마커 사이 교체
$readme = Get-Content "README.md" -Raw -Encoding UTF8
$updated = $readme -replace "(?s)(<!-- TRACKER_START -->).*?(<!-- TRACKER_END -->)", "<!-- TRACKER_START -->`n$newTable`n<!-- TRACKER_END -->"
[System.IO.File]::WriteAllText((Resolve-Path "README.md"), $updated, [System.Text.Encoding]::UTF8)

Write-Host "트래커 업데이트 완료!"
foreach ($entry in $weekData.GetEnumerator()) {
    $w = $entry.Value
    Write-Host "  $($entry.Key) ($($w.Monday.ToString('MM/dd'))~$($w.Sunday.ToString('MM/dd'))): $($w.Count)문제"
}
