package day6;

public class MinTimeBusTrip {
    public static long minTime(int[] arr, int trips){
        long left = 1, right = Long.MAX_VALUE, mid = 0, res = 0;
        while(left<=right){
            mid = left + (right - left)/2;
            if(check(arr,trips, mid)) {res = mid; right = mid-1;}
            else left = mid+1;
        }
        return res;
    }
    public static boolean check(int[] arr, int trips, long time){
        long cTrips = 0;
        for(int each:arr){
            cTrips += time/each;
            if(cTrips>=trips) return true;
        }
        return cTrips>=trips;
    }
    public static void main(String[] args) {
        System.out.println(minTime(new int[]{1,2,3}, 5));
        System.out.println(minTime(new int[]{2}, 1));
    }
}
