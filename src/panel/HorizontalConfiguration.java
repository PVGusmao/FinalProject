package panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import model.Calculos;
import model.StaticVariable;

public class HorizontalConfiguration extends JFrame {
	
	Calculos calc = new Calculos();
	
	private static final long serialVersionUID = 6294689542092367723L;
	
	private JFrame horizontalFrame;
	
	private JTextField textFieldAltura;
	private JTextField textFieldEspaçamento;
	private JTextField textFieldRaio;
	private JTextField textFieldDistanciaSub;
	private JTextField textFieldFases;
	private JTextField textFieldTensao;
	private JTextField textFieldAtoP;
	private JTextField textFieldBtoP;
	private JTextField textFieldCtoP;
	private JTextField textFieldRazao;
	private JTextField textFieldxP1;
	private JTextField textFieldyP1;
	private JTextField textFieldxP2;
	private JTextField textFieldyP2;
	private JTextField textFieldRaioParaRaio;
	
	private JRadioButton markDoisHorizontal;
	private JRadioButton markTresHorizontal;
	private JRadioButton markCincoHorizontal;
	private JRadioButton markQuatroHorizontal;
	
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	
	public static void horizontalFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HorizontalConfiguration window = new HorizontalConfiguration();
					window.horizontalFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public HorizontalConfiguration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		horizontalFrame = new JFrame();
		horizontalFrame.setResizable(false);
		horizontalFrame.setTitle("Configura\u00E7\u00E3o Horizontal");
		horizontalFrame.setBackground(Color.LIGHT_GRAY);
		horizontalFrame.setBounds(100, 100, 778, 650);
		horizontalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		horizontalFrame.getContentPane().setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point middle = new Point(screenSize.width / 3, screenSize.height / 2);
		Point newLocation = new Point(middle.x - (horizontalFrame.getWidth() / 2), 
		                              middle.y - (horizontalFrame.getHeight() / 2));
		horizontalFrame.setLocation(newLocation);
		
		JLabel labelAltura = new JLabel("Altura fase-solo em metros");
		labelAltura.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelAltura.setBounds(20, 0, 164, 29);
		horizontalFrame.getContentPane().add(labelAltura);
		
		JLabel labelEspaçamento = new JLabel("Espa\u00E7amento em metros");
		labelEspaçamento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelEspaçamento.setBounds(404, 0, 158, 29);
		horizontalFrame.getContentPane().add(labelEspaçamento);
		
		JLabel labelRaio = new JLabel("Raio do Condutor em metros");
		labelRaio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelRaio.setBounds(20, 56, 173, 29);
		horizontalFrame.getContentPane().add(labelRaio);
		
		JLabel labelDistancia = new JLabel("Dist\u00E2ncia entre SubCondutores em metros");
		labelDistancia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelDistancia.setBounds(404, 56, 257, 29);
		horizontalFrame.getContentPane().add(labelDistancia);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(20, 27, 349, 29);
		horizontalFrame.getContentPane().add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		textFieldEspaçamento = new JTextField();
		textFieldEspaçamento.setColumns(10);
		textFieldEspaçamento.setBounds(404, 27, 349, 29);
		horizontalFrame.getContentPane().add(textFieldEspaçamento);
		
		textFieldRaio = new JTextField();
		textFieldRaio.setColumns(10);
		textFieldRaio.setBounds(20, 85, 349, 29);
		horizontalFrame.getContentPane().add(textFieldRaio);
		
		textFieldDistanciaSub = new JTextField();
		textFieldDistanciaSub.setColumns(10);
		textFieldDistanciaSub.setBounds(404, 85, 349, 29);
		horizontalFrame.getContentPane().add(textFieldDistanciaSub);
		
		JLabel labelFases = new JLabel("N\u00FAmero de Fases");
		labelFases.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelFases.setBounds(20, 118, 158, 29);
		horizontalFrame.getContentPane().add(labelFases);
		
		textFieldFases = new JTextField();
		textFieldFases.setColumns(10);
		textFieldFases.setBounds(20, 146, 349, 29);
		horizontalFrame.getContentPane().add(textFieldFases);
		
		JLabel labelTensao = new JLabel("Tens\u00E3o da Linha kV");
		labelTensao.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelTensao.setBounds(404, 118, 184, 29);
		horizontalFrame.getContentPane().add(labelTensao);
		
		textFieldTensao = new JTextField();
		textFieldTensao.setColumns(10);
		textFieldTensao.setBounds(404, 146, 349, 29);
		horizontalFrame.getContentPane().add(textFieldTensao);
		
		JLabel labelAtoP = new JLabel("Dist\u00E2ncia Horizontal da fase A ao ponto P no Solo em metros");
		labelAtoP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelAtoP.setBounds(20, 173, 374, 29);
		horizontalFrame.getContentPane().add(labelAtoP);
		
		textFieldAtoP = new JTextField();
		textFieldAtoP.setColumns(10);
		textFieldAtoP.setBounds(20, 201, 349, 29);
		horizontalFrame.getContentPane().add(textFieldAtoP);
		
		JLabel labelBtoP = new JLabel("Dist\u00E2ncia Horizontal da fase B ao ponto P no Solo em metros");
		labelBtoP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelBtoP.setBounds(20, 230, 358, 29);
		horizontalFrame.getContentPane().add(labelBtoP);
		
		textFieldBtoP = new JTextField();
		textFieldBtoP.setColumns(10);
		textFieldBtoP.setBounds(20, 258, 349, 29);
		horizontalFrame.getContentPane().add(textFieldBtoP);
		
		JLabel labelCtoP = new JLabel("Dist\u00E2ncia Horizontal da fase C ao ponto P no Solo em metros");
		labelCtoP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelCtoP.setBounds(20, 286, 358, 29);
		horizontalFrame.getContentPane().add(labelCtoP);
		
		textFieldCtoP = new JTextField();
		textFieldCtoP.setColumns(10);
		textFieldCtoP.setBounds(20, 311, 349, 29);
		horizontalFrame.getContentPane().add(textFieldCtoP);
		
		JLabel lblRazoEntreAltura = new JLabel("Altura de A menos Altura de B dividido por espa\u00E7amento");
		lblRazoEntreAltura.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRazoEntreAltura.setBounds(20, 338, 336, 29);
		horizontalFrame.getContentPane().add(lblRazoEntreAltura);
		
		textFieldRazao = new JTextField();
		textFieldRazao.setColumns(10);
		textFieldRazao.setBounds(20, 363, 349, 29);
		horizontalFrame.getContentPane().add(textFieldRazao);
		
		JButton btnCalculate = new JButton("Calcular");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textFieldAltura.getText().length() == 0 || textFieldEspaçamento.getText().length() == 0 || textFieldRazao.getText().length() == 0 || textFieldRaio.getText().length() == 0
						 || textFieldFases.getText().length() == 0 || textFieldDistanciaSub.getText().length() == 0 || textFieldTensao.getText().length() == 0 || textFieldAtoP.getText().length() == 0
						 || textFieldBtoP.getText().length() == 0 || textFieldCtoP.getText().length() == 0 || textFieldxP1.getText().length() == 0 || textFieldyP1.getText().length() == 0 
						 || textFieldxP2.getText().length() == 0 || textFieldyP2.getText().length() == 0 || textFieldRaioParaRaio.getText().length() == 0 ||buttonGroup.isSelected(null)){
					JOptionPane.showMessageDialog(null, "Formulário necessita estar preenchido");
				}
				try {
				double h = Double.parseDouble(textFieldAltura.getText());
				double s = Double.parseDouble(textFieldEspaçamento.getText());
				double t = Double.parseDouble(textFieldRazao.getText());
				double r = Double.parseDouble(textFieldRaio.getText());
				int n = Integer.parseInt(textFieldFases.getText());
				double subconductorDistance = Double.parseDouble(textFieldDistanciaSub.getText());
				double tension = Double.parseDouble(textFieldTensao.getText());
				double pointPtoA = Double.parseDouble(textFieldAtoP.getText());
				double pointPtoB = Double.parseDouble(textFieldBtoP.getText());
				double pointPtoC = Double.parseDouble(textFieldCtoP.getText());
				double xP1 = Double.parseDouble(textFieldxP1.getText());
				double yP1 = Double.parseDouble(textFieldyP1.getText());
				double xP2 = Double.parseDouble(textFieldxP2.getText());
				double yP2 = Double.parseDouble(textFieldyP2.getText());
				double rpr = Double.parseDouble(textFieldRaioParaRaio.getText());
				
				if (markDoisHorizontal.isSelected()) {
					int sub = 2;
					double[][] matrix = calc.createMatrixFlatDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
					double invertedMatrix[][] = calc.invert(matrix);
					double rMatrix[] = calc.realVoltage(tension, 120, n, sub);
					double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
					double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, rMatrix, n, sub);
					double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, iMatrix, n, sub);
					double realAtGround = calc.groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
					double imaginaryAtGround = calc.groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
					double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround);
					
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
		 
				} else if (markTresHorizontal.isSelected()) {
					int sub = 3; 
					double[][] matrix = calc.createMatrixFlatTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
					double invertedMatrix[][] = calc.invert(matrix);
					double rMatrix[] = calc.realVoltage(tension, 120, n, sub);
					double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
					double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, rMatrix, n, sub);
					double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, iMatrix, n, sub);
					double realAtGround = calc.groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
					double imaginaryAtGround = calc.groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
					double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround);
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
		            
				}else if (markQuatroHorizontal.isSelected()) {
					int sub = 4;
					double[][] matrix = calc.createMatrixFlatQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
					double invertedMatrix[][] = calc.invert(matrix);
					double rMatrix[] = calc.realVoltage(tension, 120, n, sub);
					double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
					double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, rMatrix, n, sub);
					double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, iMatrix, n, sub);
					double realAtGround = calc.groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
					double imaginaryAtGround = calc.groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
					double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround);
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
		            
				}else if (markCincoHorizontal.isSelected()) {
					int sub = 5;
					double[][] matrix = calc.createMatrixFlatCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
					double invertedMatrix[][] = calc.invert(matrix);
					double rMatrix[] = calc.realVoltage(tension, 120, n, sub);
					double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
					double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, rMatrix, n, sub);
					double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, iMatrix, n, sub);
					double realAtGround = calc.groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
					double imaginaryAtGround = calc.groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
					double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround);
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
					}
				} catch(Exception e1) {};
			}	
		});
		btnCalculate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCalculate.setBounds(143, 530, 134, 21);
		horizontalFrame.getContentPane().add(btnCalculate);
		
		JButton btnReturn = new JButton("Retornar");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntroFrame.introFrame();
				horizontalFrame.setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReturn.setBounds(296, 561, 134, 21);
		horizontalFrame.getContentPane().add(btnReturn);
		
		JButton btnHelpHorizontal = new JButton("...");
		btnHelpHorizontal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageFrame.imageFrame();
			}
		});
		btnHelpHorizontal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnHelpHorizontal.setBounds(203, 59, 20, 22);
		horizontalFrame.getContentPane().add(btnHelpHorizontal);
		
		markDoisHorizontal = new JRadioButton("Dois");
		buttonGroup.add(markDoisHorizontal);
		markDoisHorizontal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markDoisHorizontal.setBounds(259, 474, 53, 21);
		horizontalFrame.getContentPane().add(markDoisHorizontal);
		
		markQuatroHorizontal = new JRadioButton("Quatro");
		buttonGroup.add(markQuatroHorizontal);
		markQuatroHorizontal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markQuatroHorizontal.setBounds(416, 474, 71, 21);
		horizontalFrame.getContentPane().add(markQuatroHorizontal);
		
		markCincoHorizontal = new JRadioButton("Cinco");
		buttonGroup.add(markCincoHorizontal);
		markCincoHorizontal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markCincoHorizontal.setBounds(501, 474, 61, 21);
		horizontalFrame.getContentPane().add(markCincoHorizontal);
		
		markTresHorizontal = new JRadioButton("Tr\u00EAs");
		buttonGroup.add(markTresHorizontal);
		markTresHorizontal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markTresHorizontal.setBounds(339, 474, 53, 21);
		horizontalFrame.getContentPane().add(markTresHorizontal);
		
		JLabel lblQuantidade = new JLabel(" Quantidade de");
		lblQuantidade.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantidade.setBounds(143, 470, 100, 29);
		horizontalFrame.getContentPane().add(lblQuantidade);
		
		JLabel lblCondutores = new JLabel("Condutores");
		lblCondutores.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCondutores.setBounds(153, 491, 100, 29);
		horizontalFrame.getContentPane().add(lblCondutores);
		
		JButton btnLimparHorizontal = new JButton("Limpar");
		btnLimparHorizontal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAltura.setText("");
				textFieldAtoP.setText("");
				textFieldBtoP.setText("");
				textFieldCtoP.setText("");
				textFieldDistanciaSub.setText("");
				textFieldEspaçamento.setText("");
				textFieldFases.setText("");
				textFieldRaio.setText("");
				textFieldRazao.setText("");
				textFieldTensao.setText("");
				textFieldxP1.setText("");
				textFieldyP1.setText("");
				textFieldxP2.setText("");
				textFieldyP2.setText("");
				textFieldRaioParaRaio.setText("");
				
				buttonGroup.clearSelection();
			}
		});
		btnLimparHorizontal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLimparHorizontal.setBounds(454, 561, 134, 21);
		horizontalFrame.getContentPane().add(btnLimparHorizontal);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textFieldAltura.getText().length() == 0 || textFieldEspaçamento.getText().length() == 0 || textFieldRazao.getText().length() == 0 || textFieldRaio.getText().length() == 0
						 || textFieldFases.getText().length() == 0 || textFieldDistanciaSub.getText().length() == 0 || textFieldTensao.getText().length() == 0 || textFieldAtoP.getText().length() == 0
						 || textFieldBtoP.getText().length() == 0 || textFieldCtoP.getText().length() == 0 || textFieldxP1.getText().length() == 0 || textFieldyP1.getText().length() == 0 
						 || textFieldxP2.getText().length() == 0 || textFieldyP2.getText().length() == 0 || textFieldRaioParaRaio.getText().length() == 0 ||buttonGroup.isSelected(null)){
					JOptionPane.showMessageDialog(null, "Formulário necessita estar preenchido");
				} else { 
					
					try {
						JFileChooser chooser = new JFileChooser();
						int result = chooser.showSaveDialog(null);
						switch (result) {
						case JFileChooser.APPROVE_OPTION:
							File file = chooser.getSelectedFile();
							FileWriter fw = new FileWriter(file, true);
							
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(textFieldAltura.getText());
							bw.newLine();
							bw.write(textFieldEspaçamento.getText());
							bw.newLine();
							bw.write(textFieldRaio.getText());
							bw.newLine();
							bw.write(textFieldDistanciaSub.getText());
							bw.newLine();
							bw.write(textFieldFases.getText());
							bw.newLine();
							bw.write(textFieldTensao.getText());
							bw.newLine();
							bw.write(textFieldAtoP.getText());
							bw.newLine();
							bw.write(textFieldBtoP.getText());
							bw.newLine();
							bw.write(textFieldCtoP.getText());
							bw.newLine();
							bw.write(textFieldRazao.getText());
							bw.newLine();
							bw.write(textFieldxP1.getText());
							bw.newLine();
							bw.write(textFieldyP1.getText());
							bw.newLine();
							bw.write(textFieldxP2.getText());
							bw.newLine();
							bw.write(textFieldyP2.getText());
							bw.newLine();
							bw.write(textFieldRaioParaRaio.getText());
							bw.newLine();
							
							JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso.");
							bw.close();
							fw.close();	
							break;
						
						case JFileChooser.CANCEL_OPTION:
							JOptionPane.showMessageDialog(null, "Operação Cancelada.");
							break;
						}
					
				} catch (Exception ex) {
					System.out.println(ex);
				}	
			}
		}
	});
		btnSalvar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSalvar.setBounds(296, 530, 134, 21);
		horizontalFrame.getContentPane().add(btnSalvar);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				try{String fileName = f.getAbsolutePath();
				textFieldAltura.setText("");
				textFieldEspaçamento.setText("");
				textFieldRaio.setText("");
				textFieldDistanciaSub.setText("");
				textFieldFases.setText("");
				textFieldTensao.setText("");
				textFieldAtoP.setText("");
				textFieldBtoP.setText("");
				textFieldCtoP.setText("");
				textFieldRazao.setText("");
				textFieldxP1.setText("");
				textFieldyP1.setText("");
				textFieldxP2.setText("");
				textFieldyP2.setText("");
				textFieldRaioParaRaio.setText("");
				
				buttonGroup.clearSelection();
				
				try {
					
					Scanner br1 = new Scanner(new FileReader(fileName));
					if (br1.hasNextLine()) {
						
						textFieldAltura.setText(br1.nextLine());
						textFieldEspaçamento.setText(br1.nextLine());
						textFieldRaio.setText(br1.nextLine());
						textFieldDistanciaSub.setText(br1.nextLine());
						textFieldFases.setText(br1.nextLine());
						textFieldTensao.setText(br1.nextLine());
						textFieldAtoP.setText(br1.nextLine());
						textFieldBtoP.setText(br1.nextLine());
						textFieldCtoP.setText(br1.nextLine());
						textFieldRazao.setText(br1.nextLine());
						textFieldxP1.setText(br1.nextLine());
						textFieldyP1.setText(br1.nextLine());
						textFieldxP2.setText(br1.nextLine());
						textFieldyP2.setText(br1.nextLine());
						textFieldRaioParaRaio.setText(br1.nextLine());
						
					br1.close();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch(Exception e1) {};
		}
	});
		btnCarregar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCarregar.setBounds(454, 530, 134, 21);
		horizontalFrame.getContentPane().add(btnCarregar);
		
		textFieldxP1 = new JTextField();
		textFieldxP1.setColumns(10);
		textFieldxP1.setBounds(404, 201, 349, 29);
		horizontalFrame.getContentPane().add(textFieldxP1);
		
		textFieldyP1 = new JTextField();
		textFieldyP1.setColumns(10);
		textFieldyP1.setBounds(404, 258, 349, 29);
		horizontalFrame.getContentPane().add(textFieldyP1);
		
		textFieldxP2 = new JTextField();
		textFieldxP2.setColumns(10);
		textFieldxP2.setBounds(404, 311, 349, 29);
		horizontalFrame.getContentPane().add(textFieldxP2);
		
		textFieldyP2 = new JTextField();
		textFieldyP2.setColumns(10);
		textFieldyP2.setBounds(404, 363, 349, 29);
		horizontalFrame.getContentPane().add(textFieldyP2);
		
		JLabel labelxP1 = new JLabel("Dist\u00E2ncia horizontal para-raio 1 em metros.");
		labelxP1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelxP1.setBounds(404, 173, 374, 29);
		horizontalFrame.getContentPane().add(labelxP1);
		
		JLabel labelyP1 = new JLabel("Dist\u00E2ncia Vertical para-raio 1 em metros.");
		labelyP1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelyP1.setBounds(404, 230, 358, 29);
		horizontalFrame.getContentPane().add(labelyP1);
		
		JLabel labelxP2 = new JLabel("Dist\u00E2ncia horizontal para-raio 2 em metros.");
		labelxP2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelxP2.setBounds(404, 286, 358, 29);
		horizontalFrame.getContentPane().add(labelxP2);
		
		JLabel labelyP2 = new JLabel("Dist\u00E2ncia vertical para-raio 2 em metros.");
		labelyP2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelyP2.setBounds(404, 338, 336, 29);
		horizontalFrame.getContentPane().add(labelyP2);
		
		JButton btnGrafico = new JButton("Gr\u00E1fico");
		btnGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DadosGrafico dg = new DadosGrafico();
				
				if (textFieldAltura.getText().length() == 0 || textFieldEspaçamento.getText().length() == 0 || textFieldRazao.getText().length() == 0 || textFieldRaio.getText().length() == 0
						 || textFieldFases.getText().length() == 0 || textFieldDistanciaSub.getText().length() == 0 || textFieldTensao.getText().length() == 0 || textFieldAtoP.getText().length() == 0
						 || textFieldBtoP.getText().length() == 0 || textFieldCtoP.getText().length() == 0 || textFieldxP1.getText().length() == 0 || textFieldyP1.getText().length() == 0 
						 || textFieldxP2.getText().length() == 0 || textFieldyP2.getText().length() == 0 || textFieldRaioParaRaio.getText().length() == 0 || buttonGroup.isSelected(null)){
					JOptionPane.showMessageDialog(null, "Formulário necessita estar preenchido");
				}
				
				int mark = 0;
				
				if (markDoisHorizontal.isSelected()) {
					mark = 2;
				} else if(markTresHorizontal.isSelected()) {
					mark = 3;
				} else if(markQuatroHorizontal.isSelected()) {
					mark = 4;
				} else if(markCincoHorizontal.isSelected()) {
					mark = 5;
				}
				
				try {
				StaticVariable.markSub = mark;
				StaticVariable.h = Double.parseDouble(textFieldAltura.getText());
				StaticVariable.s = Double.parseDouble(textFieldEspaçamento.getText());
				StaticVariable.t = Double.parseDouble(textFieldRazao.getText());
				StaticVariable.r = Double.parseDouble(textFieldRaio.getText());
				StaticVariable.n = Integer.parseInt(textFieldFases.getText());
				StaticVariable.subconductorDistance = Double.parseDouble(textFieldDistanciaSub.getText());
				StaticVariable.tension = Double.parseDouble(textFieldTensao.getText());
				StaticVariable.pointPtoA = Double.parseDouble(textFieldAtoP.getText());
				StaticVariable.pointPtoB = Double.parseDouble(textFieldBtoP.getText());
				StaticVariable.pointPtoC = Double.parseDouble(textFieldCtoP.getText());
				StaticVariable.xP1 = Double.parseDouble(textFieldxP1.getText());
				StaticVariable.yP1 = Double.parseDouble(textFieldyP1.getText());
				StaticVariable.xP2 = Double.parseDouble(textFieldxP2.getText());
				StaticVariable.yP2 = Double.parseDouble(textFieldyP2.getText());
				StaticVariable.rpr = Double.parseDouble(textFieldRaioParaRaio.getText());
				
				dg.setVisible(true);
				} catch(Exception e1) {};
			}
		});
		
		btnGrafico.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGrafico.setBounds(144, 561, 134, 21);
		horizontalFrame.getContentPane().add(btnGrafico);
		
		textFieldRaioParaRaio = new JTextField();
		textFieldRaioParaRaio.setColumns(10);
		textFieldRaioParaRaio.setBounds(213, 419, 349, 29);
		horizontalFrame.getContentPane().add(textFieldRaioParaRaio);
		
		JLabel lblRaioParaRaio = new JLabel("Raio do para-raio em metros.");
		lblRaioParaRaio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRaioParaRaio.setBounds(213, 393, 336, 29);
		horizontalFrame.getContentPane().add(lblRaioParaRaio);
	}

	
	public void calcGraficoHorizontal(int i, int range, Double[] value, double abscissa, int pontos) {
		
		double h = 0;
		double s = 0;
		double t = 0;
		double r = 0;
		int n = 0;
		double subconductorDistance = 0;
		double tension = 0;
		double pointPtoA = 0;
		double pointPtoB = 0;
		double pointPtoC = 0;
		double xP1 = 0;
		double yP1 = 0;
		double xP2 = 0;
		double yP2 = 0;
		double rpr = 0;
		int mark = 0;
		
		for (i = 0; i < range; i++) {
		
		mark = StaticVariable.markSub;
		h = StaticVariable.h;
		s = StaticVariable.s;
		t = StaticVariable.t;
		r = StaticVariable.r;
		n = StaticVariable.n;
		subconductorDistance = StaticVariable.subconductorDistance;
		tension = StaticVariable.tension;
		pointPtoA = StaticVariable.pointPtoA - i*abscissa;
		pointPtoB = StaticVariable.pointPtoB - i*abscissa;
		pointPtoC = StaticVariable.pointPtoC - i*abscissa;
		xP1 = StaticVariable.xP1;
		yP1 = StaticVariable.yP1;
		xP2 = StaticVariable.xP2;
		yP2 = StaticVariable.yP2;
		rpr = StaticVariable.rpr;
				
					if (mark == 2) {
						int sub = 2;
						double[][] matrix = calc.createMatrixFlatDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
						double invertedMatrix[][] = calc.invert(matrix);
						double rMatrix[] = calc.realVoltage(tension, 120, n, sub);
						double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
						double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, rMatrix, n, sub);
						double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, iMatrix, n, sub);
						double realAtGround = calc.groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
						double imaginaryAtGround = calc.groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
						double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround);
				        value[i] = polarValue[0];
				            
					} else if (mark == 3) {
						int sub = 3; 
						double[][] matrix = calc.createMatrixFlatTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
						double invertedMatrix[][] = calc.invert(matrix);
						double rMatrix[] = calc.realVoltage(tension, 120, n, sub);
						double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
						double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, rMatrix, n, sub);
						double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, iMatrix, n, sub);
						double realAtGround = calc.groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
						double imaginaryAtGround = calc.groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
						double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround);
				        value[i] = polarValue[0];
				            
					} else if (mark == 4) {
						int sub = 4;
						double[][] matrix = calc.createMatrixFlatQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
						double invertedMatrix[][] = calc.invert(matrix);
						double rMatrix[] = calc.realVoltage(tension, 120, n, sub);
						double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
						double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, rMatrix, n, sub);
						double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, iMatrix, n, sub);
						double realAtGround = calc.groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
						double imaginaryAtGround = calc.groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
						double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround);
				        value[i] = polarValue[0];
				           
					} else if (mark == 5) {
						int sub = 5;
						double[][] matrix = calc.createMatrixFlatCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
						double invertedMatrix[][] = calc.invert(matrix);
						double rMatrix[] = calc.realVoltage(tension, 120, n, sub);
						double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
						double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, rMatrix, n, sub);
						double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix, iMatrix, n, sub);
						double realAtGround = calc.groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
						double imaginaryAtGround = calc.groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
						double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround);
				        value[i] = polarValue[0];
				            
					}
				}

	    // Create dataset
	    XYSeriesCollection dataset = new XYSeriesCollection();

	    XYSeries series = new XYSeries("Electric Field x Horizontal Distance");
	    
	    for (int j = 0; j < pontos; j++){
	        series.add(j*abscissa, value[j]);
	    }
	    	    
	    //Add series to dataset
        dataset.addSeries(series);
        
	    // Create chart
	    JFreeChart chart = ChartFactory.createXYLineChart("Electric Field x Horizontal Distance", 
	    		"Horizontal Distance (m)", 
	    		"Electric Field (V/m)", 
	    		 dataset,
	    		 PlotOrientation.VERTICAL,
	    		 true, true, false);
	   
	    // Create Panel
	    ChartPanel panel = new ChartPanel(chart);	
	    XYPlot plot = chart.getXYPlot( );
	    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	    renderer.setSeriesPaint( 0 , Color.RED );
	    renderer.setSeriesStroke( 0 , new BasicStroke( 2.0f ) );
	    plot.setRenderer( renderer ); 
	    setContentPane(panel);	

	    SwingUtilities.invokeLater(() -> {
	    setSize(800, 600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	    setVisible(true);
	    
	    });
	} 
}
