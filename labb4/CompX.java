import java.util.*;

public class CompX implements Comparator<Point>{
	private int count = 0;

	public int compare(Point o1, Point o2){
		// if(o1 instanceof Point && o2 instanceof Point){

		// System.out.println(count++);
		// System.out.println("hej");
		Point p1 = o1;
		Point p2 = o2;
		// System.out.println(p1.getX() + " " + p2.getX());
		// System.out.println(p1.getX() - p2.getX() > 0 ? 1 : -1);
		if(p1.getX() == p2.getX()){
			return 0;
		}
		return p1.getX() - p2.getX() >= 0 ? 1 : -1;
	// } else {
	// 	return 1;
	// }
	}
}