import java.util.*;
import java.io.*;

public class WordLadder{
	
	private ArrayList<String> orginalList;
	private	ArrayList<String> compareList;
	private HashMap<String, HashMap<Integer, ArrayList<String>>> words;
	private static final int WORD_LENGTH = 5;
	private HashMap<String, HashMap<String, Boolean>> takenWords;
	private ArrayList<String> notNull;
	
	public void parseData(String fileName) throws IOException{
		BufferedReader buf = null;
		orginalList = new ArrayList<String>();	
	
			buf = new BufferedReader(new FileReader(fileName));
			String line = buf.readLine();

		while(line!=null){
			orginalList.add(line);
			line = buf.readLine();
		}				
	}


	public ArrayList<String> parseInput(String file) throws IOException{		
		compareList = new ArrayList<String>();
		BufferedReader buf = new BufferedReader(new FileReader(file));		
		String line = buf.readLine();
		while(line!=null){
			String[] wordLine = line.split(" ");
			compareList.add(wordLine[0]);
			compareList.add(wordLine[1]);
			line = buf.readLine();
		}
		return compareList;
	}


	public void buildMap(){	
		words = new HashMap<String, HashMap<Integer, ArrayList<String>>>();	
		takenWords = new HashMap<String, HashMap<String, Boolean>>();
		notNull = new ArrayList<String>();
		notNull.add("I'm not null");
		HashMap<Integer, ArrayList<String>> wordTree = null;		
		for(int i=0; i<orginalList.size(); i++){
			words.put(orginalList.get(i), null);
			takenWords.put(orginalList.get(i), null);		
		}
		
		for(int i=0; i<orginalList.size(); i++){		
			boolean layerWasAdded = true;
			int layer = 1;		
			String currentWord = orginalList.get(i);
			wordTree = words.get(currentWord);
			while(layerWasAdded){								 
				if(wordTree==null){
					layerWasAdded = buildFirstLayer(currentWord);				
				} else {
					layerWasAdded = buildNextLayer(layer, currentWord);
				}
				layer++;
			}
			wordTree.put(layer, null);
			words.put(currentWord, wordTree);				
		}		
	}
	public boolean buildFirstLayer(String currentWord){
		ArrayList<String> matchingWords = new ArrayList<String>();	
		HashMap<String, Boolean> temp = takenWords.get(currentWord);
		HashMap<Integer, ArrayList<String>> wordTree =  new HashMap<Integer, ArrayList<String>>();
		for(int i=0; i<orginalList.size(); i++){
			String compareWord = orginalList.get(i);
			if(!currentWord.equals(compareWord) && isMatch(currentWord, compareWord)){
				matchingWords.add(compareWord);
				temp.put(compareWord, true);			
			}
		}		
		takenWords.put(currentWord, temp);
		if(matchingWords.isEmpty()){	//There is no first layer for the word
			wordTree.put(0, notNull);
			words.put(currentWord, wordTree);
			return false;
		}
		wordTree.put(1, matchingWords);
		words.put(currentWord, wordTree);
		return true;
	}

	public boolean buildNextLayer(int layer, String currentWord){		
		HashMap<Integer, ArrayList<String>> wordTree = words.get(currentWord);
		ArrayList<String> wordsInCurrentLayer = wordTree.get(layer);
		ArrayList<String> newWords = new ArrayList<String>();		
		for(int i=0; i<wordsInCurrentLayer.size(); i++){
			String compareWord = wordsInCurrentLayer.get(i);
			HashMap<Integer, ArrayList<String>> layerWordz = words.get(compareWord);	
			if(layerWordz.isEmpty() && wordTree.get(0)==null){
				buildFirstLayer(wordsInCurrentLayer.get(i));
			}
			ArrayList<String> potWords = layerWordz.get(1);			
			if(!potWords.isEmpty()){
				for(int k=0; k<potWords.size(); k++){
					HashMap<String, Boolean> checkWordTaken = takenWords.get(currentWord);

					if(!checkWordTaken.get(potWords.get(k))){ //The word hasn't been used
						newWords.add(potWords.get(k));
						checkWordTaken.put(potWords.get(k), true);
					}
				}
			}	
		}
		wordTree.put(layer, newWords);
		return !newWords.isEmpty();
	}
	
	public boolean isMatch(String currentWord, String compareWord){
			boolean[] matchingWords = new boolean[WORD_LENGTH];
			int nbrOfMatches = 0;
		 	for(int i=1; i<WORD_LENGTH; i++){
		 		for(int k=0; k<WORD_LENGTH; k++){
		 			char currentTemp = currentWord.charAt(i);
		 			char compareTemp = compareWord.charAt(k);
		 			if(currentTemp==compareTemp && !matchingWords[k]){
		 				nbrOfMatches++;
		 				matchingWords[k] = true;
		 			}
		 		}		 		
		 	}
		 return nbrOfMatches == WORD_LENGTH-1;
	}

	public HashMap<Integer, ArrayList<String>> getWordTree(String word){
		return words.get(word);
	}





	public static void main(String[] args){	

		
		WordLadder wd = new WordLadder();
		ArrayList<String>  compareList = null;
		try{
			wd.parseData(args[0]);
			compareList = wd.parseInput(args[1]);
		}catch(IOException e){
			System.exit(1);
		}
		
		
		wd.buildMap();



		for (int k = 0; k < compareList.size(); k=k+2){
			String startWord = compareList.get(k); 		//ordet vi granskar
			String endWord = compareList.get(k+1);	//ordet vi vill jämföra med
			HashMap<Integer, ArrayList<String>> wordTree = wd.getWordTree(startWord);

			int layer = 0;
			boolean found = false;
			while(!found && (!(wordTree.get(layer)==null) || layer==0)){
				if(wordTree.get(layer) != null && layer==0){
					found = true;
					System.out.println(-1);
				} else {
					ArrayList<String> layerWordz = wordTree.get(layer);
					if(layerWordz.contains(endWord)){
						found = true;
							System.out.println(layer);
					}					
				}
				layer++;
			}
		}
			// for(Entry<Integer, ArrayList<String>> entry : wordTree.entrySet()) {
			// 	int layer = entry.getKey();
			// 	ArrayList<String> value = entry.getValue();
			// 	if(value.contains(endWord)) System.out.println(layer);
			// }

		

	}
}
