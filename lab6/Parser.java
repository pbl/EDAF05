1import java.util.*;
import java.io.*;

public class Parser{
ArrayList<Integer> cities;		//De angränsande städerna för en stad
HashMap<Integer, Edge> stations;	//Map med städer och deras edges
HashMap<Integer, ArrayList<Integer>> cityNeighbours; //map med städers angränsande städer

	public Parser(){
		stations = new HashMap<Integer, Edge>();
		cityNeighbours = new HashMap<Integer, ArrayList<Integer>>();
		cities = new ArrayList<Integer>();
	}

//HashMap<int, Edge>();//som håller på alla städer och deras edges.

	public HashMap<Integer, Edge> parseInput(String file){
		BufferedReader buf = null;
		try{
			buf = new BufferedReader(new FileReader(file)); 
			for(int i = 0; i<176; i++){ // hoppar över allt skit, sista inläsning dock relevant
				String line = buf.readLine();	
					if(i>57){
						String[] wordLine = line.split(" ");
						int cityA = Integer.parseInt(wordLine[0]);
						int cityB =Integer.parseInt(wordLine[1]);
						int cap = Integer.parseInt(wordLine[2]);
						Edge e = new Edge(cityA,cityB, cap);
						stations.put(cityA, e);
						cityNeighbours.get(cityA).add(cityB);


					}		
			}
			return stations;

		}catch (IOException e){
			System.err.println("File not found: " + e.getMessage());
		}
	return null;
	}

	public HashMap<Integer, ArrayList<Integer>> getNeighbours(){
		return cityNeighbours;
	}
}