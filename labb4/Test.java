import java.util.*;

public class Test{
	public static void main(String[] args){
		Point[] points = new Point[5];
		points[0] = new Point(3, 5);
		points[1] = new Point(3, 5);
		points[2] = new Point(3, 5);
		points[3] = new Point(3, 5);
		points[4] = new Point(3, 5);

		int length = points.length / 2;
		Point[] leftHalf = new Point[length];
		Point[] rightHalf = new Point[points.length - length];
		leftHalf = Arrays.copyOfRange(points, 0, length);
		rightHalf = Arrays.copyOfRange(points, length, points.length);
		System.out.println(leftHalf.length);
		System.out.println(rightHalf.length);
		System.out.println(leftHalf[1].getX());
		System.out.println(rightHalf[2].getX());
		
	}
}