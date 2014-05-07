import java.util.*;
import java.awt.*;

public class Naive{
	private ArrayList<Point> points;

	public Naive(){
		points = new ArrayList<Point>();
		Point one = new Point(0, 0);
		Point two = new Point(2, 3);
		Point three = new Point(-20, -25);
		Point four = new Point(30, 24);
		points.add(one);
		points.add(two);
		points.add(three);
		points.add(four);
	}

	public String findClosestPoints(){
		double shortestDist = Double.MAX_VALUE;
		double xDist = 0;
		double yDist = 0;
		String str = "";
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
		str = str.concat(String.valueOf(xDist) + " " + String.valueOf(yDist));
		return str;
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

	public static void main(String[] args){
		Naive naive = new Naive();
		String points = naive.findClosestPoints();
		System.out.println(points);

	}
}
