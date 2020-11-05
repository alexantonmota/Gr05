/**
 * Clase Entrada con sus atributos
 * @author alex
 *
 */

public class Entrada{
	
		private Pelicula infoPelicula;
		private Sesion infoSesion;
		private Sala infoSala;
	    private int precio;
	    private int cantidad;
	    


public Entrada(Pelicula infoPelicula, Sesion infoSesion, Sala infoSala, int precio, int cantidad) {
			super();
			this.infoPelicula = infoPelicula;
			this.infoSesion = infoSesion;
			this.infoSala = infoSala;
			this.precio = precio;
			this.cantidad = cantidad;
		}

public Pelicula getInfoPelicula() {
	return infoPelicula;
}

public void setInfoPelicula(Pelicula infoPelicula) {
	this.infoPelicula = infoPelicula;
}

public Sesion getInfoSesion() {
	return infoSesion;
}

public void setInfoSesion(Sesion infoSesion) {
	
	this.infoSesion = infoSesion;
}
public Sala getInfoSala() {
	return infoSala;
}

public void setInfoSala(Sala infoSala) {
	this.infoSala = infoSala;
}

public int getPrecio() {
	return precio;
}

public void setPrecio(int precio) {
	this.precio = precio;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public void mostrarInfoEntrada() {
	 System.out.println();               
     System.out.println("Película:" + "<" + infoPelicula.titulo + ">");
     System.out.println("Sesion:" + "<" + infoSesion.hora + ">");
     System.out.println("Sala:" + "<" + infoSala.nombre + ">");
     System.out.println("Asiento:" + "<" + infoSala.numAsientos+ ">");
     System.out.println("Cantidad:" + "<" + cantidad + ">");
     System.out.println("Precio:" + "<" + precio + ">");
     

	    
		
}
}
