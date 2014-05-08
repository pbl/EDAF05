import java.util.*;

public class ClosestPoints{

	public ClosestPoints(){
	}

	public String findClosestPoints(ArrayList<Point> points){
		double shortestDist = Double.MAX_VALUE;
		double xDist = 0;
		double yDist = 0;
		for(int i=0; i<points.size(); i++){
			for(int k = i+1; k<points.size(); k++){
				double dist = getDistance(points.get(i), points.get(k));
				if(dist < shortestDist){
					shortestDist = dist;
					xDist = Math.abs(points.get(i).getX() - points.get(k).getX());
					yDist = Math.abs(points.get(i).getY() - points.get(k).getY());
				}
			}
		}
		return String.valueOf(xDist) + " " + String.valueOf(yDist);
	}

	private double getDistance(Point p1, Point p2){
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();

		double xDist = Math.abs(x1-x2);
		double yDist = Math.abs(y1-y2);

		double dist = Math.sqrt(xDist*xDist+yDist*yDist);
		return dist;
	}
}
