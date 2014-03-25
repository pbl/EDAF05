INITIALIZE S to empty matching.
WHILE (some man m is unmatched and hasn't proposed to every woman)
 w ← ﬁrst woman on m's list to whom m has not yet proposed.
 IF (w is unmatched)
Add pair m–w to matching S.
ELSE IF (w prefers m to her current partner m')
Remove pair m'–w from matching S.
Add pair m–w to matching S.
ELSE
w rejects m.
RETURN stable matching S


public class Matching{
	public Stack<Stack> freeMen = new Stack<Stack>();
	public Stack<Integer> rossPrefList = new Stack<Integer>;
	public Stack<Integer> chandlerPrefList = new Stack<Integer>;
	public Stack<Integer> joeyPrefList = new Stack<Integer>;
	rossPrefList.push(2);
	rossPrefList.push(4);
	rossPrefList.push(6);
	chandlerPrefList.push(4);
	chandlerPrefList.push(6);
	chandlerPrefList.push(2);
	joeyPrefList.push(2);
	joeyPrefList.push(4);
	joeyPrefList.push(6);

	freeMen.push
		



	public static void main(String[] args){
		HashMap<Integer,Man> takenMen = new HashMap<Integer,Man>();		
		while(!freeMan.isEmpty()){
			Man man = freeMan.pop();
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
				if(prioCurrent > prioPotiential){ 
					freeMan.push(man);	//Return the man to the avaliable stack
					takenMen.remove(man.getId());
				} else {
					int oldManId = pairs.get(idW);					
					Man oldMan = takenMen.get(oldManId);					
					freeMan.push(oldMan);
					takenMen.remove(oldManId;
					pairs.remove(idW);
					pairs.put(idW,man.getId());
				}
			}
		}
		for(int )
	}
}