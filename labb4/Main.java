import java.util.*;

public class Main{
	public static void main(String[] args){
		Parser parse = new Parser();
		ArrayList<Point> points = parse.parseInput(args[0]);
		Naive naive = new Naive();
		String str = naive.findClosestPoints(points);
		System.out.println(str);
	}
}