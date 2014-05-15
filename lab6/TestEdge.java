public class TestEdge{

	//this test class tests an older version of edge
	public static void main(String[] args){
		System.out.println("Test 1");
		Edge edge = new Edge(0, 1, 30);

		// System.out.println("Test forward and backword values");
		System.out.println("Capacity is: " + edge.getCapacity() + " should be 30");
		System.out.println("Bottleneck for 0: " + edge.getBottleNeckValue(0) + " should be 30");
		System.out.println("Bottleneck for 1: " + edge.getBottleNeckValue(1) + " should be 30");


		System.out.println();
		System.out.println("get the other city input 0: " + edge.getOtherCity(0)+ " should be 1");
		System.out.println();

		edge.increase(20, 0);
		// edge.getStatus();
		System.out.println("Residual/bottleneck for city 0: " + edge.getBottleNeckValue(0) + " should be 10");
		System.out.println("Residual/bottleneck for city 1: " + edge.getBottleNeckValue(1) + " should be 50");
		// System.out.println("Bottleneck for 0: " + edge.getBottleNeckValue(0) + " should be 10");
		// System.out.println("Bottleneck for 1: " + edge.getBottleNeckValue(1) + " should be 50");
		System.out.println("asks if 1 can use edge: " + edge.canUseEdge(1) + " should be true");
		System.out.println("asks if 0 can use edge: " + edge.canUseEdge(0) + " should be true");
		System.out.println();
		edge.increase(10, 1);
		System.out.println("Residual/bottleneck for 0: " + edge.getBottleNeckValue(0) + " should be 20");
		System.out.println("Residual/bottleneck for 1: " + edge.getBottleNeckValue(1) + " should be 40");
		// System.out.println("Keeptrack forward: " + edge.getKeepTrackForward() + " should be 20");
		// System.out.println("Keeptrack backward: " + edge.getKeepTrackBackward() + " should be 10");
		System.out.println("asks if 1 can use edge: " + edge.canUseEdge(1) + " should be true");

		// System.out.println();

		// edge.increase(10, 1);
		// System.out.println("Keeptrack forward: " + edge.getKeepTrackForward() + " should be 20");
		// System.out.println("Keeptrack backward: " + edge.getKeepTrackBackward() + " should be 10");
		// System.out.println("Bottleneck for 0: " + edge.getBottleNeckValue(0) + " should be 20");
		// System.out.println("Bottleneck for 1: " + edge.getBottleNeckValue(1) + " should be 10");
		// System.out.println("asks if 1 can use edge: " + edge.canUseEdge(1) + " should be false");

		// System.out.println();
		// System.out.println("Test 2");
		// Edge edge2 = new Edge(0, 1, -1);
		// System.out.println("Capacity is: " + edge2.getCapacity() + " should be a very big number");


		// edge.getStatus();

	}
}