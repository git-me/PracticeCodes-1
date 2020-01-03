import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMap {
    public static void main(String[] args) {
   Map<String,Integer> mp=new HashMap<>();
        mp.put("1",2);
        mp.put("451",300);
        mp.put("678",674);
        mp.put("909",543);
        mp.put("88",278);
        mp.put("49",78);
        mp.put("234",0);
        mp.put("89",6);
        mp.put("21",90);
        mp.put("112",4);
        //if we declare this map as : "Map m" then e.getKey, e.getValue will not work since they work on type inference
        System.out.println(" --------------------------------------------------------------------------------------------------");
        System.out.println("sorting on basis of reverse value order  using java 8");
        System.out.println(" --------------------------------------------------------------------------------------------------");
        Map<String,Integer> m=sortMapByValue(mp);
        m.entrySet().stream().forEach(e->{System.out.println("key : " +e.getKey()+ "  value : " + e.getValue());});
        System.out.println(" --------------------------------------------------------------------------------------------------");
        System.out.println("sorting on basis of natural key order using java 8");
       System.out.println(" --------------------------------------------------------------------------------------------------");
        Map<String,Integer> mk=sortMapByKey(mp);
        mk.entrySet().stream().forEach(e->{
            System.out.println("key : "+ e.getKey()+ "  value : "+ e.getValue());
        });


    }

    public static Map<String,Integer> sortMapByValue(Map<String, Integer> map){
        LinkedHashMap<String, Integer> collect = map.entrySet().stream().sorted(Map.Entry
                .comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return collect;
    }
    public static Map<String,Integer> sortMapByKey(Map<String, Integer> map){
        LinkedHashMap<String, Integer> collect = map.entrySet().stream().sorted(Map.Entry
                .comparingByKey(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return collect;
    }
}