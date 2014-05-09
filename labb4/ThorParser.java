import java.util.*;
import java.io.*;

public class ThorParser{

	public ThorParser(){

	}

	public HashMap<String, Double> parse(String fileName){
		BufferedReader buf = null;
		HashMap<String, Double> thorRes = new HashMap<String, Double>();
		try{
			buf = new BufferedReader(new FileReader(fileName));
			for(int i=0; i<95; i++){
				String wholeLine = buf.readLine();
				String[] wordLine = wholeLine.split(" ");
				String[] name = wordLine[0].split("/");
				name[2] = name[2].substring(0, name[2].length() - 1);
				thorRes.put(name[2], Double.parseDouble(wordLine[2]));
			}
		} catch(IOException e){

		}
		return thorRes;
	}
}