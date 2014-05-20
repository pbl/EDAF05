public class Edge{  
	int city1;
	int city2;
	int capacity;
	int keepTrackForward;
	int keepTrackBackword;
	boolean inf;
	int flow; 
	int pos;

	//create an edge with points from city1 to city2 if nothing else is specified
	public Edge(int city1, int city2, int capacity, int pos){
		this.city1 = city1;
		this.city2 = city2;
		inf = capacity==-1;
		this.capacity = capacity;
		keepTrackForward = capacity;
		keepTrackBackword = capacity;
		flow = 0; //uneccessary
		this.pos = pos;
	}
	

	//unnecessary, can use method canUseEdge instead. Gives the same result	
	public boolean isMaxed(int city){
		if(inf){
			return false;
		}
		return city == city1 ? keepTrackForward==0 : keepTrackBackword==0;
	}

	public int getPos(){
		return pos;
	}

	public int getBottleNeckValue(int city){
		if(inf){
			return Integer.MAX_VALUE;
		}
		return city == city1 ? keepTrackForward : keepTrackBackword;
	}

	//more or less the same as getBottleNeck value
	public boolean canUseEdge(int city){
		if(inf){
			return
			 true;
		}
		return city == city1 ? keepTrackForward > 0 : keepTrackBackword > 0;
	}

	public int getOtherCity(int city){
		return city == city1 ? city2 : city1;
	}
	
	//is this method used???
	public int getCapacity(){
		if(inf){
			return Integer.MAX_VALUE;
		}
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

	//are these two methods used??
	public int getCity1(){
		return city1;
	}

	public int getCity2(){
		return city2;
	}

	// public boolean isInf(){
	// 	return inf;
	// }
	

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


}