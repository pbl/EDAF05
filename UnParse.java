import java.util.*;
import java.io.*;
public class UnParse{
	int nbrOfPairs;
	Stack<Man> freeMen;
	HashMap<Integer,HashMap<Integer,Integer>> women;

	public UnParse(String fileName){
		freeMen = new Stack<Man>();
		women = new HashMap<Integer,HashMap<Integer,Integer>>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte hittas");
			System.exit(1);
		}
		int id = 0;

		while (scan.hasNext()) {
			String line = scan.nextLine();
			while(line.startsWith("#")){
				line = scan.nextLine();
			}
			if(line.contains("=")){
				nbrOfPairs = Integer.parseInt(line.split("=")[1]);
			}
			if (line.contains(":")){
				id++;

				String[] prefList = line.split(" ");
				if(id%2 == 1){						
					Stack<Integer> mPref = new Stack<Integer>();
					for(int i=nbrOfPairs-1;i>0;i--){
						mPref.push(Integer.parseInt(prefList[i]));
					}
					freeMen.push(new Man(id, mPref));
				} else {
					HashMap<Integer,Integer> wPref = new HashMap<Integer,Integer>();
					for(int i=1; i<nbrOfPairs;i++){
						wPref.put(Integer.parseInt(prefList[i]), i);
					}
					women.put(id, wPref);
				}
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
}