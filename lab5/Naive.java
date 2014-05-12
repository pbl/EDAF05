import java.util.*;
public class Naive{
	private static final int DELTA = -4;
	int[][] costMatrix;
	private HashMap<String, HashMap<String, Integer>> misMatchCostMap;
	private ArrayList<String> arr1;
	private ArrayList<String> arr2;

	public Naive(){
		misMatchCostMap = (new MisMatchCostParser()).parse();
	}

	public void findAllAllignments(String fileName){
		DataParser dataParser = new DataParser("myTest.in");
		ArrayList<ArrayList<String>> allStrings = dataParser.getLists();

		for(int i=0; i<allStrings.size()-1; i++){
			for(int k=i+1; k<allStrings.size(); k++){
				arr1 = allStrings.get(i);
				arr2 = allStrings.get(k);
				findAlignment(arr1, arr2);
			}
		}
	}

	private void findAlignment(ArrayList<String> arr1, ArrayList<String> arr2){
		costMatrix = new int[arr1.size()][arr2.size()];
		for(int i=0; i<arr1.size(); i++){
			costMatrix[i][0] = i*DELTA;
		}
		for(int j=0; j<arr2.size(); j++){
			costMatrix[0][j] = j*DELTA;
		}
		for(int row=1; row<arr1.size(); row++){
			for(int col=1; col<arr2.size(); col++){
				int cost1 = misMatchCost(arr1.get(row), arr2.get(col)) + costMatrix[row-1][col-1];
				int cost2 = DELTA + costMatrix[row][col-1];
				int cost3 = DELTA + costMatrix[row-1][col];
				costMatrix[row][col] = opt(cost1, cost2, cost3); 
				// System.out.println("row, col: " + row + " ," + col + " value: " + costMatrix[row][col]);
			}
		}
	}

	private int opt	(int cost1, int cost2, int cost3){
		return Math.max(cost1, Math.max(cost2, cost3));
	}

	private int misMatchCost(String letter1, String letter2){
		return misMatchCostMap.get(letter1).get(letter2);
	}

	public void findPath(){
		int[] coor = new int[2];
		coor[0] = costMatrix.length-1; //row
		coor[1] = costMatrix[0].length-1;	//col
		System.out.println("row: " + (coor[0]+1) + " col: " + (coor[1]+1));
		while(coor[0]!=0 && coor[1]!=0){
			coor = findNextLegalCoordinate(coor);
			System.out.println("row: " + (coor[0]+1) + " col: " + (coor[1]+1));
		} 
	}

	private int[] findNextLegalCoordinate(int[] coor){
		int row = coor[0];
		int col = coor[1];
		if(col==0){
			coor[0] = 0;
			coor[1] = 0;
			return coor;
		} else if(row==0){
			coor[0] = 0;
			coor[1] = 0;
			return coor;
		}
		int currentCost = costMatrix[row][col];
		int notDiagonal = currentCost-DELTA;	

		if(notDiagonal==costMatrix[row-1][col]){
			coor[0] = row-1;
			coor[1] = col;
			return coor;
		} else if(notDiagonal == costMatrix[row][col-1]){
			coor[0] = row;
			coor[1] = col-1;
			return coor;
		} else{
			coor[0] = row-1;
			coor[1] = col-1;
			System.out.println("row: " + (coor[0]+1) + " col: " + (coor[1]+1));
			return coor;
		}
	}



	public void print(){
		for (int[] row : costMatrix){
		    for (int value : row){
		         System.out.print(value + "\t");
		    }
		    System.out.println();
		}
	}

	public static void main(String[] args){
		Naive naive = new Naive();
		naive.findAllAllignments("asds");
		naive.print();
		naive.findPath();
	}
}
