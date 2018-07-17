package jse;

public class ADHero extends Hero implements Mortal{

	public static void battleWin(){
		System.out.println("wo shi ADHero.");
	}
	
	@Override
	public void die() {

		System.out.println(name + " Class ADHero die.");
		
	}


}
