package VistaCliente;
import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana donde se visualiza los datos de la pelicula
 * @author alex
 *
 */
public class VentanaPelicula extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTit;
	private JTextField txtAnyo;
	private JTextField txtSinopsis;
	private JTextField textDur;
	private JTextField txtGenero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPelicula dialog = new VentanaPelicula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPelicula() {
		setResizable(false);
		setForeground(Color.ORANGE);
		setBackground(Color.GRAY);
		getContentPane().setBackground(Color.GRAY);
		setBounds(320, 150, 1000, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));


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
		btnTrailer.setBackground(Color.ORANGE);
		btnTrailer.setForeground(Color.GRAY);
		btnTrailer.setOpaque(true);
		btnTrailer.setBorderPainted(false);

		btnTrailer.setOpaque(true);
		btnTrailer.setBorderPainted(false);

		txtTit = new JTextField();
		txtTit.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtTit.setEditable(false);
		txtTit.setColumns(10);

		txtAnyo = new JTextField();
		txtAnyo.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtAnyo.setEditable(false);
		txtAnyo.setColumns(10);

		txtSinopsis = new JTextField();
		txtSinopsis.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtSinopsis.setEditable(false);
		txtSinopsis.setColumns(10);

		textDur = new JTextField();
		textDur.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textDur.setEditable(false);
		textDur.setColumns(10);

		JLabel lblGenero = new JLabel("Género");
		lblGenero.setForeground(Color.ORANGE);
		lblGenero.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblGenero.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		txtGenero = new JTextField();
		txtGenero.setEditable(false);
		txtGenero.setColumns(10);

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
												.addComponent(txtSinopsis, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSinopsis)
												.addComponent(txtAnyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAnyo)
												.addComponent(txtGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblGenero)))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(80)
										.addComponent(btnTrailer)))
						.addContainerGap(172, Short.MAX_VALUE))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(14)
						.addComponent(lblTit)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtTit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblGenero)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addComponent(lblAnyo)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtAnyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblSinopsis)
						.addGap(18)
						.addComponent(txtSinopsis, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblDur)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textDur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblTrailer)
						.addGap(12)
						.addComponent(btnTrailer)
						.addGap(31))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
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
						VentanaEntrada entrada= new VentanaEntrada();
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
