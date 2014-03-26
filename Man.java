import java.util.*;

public class Man{
	
	Stack<Integer> mPref;
	int id;

	public Man(int id, Stack<Integer> mPref){
		this.id=id;
		this.mPref=mPref;
	}
	public void push(int Id){
		mPref.push(Id);
	}


	public int getId(){
		return id;
	}
	public int pop(){
		return 	mPref.pop();
	}
}