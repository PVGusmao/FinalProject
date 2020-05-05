package panel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class HorizontalConfiguration extends JFrame{
	
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
		
		horizontalFrame();
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
		horizontalFrame.setBounds(100, 100, 780, 620);
		horizontalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		horizontalFrame.getContentPane().setLayout(null);
		
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
						 || textFieldxP2.getText().length() == 0 || textFieldyP2.getText().length() == 0 || buttonGroup.isSelected(null)){
					JOptionPane.showMessageDialog(null, "Formulário necessita estar preenchido");
				}
				
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
				
				
				if (markDoisHorizontal.isSelected()) {
					int sub = 2;
					double[][] matrix = createMatrixFlatDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
					double invertedMatrix[][] = invert(matrix);
		        	double rMatrix[] = realVoltage(tension, 120, n, sub); 
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            double imaginaryAtGround = groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            if (imaginaryAtGround < 0.01) {
		            	imaginaryAtGround = 0;
		            }
		            	
		            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
		            
				} else if (markTresHorizontal.isSelected()) {
					int sub = 3; 
					double[][] matrix = createMatrixFlatTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
					displayProduct(matrix);
		        	double invertedMatrix[][] = invert(matrix);
		        	displayProduct(invertedMatrix);
		        	double rMatrix[] = realVoltage(tension, 120, n, sub); 
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            double imaginaryAtGround = groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            if (imaginaryAtGround < 0.01) {
		            	imaginaryAtGround = 0;
		            }
		            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
		            
				}else if (markQuatroHorizontal.isSelected()) {
					int sub = 4;
					double[][] matrix = createMatrixFlatQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
					double invertedMatrix[][] = invert(matrix);
		        	double rMatrix[] = realVoltage(tension, 120, n, sub); 
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            double imaginaryAtGround = groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            if (imaginaryAtGround < 0.01) {
		            	imaginaryAtGround = 0;
		            }
		            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
		            
				}else if (markCincoHorizontal.isSelected()) {
					int sub = 5;
					double[][] matrix = createMatrixFlatCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
					double invertedMatrix[][] = invert(matrix);
		        	double rMatrix[] = realVoltage(tension, 120, n, sub); 
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
		            double imaginaryAtGround = groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
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
		});
		btnCalculate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCalculate.setBounds(144, 484, 134, 21);
		horizontalFrame.getContentPane().add(btnCalculate);
		
		JButton btnReturn = new JButton("Retornar");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntroFrame.introFrame();
				horizontalFrame.setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReturn.setBounds(296, 527, 134, 21);
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
		markDoisHorizontal.setBounds(266, 429, 53, 21);
		horizontalFrame.getContentPane().add(markDoisHorizontal);
		
		markQuatroHorizontal = new JRadioButton("Quatro");
		buttonGroup.add(markQuatroHorizontal);
		markQuatroHorizontal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markQuatroHorizontal.setBounds(415, 429, 71, 21);
		horizontalFrame.getContentPane().add(markQuatroHorizontal);
		
		markCincoHorizontal = new JRadioButton("Cinco");
		buttonGroup.add(markCincoHorizontal);
		markCincoHorizontal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markCincoHorizontal.setBounds(501, 429, 61, 21);
		horizontalFrame.getContentPane().add(markCincoHorizontal);
		
		markTresHorizontal = new JRadioButton("Tr\u00EAs");
		buttonGroup.add(markTresHorizontal);
		markTresHorizontal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markTresHorizontal.setBounds(339, 429, 53, 21);
		horizontalFrame.getContentPane().add(markTresHorizontal);
		
		JLabel lblQuantidade = new JLabel(" Quantidade de");
		lblQuantidade.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantidade.setBounds(133, 421, 100, 29);
		horizontalFrame.getContentPane().add(lblQuantidade);
		
		JLabel lblCondutores = new JLabel("Condutores");
		lblCondutores.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCondutores.setBounds(143, 445, 100, 29);
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
				
				buttonGroup.clearSelection();
			}
		});
		btnLimparHorizontal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLimparHorizontal.setBounds(454, 527, 134, 21);
		horizontalFrame.getContentPane().add(btnLimparHorizontal);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
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
		btnSalvar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSalvar.setBounds(296, 484, 134, 21);
		horizontalFrame.getContentPane().add(btnSalvar);
		
		JButton btnCarregar = new JButton("Carregar");
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
		btnCarregar.setBounds(454, 484, 134, 21);
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
						
						double pointPtoB = Double.parseDouble(textFieldBtoP.getText())+ i*5;
						
						double pointPtoC = Double.parseDouble(textFieldCtoP.getText())+ i*5;
						
						double xP1 = Double.parseDouble(textFieldxP1.getText());
						
						double yP1 = Double.parseDouble(textFieldyP1.getText());
						
						double xP2 = Double.parseDouble(textFieldxP2.getText());
						
						double yP2 = Double.parseDouble(textFieldyP2.getText());
						
						if (markDoisHorizontal.isSelected()) {
							int sub = 2;
							double[][] matrix = createMatrixFlatDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
							double invertedMatrix[][] = invert(matrix);
				        	double rMatrix[] = realVoltage(tension, 120, n, sub); 
				            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
				            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
				            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
				            double realAtGround = groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
				            double imaginaryAtGround = groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
				            if (imaginaryAtGround < 0.01) {
				            	imaginaryAtGround = 0;
				            }
				            	
				            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
				            value[i] = polarValue[0];
				            
				            String module = String.valueOf(polarValue[0]);
				            String angle = String.valueOf(polarValue[1]);
				            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
				            
						} else if (markTresHorizontal.isSelected()) {
							int sub = 3; 
							double[][] matrix = createMatrixFlatTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
							displayProduct(matrix);
				        	double invertedMatrix[][] = invert(matrix);
				        	displayProduct(invertedMatrix);
				        	double rMatrix[] = realVoltage(tension, 120, n, sub); 
				            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
				            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
				            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
				            double realAtGround = groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
				            double imaginaryAtGround = groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
				            if (imaginaryAtGround < 0.01) {
				            	imaginaryAtGround = 0;
				            }
				            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
				            value[i] = polarValue[0];
				            
				            String module = String.valueOf(polarValue[0]);
				            String angle = String.valueOf(polarValue[1]);
				            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
				            
						}else if (markQuatroHorizontal.isSelected()) {
							int sub = 4;
							double[][] matrix = createMatrixFlatQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
							double invertedMatrix[][] = invert(matrix);
				        	double rMatrix[] = realVoltage(tension, 120, n, sub); 
				            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
				            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
				            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
				            double realAtGround = groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
				            double imaginaryAtGround = groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
				            if (imaginaryAtGround < 0.01) {
				            	imaginaryAtGround = 0;
				            }
				            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
				            value[i] = polarValue[0];
				            
				            String module = String.valueOf(polarValue[0]);
				            String angle = String.valueOf(polarValue[1]);
				            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
				            
						}else if (markCincoHorizontal.isSelected()) {
							int sub = 5;
							double[][] matrix = createMatrixFlatCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
							double invertedMatrix[][] = invert(matrix);
				        	double rMatrix[] = realVoltage(tension, 120, n, sub); 
				            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
				            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
				            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
				            double realAtGround = groundFieldFormulaFlat(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
				            double imaginaryAtGround = groundFieldFormulaFlat(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, sub);
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
		});
		
		btnGrafico.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGrafico.setBounds(144, 527, 134, 21);
		horizontalFrame.getContentPane().add(btnGrafico);
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
	 
	 protected static Conductor[] distribui(int n, int sub, double d, double h, double r, double s, double xP1, double yP1, double xP2, double yP2) {
		
		 Conductor condutor[] = new Conductor[n * sub +2];
 		 for (int i = 0; i<(n *sub+2); i++) {
 			condutor[i] = new Conductor();
 		 }
 		 
		 Vetor roda = new Vetor();
		
		 double a = (2 * Math.PI)/sub;
		 int c = 0;
		 double p = 0;
		 
		 for (int j = 0; j<n; j++) {
			 condutor[c].x = p;
			 condutor[c].y = h;
			 condutor[c].r = r;
			 c++;
			 roda.x = d;
			 roda.y = 0;
			 
    		 for (int i = 1; i<(sub); i++) {
				 condutor[c].x = condutor[c-1].x + roda.x;
				 condutor[c].y = condutor[c-1].y + roda.y;
				 condutor[c].r = condutor[c-1].r;
				 roda = rotacao(a, roda, d);
				 c++;
				 
    		}
    		 p += s;
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
	 
	 protected static double[][] createMatrixFlatCinco (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
	        double matrix[][] = new double[sub * n +2][sub * n +2];
	           
		Conductor condutor[] = distribui(n, sub, d, h, r, s, xP1, yP1, xP2, yP2);
		 
	 	for (int i = 0; i<n*sub +2; i++) {
	 		for (int j = 0; j<n*sub +2; j++) {
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
	 
	 protected static double[][] createMatrixFlatQuatro (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
	        double matrix[][] = new double[sub * n +2][sub * n +2];
	           
		Conductor condutor[] = distribui(n, sub, d, h, r, s, xP1, yP1, xP2, yP2);
		 
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
	
	 protected static double[][] createMatrixFlatTres (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
	        double matrix[][] = new double[sub * n+2][sub * n+2];
	           
		Conductor condutor[] = distribui(n, sub, d, h, r, s, xP1, yP1, xP2, yP2);
		 
	 	for (int i = 0; i<n*sub +2; i++) {
	 		for (int j = 0; j<n*sub +2; j++) {
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
	 
	 protected static double[][] createMatrixFlatDois (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
	    double matrix[][] = new double[sub * n +2][sub * n +2];
	           
		Conductor condutor[] = distribui(n, sub, d, h, r, s, xP1, yP1, xP2, yP2);
		 
	 	for (int i = 0; i<n*sub +2; i++) {
	 		for (int j = 0; j<n*sub +2; j++) {
	 			if (i == j) {
					matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
	 			} else {
	 					double dxy = Math.sqrt(Math.pow((condutor[j].x - condutor[i].x), 2) + Math.pow(condutor[j].y - condutor[i].y, 2));
	 					double distPontoImagem = Math.sqrt(Math.pow(2 * condutor[j].y, 2) + Math.pow(dxy, 2));
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
    	double[] rMatrix= new double [n * sub+2];
    	    	
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
    	double[] iMatrix= new double [n * sub +2]; 				
    		
    	for (int i = 0; i < (sub *n+2); i++) {
    		if (i < sub) {
    			int d = 0;
    			double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * d));
    			iMatrix[i] = faseImaginary;
    		} else if ( i >= sub && i < 2*sub) {
    			int d = 1;
    			double faseImaginary = (tension * Math.pow(10, 3))/Math.sqrt(3) * Math.sin(degreeToRad(angle - 120 * d));
    			iMatrix[i] = faseImaginary;
    		} else if (i >= 2*sub && i < 3*sub) {
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
        
    	double[][] product = new double[(sub * n +2)][1];
        for(int i = 0; i < (sub * n +2); i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < (sub * n +2); k++) {
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
    
    public static double groundFieldFormulaFlat(double a[][], double dh1, double dh2, double dh3, double h, int n, double s, int sub) {
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
    	for(int i = 0; i < (sub * n +2); i++) {
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
    private JRadioButton markDoisHorizontal;
    private JRadioButton markTresHorizontal;
    private JRadioButton markCincoHorizontal;
    private JRadioButton markQuatroHorizontal;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField textFieldxP1;
    private JTextField textFieldyP1;
    private JTextField textFieldxP2;
    private JTextField textFieldyP2;
    
}
