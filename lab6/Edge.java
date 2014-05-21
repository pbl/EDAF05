public class Edge{  
	int city1;
	int city2;
	int capacity;
	int keepTrackForward;
	int keepTrackBackword;
	boolean inf;
	int pos;

	Deque dq = new Deque();

	public Edge(int city1, int city2, int capacity, int pos){
		this.city1 = city1;
		this.city2 = city2;
		inf = capacity==-1;
		this.capacity = capacity;
		keepTrackForward = capacity;
		keepTrackBackword = capacity;
		this.pos = pos;
	}
	
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
	
	public int getCapacity(){
		if(inf){
			return Integer.MAX_VALUE;
		}
		return capacity;
	}

	public void increase(int value, int city){
		if(city == city1){
			keepTrackForward -= value;
			keepTrackBackword += value;
		} else{
			keepTrackForward += value;
			keepTrackBackword -= value;
		}
	}

	public int getCity1(){
		return city1;
	}

	public int getCity2(){
		return city2;
	}
}