import java.util.*;

public class Main{
	private static final int DELTA = -4;
	private HashMap<String, HashMap<String, Integer>> misMatchCostMap;

	public Main(){
		misMatchCostMap = (new MisMatchCostParser()).parse();
	}

	public ArrayList<Pair<String, String>> findAllAllignments(String fileName){
		DataParser dataParser = new DataParser(fileName);
		ArrayList<ArrayList<String>> allStrings = dataParser.getLists();
		ArrayList<Pair<String, String>[]> result = new ArrayList<Pair<String, String>[]>();

		for(int i=0; i<allStrings.size()-1; i++){
			for(int k=i+1; k<allStrings.size(); k++){
				result.add(findAlignment(allStrings.get(i), allStrings.get(k)));
			}
		}
		return result;
	}

	private Pair<String, String>[] findAlignment(ArrayList<String> arr1, ArrayList<String> arr2){
		Pair<String, String>[] allPairs = new Pair<String, String>[arr1.size() + arr2.size()];



		for(int i=1; i<arr1.size(); i++){
			for(int j=1; j<arr2.size(); j++){
				
			}

		}

	}

	private Pair<String, String> optPair(){

	}



	private int misMatchCost(String letter1, String letter2){
		HashMap<String, Integer> map = misMatchCostMap.get(letter1);
		return map.get(letter2);
	}

	private int opt(ArrayList<String> arr1, ArrayList<String> arr2, int i, int j){		
		int pos = Math.max(i, j);
		int sizeOfLargestArray = Math.max(arr1.size(), arr2.size());
		if(i == sizeOfLargestArray && j==sizeOfLargestArray){
			// int costForCurrentLetters = cost(arr1.get(i), arr2.get(j));
			// int costForNextWithI = cost(arr1.get(i), "*") + opt(arr1, arr2, i+1, j);
			// int costForNextWithJ = cost("*", arr2.get(j)) + opt(arr1, arr2, i, j+1);	
			return 0;
			
		} else if(i == sizeOfLargestArray){
			// int costForCurrentLetters = cost(arr1.get(i), arr2.get(j)) + opt(arr1, arr2, i+1, j+1);
			// int costForNextWithI = cost(arr1.get(i), "*") + opt(arr1, arr2, i+1, j);
			int costForNextWithJ = cost("*", arr2.get(j)) + opt(arr1, arr2, i, j+1);
			return costForNextWithJ;
		} else if(j == sizeOfLargestArray){
			int costForNextWithI = cost(arr1.get(i), "*") + opt(arr1, arr2, i+1, j);
			return costForNextWithI;
		} else{
			int costForCurrentLetters = cost(arr1.get(i), arr2.get(j)) + opt(arr1, arr2, i+1, j+1);
			int costForNextWithI = cost(arr1.get(i), "*") + opt(arr1, arr2, i+1, j);
			int costForNextWithJ = cost("*", arr2.get(j)) + opt(arr1, arr2, i, j+1);
			return Math.max(costForCurrentLetters, Math.max(costForNextWithI, costForNextWithJ));			

		}
		// System.out.println("size of arr1: " + arr1.size());
		// System.out.println("i: " + i);
		// System.out.println(arr1.get(i));
		// System.out.println("size of arr2: " + arr2.size());
		// System.out.println("j: " + j);
		// System.out.println(arr2.get(j));
	}


	public static void main(String[] args){
		Main main = new Main();
		int[] cost = main.alignment();
		for(int i=0; i<cost.length; i++){
			System.out.println(cost[i]);
		}
	}
}
























