import java.util.*;
import java.io.*;

public class TestParser{


	public static void main (String[] args){
		
		Parser p = new Parser();
		HashMap<Integer, Edge> theMap = p.parseInput(args[0]);

		for(Map.Entry hej : theMap.entrySet()){
			System.out.println("bög-staden är" + hej);
		}
		HashMap<Integer, ArrayList<Integer>> test = p.getNeighbours();

		for(Map.Entry snopp : theMap.entrySet()){
			System.out.println("snopppp " + snopp);
		}
	}	

}