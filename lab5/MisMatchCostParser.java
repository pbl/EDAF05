import java.util.*;
import java.io.*;

public class MisMatchCostParser{
	private ArrayList<String> letterIndex;


	public MisMatchCostParser(){
		letterIndex = new ArrayList<String>();
	}

	public HashMap<String, HashMap<String, Integer>> parse(){
		HashMap<String, HashMap<String, Integer>> misMatchCost = new HashMap<String, HashMap<String, Integer>>();
		BufferedReader buf = null;
		try{
			buf = new BufferedReader(new FileReader("./testfiles/BLOSUM62.txt"));
			for(int i=0; i<6; i++){
				buf.readLine();
			}
			String[] wordLine = buf.readLine().split(" ");
			wordLine = removeGaps(wordLine);
			misMatchCost = init(misMatchCost, wordLine);

			String line = buf.readLine();
			while(line!=null){
				wordLine = line.split(" ");
				wordLine = removeGaps(wordLine);

				HashMap<String, Integer> letterCostMap = new HashMap<String, Integer>();
				String letter = wordLine[0];
				for(int i=1; i<wordLine.length; i++){
					letterCostMap.put(letterIndex.get(i-1), Integer.parseInt(wordLine[i]));
					misMatchCost.put(letter, letterCostMap);
				}
				line = buf.readLine();
			}
		} catch(IOException e){
			System.out.println(e.getMessage());

		}
		return misMatchCost;

	}

	private HashMap<String, HashMap<String, Integer>> init(HashMap<String, HashMap<String, Integer>> misMatchCost, String[] wordLine){
		for(int i=0; i<wordLine.length; i++){
			misMatchCost.put(wordLine[i], null);
			letterIndex.add(wordLine[i]);
		}
		return misMatchCost;
	}



	private String[] removeGaps(String[] wordLine){
		ArrayList<String> theWords = new ArrayList<String>();
		for(int i=0; i<wordLine.length; i++){
			if(!(wordLine[i].equals(""))){
				theWords.add(wordLine[i]);
			}
		} 
		String[] fixed = new String[theWords.size()];
		for(int i=0; i<theWords.size(); i++){
			fixed[i] = theWords.get(i);
		}
		return fixed;
	}
}