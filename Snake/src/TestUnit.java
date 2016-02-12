import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestUnit {

	@Test
	public void testPlansza() {
		//fail("Not yet implemented");
	}

	@Test
	public void testInitGame() {
		//fail("Not yet implemented");
	
	}

	@Test
	public void testDajZarcie() {

		int licznik =0;
		Plansza plansza= new Plansza();
		for (int i=0;i<1000;i++){
		
		
		plansza.dajZarcie();
	
		System.out.println(plansza.jedzenie);
		System.out.println(licznik + "  dubli = "+ plansza.licznik);
		assertEquals(true, plansza.jedzenie);
		licznik++;
		}
		

		
	}

	@Test
	public void testPaintComponentGraphics() {
		//fail("Not yet implemented");
	}

	@Test
	public void testMove() {
		//fail("Not yet implemented");
	}

	@Test
	public void testActionPerformed() {
		//fail("Not yet implemented");
	}

}
