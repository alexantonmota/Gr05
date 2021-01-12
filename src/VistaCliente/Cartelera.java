package VistaCliente;
import java.awt.Color;
import java.awt.Component;
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

import Conexion.Conexion;
import model.Pelicula;

import javax.swing.LayoutStyle.ComponentPlacement;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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


		
		String sql = "SELECT titulo, anyo, genero, sinopsis, duracion, trailer, nomPoster,nomPMenu FROM pelicula";
		PreparedStatement stmt;
		Conexion cc= new Conexion();
		Connection conn= cc.conectar();
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculas.clear();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Pelicula p = new Pelicula(rs.getString("titulo"), rs.getString("genero"), rs.getInt("anyo"), rs.getString("sinopsis"), rs.getInt("duracion"), rs.getString("trailer"), rs.getString("nomPoster"),rs.getString("nomPMenu"));

				peliculas.add(p);
			}

		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		//Cada uno de los siguientes label representara los posters de las peliculas que haya en la base de datos de Peliculas
		JLabel lblP1 = new JLabel("");
		
		
		for (int i = 0; i < peliculas.size()-11;i++) {
			lblP1.setIcon(peliculas.get(i).getPoster());
			
		}
		lblP1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				for (int i = 0; i < peliculas.size()-11;i++) {
					peli.lblNewLabel.setIcon(peliculas.get(i).getPoster());
					
				}
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
		for (int j = 0; j < peliculas.size()-10;j++) {
			lblP2.setIcon(peliculas.get(j).getPoster());
		}
		
		

		JLabel lblP3 = new JLabel("");
		lblP3.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		
		lblP3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		for (int k = 0; k < peliculas.size()-9;k++) {
			lblP3.setIcon(peliculas.get(k).getPoster());
		}
		
		
		JLabel lblP4 = new JLabel("");
		lblP4.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		for (int l = 0; l < peliculas.size()-8;l++) {
			lblP4.setIcon(peliculas.get(l).getPoster());
		}
		
		

		JLabel lblP5 = new JLabel("");
		lblP5.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		for (int m = 0; m < peliculas.size()-7;m++) {
			lblP5.setIcon(peliculas.get(m).getPoster());
		}
		

		JLabel lblP6 = new JLabel("");
		lblP6.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		for (int n = 0; n < peliculas.size()-6;n++) {
			lblP6.setIcon(peliculas.get(n).getPoster());
		}
		
		JLabel lblP7 = new JLabel("");
		lblP7.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);
			
			}
		});
		for (int o = 0; o < peliculas.size()-5;o++) {
			lblP7.setIcon(peliculas.get(o).getPoster());
		}
		
		

		JLabel lblP8 = new JLabel("");
		lblP8.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		
		lblP8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		for (int p = 0; p < peliculas.size()-4;p++) {
			lblP8.setIcon(peliculas.get(p).getPoster());
		}
		
		JLabel lblP9 = new JLabel("");
		lblP9.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		for (int q = 0; q < peliculas.size()-3;q++) {
			lblP9.setIcon(peliculas.get(q).getPoster());
		}
		
		
		JLabel lblP10 = new JLabel("");
		lblP10.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		for (int r = 0; r < peliculas.size()-2;r++) {
			lblP10.setIcon(peliculas.get(r).getPoster());
		}
		
		
		JLabel lblP11 = new JLabel("");
		lblP11.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		for (int s = 0; s< peliculas.size()-1;s++) {
			lblP11.setIcon(peliculas.get(s).getPoster());
		}
		
		JLabel lblP12 = new JLabel("");
		lblP12.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula peli= new VentanaPelicula();
				peli.setVisible(true);

			}
		});
		for (int t = 0; t < peliculas.size();t++) {
			lblP12.setIcon(peliculas.get(t).getPoster());
		}
		
		
		peliculas.clear();
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
