package backEnd;

import java.util.ArrayList;
import java.util.Collections;

public class TODOManager {
	
	private ArrayList<TODO> thingsTODO;
	
	public TODOManager(){
		thingsTODO = new ArrayList<TODO>();
	}
	
	public void addThingTODO(TODO t){
		thingsTODO.add(t);
	}
	
	public ArrayList<TODO> sortList(){
		Collections.sort(thingsTODO);
		return thingsTODO;
	}

}
