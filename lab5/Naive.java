import java.util.*;
public class Naive{
	private static final int DELTA = -4;
	int[][] costMatrix;
	private HashMap<String, HashMap<String, Integer>> misMatchCostMap;
	private ArrayList<String> arr1;
	private ArrayList<String> arr2;
	private StringBuffer sb1;
	private StringBuffer sb2;

	public Naive(){
		misMatchCostMap = (new MisMatchCostParser()).parse();
	}

	public void findAlignment(ArrayList<String> arr1, ArrayList<String> arr2){
		this.arr1 = arr1;
		this.arr2 = arr2;

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
		sb1 = new StringBuffer();
		sb2 = new StringBuffer();


		int[] coor = new int[2];
		coor[0] = costMatrix.length-1; //row
		coor[1] = costMatrix[0].length-1;	//col
		while(coor[0]!=0 && coor[1]!=0){
			coor = findNextLegalCoordinate(coor);
		} 
		System.out.println(arr1.get(0)+ "--"+arr2.get(0) + ": " + costMatrix[costMatrix.length-1][costMatrix[0].length-1]);
		System.out.println(sb1.reverse().toString());
		System.out.println(sb2.reverse().toString());

	}

	private int[] findNextLegalCoordinate(int[] coor){
		int row = coor[0];
		int col = coor[1];
		if(col==0){
			for(int i=row; i>0; i--){
				sb1.append(arr1.get(i));
				sb2.append("-");
			}
			coor[0] = 0;
			return coor;
		} else if(row==0){
			for(int i=col; i>0; i--){
				sb1.append("-");
				sb2.append(arr2.get(i));
			}
			coor[1] = 0;
			return coor;
		}
		int currentCost = costMatrix[row][col];
		int notDiagonal = currentCost-DELTA;	

		if(notDiagonal==costMatrix[row-1][col]){
			sb1.append(arr1.get(row));
			sb2.append("-");
			coor[0] = row-1;
			coor[1] = col;
			return coor;
		} else if(notDiagonal == costMatrix[row][col-1]){
			sb1.append("-");
			sb2.append(arr2.get(col));
			coor[0] = row;
			coor[1] = col-1;
			return coor;
		} else{
			sb1.append(arr1.get(row));
			sb2.append(arr2.get(col));
			coor[0] = row-1;
			coor[1] = col-1;
			// System.out.println("row: " + (coor[0]+1) + " col: " + (coor[1]+1));
			return coor;
		}
	}



	// public void print(){
	// 	for (int[] row : costMatrix){
	// 	    for (int value : row){
	// 	         System.out.print(value + "\t");
	// 	    }
	// 	    System.out.println();
	// 	}
	// }

	public static void main(String[] args){
		Naive naive = new Naive();
		DataParser dataParser = new DataParser("Toy_FASTAs.in");
		// DataParser dataParser = new DataParser("HbB_FASTAs.in");
		ArrayList<ArrayList<String>> allStrings = dataParser.getLists();

		for(int i=0; i<allStrings.size()-1; i++){
			for(int k=i+1; k<allStrings.size(); k++){
				naive.findAlignment(allStrings.get(i), allStrings.get(k));
				// naive.print();
				naive.findPath();
			}
		}
	}
}
