import java.util.*;

public class Main{
	public static void main(String[] args){
		UnParse parser = new UnParse(args[0]);
		HashMap<Integer,Man> takenMen = new HashMap<Integer,Man>();
		HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		Stack<Man> freeMen = parser.getFreeMen();
		HashMap<Integer,HashMap<Integer,Integer>> women = parser.getWomen();
		int nbrOfPairs = parser.getNbrOfPairs();	

		while(!freeMen.isEmpty()){
			Man man = freeMen.pop();
			takenMen.put(man.getId(), man);
			int idW = man.pop();
			if(!pairs.containsKey(idW)){
				pairs.put(idW, man.getId());
			} else {				//The woman is already paired
				int currentMan = pairs.get(idW);
				int potientialMan = man.getId();
				HashMap<Integer,Integer> wPrefList = women.get(idW);
				int prioCurrent = wPrefList.get(currentMan);
				int prioPotiential = wPrefList.get(potientialMan);
				if(prioCurrent < prioPotiential){ //The current is more prioritized
					freeMen.push(man);	//Return the man to the avaliable stack
					takenMen.remove(man.getId());
				} else {
					int oldManId = pairs.get(idW);					
					Man oldMan = takenMen.get(oldManId);					
					freeMen.push(oldMan);
					takenMen.remove(oldManId);
					pairs.remove(idW);
					pairs.put(idW,man.getId());
				}
			}
		}
		for(int i=2; i<=nbrOfPairs*2; i+=2){
			System.out.println("Women number: " + i + " Is with man number: " + pairs.get(i));
		}
	}
}