public class unParse{

int nbrOfPairs;
char prev;

public void unParse(String fileName) { 

		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte hittas");
			System.exit(1);
		}

		while (scan.hasNext()) {
			String line = scan.nextLine();
			While(line.startsWith("#")){
				line = scan.nextLine();
			}
			if(line.contains("=")){
				nbrOfPairs = Integer.parseInt(line.Split("=")[1]);
			}
			if (line.contains(":")){
				String list = line.substring(3);
				int[]prefList = Integer.parseInt(list.Split(" "));
				for(inti=0;i<nbrOfPais;i++){
				menpref.add(i);
				}





nextInt()
Scans the next token of the input as an int.
			}
		}
	 
}