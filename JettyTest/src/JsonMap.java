import java.util.*;


public class JsonMap extends HashMap<String,String>
{
	JsonMap()
	{
	}
	
	public void addNumber(String key, String value){
		this.put(key, value);
	}
	
	public void addString(String key, String value ){
		this.put(key,"\"" + value + "\"");
	}
	
	public void addJsonMap(String key, String value ){
		this.put(key, value);
	}
	
	public void addJsonMap(String key, JsonMap value ){
		this.put(key, value.toString());
	}

	public void addJsonArray(String key, String value){
		this.put(key, value);
	}
	
	public void addJsonArray(String key, JsonArray value){
		this.put(key, value.toString());
	}
	
	
	public String toString()
	{
		String res = new String ("{ ");
		
		Set<String> keySet = this.keySet();

		Iterator<String> iter = keySet.iterator();
		
		boolean begin = true;
		
		while(iter.hasNext()){
			if (!begin)
				res += ",";
			String key = new String(iter.next());
			res += " \"" + key +"\"";
			res += " : " + this.get(key);
			begin = false;
		}
		res += " }";
		return res;
	}
}

