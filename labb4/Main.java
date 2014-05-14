import java.util.*;
import java.util.*;
	
public class Main{
	private ClosestPoints closestPoints;

	public Main(){
		closestPoints = new ClosestPoints();
	}

	public Pair closestPair(Point[] points){
		Arrays.sort(points, new CompX());
		return closestPairRec(points);
	}

	private Pair closestPairRec(Point[] points){
		if(points.length <= 3){
			return closestPoints.findClosestPoints(points);
		}
		Point[] leftHalf = splitLeft(points);
		Point[] rightHalf = splitRight(points);

 		Pair sidePair = bestPair(closestPairRec(leftHalf), closestPairRec(rightHalf));

 		double x = (leftHalf[leftHalf.length-1].getX() + rightHalf[0].getX()) / 2;
 		double dist = sidePair.dist();

 		Point[] relevantPoints = relPoints(x - dist, x + dist, points);

 		Arrays.sort(relevantPoints, new CompY());
 		double minmergedist = dist;
 		Point[] blaha = fakePoints();
 		Pair mergePair = new Pair(blaha[0], blaha[1]);
 		for(int i = 0; i< relevantPoints.length-1; i++){
 			for(int j = i+1; j < relevantPoints.length && j < i+10; j++) {
 				if((new Pair(relevantPoints[i], relevantPoints[j])).dist() < minmergedist){
 					mergePair = new Pair(relevantPoints[i], relevantPoints[j]);
 					minmergedist = mergePair.dist();
 				}
 			}
 		}	
 		return sidePair.dist() < mergePair.dist() ? sidePair : mergePair;
	}

	private Point[] relPoints(double start, double end, Point[] points){
		ArrayList<Point> relevantPoints = new ArrayList<Point>();
		for(int i=0; i<points.length; i++){
			if(inRange(start, end, points[i].getX())){
				relevantPoints.add(points[i]);
			}
		}
		Point[] rP = new Point[relevantPoints.size()];
		for(int i=0; i<relevantPoints.size(); i++){
			rP[i] = relevantPoints.get(i);
		}
		return relevantPoints.size() < 2 ? fakePoints() : rP;
	}

	private boolean inRange(double start, double end, double pos){
		return (pos > start && pos < end) ? true : false;
	}

	private Point[] fakePoints(){
		Point[] points = new Point[2];
		double bigNbr = Double.parseDouble("1.14400e+100");
		points[0] = new Point(0, 0); 
		points[1] = new Point(bigNbr, bigNbr);
		return points;
	}

	private Pair bestPair(Pair left, Pair right){
		return left.dist() < right.dist() ? left : right;
	}

	private Point[] splitLeft(Point[] points){
		int length = points.length / 2;
		Point[] leftHalf = new Point[length];
		return Arrays.copyOfRange(points, 0, length);
	}

	private Point[] splitRight(Point[] points){
		int length = points.length / 2;
		Point[] rightHalf = new Point[points.length - length];
		return Arrays.copyOfRange(points, length, points.length);
	}

	public static void main(String[] args){
		Main main = new Main();
		CoolParser coolParse = new CoolParser();
		ThorParser thorParse = new ThorParser();

		HashMap<String, Double> thorRes = thorParse.parse("./testfiler/closest-pair.out");
		int count = 0;
		for (Map.Entry<String, Double> entry : thorRes.entrySet()) {
		    String key = entry.getKey();
		    Double value = entry.getValue();

			Point[] points = coolParse.parseInput("./testfiler/" + key);
			Pair closestPair = main.closestPair(points);
			Double diff = Math.abs(value - closestPair.dist());
			if(diff > 0.000000001){
				System.out.println("The diff in file: " + key + " is: " + diff);
				count++;
			}
		}
		if(count == 0){
			System.out.println("There was no diff greater than 10^-9 for all files");
		}
	}
}