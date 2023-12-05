package sistemaDeInventario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PantallaDeConfirmacion extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDeConfirmacion frame = new PantallaDeConfirmacion();
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
	public PantallaDeConfirmacion() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 436, 263);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario registrado exitosamente");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblNewLabel.setBounds(67, 29, 302, 48);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gracias por utilizar la aplicación");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblNewLabel_1.setBounds(67, 105, 302, 48);
		panel.add(lblNewLabel_1);

	}
}
