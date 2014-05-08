import java.util.*;

public class Main{
	public static void main(String[] args){
		Parser parse = new Parser();
		ArrayList<Point> points = parse.parseInput(args[0]);
		ClosestPoints closestPoints = new ClosestPoints();
		String str = closestPoints.findClosestPoints(points);
		System.out.println(str);
	}
}