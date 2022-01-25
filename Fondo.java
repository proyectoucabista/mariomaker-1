


import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


import java.awt.Color;

public class Fondo{
	
	private static final Image
		CIELO = (new ImageIcon("Imagenes/nubes.gif")).getImage(),
		LADRILLO = (new ImageIcon("Imagenes/bloqueOscuro.gif")).getImage(),
		CESPED = (new ImageIcon("Imagenes/suelo.jpg")).getImage();
	
	private boolean underground;
	
	public static final Color
		CIELO_COLOR = new Color(63,191,255),
		UNDERGROUND_COLOR = Color.BLACK;
	
	private static final double
		CIELO_MULTI = 0.1,
		TIERRA_MULTI = 1.0;
	
	// crear tema undegraund, falso si no
	public Fondo(boolean underground){
		this.underground = underground;
    }
	
	
	public boolean isUnderground(){
		return underground;
	}
    /**
     * determinar color del fondo
     */
    public void draw(Graphics g, java.awt.image.ImageObserver o, Hero hero){
		double viewX = hero.viewX();
		double viewY = hero.viewY();
		if(underground)
			g.setColor(UNDERGROUND_COLOR);
		else
			g.setColor(Fondo.CIELO_COLOR);
		g.fillRect(0, 0, JGameMaker.screenWidth, JGameMaker.screenHeight);
    	Image ground;
    	int groundHeight,groundWidth;
    	//g.setColor(CIELO_COLOR);
    	if(!underground){
    		ground = CESPED;
	    	groundHeight = ground.getHeight(o);
	    	groundWidth = ground.getWidth(o);
	    	int skyHeight = CIELO.getHeight(o)*3,
	    		skyWidth = CIELO.getWidth(o)*3;
	    		
	    	
	    	double x = -viewX*CIELO_MULTI;
	    	double y = (viewY - (JGameMaker.screenHeight - JGameMaker.NIVEL_SUELO))*CIELO_MULTI;
	    	while(x > 0)
	    		x -= skyWidth;
	    	((Graphics2D)g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
	    	for(; x < JGameMaker.screenWidth; x+=skyWidth){
	    		g.drawImage(CIELO, JGameMaker.scaleW(x),JGameMaker.scaleH(y),JGameMaker.scaleW(skyWidth),JGameMaker.scaleH(skyHeight),o);
	    	}
	    	((Graphics2D)g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));


			
    	}else{
    		ground = LADRILLO;
	    	groundHeight = ground.getHeight(o)*2;
	    	groundWidth = ground.getWidth(o)*2;
    	}
    	
    	
    	for(double y = viewY; y < JGameMaker.screenHeight; y+=groundHeight){
    		double x = viewX;
	    	x *= -TIERRA_MULTI;
	    	while(x > 0)
	    		x -= groundWidth;
	    		
	    	for(; x < JGameMaker.screenWidth; x+=groundWidth){
	    		g.drawImage(ground, JGameMaker.scaleW(x),JGameMaker.scaleH(y),JGameMaker.scaleW(groundWidth),JGameMaker.scaleH(groundHeight),o);
	    	}
    	}
    }
	
	
}