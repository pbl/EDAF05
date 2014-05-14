import java.util.*;
import java.io.*;

public class DataParser{
	private ArrayList<ArrayList<String>> arr;

	public DataParser(String fileName){
		parse(fileName);
	}

	private void parse(String fileName){
		arr = new ArrayList<ArrayList<String>>();
		BufferedReader buf = null;
		try{
			buf = new BufferedReader(new FileReader("./testfiles/" + fileName));
			String line = buf.readLine();
			while(line!=null){
				ArrayList<String> al = new ArrayList<String>();
				if(line.startsWith(">")){
					// System.out.println("first startswith" + line);
					String[] name = line.split(" ");
					String temp = name[0].substring(1, name[0].length());
					al.add(temp);
					line = buf.readLine();
				}
				// ArrayList<String> letters = new ArrayList<String>();
				boolean check = true;
				while(check){
					for(int i=0; i<line.length(); i++){
						al.add(line.substring(i, i+1));
					}
					line = buf.readLine();
					if(line==null){
						check = false;
					} else if(line.startsWith(">")){
						// System.out.println("startswith: " + line);
						check = false;
					}
				}
				arr.add(al);
			}
		} catch(IOException e ){
			System.out.println(e.getMessage());
		}
	}



	public ArrayList<ArrayList<String>> getLists(){
		return arr;
	}

	// public static void main(String[] args){
	// 	// DataParser dataParser = new DataParser("Toy_FASTAs.in");
	// 	DataParser dataParser = new DataParser("HbB_FASTAs.in");
	// 	ArrayList<ArrayList<String>> arr = dataParser.getLists();
	// 	System.out.println("list size: " + arr.size());
	// 	for(int i=0; i<arr.size(); i++){
	// 		ArrayList<String> list = arr.get(i);
	// 		System.out.println("first element: " + list.get(0));
	// 		for(int k=1; k<list.size(); k++){
	// 			System.out.print("" + list.get(k) + "");
	// 		}
	// 		System.out.println();
	// 	}
	// }
}