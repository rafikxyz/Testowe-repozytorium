public class Waz {

	static int dlWeza;
	int[] wazX;
	int[] wazY;
	
	public Waz(int dlWeza){
		Waz.dlWeza=dlWeza;
		this.wazX = new int[dlWeza];
		this.wazY = new int[dlWeza];
		
	}
	public int getDlWeza() {
		return dlWeza;
	}
	public void setDlWeza(int dlWeza) {
		Waz.dlWeza = dlWeza;
	}
}
