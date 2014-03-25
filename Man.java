import java.util.*;

public class Man{
	
	Stack<Integer> wPref;
	int id;

	public Man(int id, Stack wPref){
		this.id=id;
		this.wPref=wPref;
	}
	public int getId(){
		return id;
	}
	public int pop(){
		return 	wPref.pop();
	}
}