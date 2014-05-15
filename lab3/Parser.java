import java.util.*;
import java.io.*;

public class Parser{
	private HashSet<String> addedCities;
	private HashMap<String, PriorityQueue<Edge>> pqList;
	private int distance;

	public Parser(){
		addedCities = new HashSet<String>();
		pqList = new HashMap<String, PriorityQueue<Edge>>();
		distance = 0;
	}
	
	public void buildPriorities(String fileName) throws IOException{
		BufferedReader buf = new BufferedReader(new FileReader(fileName));
		String line;
		for(int i=0; i<128; i++){
			line = buf.readLine();
			pqList.put(line, null);
		}
		line = buf.readLine();
		while(line != null){
			String[] split1 = line.split("--");
			String city1 = split1[0];
			
			String[] split2 = split1[1].split(" ");
			String strDist = split2[split2.length-1];
			strDist = strDist.substring(1, strDist.length()-1);
			int edgeDistance = Integer.parseInt(strDist);
			
			String city2 = split2[0];
			for(int k=1;k<split2.length-1; k++){
				city2 = city2.concat(" ");
				city2 = city2.concat(split2[k]);
			}
			addEdge(city1, city2, edgeDistance);
			addEdge(city2, city1, edgeDistance);	
			line = buf.readLine();
		}
	}

	public void addEdge(String city1, String city2, int edgeDistance){
		PriorityQueue<Edge> pq1 = pqList.get(city1);
		if(pq1 == null){
			pq1 = new PriorityQueue<Edge>();
		}
		pq1.add(new Edge(city2, edgeDistance));
		pqList.put(city1, pq1);	
	}

	public void addNextEdge(){
		PriorityQueue<Edge> pq = null;
		int minDistance = Integer.MAX_VALUE;
		String bestCity = null;
		if(addedCities.isEmpty()){
			addedCities.add("Sterling");
			bestCity = "Sterling";
		} else {
			for(String str: addedCities){
				pq = pqList.get(str);
				Edge edge = nextLegalEdge(pq, str);
				if(edge.getDistance() < minDistance){
					bestCity = str;
					minDistance = edge.getDistance();
				}	
			}
		}
		pq = pqList.get(bestCity);
		Edge edge = pq.poll();
		pqList.put(bestCity, pq);
		addedCities.add(edge.getCity());
		distance += edge.getDistance();
	}

	public Edge nextLegalEdge(PriorityQueue<Edge> pq, String city){
		Edge edge = pq.peek();
		if(!addedCities.contains(edge.getCity())){
			return edge;
		} else {
			while(addedCities.contains(edge.getCity())){
				edge = pq.poll();
			}
			pq.add(edge);
			pqList.put(city, pq);
			return edge;	
		}
	}

	public int totalDistance(){
		return distance;
	}

	public int getAddedCities(){
		return addedCities.size();
	}

	public static void main(String[] args){
		Parser parser = new Parser();
		try{
			parser.buildPriorities(args[0]);	
		} catch(IOException e){
			System.exit(1);
		}
		while(parser.getAddedCities()<128){
			parser.addNextEdge();
		}
		System.out.println(parser.totalDistance());
	}
}