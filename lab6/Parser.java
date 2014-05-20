import java.util.*;
import java.io.*;

public class Parser{
    Edge[] allEdges;				//Map med städer och deras edges, så att när en edge
								//ändras ändras det globalt och inte bara för en specifik stad
    ArrayList<ArrayList<Integer>> edgesForACity;	 //map med specifik stads kopplade edges
					

	public Parser(){
		allEdges = new Edge[119]; //skapar vekto med 119 platser för edges
		edgesForACity = new ArrayList<ArrayList<Integer>>();
		
		for(int j = 0; j<55;j++){		//loopar in tomma listor i edgesForAllCity
			edgesForACity.add(new ArrayList<Integer>());
		}
	}
	public Edge[] parseInput(String file){
		BufferedReader buf = null;
		int edgeKey = 0;
		try{
			buf = new BufferedReader(new FileReader(file)); 
			for(int i = 1; i<=176; i++){ // hoppar över allt skit, sista inläsning dock relevant
				String line = buf.readLine();	
					if(i>=58){
						
						String[] wordLine = line.split(" ");
						int cityA = Integer.parseInt(wordLine[0]);
						int cityB =Integer.parseInt(wordLine[1]);
						int capacity = Integer.parseInt(wordLine[2]);
						Edge e = new Edge(cityA,cityB, capacity, edgeKey);
						// System.out.println("the capacity is: " + capacity);
						
						allEdges[edgeKey] = e; //sparar undan den unika edgen på unik nyckel
						//int edgeKey = Arrays.asList(allEdges).indexOf(e);//finner index för den edge:n
							

						//på platsen a och b vill vi lägga in en array eller uppdaterad array med 
						//med nytt antal av edges.

						ArrayList<Integer> tempA = edgesForACity.get(cityA);
						ArrayList<Integer> tempB = edgesForACity.get(cityB);
						
						tempA.add(edgeKey);
						tempB.add(edgeKey);

						edgesForACity.remove(cityA);
						edgesForACity.add(cityA, tempA);

						edgesForACity.remove(cityB);
						edgesForACity.add(cityB, tempB);
						
						
						edgeKey++;



					}		
			}
			return allEdges;

		}catch (IOException e){
			System.err.println("File not found: " + e.getMessage());
		}
	return null;
	}

	public ArrayList<ArrayList<Integer>> getEdgesForACity(){
		return edgesForACity;
	}
}