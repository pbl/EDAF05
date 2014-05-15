import java.util.*;
public class Edge implements Comparable<Edge>{
	String city;
	int distance;

	public Edge(String city, int distance){
		this.city = city;
		this.distance = distance;
	}

	public String getCity(){
		return city;
	}

	public int getDistance(){
		return distance;
	}

	@Override
	public int compareTo(Edge anotherEdge){
		return distance - anotherEdge.getDistance();
	}
}