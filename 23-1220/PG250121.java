import java.util.*;
/**
 * PG_250121
 */
class PG_250121 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 컬럼들 순서랑 컬럼명 매핑시킬 수 있는 값 필요하니까 맵 사용
        Map<String, Integer> colum = new HashMap<>();
        colum.put("code", 0);
        colum.put("date", 1);
        colum.put("maximum", 2);
        colum.put("remain", 3);

        // filter랑 정렬 람다식 사용하려면 stream으로 변경
        // 후 다시 2차원 배열로 변경 toArray(int[][]::new)
        int[][] answer = Arrays.stream(data).filter((d)->d[colum.get(ext)] < val_ext).toArray(int[][]::new);
        Arrays.sort(answer, (a, b) -> a[colum.get(sort_by)] - b[colum.get(sort_by)]);

        return answer;
    }
}