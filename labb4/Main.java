import java.util.*;
	
public class Main{
	private ClosestPoints closestPoints;

	public Main(){
		closestPoints = new ClosestPoints();
	}

	public Pair closestPair(Point[] points){
		Comp c = new Comp();
		Arrays.sort(points, c);
		Pair pair = closestPairRec(points); 
		return pair;
	}

	private Pair closestPairRec(Point[] points){
		if(points.length <= 3){
			return closestPoints.findClosestPoints(points);
		}
		int length = points.length / 2;
		Point[] leftHalf = new Point[lenght];
		Point[] rightHalf = new Point[points.length - length];
		leftHalf = Arrays.copyOfRange(points, 0, length);
		rightHalf = Arrays.copyOfRange(points, length, points.length);
 		Pair pLeft = closestPairRec(leftHalf);
 		Pair pRight = closestPairRec(rightHalf);

 		double dist = bestPair(pLeft, pRight);

	}

	private double bestPair(Pair l, Pair r){
		return l.dist > r.dist ? r.dist() : l.dist();
	}

	private Point[] splitLeft(Point[] points){
		int length = points.length / 2;
		Point[] leftHalf = new Point[lenght];
		return Arrays.copyOfRange(points, 0, length);
	}

	private Point[] splitLeft(Point[] points){
		int length = points.length / 2;
		Point[] rightHalf = new Point[points.length - length];
		return Arrays.copyOfRange(points, length, points.length);
	}

		// om mindre än tre gör något

		// annars dela upp i två halvor, 4 bitar
		// pair = rec på ena halvan
		// pair = rec på andra halvan

		// int dist = minsta ditansen av pair1 och pair2


	// private Pair merge(leftHalf, rightHalf){

	// }


 

	public static void main(String[] args){
		Main main = new Main();
		Parser parse = new Parser();
		Point[] points = parse.parseInput(args[0]);
		Pair pair = main.closestPair(points);
		System.out.println(pair.print());


		// for(int i=0; i<points.length; i++){
		// 	System.out.println(points[i].getX());
		// }		
		// String str = closestPoints.findClosestPoints(points);
		// System.out.println(str);
	}
}