import java.util.*;
import java.io.*;

public class TreeBuilder{
	TreeSet<String> sortedTree;
	ArrayList<String> testInWords;
	HashSet<String> takenWords;
	LinkedList<LinkedList<String>> layerList;
	HashMap<String, LinkedList<String>> realWords;

	public TreeBuilder(String dataIn, String testIn){
		sortedTree = new TreeSet<String>();
		testInWords = new ArrayList<String>();
		takenWords = new HashSet<String>();
		layerList = new LinkedList<LinkedList<String>>();	
		realWords = new HashMap<String, LinkedList<String>>();
		try{
			sortData(dataIn, testIn);
		} catch(IOException e){
			System.exit(1);
		}
	}

	public void sortData(String fileName1, String fileName2) throws IOException{
		BufferedReader buf = null;
		buf = new BufferedReader(new FileReader(fileName1));
		String line = buf.readLine();
		HashSet<String> addedWord = new HashSet<String>();
		while(line!=null){
			String sortedWord = alfabeticOrder(line);
			sortedTree.add(sortedWord);
			if(addedWord.contains(sortedWord)){	//the letters already exists in realWords
				LinkedList<String> newWord = realWords.get(sortedWord);
				newWord.add(line);
				realWords.put(sortedWord, newWord);
			} else{	//the letters doesnt exist
				addedWord.add(sortedWord);
				LinkedList<String> newWord = new LinkedList<String>();
				newWord.add(line);
				realWords.put(sortedWord, newWord);
			}
			line = buf.readLine();
		}

		buf.close();
		buf = new BufferedReader(new FileReader(fileName2));
		line = buf.readLine();
		while(line!=null){
			String[] wordLine = line.split(" ");
			testInWords.add(wordLine[0]);
			testInWords.add(wordLine[1]);
			line = buf.readLine();
		}
		// System.out.println("read from files done");
	}

	public LinkedList<String> findMatchingWords(String word){
		String sortedWord = alfabeticOrder(word.substring(1));
		LinkedList<String> layerWords = new LinkedList<String>();
		for(String str: sortedTree){
			if(match(sortedWord, str) && !takenWords.contains(str)){
				LinkedList<String> newWords = realWords.get(str);
				takenWords.add(str);
				layerWords.addAll(newWords);
			}
		}
		return layerWords;
	}

	public boolean match(String str1, String str2){
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray(); 
		int noMatch = 0;
		int place1 = 0;
		int place2 = 0;
		while(noMatch<2 && place1<ch1.length && place2<ch2.length){			
			if(ch1[place1] == ch2[place2]){
				place1++;
				place2++;
			} else if(ch1[place1] < ch2[place2]){
				return false;
			}else{
				place2++;
				noMatch++;
			}
		}
		return noMatch<2;
	}

	public String alfabeticOrder(String word){
		char[] ch = word.toCharArray();
		Arrays.sort(ch);
		return String.valueOf(ch);
	}

	public void buildTree(String startWord){ 
		takenWords.clear(); 
		layerList.clear(); 
		layerList.add(findMatchingWords(startWord));
		// System.out.println("first layer done");
			while(layerList.getLast().size()!=0){
				layerList.add(buildNextLayer());
				// System.out.println("next layer done");
			}
	}

	public LinkedList<String> buildNextLayer(){
		LinkedList<String> nextLayer = new LinkedList<String>();
		for(String str: layerList.getLast()){
			LinkedList<String> potWords = new LinkedList<String>();
			potWords = findMatchingWords(str);
			nextLayer.addAll(potWords);
			
		}
		return nextLayer;
	}

	public int findDistance(String startWord, String endWord){
		// System.out.println("For: " + startWord + " to " + endWord);
		buildTree(startWord); //leta efter endWord i listan 
		for(LinkedList<String> list: layerList){
			// System.out.println(layerList.indexOf(list) + 1);
			for(String str: list){
				// System.out.print(str + ", ");
			}
			// System.out.println();
			if(list.contains(endWord)){
				return layerList.indexOf(list) + 1;
			} 
		}
		return -1;
		
		// System.out.println("Ordet hittades inte i den LänkadeListan layerList");
		
	}

	public void printOutDistance(){
		for(int i=0; i<testInWords.size(); i+=2){
			// System.out.println()
			if(!testInWords.get(i).equals(testInWords.get(i+1))){
				System.out.println(findDistance(testInWords.get(i), testInWords.get(i+1)));
			} else {
				System.out.println("0");
			}
		}
	}
}