package sistemaDeInventario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaDeInicio extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDeInicio frame = new PantallaDeInicio();
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
	public PantallaDeInicio() {
		setTitle("Aplicación de Inventario");
		setBounds(100, 100, 597, 401);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 583, 187);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAplicacinDeInventario = new JLabel("Aplicación de Inventario");
		lblAplicacinDeInventario.setFont(new Font("Yu Gothic Medium", Font.BOLD, 30));
		lblAplicacinDeInventario.setBounds(125, 72, 380, 37);
		panel.add(lblAplicacinDeInventario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(125, 166, 137));
		panel_1.setBounds(0, 184, 583, 180);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Iniciar Sesión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaDeInicioDeSesion pdids = new PantallaDeInicioDeSesion();
				pdids.show();
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		btnNewButton.setBounds(172, 27, 216, 36);
		panel_1.add(btnNewButton);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaDeRegistro pdr = new PantallaDeRegistro();
				pdr.show();
				dispose();
			}
		});
		btnRegistrarse.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		btnRegistrarse.setBounds(172, 89, 216, 36);
		panel_1.add(btnRegistrarse);

	}
}
