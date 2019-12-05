package main;

import java.util.ArrayList;

import spotpackage.*;

public class Test {
	static boolean checkcontains(ArrayList<Spot> spotlist, Spot obj) {
		if(spotlist.contains(obj)) {
			return true;
		}
		return false;
	};
	static void print(ArrayList<Spot> arr){
		for(Spot obj: arr){
			System.out.print(obj.p+", ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		ArrayList<Spot> mlist = new ArrayList();
		mlist.add(new Hazard(1,1));
		mlist.add(new Hazard(1,2));
		print(mlist);
		mlist.remove(new Hazard(1,1));
		print(mlist);
		
	}

}
