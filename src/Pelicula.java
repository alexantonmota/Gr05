import java.io.FileInputStream;
/**
 * Clase Pelicula
 * @author alex
 *
 */


public class Pelicula 
{
	protected FileInputStream cartel;
    protected String titulo;
    protected int anyo;
    protected String sinopsis;           
    protected Genero genero;  
    protected String trailer;

   
                              
   
    public Pelicula(FileInputStream cartel, String titulo, int anyo, String sinopsis, Genero genero, String trailer) {
		super();
		this.cartel = cartel;
		this.titulo = titulo;
		this.anyo = anyo;
		this.sinopsis = sinopsis;
		this.genero = genero;
		this.trailer= trailer;
	}


	public FileInputStream getCartel() {
		return cartel;
	}



	public void setCartel(FileInputStream cartel) {
		this.cartel = cartel;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
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


	public Genero getGenero() {
		return genero;
	}



	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public void mostrarInfoPelicula()
    {
        System.out.println();               
        System.out.println("Película:" + "<" + titulo + ">");
        System.out.println("Año:" + "<" + anyo + ">");
        System.out.println("Género:" + "<" + genero + ">");
        System.out.println("Sinopsis:" + "<" + sinopsis + ">");
        
    }
       
}