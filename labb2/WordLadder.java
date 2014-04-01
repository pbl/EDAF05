//Hej philip
import java.util.*;
import.io.*;

public class WordLadder{
	ArrayList<String> orginalList;
	HashMap<String, HashMap<Integer, ArrayList<String>> words;
	HashMap<Integer, ArrayList<String>> indWordTree;

	public ArrayList<String> Parse(String fileName){
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		orginalList = new ArrayList<String>();
		String line = br.readLine();
		while(line!=null){
			orginalList.add(line);
		}
	}

	public void buildMap(){
		words = new HashMap<String, HashMap<Integer, ArrayList<String>>();
		HashMap<Integer, ArrayList<String>> indWordTree = null;
		
		for(int i=0; i<orginalList.size(); i++){
			words.put(orginalList(i), null);
		}

		for(int i=0; i<orginalList.size(); i++){
			boolean nextLayerBuilt = true;
			int i = 0;
			HashMap<String, boolean> takenWords = new HashMap<String, boolean>();

			while(nextLayerBuilt){
				i++;
				indWordTree = words.get(orginalList(i)); 
				if(indWordTree==null){
					nextLayerBuilt = buildLayer();				
				} else {
					nextLayerBuilt = buildNextLayer(i);
				}
			}				
		}		
	}

	public boolean buildLayer(String str){
		//grejor
	}

	public boolean buildNextLayer(HashMap<String, boolean> takenWords, int layer, String word){


	}

	 


	public static void main(String[] args){
		WordLadder wd = new...
		ArrayList<String> sf = WordLadder.parse(arg[0]);

	}
}

}