package panel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class VerticalConfiguration extends JFrame {

	private static final long serialVersionUID = 6294689542092367723L;
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

	/**
	 * Launch the application.
	 */
	private JFrame verticalFrame;
	private JButton btnCalculate;
	private JButton btnReturn;

	/**
	 * Launch the application.
	 */
	
	public static void verticalFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerticalConfiguration window = new VerticalConfiguration();
					window.verticalFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String Args) {
		
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	        }
		verticalFrame();
		
	}

	/**
	 * Create the application.
	 */
	
	public VerticalConfiguration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		verticalFrame = new JFrame();
		verticalFrame.setResizable(false);
		verticalFrame.setTitle("Configura\u00E7\u00E3o Vertical");
		verticalFrame.setBackground(Color.LIGHT_GRAY);
		verticalFrame.setBounds(100, 100, 780, 620);
		verticalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		verticalFrame.getContentPane().setLayout(null);
		
		JLabel labelAltura = new JLabel("Altura fase-solo em metros");
		labelAltura.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelAltura.setBounds(20, 0, 180, 29);
		verticalFrame.getContentPane().add(labelAltura);
		
		JLabel labelEspaçamento = new JLabel("Espa\u00E7amento em metros");
		labelEspaçamento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelEspaçamento.setBounds(382, 3, 150, 29);
		verticalFrame.getContentPane().add(labelEspaçamento);
		
		JLabel labelRaio = new JLabel("Raio do Condutor em metros");
		labelRaio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelRaio.setBounds(20, 62, 180, 29);
		verticalFrame.getContentPane().add(labelRaio);
		
		JLabel labelDistancia = new JLabel("Dist\u00E2ncia entre Condutores em metros");
		labelDistancia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelDistancia.setBounds(382, 58, 223, 29);
		verticalFrame.getContentPane().add(labelDistancia);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(20, 27, 336, 29);
		verticalFrame.getContentPane().add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		textFieldEspaçamento = new JTextField();
		textFieldEspaçamento.setColumns(10);
		textFieldEspaçamento.setBounds(382, 27, 336, 29);
		verticalFrame.getContentPane().add(textFieldEspaçamento);
		
		textFieldRaio = new JTextField();
		textFieldRaio.setColumns(10);
		textFieldRaio.setBounds(20, 85, 336, 29);
		verticalFrame.getContentPane().add(textFieldRaio);
		
		textFieldDistanciaSub = new JTextField();
		textFieldDistanciaSub.setColumns(10);
		textFieldDistanciaSub.setBounds(382, 85, 336, 29);
		verticalFrame.getContentPane().add(textFieldDistanciaSub);
		
		JLabel labelFases = new JLabel("N\u00FAmero de Fases");
		labelFases.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelFases.setBounds(20, 124, 158, 29);
		verticalFrame.getContentPane().add(labelFases);
		
		textFieldFases = new JTextField();
		textFieldFases.setColumns(10);
		textFieldFases.setBounds(20, 150, 336, 29);
		verticalFrame.getContentPane().add(textFieldFases);
		
		JLabel labelTensao = new JLabel("Tens\u00E3o da Linha em kV");
		labelTensao.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelTensao.setBounds(382, 124, 158, 29);
		verticalFrame.getContentPane().add(labelTensao);
		
		textFieldTensao = new JTextField();
		textFieldTensao.setColumns(10);
		textFieldTensao.setBounds(382, 150, 336, 29);
		verticalFrame.getContentPane().add(textFieldTensao);
		
		JLabel labelAtoP = new JLabel("Dist\u00E2ncia Horizontal da fase A ao ponto P no Solo metros");
		labelAtoP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelAtoP.setBounds(20, 183, 356, 29);
		verticalFrame.getContentPane().add(labelAtoP);
		
		textFieldAtoP = new JTextField();
		textFieldAtoP.setColumns(10);
		textFieldAtoP.setBounds(20, 211, 336, 29);
		verticalFrame.getContentPane().add(textFieldAtoP);
		
		JLabel labelBtoP = new JLabel("Dist\u00E2ncia Horizontal da fase B ao ponto P no Solo metros");
		labelBtoP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelBtoP.setBounds(20, 240, 356, 29);
		verticalFrame.getContentPane().add(labelBtoP);
		
		textFieldBtoP = new JTextField();
		textFieldBtoP.setColumns(10);
		textFieldBtoP.setBounds(20, 268, 336, 29);
		verticalFrame.getContentPane().add(textFieldBtoP);
		
		JLabel labelCtoP = new JLabel("Dist\u00E2ncia Horizontal da fase C ao ponto P no Solo metros");
		labelCtoP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelCtoP.setBounds(20, 297, 356, 29);
		verticalFrame.getContentPane().add(labelCtoP);
		
		textFieldCtoP = new JTextField();
		textFieldCtoP.setColumns(10);
		textFieldCtoP.setBounds(20, 322, 336, 29);
		verticalFrame.getContentPane().add(textFieldCtoP);
		
		JLabel lblRazoEntreAltura = new JLabel("Altura de A menos Altura de B dividido por espa\u00E7amento");
		lblRazoEntreAltura.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRazoEntreAltura.setBounds(20, 361, 336, 29);
		verticalFrame.getContentPane().add(lblRazoEntreAltura);
		
		textFieldRazao = new JTextField();
		textFieldRazao.setColumns(10);
		textFieldRazao.setBounds(20, 386, 336, 29);
		verticalFrame.getContentPane().add(textFieldRazao);
		
		btnCalculate = new JButton("Calcular");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textFieldAltura.getText().length() == 0 || textFieldEspaçamento.getText().length() == 0 || textFieldRazao.getText().length() == 0 || textFieldRaio.getText().length() == 0
						 || textFieldFases.getText().length() == 0 || textFieldDistanciaSub.getText().length() == 0 || textFieldTensao.getText().length() == 0 || textFieldAtoP.getText().length() == 0
						 || textFieldBtoP.getText().length() == 0 || textFieldCtoP.getText().length() == 0 || textFieldxP1.getText().length() == 0 || textFieldyP1.getText().length() == 0 
						 || textFieldxP2.getText().length() == 0 || textFieldyP2.getText().length() == 0 || buttonGroup.isSelected(null)){
					JOptionPane.showMessageDialog(null, "Formulário necessita estar preenchido");
				}else {
				
				double h = Double.parseDouble(textFieldAltura.getText());
				System.out.println("Altura é " +h);
				
				double s = Double.parseDouble(textFieldEspaçamento.getText());
				System.out.println("Espaçamento é " +s);
				
				double t = Double.parseDouble(textFieldRazao.getText());
				System.out.println("Razão é " +t);
				
				double r = Double.parseDouble(textFieldRaio.getText());
				System.out.println("Raio é " +r);
				
				int n = Integer.parseInt(textFieldFases.getText());
				System.out.println("Número de fases é " +n);
				
				double subconductorDistance = Double.parseDouble(textFieldDistanciaSub.getText());
				System.out.println("Distancia entre subcondutores é " +subconductorDistance);
				
				double tension = Double.parseDouble(textFieldTensao.getText());
				System.out.println("Tensão é " +tension);
				
				double pointPtoA = Double.parseDouble(textFieldAtoP.getText());
				System.out.println("Distancia P para A é " +pointPtoA);
				
				double pointPtoB = Double.parseDouble(textFieldBtoP.getText());
				System.out.println("Distancia P para C é " +pointPtoB);
				
				double pointPtoC = Double.parseDouble(textFieldCtoP.getText());
				System.out.println("Distancia P para C é " +pointPtoC);
				
				double xP1 = Double.parseDouble(textFieldxP1.getText());
				System.out.println("Distancia P para C é " +pointPtoC);
				
				double yP1 = Double.parseDouble(textFieldyP1.getText());
				System.out.println("Distancia P para C é " +pointPtoC);
				
				double xP2 = Double.parseDouble(textFieldxP2.getText());
				System.out.println("Distancia P para C é " +pointPtoC);
				
				double yP2 = Double.parseDouble(textFieldyP2.getText());
				System.out.println("Distancia P para C é " +pointPtoC);
				
				if (markDoisVertical.isSelected()) {
					int sub = 2;
					double[][] matrix = createMatrixVerticalDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
		        	double invertedMatrix[][] = invert(matrix);
		            double rMatrix[] = realVoltage(tension, 120, n, sub);  
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix,pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            if (imaginaryAtGround < 0.01) {
		            	imaginaryAtGround = 0;
		            }
		            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
		            
				} else if (markTresVertical.isSelected()) {
					int sub = 3;
					double[][] matrix = createMatrixVerticalTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
					displayProduct(matrix);
		        	double invertedMatrix[][] = invert(matrix);
		        	displayProduct(invertedMatrix);
		            double rMatrix[] = realVoltage(tension, 120, n, sub);  
		            displayProduct2(rMatrix);
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            displayProduct2(iMatrix);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            displayProduct(RealLoadMatrix);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            displayProduct(ImaginaryLoadMatrix);
		            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            System.out.println(realAtGround);
		            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            System.out.println(imaginaryAtGround);
		            if (imaginaryAtGround < 0.01) {
		            	imaginaryAtGround = 0;
		            }
		            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
		            
				} else if (markQuatroVertical.isSelected()) {
					int sub = 4;
					double[][] matrix = createMatrixVerticalQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
		        	double invertedMatrix[][] = invert(matrix);
		            double rMatrix[] = realVoltage(tension, 120, n, sub);  
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            if (imaginaryAtGround < 0.01) {
		            	imaginaryAtGround = 0;
		            }
		            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
				
				}else if (markCincoVertical.isSelected()) {
					int sub = 5;
					double[][] matrix = createMatrixVerticalCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
		        	double invertedMatrix[][] = invert(matrix);
		            double rMatrix[] = realVoltage(tension, 120, n, sub);  
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            if (imaginaryAtGround < 0.01) {
		            	imaginaryAtGround = 0;
		            }
		            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
				}
			}
		}
	});
		btnCalculate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCalculate.setBounds(159, 488, 134, 21);
		verticalFrame.getContentPane().add(btnCalculate);
		
		btnReturn = new JButton("Retornar");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntroFrame.introFrame();
				verticalFrame.setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReturn.setBounds(319, 535, 134, 21);
		verticalFrame.getContentPane().add(btnReturn);
		
		JButton btnHelpVertical = new JButton("...");
		btnHelpVertical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageFrame.imageFrame();
			}
		});
		btnHelpVertical.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnHelpVertical.setBounds(193, 65, 20, 22);
		verticalFrame.getContentPane().add(btnHelpVertical);
		
		label = new JLabel(" Quantidade de");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label.setBounds(162, 425, 100, 29);
		verticalFrame.getContentPane().add(label);
		
		label_1 = new JLabel("Condutores");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_1.setBounds(172, 449, 100, 29);
		verticalFrame.getContentPane().add(label_1);
		
		markDoisVertical = new JRadioButton("Dois");
		buttonGroup.add(markDoisVertical);
		markDoisVertical.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markDoisVertical.setBounds(287, 433, 53, 21);
		verticalFrame.getContentPane().add(markDoisVertical);
		
		markTresVertical = new JRadioButton("Tr\u00EAs");
		buttonGroup.add(markTresVertical);
		markTresVertical.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markTresVertical.setBounds(376, 433, 53, 21);
		verticalFrame.getContentPane().add(markTresVertical);
		
		markQuatroVertical = new JRadioButton("Quatro");
		buttonGroup.add(markQuatroVertical);
		markQuatroVertical.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markQuatroVertical.setBounds(448, 433, 71, 21);
		verticalFrame.getContentPane().add(markQuatroVertical);
		
		markCincoVertical = new JRadioButton("Cinco");
		buttonGroup.add(markCincoVertical);
		markCincoVertical.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markCincoVertical.setBounds(544, 433, 61, 21);
		verticalFrame.getContentPane().add(markCincoVertical);
		
		btnLimparVertical = new JButton("Limpar");
		btnLimparVertical.addActionListener(new ActionListener() {
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
				buttonGroup.clearSelection();
			}
		});
		btnLimparVertical.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLimparVertical.setBounds(471, 535, 134, 21);
		verticalFrame.getContentPane().add(btnLimparVertical);
		
		btnSave = new JButton("Salvar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textFieldAltura.getText().length() == 0 || textFieldEspaçamento.getText().length() == 0 || textFieldRazao.getText().length() == 0 || textFieldRaio.getText().length() == 0
						 || textFieldFases.getText().length() == 0 || textFieldDistanciaSub.getText().length() == 0 || textFieldTensao.getText().length() == 0 || textFieldAtoP.getText().length() == 0
						 || textFieldBtoP.getText().length() == 0 || textFieldCtoP.getText().length() == 0 || textFieldxP1.getText().length() == 0 || textFieldyP1.getText().length() == 0 
						 || textFieldxP2.getText().length() == 0 || textFieldyP2.getText().length() == 0 || buttonGroup.isSelected(null)){
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
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBounds(313, 488, 134, 21);
		verticalFrame.getContentPane().add(btnSave);
		
		btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String fileName = f.getAbsolutePath();
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
						
					br1.close();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCarregar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCarregar.setBounds(471, 488, 134, 21);
		verticalFrame.getContentPane().add(btnCarregar);
		
		textFieldxP1 = new JTextField();
		textFieldxP1.setColumns(10);
		textFieldxP1.setBounds(382, 211, 336, 29);
		verticalFrame.getContentPane().add(textFieldxP1);
		
		JLabel lblDistnciaHorizontalPararaio = new JLabel("Dist\u00E2ncia Horizontal para-raio 1 em metros");
		lblDistnciaHorizontalPararaio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDistnciaHorizontalPararaio.setBounds(382, 183, 356, 29);
		verticalFrame.getContentPane().add(lblDistnciaHorizontalPararaio);
		
		JLabel lblDistnciaVerticalPararaio = new JLabel("Dist\u00E2ncia Vertical para-raio 1 em metros");
		lblDistnciaVerticalPararaio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDistnciaVerticalPararaio.setBounds(382, 240, 356, 29);
		verticalFrame.getContentPane().add(lblDistnciaVerticalPararaio);
		
		textFieldyP1 = new JTextField();
		textFieldyP1.setColumns(10);
		textFieldyP1.setBounds(382, 268, 336, 29);
		verticalFrame.getContentPane().add(textFieldyP1);
		
		JLabel lblDistnciaHorizontalPararaio_1 = new JLabel("Dist\u00E2ncia Horizontal para-raio 2 em metros");
		lblDistnciaHorizontalPararaio_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDistnciaHorizontalPararaio_1.setBounds(382, 297, 356, 29);
		verticalFrame.getContentPane().add(lblDistnciaHorizontalPararaio_1);
		
		textFieldxP2 = new JTextField();
		textFieldxP2.setColumns(10);
		textFieldxP2.setBounds(382, 322, 336, 29);
		verticalFrame.getContentPane().add(textFieldxP2);
		
		JLabel lblDistnciaVerticalPararaio_1 = new JLabel("Dist\u00E2ncia Vertical para-raio 2 em metros");
		lblDistnciaVerticalPararaio_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDistnciaVerticalPararaio_1.setBounds(382, 361, 336, 29);
		verticalFrame.getContentPane().add(lblDistnciaVerticalPararaio_1);
		
		textFieldyP2 = new JTextField();
		textFieldyP2.setColumns(10);
		textFieldyP2.setBounds(382, 386, 336, 29);
		verticalFrame.getContentPane().add(textFieldyP2);
		
		btnGrafico = new JButton("Gr\u00E1fico");
		btnGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textFieldAltura.getText().length() == 0 || textFieldEspaçamento.getText().length() == 0 || textFieldRazao.getText().length() == 0 || textFieldRaio.getText().length() == 0
						 || textFieldFases.getText().length() == 0 || textFieldDistanciaSub.getText().length() == 0 || textFieldTensao.getText().length() == 0 || textFieldAtoP.getText().length() == 0
						 || textFieldBtoP.getText().length() == 0 || textFieldCtoP.getText().length() == 0 || textFieldxP1.getText().length() == 0 || textFieldyP1.getText().length() == 0 
						 || textFieldxP2.getText().length() == 0 || textFieldyP2.getText().length() == 0 || buttonGroup.isSelected(null)){
					JOptionPane.showMessageDialog(null, "Formulário necessita estar preenchido");
				}
				
				int i = 0;
			    int range = 10;
			    double[] value = new double[range];
			 
			    for (i = 0; i < 10; i++) {
			    
			    	double h = Double.parseDouble(textFieldAltura.getText());
					
					double s = Double.parseDouble(textFieldEspaçamento.getText());
					
					double t = Double.parseDouble(textFieldRazao.getText());
					
					double r = Double.parseDouble(textFieldRaio.getText());
					
					int n = Integer.parseInt(textFieldFases.getText());
					
					double subconductorDistance = Double.parseDouble(textFieldDistanciaSub.getText());
					
					double tension = Double.parseDouble(textFieldTensao.getText());
					
					double pointPtoA = Double.parseDouble(textFieldAtoP.getText()) + i*5;
					
					double pointPtoB = Double.parseDouble(textFieldBtoP.getText()) + i*5;
					
					double pointPtoC = Double.parseDouble(textFieldCtoP.getText()) + i*5;
					
					double xP1 = Double.parseDouble(textFieldxP1.getText());
					
					double yP1 = Double.parseDouble(textFieldyP1.getText());
					
					double xP2 = Double.parseDouble(textFieldxP2.getText());
					
					double yP2 = Double.parseDouble(textFieldyP2.getText());
					
					if (markDoisVertical.isSelected()) {
						int sub = 2;
						double[][] matrix = createMatrixVerticalDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
			        	double invertedMatrix[][] = invert(matrix);
			            double rMatrix[] = realVoltage(tension, 120, n, sub);  
			            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
			            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
			            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
			            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix,pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
			            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
			            if (imaginaryAtGround < 0.01) {
			            	imaginaryAtGround = 0;
			            }
			            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
			            value[i] = polarValue[0];
			            
			            String module = String.valueOf(polarValue[0]);
			            String angle = String.valueOf(polarValue[1]);
			            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
			            
					} else if (markTresVertical.isSelected()) {
						int sub = 3;
						double[][] matrix = createMatrixVerticalTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
			        	double invertedMatrix[][] = invert(matrix);
			            double rMatrix[] = realVoltage(tension, 120, n, sub);  
			            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
			            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
			            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
			            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
			            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
			            if (imaginaryAtGround < 0.01) {
			            	imaginaryAtGround = 0;
			            }
			            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
			            value[i] = polarValue[0];
			            
			            String module = String.valueOf(polarValue[0]);
			            String angle = String.valueOf(polarValue[1]);
			            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
			            
					} else if (markQuatroVertical.isSelected()) {
						int sub = 4;
						double[][] matrix = createMatrixVerticalQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
			        	double invertedMatrix[][] = invert(matrix);
			            double rMatrix[] = realVoltage(tension, 120, n, sub);  
			            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
			            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
			            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
			            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
			            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
			            if (imaginaryAtGround < 0.01) {
			            	imaginaryAtGround = 0;
			            }
			            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
			            value[i] = polarValue[0];
			            
			            String module = String.valueOf(polarValue[0]);
			            String angle = String.valueOf(polarValue[1]);
			            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
					
					}else if (markCincoVertical.isSelected()) {
						int sub = 5;
						double[][] matrix = createMatrixVerticalCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
			        	double invertedMatrix[][] = invert(matrix);
			            double rMatrix[] = realVoltage(tension, 120, n, sub);  
			            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
			            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
			            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
			            double realAtGround = groundFieldFormulaVertical(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
			            double imaginaryAtGround = groundFieldFormulaVertical(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
			            if (imaginaryAtGround < 0.01) {
			            	imaginaryAtGround = 0;
			            }
			            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
			            value[i] = polarValue[0];
			            
			            String module = String.valueOf(polarValue[0]);
			            String angle = String.valueOf(polarValue[1]);
			            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
					}
			    }

			    // Create dataset
			    XYSeriesCollection dataset = new XYSeriesCollection();

			    XYSeries series = new XYSeries("Electric Field x Horizontal Distance");

			    series.add(0, value[0]);
			    series.add(5, value[1]);
			    series.add(10, value[2]);
			    series.add(15, value[3]);
			    series.add(20, value[4]);
			    series.add(25, value[5]);
			    series.add(30, value[6]);
			    series.add(35, value[7]);
			    series.add(40, value[8]);
			    series.add(45, value[9]);

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
			    renderer.setSeriesPaint( 0 , Color.magenta );
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
		});
		btnGrafico.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGrafico.setBounds(159, 535, 134, 21);
		verticalFrame.getContentPane().add(btnGrafico);
	}
	
	 protected static double angle(double t, double dff) {
	    	return Math.acos(dff/Math.sqrt(Math.pow(t*dff, 2) + Math.pow(dff, 2))) + degreeToRad(90);
	    }
	 
	 public static Vetor rotacao(double ang, Vetor a, double d) {
		 Vetor resp = new Vetor();
		 
		 resp.x = (a.x * Math.cos(ang) + a.y * (-Math.sin(ang)));
		 resp.y = (a.x * Math.sin(ang) + a.y * Math.cos(ang));
		 return resp; 
	 }
	 
	 protected static Conductor[] distribui(int n, int sub, double d, double h, double r, double s, double xP1, double yP1, double xP2, double yP2, double t) {
	 		
		 Conductor condutor[] = new Conductor[n * sub+2];
 		 for (int i = 0; i<(n *sub+2); i++) {
 			condutor[i] = new Conductor();
 		 }
 		 
		 Vetor roda = new Vetor();
		 double a = (2 * Math.PI)/sub;
		 int c = 0;
		 double p = 0;
		 
		 for (int j = 0; j<(n); j++) {
			 if (j == 1) {
				 condutor[c].x = p;
				 condutor[c].y = h + s;
				 condutor[c].r = r;
				 c++;
				 roda.x = d;
				 roda.y = 0; 
			 } else if (j == 2) {
				 	condutor[c].x = p;
				 	condutor[c].y = h + 2*s;
				 	condutor[c].r = r;
				 	c++;
				 	roda.x = d;
				 	roda.y = 0;
			 } else {
				 	condutor[c].x = p;
				 	condutor[c].y = h;
				 	condutor[c].r = r;
				 	c++;
				 	roda.x = d;
				 	roda.y = 0; 
				 
			 }
    		 for (int i = 1; i<(sub); i++) {
				 condutor[c].x = condutor[c-1].x + roda.x;
				 condutor[c].y = condutor[c-1].y + roda.y;
				 condutor[c].r = condutor[c-1].r;
				 roda = rotacao(a, roda, d);
				 c++;
    		}
    		 
    	 }
		 for (int m = (sub*n); m < (sub*n+2); m++) {
			 if (m == (sub*n) ) {
				 condutor[m].x = xP1;
				 condutor[m].y = yP1;
				 } else {
					 condutor[m].x = xP2;
	    			 condutor[m].y = yP2;
				 }
		 }
		 return condutor;
	 }
	 
	 protected static double[][] createMatrixVerticalCinco (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
		    double matrix[][] = new double[sub * n+2][sub * n+2];
		           
		    Conductor condutor[] = distribui(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else {
			 			double dxy = Math.sqrt(Math.pow((condutor[j].x - condutor[i].x), 2) + Math.pow(condutor[j].y - condutor[i].y, 2));
		 				System.out.println(dxy);
		 				if (condutor[j].x == condutor[i].x) {
		 					double distPontoImagem = 2 * condutor[i].y + dxy;
			 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
		 				} else {
		 					double parc1 = Math.pow(condutor[i].y + condutor[j].y, 2);
		 					double parc2 = Math.pow(condutor[j].x - condutor[i].x, 2);
		 					double distPontoImagem = Math.sqrt(parc1 + parc2);
			 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
		 				}
			 		}
		 		}
		 	}
		 	return matrix;
		 }
	 
	 protected static double[][] createMatrixVerticalQuatro (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
		    double matrix[][] = new double[sub * n+2][sub * n+2];
		           
		    Conductor condutor[] = distribui(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else {
		 			double dxy = Math.sqrt(Math.pow((condutor[j].x - condutor[i].x), 2) + Math.pow(condutor[j].y - condutor[i].y, 2));
		 				if (condutor[j].x == condutor[i].x) {
		 					double distPontoImagem = 2 * condutor[i].y + dxy;
    		 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
		 				} else {
		 					double parc1 = Math.pow(condutor[i].y + condutor[j].y, 2);
		 					double parc2 = Math.pow(condutor[j].x - condutor[i].x, 2);
		 					double distPontoImagem = Math.sqrt(parc1 + parc2);
    		 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
		 				}
		 			}
		 		}
		 	}
		 	return matrix;
	 }
	 
	 protected static double[][] createMatrixVerticalTres (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
		    double matrix[][] = new double[sub * n+2][sub * n+2];
		           
		    Conductor condutor[] = distribui(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t);
			 
		 	for (int i = 0; i<n*sub+2; i++) {
		 		for (int j = 0; j<n*sub+2; j++) {
		 			if (i == j) {
						matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
		 			} else {
		 				double dxy = Math.sqrt(Math.pow((condutor[j].x - condutor[i].x), 2) + Math.pow(condutor[j].y - condutor[i].y, 2));
			 			double parc1 = Math.pow(condutor[i].y + condutor[j].y, 2);
			 			double parc2 = Math.pow(condutor[j].x - condutor[i].x, 2);
			 			double distPontoImagem = Math.sqrt(parc1 + parc2);
	    		 		matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
			 				
				 	}
		 		}
		 	}
		 	return matrix;
	 }
	 
	 protected static double[][] createMatrixVerticalDois (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
	    double matrix[][] = new double[sub * n+2][sub * n+2];
	           
	    Conductor condutor[] = distribui(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t);
		 
	 	for (int i = 0; i<n*sub+2; i++) {
	 		for (int j = 0; j<n*sub+2; j++) {
	 			if (i == j) {
					matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
	 			} else {
	 					double dxy = Math.sqrt(Math.pow((condutor[j].x - condutor[i].x), 2) + Math.pow(condutor[j].y - condutor[i].y, 2));
	 					double parc1 = Math.pow(condutor[i].y + condutor[j].y, 2);
	 					double parc2 = Math.pow(condutor[j].x - condutor[i].x, 2);
	 					double distPontoImagem = Math.sqrt(parc1 + parc2);
		 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
	 				}
	 			}
	 		}
	 		return matrix;
	 	}
	    
	    public static double[][] invert(double a[][]) {
	        int n = a.length;
	        double x[][] = new double[n][n];
	        double b[][] = new double[n][n];
	        int index[] = new int[n];
	        for (int i=0; i<n; ++i) 
	            b[i][i] = 1;
	 
	        gaussian(a, index);
	 
	        for (int i=0; i<n-1; ++i)
	            for (int j=i+1; j<n; ++j)
	                for (int k=0; k<n; ++k)
	                    b[index[j]][k]
	                    	    -= a[index[j]][i]*b[index[i]][k];
	        
	        for (int i=0; i<n; ++i) {
	            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
	            for (int j=n-2; j>=0; --j) {
	                x[j][i] = b[index[j]][i];
	                
	                for (int k=j+1; k<n; ++k) {
	                    x[j][i] -= a[index[j]][k] * x[k][i];
	                }
	                x[j][i] /= a[index[j]][j];
	            }

	        }
	        return x;
	    }

	    public static void gaussian(double a[][], int index[]) {
	        int n = index.length;
	        double c[] = new double[n];
	 
	        for (int i=0; i<n; ++i) 
	            index[i] = i;
	 
	        for (int i=0; i<n; ++i) 
	        {
	            double c1 = 0;
	            for (int j=0; j<n; ++j) 
	            {
	                double c0 = Math.abs(a[i][j]);
	                if (c0 > c1) c1 = c0;
	            }
	            c[i] = c1;
	        }

	        int k = 0;
	        for (int j=0; j<n-1; ++j) 
	        {
	            double pi1 = 0;
	            for (int i=j; i<n; ++i) 
	            {
	                double pi0 = Math.abs(a[index[i]][j]);
	                pi0 /= c[index[i]];
	                if (pi0 > pi1) 
	                {
	                    pi1 = pi0;
	                    k = i;
	                }
	            }
	 
	            int itmp = index[j];
	            index[j] = index[k];
	            index[k] = itmp;
	            for (int i=j+1; i<n; ++i) 	
	            {
	                double pj = a[index[i]][j]/a[index[j]][j];
	 
	                a[index[i]][j] = pj;
	 
	                for (int l=j+1; l<n; ++l)
	                    a[index[i]][l] -= pj*a[index[j]][l];
	            }
	        }
	    }
	 
	    public static double[] realVoltage (double tension, double angle, int n, int sub){ 
	    	double[] rMatrix= new double [n * sub +2];
	    	    	
	    	for (int i = 0; i < (sub * n+2); i++) {
	    		if (i < sub) {
	    			int d = 0;
	    			double faseReal = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.cos(degreeToRad(angle - 120 * d));
	    			rMatrix[i] = faseReal;
	    		} else if ( i >= sub && i < 2*sub) {
	    			int d = 1;
	    			double faseReal = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.cos(degreeToRad(angle - 120 * d));
	    			rMatrix[i] = faseReal;
	    		} else if (i >= 2*sub && i < 3*sub) {
	    			int d = 2;
	    			double faseReal = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.cos(degreeToRad(angle - 120 * d));
	    			rMatrix[i] = faseReal;
	    		} else if (i >= 3*sub) {
	    			rMatrix[i] = 0;
	    		}
	    		
	    	  } 
	    	return rMatrix;
	    }
	    
	    public static double[] imaginaryVoltage (double tension, double angle, int n, int sub){ 	
	    	double[] iMatrix= new double [n * sub+2]; 				
	    		
	    	for (int i = 0; i < (sub *n+2); i++) {
	    		if (i < sub) {
	    			int d = 0;
	    			double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * d));
	    			iMatrix[i] = faseImaginary;
	    		} else if ( i >= sub && i < 2*sub) {
	    			int d = 1;
	    			double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * d));
	    			iMatrix[i] = faseImaginary;
	    		} else if (i >= 2*sub) {
	    			int d = 2;
	    			double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * d));
	    			iMatrix[i] = faseImaginary;
	    		} else if (i >= 3*sub) {
	    			iMatrix[i] = 0;
	    		}
	    		
	    	  } 
	    	return iMatrix;
	    }
	    
	    public static double degreeToRad (double angleInDegree) {

	    	double angleInRad = angleInDegree / 57.32484076433121019108;
	    	return angleInRad;
	    }
	    
	    public static double radToDegree (double angleInRad) {

	    	double angleInDegree = angleInRad * 57.32484076433121019108; 
	    	return angleInDegree;
	    }

public static double[][] multiplyMatrix(double[][] firstMatrix, double[] secondMatrix, int n, int sub) {
	        
	    	double[][] product = new double[(sub *n+2)][1];
	        for(int i = 0; i < (sub *n+2); i++) {
	            for (int j = 0; j < 1; j++) {
	                for (int k = 0; k < (sub *n+2); k++) {
	                    product[i][j] += firstMatrix[i][k] * secondMatrix[k];
	                }
	            }
	        }
	        return product;
	    }

	    public static void displayProduct(double[][] product) {

	        System.out.println("Product of two matrices is: ");
	        for(double[] row : product) {
	            for (double column : row) {
	                System.out.print(column + "    ");
	            }
	            System.out.println();
	        }
	    }
	    
	    public static void displayProduct2(double [] realAtGround) {

	        System.out.println("Product of two matrices is: ");
	        for(double column : realAtGround) {
	                System.out.print(column + "    ");
	            
	            System.out.println();
	        }
	    }
	      
	    public static double groundFieldFormulaVertical(double a[][], double dh1, double dh2,  double dh3, double h, int n, double dff, int sub) {
	    	double GroundValue = 0;
	    	double[] dh = new double [sub * n+2];
	    	for (int c = 0; c <( sub * n+2); c++) {
	    		if ( c < sub || c == (sub*n)) {
	    			dh[c] = dh1;
	    		} else if (c >= sub && c < 2*sub) {
	    			dh[c] = dh2;
	    		} else if (c >=2*sub && c < n*sub || c == (sub*n+1)) {
	    			dh[c] = dh3;
	    		}
	    	}
	    	int j = 0;
	    	for(int i = 0; i < (sub * n+2); i++) {
	    		GroundValue += epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
	    	}
	    	return GroundValue;
	    }
	    
	    public static double[] rectangularToPolar(double a, double b) {
	    	double module = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
	    	double angle = Math.atan(b/a);
	    	double[] value = {module, radToDegree(angle)};
	    	
	    	return value;
	    }
	    
	    protected static double epsilon = 18 * Math.pow(10, 9);
	    private JLabel label;
	    private JLabel label_1;
	    private JRadioButton markDoisVertical;
	    private JRadioButton markTresVertical;
	    private JRadioButton markQuatroVertical;
	    private JRadioButton markCincoVertical;
	    private final ButtonGroup buttonGroup = new ButtonGroup();
	    private JButton btnLimparVertical;
	    private JButton btnSave;
	    private JButton btnCarregar;
	    private JTextField textFieldxP1;
	    private JTextField textFieldyP1;
	    private JTextField textFieldxP2;
	    private JTextField textFieldyP2;
	    private JButton btnGrafico;
	}
	
