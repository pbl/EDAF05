import java.util.*;

public class Main{
		//Ide, skapa en nxn matris som anvands for alla operationer, hmm
	public static void main(String[] args){
		HashMap<Integer,Man> takenMen = new HashMap<Integer,Man>();
		HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();		
		int n = 3;

		Stack<Integer> prefList1 = new Stack<Integer>();
		prefList1.push(2);
		prefList1.push(4);
		prefList1.push(6);
		Man man1 = new Man(1, prefList1);

		Stack<Integer> prefList2 = new Stack<Integer>();
		prefList2.push(4);
		prefList2.push(6);
		prefList2.push(2);
		Man man2 = new Man(3, prefList2);

		Stack<Integer> prefList3 = new Stack<Integer>();
		prefList3.push(2);
		prefList3.push(4);
		prefList3.push(6);
		Man man3 = new Man(5, prefList3);

		Stack<Man> freeMen = new Stack<Man>();
		freeMen.push(man1);
		freeMen.push(man2);
		freeMen.push(man3);

		HashMap<Integer,Integer> wPrefList1 = new HashMap<Integer,Integer>();
		wPrefList1.put(3, 1);
		wPrefList1.put(5, 2);
		wPrefList1.put(1, 3);

		HashMap<Integer,Integer> wPrefList2 = new HashMap<Integer,Integer>();
		wPrefList2.put(5, 1);
		wPrefList2.put(1, 2);
		wPrefList2.put(3, 3);

		HashMap<Integer,Integer> wPrefList3 = new HashMap<Integer,Integer>();
		wPrefList3.put(1, 1);
		wPrefList3.put(5, 2);
		wPrefList3.put(3, 3);

		HashMap<Integer,HashMap<Integer,Integer>> women = new HashMap<Integer,HashMap<Integer,Integer>>();
		women.put(2,wPrefList1);
		women.put(4,wPrefList2);
		women.put(6,wPrefList3);

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
		for(int i=2; i<=n*2; i+=2){
			System.out.println("Women number: " + i + " Is with man number: " + pairs.get(i));
		}
	}
}