class TimeMap {
    class Pair{
        int timestamp;
        String value;
        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    HashMap<String, ArrayList<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        ArrayList<Pair> list = map.get(key);
        int left = 0, right = list.size()-1;
        String str = "";
        while(left<=right){
            int mid = left + (right-left)/2;
            if(list.get(mid).timestamp <= timestamp){
                str = list.get(mid).value;
                left = mid+1;
            }
            else
                right = mid-1;
        }
        return str;
    }
    
}
