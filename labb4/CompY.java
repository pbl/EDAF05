import java.util.*;

public class CompY implements Comparator<Point>{

	public int compare(Point o1, Point o2){
		Point p1 = o1;
		Point p2 = o2;
		if(p1.getY() == p2.getY()){
			return 0;
		}
		return p1.getY() - p2.getY() > 0 ? 1 : -1;
	}
}