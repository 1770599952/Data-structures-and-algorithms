package map;

import java.util.HashMap;

public class MyHashSet {

    private HashMap map = new HashMap();
    private Object objValue = new Object();

    public Object add(Object data) {
        return map.put(data, objValue);
    }
}
