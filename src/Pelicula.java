import java.awt.Image;
import java.io.FileInputStream;
/**
 * Clase Pelicula
 * @author alex
 *
 */


public class Pelicula 
{
    private String titulo;
    private Genero genero; 
    private int anyo;
    private String sinopsis;           
    private int duracion;
    private String trailer;
    private String rutaFoto;
    private String rutaFotoMenu;
    

   
                        
   
   	public Pelicula(String titulo, Genero genero, int anyo, String sinopsis, int duracion, String trailer,String rutaFoto, String rutaFotoMenu) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.anyo = anyo;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.trailer = trailer;
		this.rutaFoto = rutaFoto;
		this.rutaFotoMenu = rutaFotoMenu;
	}
	public Pelicula(){
		
	}
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
	public String getRutaFoto() {
		return rutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}
	public String getRutaFotoMenu() {
		return rutaFotoMenu;
	}
	public void setRutaFotoMenu(String rutaFotoMenu) {
		this.rutaFotoMenu = rutaFotoMenu;
	}
	
	
	public void mostrarInfoPelicula()
    {
        System.out.println();               
        System.out.println("Película:" + "<" + titulo + ">");
        System.out.println("Género:" + "<" + genero + ">");
        System.out.println("Sinopsis:" + "<" + sinopsis + ">");
        System.out.println("Duracion:" + "<" + duracion + ">");
        
    }
       
}