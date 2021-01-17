package vistaCliente;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.pdfbox.exceptions.COSVisitorException;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDPage;
import org.pdfbox.pdmodel.edit.PDPageContentStream;
import org.pdfbox.pdmodel.font.PDType1Font;
import org.pdfbox.pdmodel.graphics.xobject.PDJpeg;

import db.Conexion;
import model.Pelicula;
/**
 * Ventana de pago que genera un pdf (no terminado) al realizar una compra
 * @author alex
 *
 */
public class Pago {

	private JFrame frame3;
	private JTextField textTarjeta;
	private JTextField textCCV;
	private int limiteTarjeta =16;
	private int limiteCCV=3;
	private JTextField textNombre;
	static int entraInicial=0;

	public int cantidad;
	public int preciot;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Pago(Pelicula p) {
		super();
		initialize(p);
		frame3.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Pelicula p) {
		frame3 = new JFrame();
		frame3.getContentPane().setBackground(Color.GRAY);
		frame3.setBounds(600, 300, 491, 356);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);


		JLabel lblNumeroTarjeta = new JLabel("Número tarjeta");
		lblNumeroTarjeta.setForeground(Color.ORANGE);
		lblNumeroTarjeta.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNumeroTarjeta.setBounds(55, 124, 157, 20);
		frame3.getContentPane().add(lblNumeroTarjeta);


		JLabel lblCcv = new JLabel("CCV");
		lblCcv.setForeground(Color.ORANGE);
		lblCcv.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblCcv.setBounds(55, 184, 69, 20);
		frame3.getContentPane().add(lblCcv);


		JLabel lblDniCliente = new JLabel("Nombre");
		lblDniCliente.setForeground(Color.ORANGE);
		lblDniCliente.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblDniCliente.setBounds(55, 92, 126, 20);
		frame3.getContentPane().add(lblDniCliente);


		JLabel lblIntroduceLosDatos = new JLabel("PAGO");
		lblIntroduceLosDatos.setForeground(Color.ORANGE);
		lblIntroduceLosDatos.setBackground(Color.GRAY);
		lblIntroduceLosDatos.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblIntroduceLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceLosDatos.setBounds(-23, 23, 534, 49);
		frame3.getContentPane().add(lblIntroduceLosDatos);

		textTarjeta= new JTextField();
		textTarjeta.setBounds(263, 122, 152, 26);
		frame3.getContentPane().add(textTarjeta);
		textTarjeta.setColumns(10);
		textTarjeta.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (textTarjeta.getText().length()== limiteTarjeta | !Character.isDigit(c))

					e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
		});

		textCCV = new JTextField();
		textCCV.setBounds(263, 182, 62, 26);
		frame3.getContentPane().add(textCCV);
		textCCV.setColumns(10);
		textCCV.addKeyListener(new KeyListener(){


			public void keyTyped(KeyEvent e)

			{
				char c=e.getKeyChar();
				if (textCCV.getText().length()== limiteCCV| !Character.isDigit(c)) {

					e.consume();}
			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
		});

		//Al clickar genera la entrada en un pdf (Contenido del fichero no terminado)
		JButton btnPagar = new JButton("Aceptar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VentanaEntrada ve= new VentanaEntrada(p);
				ArrayList<Integer> numeros= new ArrayList<Integer>();
				numeros.clear();
				numeros.add(ve.numAleatorio);


				FileWriter archivo=null;
				PrintWriter escribir= null;

				try{

					String sql1= "SELECT cantidad, preciototal,horario from Otros"; 

					Conexion conexion1 = new Conexion();
					Connection cn1 = conexion1.conectar();
					PreparedStatement ps1= null;
					try {
						ps1 = cn1.prepareStatement(sql1);
						ResultSet rs = ps1.executeQuery();

						while(rs.next()) {


							PDDocument entrada = new PDDocument();
							PDPage pagina= new PDPage();
							entrada.addPage(pagina);
							String nombre="entrada"+ String.valueOf(numeros.get(0))+".pdf";

							InputStream in = new FileInputStream(new File(p.getRutaFoto()));
							PDJpeg img = new PDJpeg(entrada, in);
							img.setHeight(400);
							img.setWidth(200);

							int cant= rs.getInt("cantidad");
							double prect =rs.getDouble("preciototal");
							String horario= rs.getString("horario");
							PDPageContentStream contenido= new PDPageContentStream(entrada,pagina);

							contenido.beginText();
							contenido.setFont(PDType1Font.COURIER,18);
							contenido.moveTextPositionByAmount(100,650);
							contenido.drawString("CINE DEUSTO");
							contenido.endText();

							contenido.beginText();
							contenido.setFont(PDType1Font.COURIER,18);
							contenido.moveTextPositionByAmount(100,650);		
							contenido.drawString("___________");		 		 		
							contenido.endText();

							contenido.beginText();
							contenido.setFont(PDType1Font.COURIER,16);
							contenido.moveTextPositionByAmount(100,580);		
							contenido.drawString("Numero de compra: "+ numeros.get(0));	 		 		
							contenido.endText();

							contenido.beginText();
							contenido.setFont(PDType1Font.COURIER,16);
							contenido.moveTextPositionByAmount(100,560);		
							contenido.drawString("Nombre: " +textNombre.getText());	 		 		
							contenido.endText();

							contenido.beginText();
							contenido.setFont(PDType1Font.COURIER,16);
							contenido.moveTextPositionByAmount(100,540);		
							contenido.drawString("Pelicula: "+ p.getTitulo());		 		
							contenido.endText();

							contenido.beginText();
							contenido.setFont(PDType1Font.COURIER,16);
							contenido.moveTextPositionByAmount(100,520);		
							contenido.drawString("Sesion: "+ horario);		 		
							contenido.endText();

							contenido.beginText();
							contenido.setFont(PDType1Font.COURIER,16);
							contenido.moveTextPositionByAmount(100,500);		
							contenido.drawString("Sala: "+ p.getSala());	 		
							contenido.endText();

							contenido.beginText();
							contenido.setFont(PDType1Font.COURIER,16);
							contenido.moveTextPositionByAmount(100,480);		
							contenido.drawString("Numero de entradas: "+ cant);		
							contenido.endText();

							contenido.beginText();
							contenido.setFont(PDType1Font.COURIER,16);
							contenido.moveTextPositionByAmount(100,460);		
							contenido.drawString("Precio por entrada: "+ ve.txtPrecU.getText());
							contenido.endText();

							contenido.beginText();
							contenido.setFont(PDType1Font.COURIER,16);
							contenido.moveTextPositionByAmount(100,440);		
							contenido.drawString("Precio total: "+ prect);
							contenido.endText();




							contenido.beginText();
							contenido.drawImage(img, 380, 250);
							contenido.endText();



							contenido.close();
							entrada.save(nombre);

							int EntraInicial=0;
							File entradapdf= new File(nombre);
							File carpetaEntrada = new File("./Entradas/"+nombre);
							Copiar(entradapdf,carpetaEntrada);
							File f= new File(nombre);
							f.delete();

							String sql= "INSERT INTO Entrada(idEntrada,titulo,horario,cantidad,sala,precioU,precioT,nombre ) VALUES (?,?,?,?,?,?,?,?)";
							try {
								PreparedStatement pst1 = cn1.prepareStatement(sql);

								pst1.setInt(1, numeros.get(0));
								pst1.setString(2, p.getTitulo());
								pst1.setString(3, horario);
								pst1.setString(4, String.valueOf(cant));
								pst1.setString(5, String.valueOf(p.getSala()));
								pst1.setString(6, ve.txtPrecU.getText());
								pst1.setString(7, String.valueOf(prect));
								pst1.setString(8, textNombre.getText());

								int n = pst1.executeUpdate();


								//Una vez pulsado el boton de añadir deshabilitamos la edición de los campos y ocultamos el boton de añadir


							}catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "ERROR");
							}


						}


					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}







					JOptionPane.showMessageDialog(frame3, "Entrada "+numeros.get(0)+" creada, gracias por su compra" , "Entrada creada"
							+ "", JOptionPane.ERROR_MESSAGE);






				}catch(IOException e6) {
					JOptionPane.showMessageDialog(frame3, "Error al crear entrada", "error", JOptionPane.ERROR_MESSAGE);
					e6.printStackTrace();
				} catch (COSVisitorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						// Nuevamente aprovechamos el finally para 
						// asegurarnos que se cierra el fichero.
						if (null != archivo)
							archivo.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}}
		});
		btnPagar.setBackground(UIManager.getColor("Button.select"));
		btnPagar.setForeground(Color.ORANGE);
		btnPagar.setOpaque(true);
		btnPagar.setBorderPainted(false);
		btnPagar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnPagar.setBounds(80, 247, 138, 29);
		frame3.getContentPane().add(btnPagar);




		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBackground(Color.ORANGE);
		btnCancel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnCancel.setForeground(Color.GRAY);
		btnCancel.setOpaque(true);
		btnCancel.setBorderPainted(false);
		btnCancel.setActionCommand("Open20");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JButton("Vuelta al login");
				String cmd20 = e.getActionCommand();

				if(cmd20.equals("Open20"))
				{
					frame3.dispose();

				}
			}});

		btnCancel.setBounds(263, 247, 152, 29);
		frame3.getContentPane().add(btnCancel);



		JComboBox MescomboBox = new JComboBox();
		MescomboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		MescomboBox.setMaximumRowCount(12);
		MescomboBox.setBounds(263, 153, 72, 27);
		frame3.getContentPane().add(MescomboBox);

		JComboBox AnyocomboBox_1 = new JComboBox();
		AnyocomboBox_1.setBackground(Color.GRAY);
		AnyocomboBox_1.setMaximumRowCount(40);
		AnyocomboBox_1.setModel(new DefaultComboBoxModel(new String[] {"20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"}));
		AnyocomboBox_1.setBounds(351, 153, 72, 27);
		frame3.getContentPane().add(AnyocomboBox_1);

		JLabel lblFecha = new JLabel("Fecha cad.");
		lblFecha.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblFecha.setForeground(Color.ORANGE);
		lblFecha.setBounds(55, 156, 126, 16);
		frame3.getContentPane().add(lblFecha);

		textNombre = new JTextField();
		textNombre.setBounds(263, 90, 152, 22);
		frame3.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JLabel lblB = new JLabel("/");
		lblB.setForeground(Color.ORANGE);
		lblB.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblB.setBounds(338, 156, 18, 16);
		frame3.getContentPane().add(lblB);

	}

	//Método recursivo para copiar fichero de una carpeta a otra
	public static void Copiar(File FOrigen,File FDestino){
		//si el origen no es una carpeta
		if(!FOrigen.isDirectory()){
			//Llamo la funcion que lo copia
			CopiarFichero(FOrigen,FDestino);
		}else{

			entraInicial++; 

			if(entraInicial==1){

				FDestino=new File(FDestino.getAbsolutePath()+"/"+FOrigen.getName()); 

				if(!FDestino.exists()){
					FDestino.mkdir();
				}
			} 

			String []Rutas=FOrigen.list();

			for(int i=0;i<Rutas.length;i++){

				File FnueOri=new File(FOrigen.getAbsolutePath()+"/"+Rutas[i]);

				File FnueDest= new File(FDestino.getAbsolutePath()+"/"+Rutas[i]);

				if(FnueOri.isDirectory() && !FnueDest.exists()){
					FnueDest.mkdir();                        
				}

				Copiar(FnueOri,FnueDest); 
			}
		}

	}    
	public static void CopiarFichero(File FOrigen,File FDestino){
		try {
			//Si el archivo a copiar existe
			if(FOrigen.exists()){
				String copiar="S";
				//si el fichero destino ya existe
				if(FDestino.exists()){
					System.out.println("El fichero ya existe, Desea Sobre Escribir:S/N ");
					copiar = ( new BufferedReader(new InputStreamReader(System.in))).readLine();
				}
				//si puedo copiar
				if(copiar.toUpperCase().equals("S")){

					FileInputStream LeeOrigen= new FileInputStream(FOrigen);

					OutputStream Salida = new FileOutputStream(FDestino);
					//separo un buffer de 1MB de lectura
					byte[] buffer = new byte[1024];
					int tamaño;
					//leo el fichero a copiar cada 1MB
					while ((tamaño = LeeOrigen.read(buffer)) > 0) {
						//Escribe el MB en el fichero destino
						Salida.write(buffer, 0, tamaño);
					}
					System.out.println(FOrigen.getName()+" Copiado con Exito!!");
					//cierra los flujos de lectura y escritura
					Salida.close();
					LeeOrigen.close();
				}

			}else{//l fichero a copiar no existe                
				System.out.println("El fichero a copiar no existe..."+FOrigen.getAbsolutePath());
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}


	}
}
