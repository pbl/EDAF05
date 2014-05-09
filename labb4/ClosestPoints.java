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

	public Pair searchBoxes(Point[] points){
		// System.out.println("Searchboxes: " + points.length);
		// System.out.println(points[0]);
		// System.out.println(points[1]);
		double shortestDist = Double.MAX_VALUE; 
		int p1 = -1;
		int p2 = -1;
		for(int i=0; i<points.length; i++){
			int end = findEnd(i, points.length);
			// System.out.println("kommer jag hit1");
			// System.out.println("end har value: " + end);
			for(int begin = i + 1; begin < end; begin++){
				// System.out.println("kommer jag hit2");
				// System.out.println("begin has the value: " + begin);
				// System.out.println("i has the value: " + i);
				// System.out.println(getDistance(points[begin], points[i]));
				if(getDistance(points[begin], points[i]) < shortestDist){
					// System.out.println("kommer jag hit3");
					p1 = begin;
					p2 = i;
				}
			}
		}
		// System.out.println("sdfn");
		// System.out.println(p1);
		// System.out.println(p2);
		return new Pair(points[p1], points[p2]);
	}

	private int findEnd(int pos, int length){
		// int[] range = new int[2];
		// int begin = pos;
		// int count = 0;
		// while(begin > 0 && count < 8){
		// 	begin--;
		// 	count++;
		// }
		// range[0] = begin;
		if(pos + 8 > length){
			return  length;
		} else{
			return pos + 8;
		}

		// int end = pos;
		// int count = 0;
		// while(end < length && count < 8){
		// 	end++;
		// 	count++;
		// }
		// // range[1] = end;
		// // System.out.println("Range for: " + pos + " is begin " + range[0] + " is end " + range[1]);
		// return end;
	}

	public double getDistance(Point p1, Point p2){
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
