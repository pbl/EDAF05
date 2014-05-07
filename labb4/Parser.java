//Labb4

// 1. Läs in alla punkter
// 2. Skapa 2 listor; en där punkternas x-koordinater är sorterade, och en med y-koordinater.
	
// 	=>OBS! varje koordinat i listorna måste hålla på information till vilken punkt den egentligen
// 			tillhör.

// 3. Dela upp de lika stora vektorerna i 2 "delar" (Q, R) så att vi teoretiskt har 4 vektorer.
// 4. Efter detta räknar man rekursivt ut kortaste avståndet mellan 2 punkter i Q med hjälp av Q:s 2
// 	halvor q1, q2.
// 5. Samma sak görs sedan "R-halvan".
// 6. Vad som nu kavrstår att undersöka är att kolla om det finns 2 punkter som båda härstammar från
// 	OLIKA halvor (Q, R) sådant att det är mindre än det minsta avståndet som erhålls från endast
// 	Q-halvan, och R-halvan.
// 7. Med andra ord jämför d(q1, q2), d(r1, r2), och d(q, r).
// 8. Om det inte är så att avståndet mellan d(q, r) så ver man att det finns i någon av delhalvorna

import java.util.*;
import java.io.*;


public class Parser{
	ArrayList<Point> thePoints;
	public Parser(){
		thePoints = new ArrayList<Point>();
	}

	public void parseInput(String file){
		BufferedReader buf = null;
		try{
		 buf = new BufferedReader(new FileReader(file)); //behövs "this"?
		
			String line2 = buf.readLine();			
			while(line2!=null){

				//if(line2.startsWith(" 1 "){

				String[] wordLine = line2.split(" ");
				
				double xCoor = Double.parseDouble(wordLine[1]);
				double yCoor = Double.parseDouble(wordLine[2]);
				
				Point pTemp = new Point(xCoor, yCoor);
				
				thePoints.add(pTemp);
				
				line2 = buf.readLine();

				//}else{
				//	line2 = scan.readLine();

				//}

			}

		}catch (IOException e){
			System.err.println("File not found: " + e.getMessage());
		}
			
	}

	

public static void main(String[] args){
	Parser ps = new Parser();
	ps.parseInput(args[0]);
}
}