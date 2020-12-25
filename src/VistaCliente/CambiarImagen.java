package VistaCliente;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Clase que permite mediante una tarea que las imagenes vayan cambiando en base a un Timer
 * @author alex
 *
 */
public class CambiarImagen {
	
	static int contador=0;
	public static void main () {
		
		
		int velocidad=4;
		
		Timer timer;
		TimerTask tarea;
		
		int velmil= velocidad*1000;
		
		MenuPrincipal cartelera= new MenuPrincipal();
		cartelera.setVisible(true);
		
		
		tarea= new TimerTask() {

			@Override
			public void run() {
				Icon icono;
				
				switch(contador) {
				
				case 0:
					
					contador=1;
					
					ImageIcon im= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/suicide.jpg");
					Icon ic= new ImageIcon(im.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic);
					cartelera.repaint();
					
					
					break;
					
				case 1:
					
					contador=2;
					
					ImageIcon im1= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/pokemon.jpg");
					Icon ic1= new ImageIcon(im1.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic1);
					cartelera.repaint();
					break;
					
					
				case 2:
					contador=3;
					ImageIcon im2= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/tombraider.jpg");
					Icon ic2= new ImageIcon(im2.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic2);
					cartelera.repaint();
					
				
					break;
					
				case 3:
					contador=4;
					ImageIcon im3= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/mulan.jpg");
					Icon ic3= new ImageIcon(im3.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic3);
					cartelera.repaint();
					
				
					break;
						
					
					
				case 4:
					contador=0;
					ImageIcon im4= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/avengers.jpeg");
					Icon ic4= new ImageIcon(im4.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic4);
					cartelera.repaint();
					
				
					break;
					
					
				
				
				
				}
				
			}
			
			
		};
		
		timer = new Timer();
		timer.scheduleAtFixedRate(tarea,velmil,velmil);
	}

}
