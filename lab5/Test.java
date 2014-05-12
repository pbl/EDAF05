import java.lang.*;
import java.sql.*;
import java.util.*;

public class Test{

	public Test(){

	}

	public static void main(String[] args){

		// DataParser parser = new DataParser("myTest.in");
		// ArrayList<ArrayList<String>> lists = parser.getLists();
		int row = 1;
		int col = 4;
		int[][] test = new int[row][col];

		// test[0][0] = 2;

		for (int[] rows : test){
		    for (int value : rows){
		         System.out.print(value + "\t");
		    }
		    System.out.println();
		}
	}
}
