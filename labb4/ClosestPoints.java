import java.util.*;

public class ClosestPoints{

	public ClosestPoints(){
	}

	public Pair findClosestPoints(Point[] points){
		double shortestDist = Double.MAX_VALUE;
		int p1 = -1;
		int p2 = -1;
		for(int i=0; i<points.length; i++){
			for(int k = i+1; k<points.length; k++){
				double dist = getDistance(points[i], points[k]);
				if(dist < shortestDist){
					shortestDist = dist;
					p1 = i;
					p2 = k;
				}
			}
		}
		return new Pair(points[p1], points[p2]);
	}

	public double getDistance(Point p1, Point p2){
		double xDist = Math.abs(p1.getX()-p2.getX());
		double yDist = Math.abs(p1.getY()-p2.getY());
		return Math.sqrt(xDist*xDist+yDist*yDist);
	}


	// private int findTo(int pos, int length){
	// 	if(pos + NBR_OF_BOXES > length){
	// 		return length;
	// 	} else{
	// 		return pos + NBR_OF_BOXES;
	// 	}
	// }


	// public Pair searchBoxes(Point[] points){
	// 	double shortestDist = Double.MAX_VALUE; 
	// 	int p1 = -1;
	// 	int p2 = -1;
	// 	for(int i=0; i<points.length; i++){
	// 		int to = findTo(i, points.length);
	// 		for(int from=i+1; from<to; from++){
	// 			if(getDistance(points[from], points[i]) < shortestDist){
	// 				p1 = from;
	// 				p2 = i;
	// 			}
	// 		}
	// 	}
	// 	return new Pair(points[p1], points[p2]);
	// }
}
