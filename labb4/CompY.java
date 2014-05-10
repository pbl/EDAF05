import java.util.*;

public class CompY implements Comparator<Point>{

	public int compare(Point p1, Point p2){
		if(p1.getY() == p2.getY()){
			return 0;
		}
		return p1.getY() - p2.getY() > 0 ? 1 : -1;
	}
}