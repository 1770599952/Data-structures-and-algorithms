package algorithms;

import java.util.*;

public class Solution_15 {
    public static void main(String[] args) {
        System.out.println(Math.abs(-1));
    }

    public static int[][] kClosest(int[][] points, int K) {
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double length = Math.sqrt(Math.abs(x) * Math.abs(x) + Math.abs(y) * Math.abs(y));
            map.put(i, length);
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            //升序排序
            @Override
            public int compare(Map.Entry<Integer, Double> o1,
                               Map.Entry<Integer, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            Map.Entry<Integer, Double> entry = list.get(i);
            result[i][0] = points[entry.getKey()][0];
            result[i][1] = points[entry.getKey()][1];
        }

        return result;
    }
}
