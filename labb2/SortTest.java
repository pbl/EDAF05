import java.util.*;
import java.io.*;
public class SortTest{

	public static void main(String[] args){

		SortTest st = new SortTest();

		ArrayList<String> wordList = null;

		try{
			wordList = st.parseData(args[0]);
		} catch(IOException e){
			System.exit(1);

		}

		st.sort(wordList);
	}

	public ArrayList<String> parseData(String fileName) throws IOException{
		BufferedReader buf = null;
		ArrayList<String> orginalList = new ArrayList<String>();	
	
			buf = new BufferedReader(new FileReader(fileName));
			String line = buf.readLine();

		while(line!=null){
			orginalList.add(line);
			line = buf.readLine();
		}
		return orginalList;				
	}

	public void sort(ArrayList<String> wordList){
		TreeSet<String> sortedList = new TreeSet<String>();
		for(int i=0; i<wordList.size(); i++){
			char[] ch = wordList.get(i).toCharArray();
			Arrays.sort(ch);
			String  sortedWord = String.valueOf(ch);
			sortedList.add(sortedWord);
		}
		for(String str: sortedList){
			System.out.println(str);
		}






	}





}

