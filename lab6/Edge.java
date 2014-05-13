public class Edge{  
	int city1;
	int city2;
	int maxCapacity;
	int keepTrackForward;
	int keepTrackBackword;


	//create an edge with points from city1 to city2 if nothing else is specified
	public Edge(int city1, int city2, int maxCapacity){
		this.city1 = city1;
		this.city2 = city2;
		this.maxCapacity = maxCapacity;
		keepTrackForward = maxCapacity;
		keepTrackBackword = 0;
	}


	public int getBottleNeckValue(int city){
		return city == city1 ? keepTrackForward : keepTrackBackword;
	}

	public int getOtherCity(int city){
		return city == city1 ? city2 : city1;
	}


	public void increase(int value){
		keepTrackForward -= value;
		keepTrackBackword += value;
	}

	public void decrease(int value){
		keepTrackForward += value;
		keepTrackBackword -= value;
	}

	public int getMaxCapacity(){
		return maxCapacity;
	}

	public int getKeepTrackForward(){
		return keepTrackForward;
	}

	public int getKeepTrackBackward(){
		return keepTrackBackword;
	}

	// public void getStatus(){
	// 	System.out.println();
	// }

	// public int getCity1(){
	// 	return city1;
	// }

	// public int getCity2(){
	// 	return city2;
	// }


	// public int valuePointsTo(int city){

	// }

	// public int valuePointsTo(int city){

	// }
}