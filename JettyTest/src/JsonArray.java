import java.util.*;


public class JsonArray extends Vector<String> {

	/**
	 * @param args
	 */
	
	public void addString(String element){
		this.addElement("\"" + element + "\"");
		
	}
	
	public void addNumber(String element){
		this.addElement(element);
	}
	
	public void addBoolean(String b){
		this.addElement(b);
	}
	
	public void addJson(JsonArray array){
		this.addElement(array.toString());
	}
	
	public void addJson(JsonMap map){
		this.addElement(map.toString());
	}
	
	JsonArray(){
		
	}
	
	JsonArray(String[] a){
		for(int i = 0; i < a.length; i++ ){
			this.addString(a[i]);
		}
		
	}
	
}
