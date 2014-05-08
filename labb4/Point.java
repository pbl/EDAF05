import java.util.*;
import java.io.*;
import java.awt.*;

public class Point{
	double x, y;
	
	public Point(double x, double y){
		this.x=x;
		this.y=y;
	}

	public double getX(){
		return x;
	}

	public double getY(){
		return y;	
	}

	public String print(){
		return String.valueOf(x) + " " + String.valueOf(y);
	}

	// @Override
	// public int compareTo(Point point){
	// 	return x - point.x;
	// }
}