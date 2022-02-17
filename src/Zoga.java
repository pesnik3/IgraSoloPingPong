
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Zoga {
	private final int PREMER = 30;
	private int x = 0;
	private int y = 0;
	private int xPremik = 1;
	private int yPremik = 1;
	
	private Igra igra;
	
	public Zoga(Igra igra) {
		this.igra = igra;
	}
	
	public void narisi(Graphics2D g2D) {
		g2D.fillOval(x,  y,  PREMER, PREMER);
	}
	
	public void premakni() {
		if(this.x + 1 > igra.getWidth() - PREMER) {
			this.xPremik = -1;
			
		}
		if(this.y + 1 > igra.getHeight() - PREMER) {
			igra.konecIgre();
		}
		if(this.x == 0) {
			this.xPremik = 1;
		}
		if(this.y == 0) {
			this.yPremik = 1;
		}
		
		if(this.trkZLoparjem() ) {
			this.yPremik = -1;
			igra.povecajTocke();
		}
		
		this.x += xPremik;
		this.y += yPremik;
	}
	
	private Rectangle getMejeZoge() {
		return new Rectangle(this.x, this.y, PREMER, PREMER);
	}
	
	private boolean trkZLoparjem() {
		return igra.lopar.getMejaLoparja().intersects(this.getMejeZoge());
	}

}
