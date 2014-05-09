import java.util.*;
import java.io.*;

public class CoolParser{

	public CoolParser(){
	}

	public Point[] parseInput(String file){
		BufferedReader buf = null;
		ArrayList<Point> thePoints = new ArrayList<Point>();
		try{
			buf = new BufferedReader(new FileReader(file)); 
			String line = buf.readLine();

			while(!line.startsWith("NODE_COORD_SECTION")){
				line = buf.readLine();
			}
			line = buf.readLine();
			String[] wordLine = line.split(" ");
			// while(!line.startsWith("EOF")){
			while(wordLine.length > 2){

				// System.out.println("hej");
				// String[] wordLine = line.split(" ");
				// System.out.println("the line " + line);
				int count = 0;
				double xCoor = 0;
				double yCoor = 0;
				for(int i=0; i<wordLine.length; i++){
					if(!(wordLine[i].equals(""))){
						switch(count){
							case 1: 
								// System.out.println(wordLine[i]);		
								xCoor = Double.parseDouble(wordLine[i]);
								// System.out.print("xCoor is " + xCoor + "\t");
								break;
							case 2:	
								yCoor = Double.parseDouble(wordLine[i]);
								 // System.out.println("yCoor is " + yCoor);
								break;
							default:
								break;
						}
						count++;
					} 
				}
				
				Point pTemp = new Point(xCoor, yCoor);
				// System.out.println("the line " + line);
				thePoints.add(pTemp);
				line = buf.readLine();
				wordLine = line.split(" ");
			}
			// System.out.println("jag e fardig");
		}catch (IOException e){
			System.err.println("File not found: " + e.getMessage());
		}
		Point[] pointArray = new Point[thePoints.size()];	
		for(int i=0; i<thePoints.size(); i++){
			pointArray[i] = thePoints.get(i);
		}
		// System.out.println(pointArray.length);
		return pointArray;
	}
}