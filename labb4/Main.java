import java.util.*;
import java.util.*;
	
public class Main{
	private ClosestPoints closestPoints;

	public Main(){
		closestPoints = new ClosestPoints();
	}

	public Pair closestPair(Point[] points){
		CompX cX = new CompX();
		Arrays.sort(points, cX);
		Pair pair = closestPairRec(points); 
		return pair;
	}

	private Pair closestPairRec(Point[] points){
		if(points.length <= 3){
			return closestPoints.findClosestPoints(points);
		}
		Point[] leftHalf = splitLeft(points);
		Point[] rightHalf = splitRight(points);
 		Pair pLeft = closestPairRec(leftHalf);
 		Pair pRight = closestPairRec(rightHalf);

 		Pair sidePair = bestPair(pLeft, pRight);
 		double xL = leftHalf[leftHalf.length-1].getX();
 		double xR = rightHalf[0].getX();
 		double x = (xL + xR) / 2;

 		double dist = sidePair.dist();
 		double xStart = x - dist;
 		double xEnd = x + dist;

 		Point[] relevantPoints = pointsInMiddle(xStart, xEnd, leftHalf, rightHalf);
 		Arrays.sort(relevantPoints, new CompY());
 		Pair mergePair = closestPoints.searchBoxes(relevantPoints);
 		// Pair mergePair = closestPoints.findClosestPoints(relevantPoints);
 		Pair bestPair = sidePair.dist() < mergePair.dist() ? sidePair : mergePair;
 		// System.out.println("BestPair so far is: " + bestPair.print());
 		return bestPair;
	}





	private Point[] pointsInMiddle(double start, double end, Point[] leftHalf, Point[] rightHalf){
		ArrayList<Point> middlePoints = new ArrayList<Point>();
		int i = leftHalf.length-1;
		// System.out.println(leftHalf.length);
		boolean check = true;
		while(check && i>0){
			if(leftHalf[i].getX()<start){
				check = false;
			} else{
				middlePoints.add(leftHalf[i]);
			}
			i--;
		}
		check = true;
		i = 0;
		while(check && i < rightHalf.length){
			if(rightHalf[i].getX()>end){
				check = false;
			} else{
				middlePoints.add(rightHalf[i]);	
			}
			i++;
		}
		Point[] points = new Point[middlePoints.size()];
		for(int k=0; k<middlePoints.size(); k++){
			points[k] = middlePoints.get(k);
		}
		return middlePoints.size() < 2 ? fakePoints() : points;
	}

	private Point[] fakePoints(){
		Point[] points = new Point[2];
		points[0] = new Point(0, 0); 
		points[1] = new Point(100000000, 1000000000);
		// System.out.println("fakePoints says hello");
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
		CoolParser cP = new CoolParser();

		ThorParser tp = new ThorParser();
		HashMap<String, Double> thorRes = tp.parse("closest-pair.out");
		int count = 0;

		for (Map.Entry<String, Double> entry : thorRes.entrySet()) {
		    String key = entry.getKey();
		    Double value = entry.getValue();
		    // System.out.println("proccessing file: "+ key);
		    
			Point[] points = cP.parseInput("./testfiler/" + key);
			Pair closestPair = main.closestPair(points);
			Double diff = Math.abs(value - closestPair.getDistance());
			if(diff > 0.0001){
				System.out.println("The diff in file: " + key + " is: " + diff);
			}
			// System.out.println("The file name is: " + key + " the value is: "+value);
		    
		}



		// for(int i=0; i<points.length; i++){
		// 	System.out.println(points[i].getX());
		// }		
		// String str = closestPoints.findClosestPoints(points);
		// System.out.println(str);
	}
}