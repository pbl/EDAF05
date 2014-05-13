public class TestEdge{

	public static void main(String[] args){
		Edge edge = new Edge(0, 1, 30);

		// System.out.println("Test forward and backword values");
		System.out.println("Startvalue is: " + edge.getMaxCapacity());
		System.out.println("Bottleneck for 0: " + edge.getBottleNeckValue(0));
		System.out.println("Bottleneck for 1: " + edge.getBottleNeckValue(1));


		System.out.println();
		System.out.println("get the other city input 0: " + edge.getOtherCity(0));
		System.out.println();

		edge.increase(20);
		// edge.getStatus();
		System.out.println("Keeptrack forward: " + edge.getKeepTrackForward() + " should be 10");
		System.out.println("Keeptrack backward: " + edge.getKeepTrackBackward() + " should be 20");
		System.out.println("Bottleneck for 0: " + edge.getBottleNeckValue(0) + " should be 10");
		System.out.println("Bottleneck for 1: " + edge.getBottleNeckValue(1) + " should be 20");
		System.out.println();
		edge.decrease(10);
		System.out.println("Keeptrack forward: " + edge.getKeepTrackForward() + " should be 20");
		System.out.println("Keeptrack backward: " + edge.getKeepTrackBackward() + " should be 10");
		System.out.println("Bottleneck for 0: " + edge.getBottleNeckValue(0) + " should be 20");
		System.out.println("Bottleneck for 1: " + edge.getBottleNeckValue(1) + " should be 10");

		System.out.println();

		// edge.getStatus();

	}
}