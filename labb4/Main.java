import java.util.*;

public class Main{
	public static void main(String[] args){
		Parser parse = new Parser();
		ArrayList<Point> points = parse.parseInput(args[0]);
		Naive naive = new Naive();
		for(int i=0; i<points.size(); i++){
			System.out.println(points.get(i).print());
		}
		System.out.println("after for loop in main");
		System.out.println();
		String str = naive.findClosestPoints(points);
		System.out.println(str);
	}
}