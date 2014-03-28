	import java.util.*;
	import java.io.*;
	public class UnParse{
		int nbrOfPairs;
		Stack<Man> freeMen;
		HashMap<Integer,HashMap<Integer,Integer>> women;
		HashMap<Integer, String> names;

		public UnParse(String fileName) throws IOException{
			names = new HashMap<Integer, String>();
			freeMen = new Stack<Man>();
			women = new HashMap<Integer,HashMap<Integer,Integer>>();
			BufferedReader scan = null;
			try {
				scan = new BufferedReader(new FileReader(fileName));
			} catch (FileNotFoundException e) {
				System.err.println("Filen kunde inte hittas");
				System.exit(1);
			}
			int id = 0;
				String line = scan.readLine();
				while(line.startsWith("#")){
					line = scan.readLine();
				}			
				
					nbrOfPairs = Integer.parseInt(line.split("=")[1]);
					int personNumber = 0;
					for(int i=0; i<nbrOfPairs*2; i++){
						line = scan.readLine();
						personNumber++;
						String[] name = line.split(" ");
						names.put(personNumber, name[1]);
					}
				scan.readLine();
				for(int k=0; k<nbrOfPairs*2; k++){
					line = scan.readLine();
					id++;
					String[] prefList = line.split(" ");
					if(id%2 == 1){						
						Stack<Integer> mPref = new Stack<Integer>();
						for(int i=nbrOfPairs;i>0;i--){
							mPref.push(Integer.parseInt(prefList[i]));						
						}
						freeMen.push(new Man(id, mPref));
					} else {
						HashMap<Integer,Integer> wPref = new HashMap<Integer,Integer>();
						for(int i=1; i<nbrOfPairs+1;i++){
							wPref.put(Integer.parseInt(prefList[i]), i);
						}
						women.put(id, wPref);
					}

				}
			}
		
		public Stack<Man> getFreeMen(){
			return freeMen;
		}
		public int getNbrOfPairs(){
			return nbrOfPairs;
		}
		public HashMap<Integer,HashMap<Integer,Integer>> getWomen(){
			return women;
		}
		public HashMap<Integer, String> getNames(){
			return names;
		}
	}