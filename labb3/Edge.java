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

	// public static void main(String[] args){
	// 	// PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	// 	// Edge edge1 = new Edge("Stockholm", "Paris", 200);
	// 	// Edge edge2 = new Edge("Stockholm", "Helsinki", 100);
	// 	// pq.add(edge1);
	// 	// pq.add(edge2);
	// 	// System.out.println(pq.poll().getDistance());
	// 	// System.out.println(pq.poll().getDistance());
	// 	// System.out.println("Bra jakla jobb grabben!");
	// 	// String str = "120";
	// 	// System.out.println(Integer.parseInt(str));
	// 	// System.out.println(Integer.MAX_VALUE);
	// }
}