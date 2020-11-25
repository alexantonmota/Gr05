package VistaAdmin;
import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Ventana donde se podrán acceder a las distintas gestiones de la aplicación
 * @author alex
 *
 */
public class Gestion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCl;
	private JLabel lblAd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Gestion dialog = new Gestion();
			dialog.addWindowListener(new java.awt.event.WindowAdapter() {
				@Override
				public void windowClosing (java.awt.event.WindowEvent e) 
				{
					System.exit(0);
				}
			});
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Gestion() {

		setBounds(250, 50, 1200, 900);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		{
			//Abre GestionClientes
			lblCl = new JLabel("");
			lblCl.setBackground(Color.ORANGE);
			lblCl.setOpaque(true);
			lblCl.setHorizontalAlignment(SwingConstants.CENTER);
			lblCl.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/gfdj.png"));
			lblCl.setBorder(new LineBorder(new Color(255, 200, 0), 5, true));

			lblCl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GestionClientes gestionclientes= new GestionClientes();
					gestionclientes.setVisible(true);


				}
			});
		}
		{
			//Abre GestionAdministrado
			lblAd = new JLabel("");
			lblAd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GestionAdministrador gestionadmin= new GestionAdministrador();
					gestionadmin.setVisible(true);
				}
			});
			lblAd.setBackground(Color.ORANGE);
			lblAd.setOpaque(true);
			lblAd.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/oli.png"));		
			lblAd.setBorder(new LineBorder(new Color(255, 200, 0), 5, true));
		}
		//Abre GestionPeliculas
		JLabel lblPe = new JLabel("");
		lblPe.setBackground(Color.ORANGE);
		lblPe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionPelis gestionpeliculas= new GestionPelis();
				gestionpeliculas.setVisible(true);



			}
		});
		lblPe.setForeground(Color.ORANGE);
		lblPe.setOpaque(true);
		lblPe.setBorder(new LineBorder(new Color(255, 200, 0), 5, true));
		lblPe.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/hgj.png"));


		JLabel lblGC = new JLabel("Gestionar Clientes");
		lblGC.setForeground(Color.ORANGE);
		lblGC.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		JLabel lblGA = new JLabel("Gestionar Administradores");
		lblGA.setForeground(Color.ORANGE);
		lblGA.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		JLabel lblGP = new JLabel("Gestionar Películas");
		lblGP.setForeground(Color.ORANGE);
		lblGP.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		JLabel lblG = new JLabel("Gestión - Cine Deusto");
		lblG.setForeground(Color.ORANGE);
		lblG.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 25));

		JLabel lblEn = new JLabel("");
		lblEn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionEntradas gestionentradas= new GestionEntradas();
				gestionentradas.setVisible(true);
			}
		});
		lblEn.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/cghck.png"));
		lblEn.setBackground(Color.ORANGE);
		lblEn.setOpaque(true);
		lblEn.setBorder(new LineBorder(new Color(255, 200, 0), 5, true));

		JLabel lblGE = new JLabel("Gestionar Entradas");
		lblGE.setForeground(Color.ORANGE);
		lblGE.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGap(81)
														.addComponent(lblGC))
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGap(52)
														.addComponent(lblCl, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
														.addGap(72)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblGA)
																.addComponent(lblAd, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addGap(70)
																		.addComponent(lblPe, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addGap(96)
																		.addComponent(lblGP)))
														.addGap(39)))
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGap(45)
														.addComponent(lblEn, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGap(73)
														.addComponent(lblGE))))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(445)
										.addComponent(lblG)))
						.addContainerGap(73, Short.MAX_VALUE))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(57)
						.addComponent(lblG)
						.addGap(136)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPe, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
								.addComponent(lblEn, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
								.addComponent(lblAd, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
								.addComponent(lblCl, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
						.addGap(55)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGC)
								.addComponent(lblGA)
								.addComponent(lblGP)
								.addComponent(lblGE))
						.addGap(102))
				);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setForeground(Color.ORANGE);
				cancelButton.setOpaque(true);
				cancelButton.setBorderPainted(false);
				cancelButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						new InicioSesionAdmin();

					}
				});
				//Cierra Ventana
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
