package sistemaDeInventario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PantallaDeInicioDeSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoUsuario;
	private JTextField campoPass;
	
File f = new File("C:\\Users\\Juan Pablo\\eclipse-workspace\\ProgramaDeInventario\\Carpeta de Usuarios");
	
	int linea;
	
	String Usuario, Contrasena, Correo;
	
	
	
	void crearCarpeta() {
		if(!f.exists()) {
			f.mkdirs();
		}
	}
	
	void leerArchivo() {
		try {
			FileReader fr = new FileReader("C:\\Users\\Juan Pablo\\eclipse-workspace\\ProgramaDeInventario\\Carpeta de Usuarios\\Usuarios.txt");
			System.err.println("El archivo ya existe");
		} catch (FileNotFoundException e) {
			try {
				FileWriter fw = new FileWriter("C:\\Users\\Juan Pablo\\eclipse-workspace\\ProgramaDeInventario\\Carpeta de Usuarios\\Usuarios.txt");
				System.out.println("Archivo creado");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		
	}
	
	void agregarDatos(String usr, String pwd, String email) {
		try {
			RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Juan Pablo\\eclipse-workspace\\ProgramaDeInventario\\Carpeta de Usuarios\\Usuarios.txt", "rw");
			for(int i=0; i<linea; i++) {
				raf.readLine();
			}
			raf.writeBytes("\r\n");
			raf.writeBytes("\r\n");
			raf.writeBytes("Usuario: "+usr+"\r\n");
			raf.writeBytes("Contrasena: "+pwd+"\r\n");
			raf.writeBytes("Correo: "+email);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void checarDatos(String usr, String pwd) {
		try {
			RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Juan Pablo\\eclipse-workspace\\ProgramaDeInventario\\Carpeta de Usuarios\\Usuarios.txt", "rw");
			String line = raf.readLine();
			Usuario=line.substring(9);
			Contrasena=raf.readLine().substring(12);
			Correo= raf.readLine().substring(8);
			PantallaDeBienvenida pdb = new PantallaDeBienvenida();
			
			if(usr.equals(Usuario) & pwd.equals(Contrasena)) {
				pdb.show();
				
								
				//JOptionPane.showMessageDialog(null, "Contraseña coincide");				
			} else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");					
			}
			dispose();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void contarLineas() {
		try {
			linea=1;
			RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Juan Pablo\\eclipse-workspace\\ProgramaDeInventario\\Carpeta de Usuarios\\Usuarios.txt", "rw");
			for(int i=0; raf.readLine() !=null;i++) {
				linea++;
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDeInicioDeSesion frame = new PantallaDeInicioDeSesion();
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
	public PantallaDeInicioDeSesion() {
		setTitle("Aplicación de Inventario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 450, 274);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblNewLabel.setBounds(49, 60, 117, 45);
		panel.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblContrasea.setBounds(49, 115, 117, 45);
		panel.add(lblContrasea);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCarpeta();
				leerArchivo();
				contarLineas();
				checarDatos(campoUsuario.getText(), campoPass.getText());
				
			}
		});
		btnConfirmar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		btnConfirmar.setBounds(277, 210, 121, 30);
		panel.add(btnConfirmar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaDeInicio pdi = new PantallaDeInicio();
				pdi.show();
				
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		btnRegresar.setBounds(58, 210, 121, 30);
		panel.add(btnRegresar);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(164, 66, 177, 30);
		panel.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoPass = new JTextField();
		campoPass.setColumns(10);
		campoPass.setBounds(164, 115, 177, 30);
		panel.add(campoPass);
	}
}
