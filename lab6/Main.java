import java.util.*;

public class Main{
	private static final int NBR_OF_EDGES = 118;

	public Main(){

	}

	public int calcBottleNeckValue(LinkedList<Pair> path){
		int b = Integer.MAX_VALUE;
		for(Pair pair : path){
			int edgeB = pair.getEdge().getBottleNeckValue(pair.getCity());
			// int edgeB = pair.getEdge().getCapacity();
			if(edgeB < b){
				b = edgeB;
			}
		}
		return b;
	}

	public Edge[] updateGraph(int b, LinkedList<Pair> path, Edge[] edges){
		for(Pair pair : path){
			Edge edge = pair.getEdge();
			edge.increase(b, pair.getCity());
			edges[edge.getPos()] = edge;
		}
		return edges;
	}

	private int calcValueOfMinCut(ArrayList<Edge> edges){
		int valueOfMinCut = 0;
		for(int i=0; i<edges.size(); i++){
			valueOfMinCut += edges.get(i).getCapacity();
		}
		return valueOfMinCut;

	}

	public void printResult(ArrayList<Edge> edges){
		System.out.println("Maxflow is " + calcValueOfMinCut(edges));
		System.out.println();
		for(int i=0; i<edges.size(); i++){
			System.out.println(edges.get(i).getCity1() + " " + edges.get(i).getCity2() + " " + edges.get(i).getCapacity());
		}
	}

	public ArrayList<Edge> minCutEdges(HashSet<Integer> setS, ArrayList<ArrayList<Integer>> cities, Edge[] edges){
		ArrayList<Edge> minCutEdges = new ArrayList<Edge>();
		for(Integer city : setS){
			ArrayList<Integer> cityEdge = cities.get(city);
			for(int i=0; i<cityEdge.size(); i++){
				Edge edge = edges[cityEdge.get(i)];
				int otherCity = edge.getOtherCity(city);
				// System.out.println("isMaxed: " + edge.isMaxed(city));
				// System.out.println("setS contains: " + setS.contains(otherCity));
				// if(edge.isMaxed(city) && !setS.contains(otherCity)){
				if(!setS.contains(otherCity)){
					// System.out.println("do i ever enter here");
					minCutEdges.add(edge);
				}
			}
		}
		return minCutEdges;
	}


	public static void main(String[] args){
		int source = 0;
		int sink = 54;

		Parser p = new Parser();
		Edge[] edges = p.parseInput("rail.txt");
		ArrayList<ArrayList<Integer>> cities = p.getEdgesForACity();
		Dfs dfs = new Dfs();
		Main main = new Main();

        LinkedList<Pair> path = dfs.dfs(cities, edges, source, sink);

        int count = 0;

		while(path!=null){
            count++;
			int b = main.calcBottleNeckValue(path);
			edges =	main.updateGraph(b, path, edges);
            path = dfs.dfs(cities, edges, source, sink);
		}

		ArrayList<Edge> minCutEdges = main.minCutEdges(dfs.getTree(), cities, edges);
		main.printResult(minCutEdges);

	}
}