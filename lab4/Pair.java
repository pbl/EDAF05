public class Pair{
	private Point p1;
	private Point p2;
	
	public Pair(Point p1, Point p2){
		this.p1 = p1;
		this.p2 = p2;
	}

	public double dist(){
		return (new ClosestPoints()).getDistance(p1, p2);
	}
}

