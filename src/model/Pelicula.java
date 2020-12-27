package model;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase Pelicula
 * @author alex
 *
 */


public class Pelicula 
{
	private String titulo;
	private String genero; 
	private int anyo;
	private String sinopsis;           
	private int duracion;
	private String trailer;
	private String rutaFoto;
	private String rutaFotoMenu;
	private ImageIcon poster;


	public Pelicula(String titulo, String genero, int anyo, String sinopsis, int duracion, String trailer,String rutaFoto, String rutaFotoMenu) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.anyo = anyo;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.trailer = trailer;
		this.rutaFoto = rutaFoto;
		this.rutaFotoMenu = rutaFotoMenu;
		this.poster = posterPelicula(titulo);
	}
	public Pelicula(){

	}



	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return String.valueOf(Genero.values());
	}
	public void setGenero(String genero) {
		this.genero = String.valueOf(Genero.values());
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
	public ImageIcon getPoster() {
	
		return poster;
	}

	public void setCover(ImageIcon poster) {
		this.poster = poster;
	}

	public static ImageIcon posterPelicula(String titulo) {

		ImageIcon imageIcon = new ImageIcon("/Users/alex/eclipse-workspace5/G05/Imagenes/" + titulo + ".jpg");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(200, 277, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		

		return imageIcon;

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