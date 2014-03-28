		import java.util.*;
		import java.io.*;

		public class Main{
			public static void main(String[] args){
				UnParse parser = null;
				try{
				parser = new UnParse(args[0]);
		}

			catch(IOException e){
					System.exit(0);
		}
				HashMap<Integer,Man> takenMen = new HashMap<Integer,Man>();
				HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();
				Stack<Man> freeMen = parser.getFreeMen();
				HashMap<Integer,HashMap<Integer,Integer>> women = parser.getWomen();
				int nbrOfPairs = parser.getNbrOfPairs();
				HashMap<Integer,String> names = parser.getNames();	

				while(!freeMen.isEmpty()){
					Man man = freeMen.pop();
					takenMen.put(man.getId(), man);
					int idW = man.getNextWomanId();
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

				int[] printVector = new int[nbrOfPairs*2 + 1];
				for(int i=2; i<=nbrOfPairs*2; i+=2){
					int idM = pairs.get(i);
					printVector[idM] = idM;
					printVector[idM +1] = i;

				}


				for(int i=1; i<=nbrOfPairs*2; i+=2){
					System.out.println(names.get(printVector[i]) + " -- " + names.get(printVector[i+1]));
				}	
		}
		}