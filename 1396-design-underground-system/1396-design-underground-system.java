import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private Map<Integer, CheckInData> checkIns;


    private Map<String, double[]> trips;

   
    static class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkIns.get(id);

        String key = data.station + "," + stationName;
        double travelTime = t - data.time;

        if (!trips.containsKey(key)) {
            trips.put(key, new double[]{0, 0});
        }

        double[] info = trips.get(key);

        
        info[0] += travelTime;

       
        info[1]++;

       
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "," + endStation;

        double[] info = trips.get(key);

        return info[0] / info[1];
    }
}