import java.util.*;
import java.io.*;

public class NaiveParser{
	private ArrayList<ArrayList<String>> arr;
	private static final int DELTA = -4;

	public NaiveParser(String fileName){
		parse(fileName);
	}

	private void parse(String fileName){
		arr = new ArrayList<ArrayList<String>>();
		BufferedReader buf = null;
		try{
			buf = new BufferedReader(new FileReader("./testfiles/" + fileName));
			String line = buf.readLine();
			while(line!=null && !line.equals("0")){
				ArrayList<String> al = new ArrayList<String>();
				if(line.startsWith(">")){
					String[] name = line.split(" ");
					String temp = name[0].substring(1, name[0].length());
					al.add("*");
					line = buf.readLine();
				}
				// ArrayList<String> letters = new ArrayList<String>();
				for(int i=0; i<line.length(); i++){
					al.add(line.substring(i, i+1));
				}
				arr.add(al);
				line = buf.readLine();
			}
		} catch(IOException e ){
			System.out.println(e.getMessage());
		}
	}



	public ArrayList<ArrayList<String>> getLists(){
		return arr;
	}
}