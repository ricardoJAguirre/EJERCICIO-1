package ejemplo1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercico1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMontoDonacion;
	private JScrollPane scpScroll;
	private JTextArea txtScroll;
	private JTextField txtMonto;
	private JButton BttnBorrar;
	private JButton BtnEjecutar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercico1 frame = new Ejercico1();
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
	public Ejercico1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMontoDonacion = new JLabel("Monto de Donaci\u00F3n");
		lblMontoDonacion.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblMontoDonacion.setBounds(23, 32, 127, 22);
		contentPane.add(lblMontoDonacion);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(160, 30, 80, 25);
		getContentPane().add(txtMonto);
		
		BtnEjecutar = new JButton("Ejecutar");
		BtnEjecutar.addActionListener(this);
		BtnEjecutar.setBounds(290, 10, 80, 25);
		getContentPane().add(BtnEjecutar);	
		
		BttnBorrar= new JButton("Borrar");
		BttnBorrar.addActionListener(this);
		BttnBorrar.setBounds(290, 40, 80, 25);
		getContentPane().add(BttnBorrar);	
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 76, 414, 174);
		contentPane.add(scpScroll);
		
		txtScroll = new JTextArea();
		scpScroll.setViewportView(txtScroll);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BttnBorrar) {
			actionPerformedBttnBorrar(e);
		}
		if (e.getSource() == BtnEjecutar) {
			actionPerformedBtnEjecutar(e);
		}
	}
	protected void actionPerformedBtnEjecutar(ActionEvent e) {
		
		double donacion, pediatria, medicinaGeneral, ginecologia, traumatologia;
		//Leer datos
		donacion=Double.parseDouble(txtMonto.getText());
		//Proceso de datos:
		medicinaGeneral= donacion * 0.45;
		ginecologia= medicinaGeneral * 0.8;
		pediatria=  0.20 * (medicinaGeneral+ ginecologia);
		traumatologia= donacion-medicinaGeneral-ginecologia-pediatria;
		//salida de Resultados
		
		txtScroll.setText("Medicina General \t: "+ medicinaGeneral+"\n");
		txtScroll.append("ginecologia \t \t: "+ medicinaGeneral+"\n");
		txtScroll.append("Pediatria \t \t: "+ pediatria+ "\n");
		txtScroll.append("traumatologia \t \t: "+traumatologia+"\n");
		
		
		}
	protected void actionPerformedBttnBorrar(ActionEvent e) {
		txtMonto.setText("");
		txtScroll.setText("");
		txtMonto.requestFocus();
	}
}
