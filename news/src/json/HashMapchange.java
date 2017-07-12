package json;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapchange {
	public static String hashMapToJson(HashMap map) {  
		 String string = "{"; 
	        for (Iterator it = map.entrySet().iterator(); it.hasNext();) { 
	            Entry e = (Entry) it.next(); 
	            string += "'" + e.getKey() + "':"; 
	            string += "'" + e.getValue() + "',";
	            
	        } 
	        string = string.substring(0, string.lastIndexOf(",")); 
	        string += "}"; 
	        //System.out.println("zhi"+string);
	        return string;  
	}  
}
