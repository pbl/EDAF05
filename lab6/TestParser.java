import java.util.*;
import java.io.*;

public class TestParser{


	public static void main (String[] args){
		
		Parser p = new Parser();
		Edge[] theMap = p.parseInput(args[0]);
		ArrayList<ArrayList<Integer>> temp = p.getEdgesForACity();
		System.out.println("det finns så här många edges: " + theMap.length);
		System.out.println("Det finns så här många städer: " + temp.size());
		
		int counter = 0;
		for(ArrayList<Integer> a : temp){
			counter = counter + a.size();
		}
		System.out.println("så här många edges hittar jag i edges for all cities:" + counter);


		// HashMap<Integer, ArrayList<Integer>> test = p.getNeighbours();

		// for(Map.Entry snopp : theMap.entrySet()){	//map med alla städer och deras angränsande städer
		// 	ArrayList<Integer> temp = snopp;
		// 	for(int i = 0; i<snopp.length; i++){
		// 		System.out.println("stadens grannar är " + snopp);

		// 	}

		// }
			}	

}