import java.util.*;
public class Naive{
	private static final int DELTA = -4;
	int[][] costMatrix;
	private HashMap<String, HashMap<String, Integer>> misMatchCostMap;

	public Naive(){
		misMatchCostMap = (new MisMatchCostParser()).parse();
	}

	public void findAllAllignments(String fileName){
		DataParser dataParser = new DataParser("myTest.in");
		ArrayList<ArrayList<String>> allStrings = dataParser.getLists();
		// ArrayList<Pair<String, String>[]> result = new ArrayList<Pair<String, String>[]>();
		// System.out.println(allStrings.size());

		for(int i=0; i<allStrings.size()-1; i++){
			for(int k=i+1; k<allStrings.size(); k++){
				ArrayList<String> arr1 = allStrings.get(i);
				ArrayList<String> arr2 = allStrings.get(k);
				costMatrix = new int[arr1.size()][arr2.size()];
				findAlignment(arr1, arr2);
			}
		}
	}

	private void findAlignment(ArrayList<String> arr1, ArrayList<String> arr2){
		for(int i=0; i<arr1.size(); i++){
			costMatrix[i][0] = i*DELTA;
		}
		// System.out.println(arr1.size());
		// System.out.println(arr2.size());
		for(int j=0; j<arr2.size(); j++){
			costMatrix[0][j] = j*DELTA;
		}
		for(int i=1; i<arr1.size(); i++){
			for(int j=1; j<arr2.size(); j++){
				System.out.println("i: " + i+ " letter: " + arr1.get(i));
				System.out.println("j: " + j+ " letter: " + arr2.get(j));
				int opt1 = misMatchCost(arr1.get(i), arr2.get(j)) + costMatrix[i-1][j-1];
				int opt2 = DELTA + costMatrix[i-1][j];
				int opt3 = DELTA + costMatrix[i][j-1];
				// int opt2 = DELTA + misMatchCost(arr1.get(i-1), arr2.get(j));
				// int opt3 = DELTA + misMatchCost(arr1.get(i), arr2.get(j-1));
				costMatrix[i][j] = opt(opt1, opt2, opt3); 
			}
		}
	}

	private int opt(int opt1, int opt2, int opt3){
		return Math.max(opt1, Math.max(opt2, opt3));
	}

	private int misMatchCost(String letter1, String letter2){
		HashMap<String, Integer> map = misMatchCostMap.get(letter1);
		return map.get(letter2);
	}

	public void print(){
		// System.out.println("hej");
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
	}
}
