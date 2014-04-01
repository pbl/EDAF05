//Hej philip
import java.util.*;
import.io.*;

public class WordLadder{
	ArrayList<String> orginalList;
	HashMap<String, HashMap<Integer, ArrayList<String>> words;
	HashMap<Integer, ArrayList<String>> indWordTree;
	HashMap<String, Boolean> takenWords;

	public void Parse(String fileName){
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		orginalList = new ArrayList<String>();
		String line = br.readLine();
		while(line!=null){
			orginalList.add(line);
		}
	}

	public void buildMap(){	
		words = new HashMap<String, HashMap<Integer, ArrayList<String>>();			
		for(int i=0; i<orginalList.size(); i++){
			words.put(orginalList(i), null);
		}

		for(int i=0; i<orginalList.size(); i++){		
			boolean nextLayerBuilt = true;
			int i = 0;
			takenWords = new HashMap<String, Boolean>();
			String currentWord = orginalList.get(i);
			while(nextLayerBuilt){
				i++;
				indWordTree = words.get(currentWord); 
				if(indWordTree==null){
					nextLayerBuilt = buildFirstLayer(currentWord);				
				} else {
					nextLayerBuilt = buildNextLayer(i);
				}
			}				
		}		
	}

	public boolean buildFirstLayer(String currentWord){
		ArrayList<String> matchingWords = new ArrayList<String>();		
		for(int i=0; i<orginalList.size();i++){
			String compareWord = orginalList.get(i);
			if(!currentWord.equals(compareWord) && isMatch(currentWord, compareWord)){
				matchingWords.add(compareWord);
				takenWords.put(currentWord, true);
			}
		}				
		if(!matchingWords.isEmpty()){
			indWordTree.put(1, matchingWords);
			words.put(currentWord, indWordTree);
			return true;
		} else{			
			return false;
		}
	}



	public boolean isMatch(String currentWord, String compareWord){
		

	}

	public boolean buildNextLayer(HashMap<String, boolean> takenWords, int layer, String word){


	}

	 


	public static void main(String[] args){
		WordLadder wd = new...
		ArrayList<String> sf = WordLadder.parse(arg[0]);

	}
}

}