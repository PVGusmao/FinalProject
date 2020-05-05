package panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
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

public class DeltaConfiguration extends JFrame {
	
	private static final long serialVersionUID = 6294689542092367723L;
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
	private JFrame deltaFrame;
	private JButton btnReturn;
	private JTextField textFieldAltura;
	private JTextField textFieldEspaçamento;
	private JTextField textFieldRaio;

	/**
	 * Launch the application.
	 */
	
	public static void deltaFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeltaConfiguration window = new DeltaConfiguration();
					window.deltaFrame.setVisible(true);
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
		
		 deltaFrame();
	}

	/**
	 * Create the application.
	 */
	public DeltaConfiguration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		deltaFrame = new JFrame();
		deltaFrame.setTitle("Configura\u00E7\u00E3o Delta");
		deltaFrame.setBackground(Color.LIGHT_GRAY);
		deltaFrame.setBounds(100, 100, 780, 620);
		deltaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		deltaFrame.getContentPane().setLayout(null);
		
		JLabel labelDistancia = new JLabel("Dist\u00E2ncia entre Condutores em metros");
		labelDistancia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelDistancia.setBounds(407, 63, 232, 29);
		deltaFrame.getContentPane().add(labelDistancia);
		
		textFieldDistanciaSub = new JTextField();
		textFieldDistanciaSub.setColumns(10);
		textFieldDistanciaSub.setBounds(407, 90, 336, 29);
		deltaFrame.getContentPane().add(textFieldDistanciaSub);
		
		JLabel labelFases = new JLabel("N\u00FAmero de Fases");
		labelFases.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelFases.setBounds(20, 118, 158, 29);
		deltaFrame.getContentPane().add(labelFases);
		
		textFieldFases = new JTextField();
		textFieldFases.setColumns(10);
		textFieldFases.setBounds(20, 144, 336, 29);
		deltaFrame.getContentPane().add(textFieldFases);
		
		JLabel labelTensao = new JLabel("Tens\u00E3o da Linha em kV");
		labelTensao.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelTensao.setBounds(407, 118, 158, 29);
		deltaFrame.getContentPane().add(labelTensao);
		
		textFieldTensao = new JTextField();
		textFieldTensao.setColumns(10);
		textFieldTensao.setBounds(407, 144, 336, 29);
		deltaFrame.getContentPane().add(textFieldTensao);
		
		JLabel labelAtoP = new JLabel("Dist\u00E2ncia Horizontal da fase A ao ponto P no Solo em metros");
		labelAtoP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelAtoP.setBounds(20, 183, 368, 29);
		deltaFrame.getContentPane().add(labelAtoP);
		
		textFieldAtoP = new JTextField();
		textFieldAtoP.setColumns(10);
		textFieldAtoP.setBounds(20, 211, 336, 29);
		deltaFrame.getContentPane().add(textFieldAtoP);
		
		JLabel labelBtoP = new JLabel("Dist\u00E2ncia Horizontal da fase B ao ponto P no Solo em metros");
		labelBtoP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelBtoP.setBounds(20, 250, 368, 29);
		deltaFrame.getContentPane().add(labelBtoP);
		
		textFieldBtoP = new JTextField();
		textFieldBtoP.setColumns(10);
		textFieldBtoP.setBounds(20, 278, 336, 29);
		deltaFrame.getContentPane().add(textFieldBtoP);
		
		JLabel labelCtoP = new JLabel("Dist\u00E2ncia Horizontal da fase C ao ponto P no Solo");
		labelCtoP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelCtoP.setBounds(20, 317, 294, 29);
		deltaFrame.getContentPane().add(labelCtoP);
		
		textFieldCtoP = new JTextField();
		textFieldCtoP.setColumns(10);
		textFieldCtoP.setBounds(20, 342, 336, 29);
		deltaFrame.getContentPane().add(textFieldCtoP);
		
		JLabel lblRazoEntreAltura = new JLabel("Altura de A menos Altura de B dividido por espa\u00E7amento");
		lblRazoEntreAltura.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRazoEntreAltura.setBounds(20, 371, 336, 29);
		deltaFrame.getContentPane().add(lblRazoEntreAltura);
		
		textFieldRazao = new JTextField();
		textFieldRazao.setColumns(10);
		textFieldRazao.setBounds(20, 396, 336, 29);
		deltaFrame.getContentPane().add(textFieldRazao);
		
		JButton btnCalculate = new JButton("Calcular");
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
				
				if(markDoisDelta.isSelected()) {
					int sub = 2;
					double[][] matrix = createMatrixDeltaDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
					displayProduct(matrix);
					double invertedMatrix[][] = invert(matrix);
					System.out.println("------------------------------------------------------------------");
		        	displayProduct(invertedMatrix);
		        	double rMatrix[] = realVoltage(tension, 120, n, sub); 
		        	System.out.println("------------------------------------------------------------------");
		            displayProduct2(rMatrix);
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            System.out.println("------------------------------------------------------------------");
		            displayProduct2(iMatrix);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            System.out.println("------------------------------------------------------------------");
		        	displayProduct(RealLoadMatrix);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            System.out.println("------------------------------------------------------------------");
		        	displayProduct(ImaginaryLoadMatrix);
		            double realAtGround = groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            System.out.println("------------------------------------------------------------------");
		            System.out.println(realAtGround);
		            double imaginaryAtGround = groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            if (imaginaryAtGround < 0.01) {
		            	imaginaryAtGround = 0;
		            }
		            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround);
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
		            
				} else if(markTresDelta.isSelected()) {
					int sub = 3;
					double[][] matrix = createMatrixDeltaTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
					displayProduct(matrix);
		        	double invertedMatrix[][] = invert(matrix);
		        	displayProduct(invertedMatrix);
		           
		        	double rMatrix[] = realVoltage(tension, 120, n, sub);
		        	displayProduct2(rMatrix);
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            System.out.println("------------------------------------------------------------------");
		            displayProduct2(iMatrix);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            System.out.println("------------------------------------------------------------------");
		            displayProduct(RealLoadMatrix);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            System.out.println("------------------------------------------------------------------");
//		            displayProduct(ImaginaryLoadMatrix);
		            double realAtGround = groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		           
		            double imaginaryAtGround = groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            if (imaginaryAtGround < 0.01) {
		            	imaginaryAtGround = 0;
		            }
		            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number); 
		            
				} else if (markQuatroDelta.isSelected()) {
					int sub = 4;
					double[][] matrix = createMatrixDeltaQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
		        	double invertedMatrix[][] = invert(matrix);
		            double rMatrix[] = realVoltage(tension, 120, n, sub);   
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            double imaginaryAtGround = groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            if (imaginaryAtGround < 0.01) {
		            	imaginaryAtGround = 0;
		            }
		            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
				
				} else if (markCincoDelta.isSelected()) {
					int sub = 5;
					double[][] matrix = createMatrixDeltaCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
		        	double invertedMatrix[][] = invert(matrix);
		            double rMatrix[] = realVoltage(tension, 120, n, sub);   
		            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            double imaginaryAtGround = groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
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
		btnCalculate.setBounds(166, 498, 134, 21);
		deltaFrame.getContentPane().add(btnCalculate);
		
		btnReturn = new JButton("Retornar");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			IntroFrame.introFrame();
			deltaFrame.setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReturn.setBounds(320, 546, 134, 21);
		deltaFrame.getContentPane().add(btnReturn);
		
		JLabel lblAlturaFasesoloEm = new JLabel("Altura fase-solo em metros");
		lblAlturaFasesoloEm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAlturaFasesoloEm.setBounds(20, 0, 158, 29);
		deltaFrame.getContentPane().add(lblAlturaFasesoloEm);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(20, 27, 336, 29);
		deltaFrame.getContentPane().add(textFieldAltura);
		
		JLabel lblEspaamentoEmMetros = new JLabel("Espa\u00E7amento em metros");
		lblEspaamentoEmMetros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEspaamentoEmMetros.setBounds(407, -1, 158, 29);
		deltaFrame.getContentPane().add(lblEspaamentoEmMetros);
		
		textFieldEspaçamento = new JTextField();
		textFieldEspaçamento.setColumns(10);
		textFieldEspaçamento.setBounds(407, 27, 336, 29);
		deltaFrame.getContentPane().add(textFieldEspaçamento);
		
		JLabel lblRaioDoCondutor = new JLabel("Raio do Condutor em metros");
		lblRaioDoCondutor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRaioDoCondutor.setBounds(20, 66, 169, 29);
		deltaFrame.getContentPane().add(lblRaioDoCondutor);
		
		JButton btnHelpDelta = new JButton("...");
		btnHelpDelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageFrame.imageFrame();
				
			}
		});
		btnHelpDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnHelpDelta.setBounds(188, 66, 20, 22);
		deltaFrame.getContentPane().add(btnHelpDelta);
		
		textFieldRaio = new JTextField();
		textFieldRaio.setColumns(10);
		textFieldRaio.setBounds(20, 90, 336, 29);
		deltaFrame.getContentPane().add(textFieldRaio);
		
		JLabel label_3 = new JLabel(" Quantidade de");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_3.setBounds(123, 435, 100, 29);
		deltaFrame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Condutores");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_4.setBounds(133, 459, 100, 29);
		deltaFrame.getContentPane().add(label_4);
		
		markDoisDelta = new JRadioButton("Dois");
		buttonGroup.add(markDoisDelta);
		markDoisDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markDoisDelta.setBounds(239, 449, 53, 21);
		deltaFrame.getContentPane().add(markDoisDelta);
		
		markTresDelta = new JRadioButton("Tr\u00EAs");
		buttonGroup.add(markTresDelta);
		markTresDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markTresDelta.setBounds(335, 449, 53, 21);
		deltaFrame.getContentPane().add(markTresDelta);
		
		markQuatroDelta = new JRadioButton("Quatro");
		buttonGroup.add(markQuatroDelta);
		markQuatroDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markQuatroDelta.setBounds(423, 449, 71, 21);
		deltaFrame.getContentPane().add(markQuatroDelta);
		
		markCincoDelta = new JRadioButton("Cinco");
		buttonGroup.add(markCincoDelta);
		markCincoDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markCincoDelta.setBounds(526, 449, 61, 21);
		deltaFrame.getContentPane().add(markCincoDelta);
		
		btnLimparDelta = new JButton("Limpar");
		btnLimparDelta.addActionListener(new ActionListener() {
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
		btnLimparDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLimparDelta.setBounds(478, 546, 134, 21);
		deltaFrame.getContentPane().add(btnLimparDelta);
		
		JButton btnSave = new JButton("Salvar");
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
		btnSave.setBounds(320, 498, 134, 21);
		deltaFrame.getContentPane().add(btnSave);
		
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
		btnCarregar.setBounds(478, 498, 134, 21);
		deltaFrame.getContentPane().add(btnCarregar);
		
		textFieldxP1 = new JTextField();
		textFieldxP1.setColumns(10);
		textFieldxP1.setBounds(407, 211, 336, 29);
		deltaFrame.getContentPane().add(textFieldxP1);
		
		textFieldyP1 = new JTextField();
		textFieldyP1.setColumns(10);
		textFieldyP1.setBounds(407, 278, 336, 29);
		deltaFrame.getContentPane().add(textFieldyP1);
		
		textFieldxP2 = new JTextField();
		textFieldxP2.setColumns(10);
		textFieldxP2.setBounds(407, 342, 336, 29);
		deltaFrame.getContentPane().add(textFieldxP2);
		
		textFieldyP2 = new JTextField();
		textFieldyP2.setColumns(10);
		textFieldyP2.setBounds(407, 396, 336, 29);
		deltaFrame.getContentPane().add(textFieldyP2);
		
		JLabel labelxP1 = new JLabel("Dist\u00E2ncia horizontal para-raio 1 em metros");
		labelxP1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelxP1.setBounds(407, 183, 368, 29);
		deltaFrame.getContentPane().add(labelxP1);
		
		JLabel labelyP1 = new JLabel("Dist\u00E2ncia vertical para-raio 1 em metros");
		labelyP1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelyP1.setBounds(407, 250, 368, 29);
		deltaFrame.getContentPane().add(labelyP1);
		
		JLabel labelxP2 = new JLabel("Dist\u00E2ncia horizontal para-raio 2 em metros");
		labelxP2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelxP2.setBounds(407, 317, 294, 29);
		deltaFrame.getContentPane().add(labelxP2);
		
		JLabel labelyP2 = new JLabel("Dist\u00E2ncia vertical para-raio 2 em metros");
		labelyP2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelyP2.setBounds(407, 371, 336, 29);
		deltaFrame.getContentPane().add(labelyP2);
		
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
					
					double pointPtoB = Double.parseDouble(textFieldBtoP.getText()) + i*5;
					
					double pointPtoC = Double.parseDouble(textFieldCtoP.getText()) + i*5;
					
					double xP1 = Double.parseDouble(textFieldxP1.getText());
					
					double yP1 = Double.parseDouble(textFieldyP1.getText());
					
					double xP2 = Double.parseDouble(textFieldxP2.getText());
					
					double yP2 = Double.parseDouble(textFieldyP2.getText());
					
					if(markDoisDelta.isSelected()) {
						int sub = 2;
						double[][] matrix = createMatrixDeltaDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
						
						double invertedMatrix[][] = invert(matrix);
						
			        	double rMatrix[] = realVoltage(tension, 120, n, sub); 
			        	
			            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
			            
			            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
			            
			            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
			            
			            double realAtGround = groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
			            
			            double imaginaryAtGround = groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
			            if (imaginaryAtGround < 0.01) {
			            	imaginaryAtGround = 0;
			            }
			            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround);
			            value[i] = polarValue[0];
			            
			            String module = String.valueOf(polarValue[0]);
			            String angle = String.valueOf(polarValue[1]);
			            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
			            
					} else if(markTresDelta.isSelected()) {
						int sub = 3;
						double[][] matrix = createMatrixDeltaTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);

			        	double invertedMatrix[][] = invert(matrix);
			           
			        	double rMatrix[] = realVoltage(tension, 120, n, sub);

			            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);

			            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);

			            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);

			            double realAtGround = groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
			           
			            double imaginaryAtGround = groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
			            if (imaginaryAtGround < 0.01) {
			            	imaginaryAtGround = 0;
			            }
			            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
			            value[i] = polarValue[0];
			            
			            String module = String.valueOf(polarValue[0]);
			            String angle = String.valueOf(polarValue[1]);
			            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
			            
					} else if (markQuatroDelta.isSelected()) {
						int sub = 4;
						double[][] matrix = createMatrixDeltaQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
						
			        	double invertedMatrix[][] = invert(matrix);
			        	
			            double rMatrix[] = realVoltage(tension, 120, n, sub);   
			            
			            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
			            
			            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
			            
			            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
			            
			            double realAtGround = groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
			            
			            double imaginaryAtGround = groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
			            if (imaginaryAtGround < 0.01) {
			            	imaginaryAtGround = 0;
			            }
			            double[] polarValue = rectangularToPolar(realAtGround, imaginaryAtGround );
			            value[i] = polarValue[0];
			            
			            String module = String.valueOf(polarValue[0]);
			            String angle = String.valueOf(polarValue[1]);
			            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
					
					} else if (markCincoDelta.isSelected()) {
						int sub = 5;
						double[][] matrix = createMatrixDeltaCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2);
						
			        	double invertedMatrix[][] = invert(matrix);
			        	
			            double rMatrix[] = realVoltage(tension, 120, n, sub);   
			            
			            double iMatrix[] = imaginaryVoltage(tension, 120, n, sub);
			            
			            double RealLoadMatrix[][] = multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
			            
			            double ImaginaryLoadMatrix[][] = multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
			            
			            double realAtGround = groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
			            
			            double imaginaryAtGround = groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
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
			    renderer.setSeriesPaint( 0 , Color.BLUE );
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
		btnGrafico.setBounds(166, 546, 134, 21);
		deltaFrame.getContentPane().add(btnGrafico);
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
		
		 Conductor condutor[] = new Conductor[n * sub +2];
		 for (int i = 0; i<(n *sub+2); i++) {
			condutor[i] = new Conductor();
		 }
		 
		 Vetor roda = new Vetor();
		
		 double a = (2 * Math.PI)/sub;
		 int c = 0;
		 double p = 0;
		 
		 for (int j = 0; j<n; j++) {
			 if (j == 1) {
				 condutor[c].x = p;
				 condutor[c].y = h + s*t;
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
	 
	 protected static double[][] createMatrixDeltaCinco (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
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
		 					System.out.println(distPontoImagem);
    		 				System.out.println("------------------------------------------------");
    		 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
    		 				System.out.println(matrix[i][j]);
    		 				System.out.println("------------------------------------------------");
		 				} else {
		 					double parc1 = Math.pow(condutor[i].y + condutor[j].y, 2);
		 					System.out.println(parc1);
		 					System.out.println("------------------------------------------------");
		 					double parc2 = Math.pow(condutor[j].x - condutor[i].x, 2);
		 					System.out.println(parc2);
		 					System.out.println("------------------------------------------------");
		 					double distPontoImagem = Math.sqrt(parc1 + parc2);
		 					System.out.println(distPontoImagem);
		 					System.out.println("------------------------------------------------");
    		 				matrix[i][j] = epsilon * Math.log(distPontoImagem/dxy);
    		 				System.out.println(matrix[i][j]);;
		 				}
		 			}
		 		}
		 	}
		 	return matrix;
	 }
	 
	 protected static double[][] createMatrixDeltaQuatro (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
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
   		 				System.out.println(matrix[i][j]);
		 				}
		 			}
		 		}
		 	}
		 	return matrix;
	 }
	 
	 protected static double[][] createMatrixDeltaTres (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
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
	 
	 protected static double[][] createMatrixDeltaDois (double h, double r, double s, int n, double d, double t, int sub, double xP1, double yP1, double xP2, double yP2) {
        double matrix[][] = new double[sub * n+2][sub * n+2];
           
		Conductor condutor[] = distribui(n, sub, d, h, r, s, xP1, yP1, xP2, yP2, t);
		 
	 	for (int i = 0; i<n*sub+2; i++) {
	 		for (int j = 0; j<n*sub+2; j++) {
	 			if (i == j) {
	 				matrix[i][j] = epsilon * Math.log(Math.sqrt(Math.pow(2 * condutor[j].y, 2))/r);
					System.out.println(matrix[i][j]);
					System.out.println("------------------------------------------------");
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
	    
	    public static double groundFieldFormulaDelta(double a[][], double dh1, double dh2, double dh3, double h, int n, double dff, double t, int sub) {
	    	double GroundValue0 = 0;
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
	    	for(int i = 0; i <(sub * n + 2); i++) {
	    		if (i < sub || i == (sub*n)) {
	    			GroundValue0 += epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
	    			System.out.println("-----------------------------------------------------------------------");
	    			System.out.println(GroundValue0);
	    		} else if ( i >= sub && i < 2*sub) {
	    			GroundValue0 += epsilon * 2 * ((a[i][j] * (h + (dff * t))/(Math.pow(dh[i], 2) + Math.pow((h + (dff * t)), 2))));
	    			System.out.println("-----------------------------------------------------------------------");
	    			System.out.println(GroundValue0);
	    		} else if (i >=2*sub && i < n*sub || i == n*sub+1) {
	    			GroundValue0 += epsilon * 2 * ((a[i][j] * h)/(Math.pow(dh[i], 2) + Math.pow(h, 2)));
	    			System.out.println("-----------------------------------------------------------------------");
	    			System.out.println(GroundValue0);
	    		}
	    	}
	    	return GroundValue0;
	    }
	    
	    public static double[] rectangularToPolar(double a, double b) {
	    	double module = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
	    	double angle = Math.atan(b/a);
	    	double[] value = {module, radToDegree(angle)};
	    	
	    	return value;
	    }
	    
	    protected static double epsilon = 18 * Math.pow(10, 9);
	    private JRadioButton markDoisDelta;
	    private JRadioButton markCincoDelta;
	    private JRadioButton markQuatroDelta;
	    private JRadioButton markTresDelta;
	    private final ButtonGroup buttonGroup = new ButtonGroup();
	    private JButton btnLimparDelta;
	    private JTextField textFieldxP1;
	    private JTextField textFieldyP1;
	    private JTextField textFieldxP2;
	    private JTextField textFieldyP2;
	}
	

