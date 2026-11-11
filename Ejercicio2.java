package ejemplo1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTotalVendido;
	private JTextField txtTotal;
	private JButton btnCalcular;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtScroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 frame = new Ejercicio2();
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
	public Ejercicio2() {
		setTitle("Reporte de pago / Trabajadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTotalVendido = new JLabel("TOTAL VENDIDO / MES");
		lblTotalVendido.setBackground(Color.WHITE);
		lblTotalVendido.setBounds(10, 40, 132, 14);
		contentPane.add(lblTotalVendido);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(164, 37, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		btnCalcular.setForeground(Color.RED);
		btnCalcular.setBounds(270,16,89,23);
		contentPane.add(btnCalcular);
		
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setForeground(Color.RED);
		btnBorrar.setBounds(270, 44, 89, 23);
		contentPane.add(btnBorrar);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 78, 414, 172);
		contentPane.add(scpScroll);
		
		txtScroll = new JTextArea();
		scpScroll.setViewportView(txtScroll);
		
		
		
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnCalcular) {
			actionPerformedBtnCalcular(e);
		}
	}
	protected void actionPerformedBtnCalcular(ActionEvent e) {
		
		//Declaracion de variable
		int sueldo_basico;
		double comisionVentas, sueldoBruto, descuento, sueldoNeto, importeTotal;
		//Entrada de Datos
		importeTotal= Double.parseDouble(txtTotal.getText());
		//proceso de datos
		sueldo_basico = 300;
		comisionVentas= 0.09*importeTotal;
		sueldoBruto= sueldo_basico + comisionVentas;
		descuento= 0.11*sueldoBruto;
		sueldoNeto= sueldoBruto - descuento;
		
		//SALIDA DE RESULTADOS
		txtScroll.setText("Sueldo Basico \t \t: "+ sueldo_basico +"\n");
		txtScroll.append("Comision / Ventas \t: "+ comisionVentas +"\n");
		txtScroll.append("Sueldo Bruto \t \t: "+ sueldoBruto + "\n");
		txtScroll.append("Descuento \t \t: "+ descuento +"\n");
		txtScroll.append("Sueldo Neto \t \t: "+ sueldoNeto +"\n");
		
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtTotal.setText("");
		txtScroll.setText("");
		txtTotal.requestFocus();
	}
}
