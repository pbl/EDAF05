import java.util.*;

public class Comp implements Comparator{

	public int compare(Object o1, Object o2){
		Point p1 = (Point) o1;
		Point p2 = (Point) o2;
		return p1.getX() - p2.getX() ? 1 : -1;
	}
}