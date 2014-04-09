import java.util.*;
import java.io.*;

public class TreeBuilder{
	TreeSet<String> sortedTree;
	ArrayList<String> testInWords;
	HashSet<String> takenWords;
	LinkedList<LinkedList<String>> layerList;
	HashMap<String, ArrayList<String>> realWords;

	public TreeBuilder(String dataIn, String testIn){
		layerList = new LinkedList<LinkedList<String>>();	
		sortedTree = new TreeSet<String>();
		testInWords = new ArrayList<String>();
		takenWords = new HashSet<String>();
		realWords = new HashMap<String, ArrayList<String>>();
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
			String sortedWord = sort(line);
			sortedTree.add(sortedWord);
			if(addedWord.contains(sortedWord)){	//the letters already exists in realWords
				ArrayList<String> newWord = realWords.get(sortedWord);
				newWord.add(line);
				realWords.put(sortedWord, newWord);
			} else{	//the letters doesnt exist
				addedWord.add(sortedWord);
				ArrayList<String> newWord = new ArrayList<String>();
				newWord.add(line);
				realWords.put(sortedWord, newWord);
			}
			addedWord.add(sortedWord);
			line = buf.readLine();
		}

		buf = new BufferedReader(new FileReader(fileName2));
		line = buf.readLine();
		while(line!=null){	
			testInWords.add(line);
		}
	}

	public LinkedList<String> findMatchingWords(String word){
		String sortedWord = fixWord(word);
		// TreeSet<String> subTree = sortedTree.subSet("a", sortedWord);
		LinkedList<String> layerWords = new LinkedList<String>();
		for(String str: sortedTree){
			if(match(sortedWord, str) && !takenWords.contains(str)){
				ArrayList<String> newWords = realWords.get(str);
				takenWords.add(str);
				for(String s: newWords){
					layerWords.add(s);
				}
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
				place1++;
				noMatch++;
			}else{
				place2++;
				noMatch++;
			}
		}
		return noMatch<2;
	}

	public static String fixWord(String word){
		String subWord = word.substring(1);
		return sort(subWord);
	}

	public static String sort(String word){
		char[] ch = word.toCharArray();
		Arrays.sort(ch);
		return String.valueOf(ch);
	}

	public void buildTree(String startWord){ 
		takenWords.clear(); 
		layerList.clear(); 
		layerList.add(findMatchingWords(startWord));
			while(layerList.getLast().size()!=0){
				buildNextLayer(layerList.getLast());
			}
	}

	public LinkedList<String> buildNextLayer(LinkedList<String> layer){
		LinkedList<String> nextLayer = new LinkedList<String>();
		for(String str: layer){
			nextLayer.addAll(findMatchingWords(str));
		}
		return nextLayer;
	}

	public int findDistance(String startWord, String endWord){
		buildTree(startWord); //leta efter endWord i listan 
				
		for(LinkedList<String> list: layerList){
			if(list.contains(endWord)){
				return layerList.indexOf(list);
			}
			//kör contains på noden för ordet
			//if ordet finns return indexOf
			//
		}
		
		System.out.println("Ordet hittades inte i den LänkadeListan layerList");
		return -1;
		
		
	}



	public void printOutDistance(){
		for(int i=0; i<testInWords.size(); i+=2){
			findDistance(testInWords.get(i), testInWords.get(i+1));
		}

	}
}