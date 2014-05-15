public class Edge{  
	int city1;
	int city2;
	int capacity;
	int keepTrackForward;
	int keepTrackBackword;
	boolean inf;
	int flow;

	//create an edge with points from city1 to city2 if nothing else is specified
	public Edge(int city1, int city2, int capacity){
		this.city1 = city1;
		this.city2 = city2;
		inf = capacity==-1;
		this.capacity = capacity;
		keepTrackForward = capacity;
		keepTrackBackword = capacity;
		flow = 0;
	}

	public boolean isInf(){
		return inf;
	}

	public int getBottleNeckValue(int city){
		return city == city1 ? keepTrackForward : keepTrackBackword;
	}

	public boolean canUseEdge(int city){
		return city == city1 ? keepTrackForward > 0 : keepTrackBackword > 0;
	}

	public int getOtherCity(int city){
		return city == city1 ? city2 : city1;
	}

	//is this method really neccesary??
	// public int getFlow(){
	// 	return Math.abs(capacity - keepTrackForward);
	// }

	public int getCapacity(){
		return capacity;
	}

	public void increase(int value, int city){
		//wht happens with flow??
		if(city == city1){
			keepTrackForward -= value;
			keepTrackBackword += value;
		} else{
			keepTrackForward += value;
			keepTrackBackword -= value;
		}
	}

	// public void decrease(int value){
	// 	keepTrackForward += value;
	// 	keepTrackBackword -= value;
	// }

	// public int getKeepTrackForward(){
	// 	return keepTrackForward;
	// }

	// public int getKeepTrackBackward(){
	// 	return keepTrackBackword;
	// }

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