package day14;

import java.util.Arrays;

public class CheapestFlightInKStops {
    public static int findCheapestPrice(int size, int[][] flights, int src, int dst, int stops) {
        // Distance array: dist[i] = min cost to reach city i
        int[] dist = new int[size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        // Relax edges up to k+1 times (because k stops means k+1 edges)
        for (int i = 0; i <= stops; i++) {
            int[] temp = Arrays.copyOf(dist, size);
            for (int[] flight : flights) {
                int cs = flight[0], cd = flight[1], cost = flight[2];
                if (dist[cs] != Integer.MAX_VALUE && dist[cs] + cost < temp[cd]) 
                    temp[cd] = dist[cs] + cost;
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE? -1 : dist[dst];
    }
    public static void main(String[] args) {
        System.out.println(findCheapestPrice(4, new int[][]{
            {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}
        }, 0, 3, 1));
    }
}
