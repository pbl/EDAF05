import java.util.*;
import java.io.*;

public class CoolParser{
	ArrayList<Point> points;

	public CoolParser(){
	}

	public Point[] parseInput(String file){
		BufferedReader buf = null;
		points = new ArrayList<Point>();
		try{
			buf = new BufferedReader(new FileReader(file)); 
			skip
			String line = buf.readLine();
			while(!line.startsWith("NODE_COORD_SECTION")){
				line = buf.readLine();
			}

			line = buf.readLine();
			String[] wordLine = line.split(" ");
			while(wordLine.length > 2){
				addPoint(wordLine);
				line = buf.readLine();
				wordLine = line.split(" ");
			}
		}catch (IOException e){
			System.err.println("File not found: " + e.getMessage());
		}
		return transform(points);
	}

	private void addPoint(String[] wordLine){
		int nbrOfFoundWords = 0;
		double xCoor = 0;
		double yCoor = 0;
		for(int i=0; i<wordLine.length; i++){
			if(!(wordLine[i].equals(""))){
				switch(nbrOfFoundWords){
					case 1: 
						xCoor = Double.parseDouble(wordLine[i]);
						break;
					case 2:	
						yCoor = Double.parseDouble(wordLine[i]);
						break;
					default:
						break;
				}
				nbrOfFoundWords++;
			} 
		}
		points.add(new Point(xCoor, yCoor));
	}

	private Point[] transform(ArrayList<Point> arrPoints){
		Point[] points = new Point[arrPoints.size()];	
		for(int i=0; i<arrPoints.size(); i++){
			points[i] = arrPoints.get(i);
		}
		return points;
	}
}