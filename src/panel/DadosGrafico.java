package panel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class DadosGrafico extends JFrame {

	private static final long serialVersionUID = 1L;
	
	HorizontalConfiguration hc = new HorizontalConfiguration();
	DeltaConfiguration dc = new DeltaConfiguration();
	VerticalConfiguration vc = new VerticalConfiguration();
	
	public JPanel contentPane;
	public JFrame graficoFrame;
	public JFrame dadosFrame;
	public JTextField textFieldAbscissa;
	public JTextField textFieldPontos;
	public JButton btnOk;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosGrafico frame = new DadosGrafico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void dadosFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosGrafico window = new DadosGrafico();
					window.graficoFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DadosGrafico() {
		setTitle("Gr\u00E1fico");
		setBounds(100, 100, 226, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAbscissa = new JLabel("Valor espa\u00E7amento abscissa");
		lblAbscissa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAbscissa.setBounds(23, 25, 179, 13);
		contentPane.add(lblAbscissa);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StaticVariable.abscissa = Double.parseDouble(textFieldAbscissa.getText());
				StaticVariable.pontos = Integer.parseInt(textFieldPontos.getText());
				
				int i = 0;
				int range = StaticVariable.pontos;
				Double[] value = new Double[range];
				
				if (StaticVariable.markConfig == 1) {
					hc.calcGraficoHorizontal(i, range, value, StaticVariable.abscissa, StaticVariable.pontos);
				} else if (StaticVariable.markConfig == 2) {
					dc.calcGraficoDelta(i, range, value, StaticVariable.abscissa, StaticVariable.pontos);
				} else if (StaticVariable.markConfig == 3) {
					vc.calcGraficoVertical(i, range, value, StaticVariable.abscissa, StaticVariable.pontos);
				}
			}
		});
		btnOk.setBounds(45, 139, 121, 30);
		contentPane.add(btnOk);
		
		textFieldAbscissa = new JTextField();
		textFieldAbscissa.setBounds(23, 48, 162, 24);
		contentPane.add(textFieldAbscissa);
		textFieldAbscissa.setColumns(10);
		
		JLabel lblPontos = new JLabel("Quantidade pontos Abscissa");
		lblPontos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPontos.setBounds(23, 77, 179, 13);
		contentPane.add(lblPontos);
		
		textFieldPontos = new JTextField();
		textFieldPontos.setColumns(10);
		textFieldPontos.setBounds(23, 100, 162, 24);
		contentPane.add(textFieldPontos);
	}
}
