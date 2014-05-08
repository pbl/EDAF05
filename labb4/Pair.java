
public class Pair{
Point a, b;

	public Pair(Point a, Point b){
		this.a=a;
		this.b=b;
	}

	public double getDist(){

        return Math.sqrt(
            
            (a.getX() - b.getX()) *  (a.getX() - b.getX()) + 
            (a.getY() - b.getY()) *  (a.getY() - b.getY())

            );
	}
	

}