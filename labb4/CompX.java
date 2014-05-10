import java.util.*;

public class CompX implements Comparator<Point>{

	public int compare(Point p1, Point p2){
		if(p1.getX() == p2.getX()){
			return 0;
		}
		return p1.getX() - p2.getX() >= 0 ? 1 : -1;
	}
}