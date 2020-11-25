package VistaCliente;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Ventana Cartelera donde se visualizan las películas
 * @author alex
 *
 */
public class Cartelera extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cartelera frame = new Cartelera();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cartelera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(60, 10, 1700, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);



		JLabel lblCartelera = new JLabel("CARTELERA - CINE DEUSTO");
		lblCartelera.setBorder(BorderFactory.createLineBorder(Color.ORANGE,7));
		lblCartelera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartelera.setForeground(Color.GRAY);
		lblCartelera.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 60));
		lblCartelera.setOpaque(true);
		lblCartelera.setBackground(Color.ORANGE);



		//Cada uno de los siguientes label representara los posters de las peliculas que haya en la base de datos de Peliculas
		JLabel lblP1 = new JLabel("");
		lblP1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		lblP1.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));


		JLabel lblP2 = new JLabel("");
		lblP2.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});


		JLabel lblP3 = new JLabel("");
		lblP3.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});

		JLabel lblP4 = new JLabel("");
		lblP4.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});

		JLabel lblP5 = new JLabel("");
		lblP5.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});

		JLabel lblP6 = new JLabel("");
		lblP6.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});

		JLabel lblP7 = new JLabel("");
		lblP7.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});

		JLabel lblP8 = new JLabel("");
		lblP8.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});

		JLabel lblP9 = new JLabel("");
		lblP9.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});

		JLabel lblP10 = new JLabel("");
		lblP10.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});

		JLabel lblP11 = new JLabel("");
		lblP11.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});

		JLabel lblP12 = new JLabel("");
		lblP12.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1680, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(14)
										.addComponent(lblCartelera, GroupLayout.PREFERRED_SIZE, 1653, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(75)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP7, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGap(66)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP8, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGap(67)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP9, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGap(65)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP10, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGap(71)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP5, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP11, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGap(65)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP12, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP6, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(20, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(14)
						.addComponent(lblCartelera, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(93)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblP1, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP2, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP3, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP4, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP5, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(91)
										.addComponent(lblP6, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)))
						.addGap(60)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblP7, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP8, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP9, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP10, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP11, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP12, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				MenuPrincipal menu= new MenuPrincipal();
				menu.setVisible(true);

			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(1572, Short.MAX_VALUE)
						.addComponent(btnNewButton)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnNewButton)
						.addContainerGap(14, Short.MAX_VALUE))
				);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);


	}
}
