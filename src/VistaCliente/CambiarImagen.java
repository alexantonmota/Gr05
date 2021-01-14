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
		
		
		
		int velocidad=3;
		
		Timer timer;
		TimerTask tarea;
		
		int velmil= velocidad*1000;
		
		MenuPrincipal cartelera= new MenuPrincipal();
		cartelera.setVisible(true);
		
		//tarea para ir cambiando las imágenes del menú principal cada x segundos
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
					ImageIcon im2= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/anabelle.jpg");
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
					contador=5;
					ImageIcon im4= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/fantasy.jpg");
					Icon ic4= new ImageIcon(im4.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic4);
					cartelera.repaint();
					
				
					break;
				case 5:
					contador=6;
					ImageIcon im5= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/frozen.jpg");
					Icon ic5= new ImageIcon(im5.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic5);
					cartelera.repaint();
					
				
					break;
				
				case 6:
					contador=7;
					ImageIcon im6= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/avatar.jpg");
					Icon ic6= new ImageIcon(im6.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic6);
					cartelera.repaint();
					
				
					break;
				case 7:
					contador=8;
					ImageIcon im7= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/escape.jpg");
					Icon ic7= new ImageIcon(im7.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic7);
					cartelera.repaint();
					
				
					break;
				case 8:
					contador=9;
					ImageIcon im8= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/padre.jpg");
					Icon ic8= new ImageIcon(im8.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic8);
					cartelera.repaint();
					
				
					break;
				case 9:
					contador=10;
					ImageIcon im9= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/soul.jpg");
					Icon ic9= new ImageIcon(im9.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic9);
					cartelera.repaint();
					
				
					break;
				case 10:
					contador=11;
					ImageIcon im10= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/coro.jpg");
					Icon ic10= new ImageIcon(im10.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic10);
					cartelera.repaint();
					
				
					break;
					
				case 11:
					contador=0;
					ImageIcon im11= new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/PostersMenuPrincipal/avengers.jpeg");
					Icon ic11= new ImageIcon(im11.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic11);
					cartelera.repaint();
					
				
					break;
					
					
				
				
				
				}
				
			}
			
			
		};
		
		timer = new Timer();
		timer.scheduleAtFixedRate(tarea,velmil,velmil);
	}
	

}
