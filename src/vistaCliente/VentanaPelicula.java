package vistaCliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import db.DBManager;
import model.Pelicula;

/**
 * Ventana donde se visualiza los datos de la pelicula
 * @author alex
 *
 */
public class VentanaPelicula extends JDialog {


	public static final long serialVersionUID = 1L;
	public final JPanel contentPanel = new JPanel();
	public JTextField txtTit;
	public JTextField txtAnyo;
	public JTextField textDur;
	public JTextField txtGenero;
	public JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public VentanaPelicula(Pelicula p) {
		setResizable(false);
		setForeground(Color.ORANGE);
		setBackground(Color.GRAY);
		getContentPane().setBackground(Color.GRAY);
		setBounds(320, 150, 1000, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		DBManager db= new DBManager();
		List<Pelicula> peliculas= db.obtenerPeliculas();
		db.desconectar();


		lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		Image fotomenu;
		fotomenu= getToolkit().getImage(p.getRutaFoto());
		fotomenu= fotomenu.getScaledInstance(300, 600, Image.SCALE_DEFAULT);


		lblNewLabel.setIcon(new ImageIcon(fotomenu));






		JLabel lblTit = new JLabel("Título");
		lblTit.setForeground(Color.ORANGE);
		lblTit.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblTit.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		JLabel lblAnyo = new JLabel("Año");
		lblAnyo.setForeground(Color.ORANGE);
		lblAnyo.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblAnyo.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		JLabel lblSinopsis = new JLabel("Sinopsis");
		lblSinopsis.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblSinopsis.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblSinopsis.setForeground(Color.ORANGE);

		JLabel lblDur = new JLabel("Duración");
		lblDur.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblDur.setForeground(Color.ORANGE);
		lblDur.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

		JLabel lblTrailer = new JLabel("Tráiler");
		lblTrailer.setForeground(Color.ORANGE);
		lblTrailer.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblTrailer.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		JButton btnTrailer = new JButton("Ver ahora");
		btnTrailer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					URL url = new URL(p.getTrailer());
					try {
						Desktop.getDesktop().browse(url.toURI());
					} catch (IOException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnTrailer.setBackground(Color.ORANGE);
		btnTrailer.setForeground(Color.GRAY);
		btnTrailer.setOpaque(true);
		btnTrailer.setBorderPainted(false);

		btnTrailer.setOpaque(true);
		btnTrailer.setBorderPainted(false);

		txtTit = new JTextField(p.getTitulo());
		txtTit.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtTit.setEditable(false);
		txtTit.setColumns(10);
		txtTit.setVisible(true);


		txtAnyo = new JTextField(String.valueOf(p.getAnyo()));
		txtAnyo.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtAnyo.setEditable(false);
		txtAnyo.setColumns(10);

		textDur = new JTextField(String.valueOf(p.getDuracion()));
		textDur.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textDur.setEditable(false);
		textDur.setColumns(10);

		JLabel lblGenero = new JLabel("Género");
		lblGenero.setForeground(Color.ORANGE);
		lblGenero.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblGenero.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		txtGenero = new JTextField(p.getGenero());
		txtGenero.setEditable(false);
		txtGenero.setColumns(10);

		JTextArea textArea = new JTextArea(p.getSinopsis());
		textArea.setEditable(false);
		textArea.setLineWrap(true);

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(18)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblTrailer)
												.addComponent(lblTit)
												.addComponent(txtTit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textDur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDur)
												.addComponent(lblSinopsis)
												.addComponent(txtAnyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAnyo)
												.addComponent(txtGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblGenero)
												.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(80)
										.addComponent(btnTrailer)))
						.addContainerGap(328, Short.MAX_VALUE))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(14)
						.addComponent(lblTit)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtTit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblGenero)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
						.addComponent(lblAnyo)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtAnyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblSinopsis)
						.addGap(18)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addGap(22)
						.addComponent(lblDur)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textDur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblTrailer)
						.addGap(12)
						.addComponent(btnTrailer)
						.addGap(31))
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
						.addContainerGap())
				);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Comprar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						VentanaEntrada entrada= new VentanaEntrada(p);

						entrada.setVisible(true);
					}
				});
				okButton.setForeground(Color.ORANGE);
				okButton.setBackground(Color.GRAY);
				okButton.setOpaque(true);
				okButton.setBorderPainted(false);
				okButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
				okButton.setActionCommand("");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setForeground(Color.ORANGE);
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setOpaque(true);
				cancelButton.setBorderPainted(false);
				cancelButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
				cancelButton.setActionCommand("");
				buttonPane.add(cancelButton);
			}
		}
	}
}
