import java.util.*;
public class TestDFS{
	public TestDFS(){

	}
	//remember to change the order of the cities in edge to test if it matters
	public static void main(String[] args){
		int source = 0;
		int sink;
		ArrayList<ArrayList<Integer>> cities;
		ArrayList<Integer> city0;
		ArrayList<Integer> city1;
		ArrayList<Integer> city2;
		ArrayList<Integer> city3;
		ArrayList<Integer> city4;
		ArrayList<Integer> city5;
		ArrayList<Integer> city6;
		DFS dfs = new DFS();
		LinkedList<Integer> path;
		System.out.println("First test");
		// hardcoding the edges1 and cities

		sink = 1;
		Edge[] edges1 = new Edge[1];
		edges1[0] = new Edge(0, 1, 20);
		
		cities = new ArrayList<ArrayList<Integer>>();

		city0 = new ArrayList<Integer>();
		city0.add(0);
		cities.add(city0);

		city1 = new ArrayList<Integer>();
		city1.add(0);
		cities.add(city1);		

		path = dfs.DFS(cities, edges1, source, sink);
		if(path == null){
			System.out.println("Should find path. But didn't");
		} else{

			for(Integer city : path){
				System.out.println(city);
			}
			
		}

		System.out.println();
		System.out.println("Second test");
		sink = 2;

		Edge[] edges2 = new Edge[2];
		edges2[0] = new Edge(0, 1, 20);
		edges2[1] = new Edge(1, 2, 20);
		
		cities = new ArrayList<ArrayList<Integer>>();
		
		city0 = new ArrayList<Integer>();
		city0.add(0);
		cities.add(city0);

		city1 = new ArrayList<Integer>();
		city1.add(0);
		city1.add(1);
		cities.add(city1);		

		city2 = new ArrayList<Integer>();
		city2.add(0);
		cities.add(city2);

		path = dfs.DFS(cities, edges2, source, sink);
		if(path == null){
			System.out.println("Should find path. But didn't");
		} else{
			System.out.println(path);

			for(Integer city : path){
				System.out.println(city);
			}
			
		}

		System.out.println();
		System.out.println("Third test");
		sink = 3;
		cities = new ArrayList<ArrayList<Integer>>();

		Edge[] edges = new Edge[5];
		edges[0] = new Edge(0, 1, 20);
		edges[1] = new Edge(0, 2, 50);
		edges[2] = new Edge(1, 2, 30);
		edges[3] = new Edge(1, 3, 50);
		edges[4] = new Edge(2, 3, 20);

		city0 = new ArrayList<Integer>();
		city0.add(0);
		city0.add(1);
		cities.add(city0);

		city1 = new ArrayList<Integer>();
		city1.add(0);
		city1.add(2);
		city1.add(3);
		cities.add(city1);

		city2 = new ArrayList<Integer>();
		city2.add(1);
		city2.add(2);
		city2.add(4);
		cities.add(city2);

		city3 = new ArrayList<Integer>();
		city3.add(3);
		city3.add(4);
		cities.add(city3);

		path = dfs.DFS(cities, edges, source, sink);

		for(Integer city : path){
			System.out.println(city);
		}

		System.out.println();
		System.out.println("fourth test");
		System.out.println("the same as the thrid ");
		sink = 3;
		cities = new ArrayList<ArrayList<Integer>>();



		Edge[] edges4 = new Edge[5];
		edges4[0] = new Edge(0, 1, 20);
		edges4[1] = new Edge(0, 2, 50);
		edges4[2] = new Edge(1, 2, 30);
		edges4[3] = new Edge(1, 3, 50);
		edges4[4] = new Edge(2, 3, 20);

		edges4[3].increase(50, 1);
		edges4[4].increase(20, 2);
		System.out.println("Residual/bottleneck for 3: " + edges4[3].getBottleNeckValue(1) + " should be 0");
		System.out.println("Residual/bottleneck for 4: " + edges4[4].getBottleNeckValue(2) + " should be 0");



		city0 = new ArrayList<Integer>();
		city0.add(0);
		city0.add(1);
		cities.add(city0);

		city1 = new ArrayList<Integer>();
		city1.add(0);
		city1.add(2);
		city1.add(3);
		cities.add(city1);

		city2 = new ArrayList<Integer>();
		city2.add(1);
		city2.add(2);
		city2.add(4);
		cities.add(city2);

		city3 = new ArrayList<Integer>();
		city3.add(3);
		city3.add(4);
		cities.add(city3);

		path = dfs.DFS(cities, edges4, source, sink);

		if(path == null){
			System.out.println("Shouldn't find path. And didn't");
		} else{
			System.out.println(path);

			for(Integer city : path){
				System.out.println(city);
			}
			
		}



			

	}
}