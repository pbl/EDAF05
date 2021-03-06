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
				String[] wordLine = buf.readLine().split(" ");
				String[] path = wordLine[0].split("/");
				path[2] = path[2].substring(0, path[2].length() - 1);
				thorRes.put(path[2], Double.parseDouble(wordLine[2]));
			}
		} catch(IOException e){

		}
		return thorRes;
	}
}