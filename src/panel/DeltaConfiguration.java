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
	
	Calculos calc = new Calculos();
	
	private static final long serialVersionUID = 6294689542092367723L;
	
	public JRadioButton markDoisDelta;
	public JRadioButton markCincoDelta;
	public JRadioButton markQuatroDelta;
	public JRadioButton markTresDelta;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JButton btnLimparDelta;
	public JTextField textFieldxP1;
	public JTextField textFieldyP1;
	public JTextField textFieldxP2;
	public JTextField textFieldyP2;
	public JTextField textFieldRaioParaRaio;
	public JTextField textFieldDistanciaSub;
	public JTextField textFieldFases;
	public JTextField textFieldTensao;
	public JTextField textFieldAtoP;
	public JTextField textFieldBtoP;
	public JTextField textFieldCtoP;
	public JTextField textFieldRazao;
	public JTextField textFieldAltura;
	public JTextField textFieldEspaçamento;
	public JTextField textFieldRaio;
	
	public JFrame deltaFrame;
	public JButton btnReturn;
	
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
		deltaFrame.setBounds(100, 100, 781, 659);
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
						 || textFieldxP2.getText().length() == 0 || textFieldyP2.getText().length() == 0 || textFieldRaioParaRaio.getText().length() == 0 || buttonGroup.isSelected(null)){
					JOptionPane.showMessageDialog(null, "Formulário necessita estar preenchido");
				}else {
				
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
				
				if(markDoisDelta.isSelected()) {
					int sub = 2;
					double[][] matrix = calc.createMatrixDeltaDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
					double invertedMatrix[][] = calc.invert(matrix);
		        	double rMatrix[] = calc.realVoltage(tension, 120, n, sub); 
		            double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = calc.groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            double imaginaryAtGround = calc.groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround);
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
		            
				} else if(markTresDelta.isSelected()) {
					int sub = 3;
					double[][] matrix = calc.createMatrixDeltaTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
		        	double invertedMatrix[][] = calc.invert(matrix);
		        	double rMatrix[] = calc.realVoltage(tension, 120, n, sub);
		            double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = calc.groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            double imaginaryAtGround = calc.groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number); 
		            
				} else if (markQuatroDelta.isSelected()) {
					int sub = 4;
					double[][] matrix = calc.createMatrixDeltaQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
		        	double invertedMatrix[][] = calc.invert(matrix);
		            double rMatrix[] = calc.realVoltage(tension, 120, n, sub);   
		            double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = calc.groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            double imaginaryAtGround = calc.groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
				
				} else if (markCincoDelta.isSelected()) {
					int sub = 5;
					double[][] matrix = calc.createMatrixDeltaCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
		        	double invertedMatrix[][] = calc.invert(matrix);
		            double rMatrix[] = calc.realVoltage(tension, 120, n, sub);   
		            double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
		            double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
		            double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
		            double realAtGround = calc.groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            double imaginaryAtGround = calc.groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
		            double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround );
		            
		            String module = String.valueOf(polarValue[0]);
		            String angle = String.valueOf(polarValue[1]);
		            String number = module + " Newtons/Coulombs" + "\n" + angle + " graus";
		            JOptionPane.showMessageDialog(null, number);
				}
			}
		}
	});
		btnCalculate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCalculate.setBounds(166, 551, 134, 21);
		deltaFrame.getContentPane().add(btnCalculate);
		
		btnReturn = new JButton("Retornar");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			IntroFrame.introFrame();
			deltaFrame.setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReturn.setBounds(320, 582, 134, 21);
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
		label_3.setBounds(133, 488, 100, 29);
		deltaFrame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Condutores");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_4.setBounds(143, 512, 100, 29);
		deltaFrame.getContentPane().add(label_4);
		
		markDoisDelta = new JRadioButton("Dois");
		buttonGroup.add(markDoisDelta);
		markDoisDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markDoisDelta.setBounds(239, 500, 53, 21);
		deltaFrame.getContentPane().add(markDoisDelta);
		
		markTresDelta = new JRadioButton("Tr\u00EAs");
		buttonGroup.add(markTresDelta);
		markTresDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markTresDelta.setBounds(335, 500, 53, 21);
		deltaFrame.getContentPane().add(markTresDelta);
		
		markQuatroDelta = new JRadioButton("Quatro");
		buttonGroup.add(markQuatroDelta);
		markQuatroDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markQuatroDelta.setBounds(423, 500, 71, 21);
		deltaFrame.getContentPane().add(markQuatroDelta);
		
		markCincoDelta = new JRadioButton("Cinco");
		buttonGroup.add(markCincoDelta);
		markCincoDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		markCincoDelta.setBounds(526, 500, 61, 21);
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
				textFieldRaioParaRaio.setText("");
				buttonGroup.clearSelection();
			}
		});
		btnLimparDelta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLimparDelta.setBounds(478, 582, 134, 21);
		deltaFrame.getContentPane().add(btnLimparDelta);
		
		JButton btnSave = new JButton("Salvar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textFieldAltura.getText().length() == 0 || textFieldEspaçamento.getText().length() == 0 || textFieldRazao.getText().length() == 0 || textFieldRaio.getText().length() == 0
						 || textFieldFases.getText().length() == 0 || textFieldDistanciaSub.getText().length() == 0 || textFieldTensao.getText().length() == 0 || textFieldAtoP.getText().length() == 0
						 || textFieldBtoP.getText().length() == 0 || textFieldCtoP.getText().length() == 0 || textFieldxP1.getText().length() == 0 || textFieldyP1.getText().length() == 0 
						 || textFieldxP2.getText().length() == 0 || textFieldyP2.getText().length() == 0 || textFieldRaioParaRaio.getText().length() == 0 || buttonGroup.isSelected(null)){
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
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBounds(320, 551, 134, 21);
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
			}
		});
		btnCarregar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCarregar.setBounds(478, 551, 134, 21);
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

				DadosGrafico dg = new DadosGrafico();
				
				if (textFieldAltura.getText().length() == 0 || textFieldEspaçamento.getText().length() == 0 || textFieldRazao.getText().length() == 0 || textFieldRaio.getText().length() == 0
						 || textFieldFases.getText().length() == 0 || textFieldDistanciaSub.getText().length() == 0 || textFieldTensao.getText().length() == 0 || textFieldAtoP.getText().length() == 0
						 || textFieldBtoP.getText().length() == 0 || textFieldCtoP.getText().length() == 0 || textFieldxP1.getText().length() == 0 || textFieldyP1.getText().length() == 0 
						 || textFieldxP2.getText().length() == 0 || textFieldyP2.getText().length() == 0 || textFieldRaioParaRaio.getText().length() == 0 || buttonGroup.isSelected(null)){
					JOptionPane.showMessageDialog(null, "Formulário necessita estar preenchido");
				}
				
				int mark = 0;
				
				if (markDoisDelta.isSelected()) {
					mark = 2;
				} else if(markTresDelta.isSelected()) {
					mark = 3;
				} else if(markQuatroDelta.isSelected()) {
					mark = 4;
				} else if(markCincoDelta.isSelected()) {
					mark = 5;
				}
				
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
			
			}	
		});
		btnGrafico.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGrafico.setBounds(166, 582, 134, 21);
		deltaFrame.getContentPane().add(btnGrafico);
		
		textFieldRaioParaRaio = new JTextField();
		textFieldRaioParaRaio.setColumns(10);
		textFieldRaioParaRaio.setBounds(229, 449, 336, 29);
		deltaFrame.getContentPane().add(textFieldRaioParaRaio);
		
		JLabel lblRaioParaRaio = new JLabel("Raio do para-raio em metros.");
		lblRaioParaRaio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRaioParaRaio.setBounds(229, 424, 336, 29);
		deltaFrame.getContentPane().add(lblRaioParaRaio);
	}
	
	public void calcGraficoDelta(int i, int range, Double[] value, double abscissa, int pontos) {
	
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
		
		if(mark == 2) {
			int sub = 2;
			double[][] matrix = calc.createMatrixDeltaDois(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
			double invertedMatrix[][] = calc.invert(matrix);
        	double rMatrix[] = calc.realVoltage(tension, 120, n, sub); 
            double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
            double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
            double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
            double realAtGround = calc.groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
            double imaginaryAtGround = calc.groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
            double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround);
            value[i] = polarValue[0];
            
		} else if(mark == 3) {
			int sub = 3;
			double[][] matrix = calc.createMatrixDeltaTres(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
        	double invertedMatrix[][] = calc.invert(matrix);
        	double rMatrix[] = calc.realVoltage(tension, 120, n, sub);
            double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
            double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
            double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
            double realAtGround = calc.groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
            double imaginaryAtGround = calc.groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
            double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround );
            value[i] = polarValue[0];
            
		} else if (mark == 4) {
			int sub = 4;
			double[][] matrix = calc.createMatrixDeltaQuatro(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
        	double invertedMatrix[][] = calc.invert(matrix);
            double rMatrix[] = calc.realVoltage(tension, 120, n, sub);   
            double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
            double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
            double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
            double realAtGround = calc.groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
            double imaginaryAtGround = calc.groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
            double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround );
            value[i] = polarValue[0];
            
		} else if (mark == 5) {
			int sub = 5;
			double[][] matrix = calc.createMatrixDeltaCinco(h, r, s, n, subconductorDistance, t, sub, xP1, yP1, xP2, yP2, rpr);
        	double invertedMatrix[][] = calc.invert(matrix);
            double rMatrix[] = calc.realVoltage(tension, 120, n, sub);   
            double iMatrix[] = calc.imaginaryVoltage(tension, 120, n, sub);
            double RealLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  rMatrix, n, sub);
            double ImaginaryLoadMatrix[][] = calc.multiplyMatrix(invertedMatrix,  iMatrix, n, sub);
            double realAtGround = calc.groundFieldFormulaDelta(RealLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
            double imaginaryAtGround = calc.groundFieldFormulaDelta(ImaginaryLoadMatrix, pointPtoA, pointPtoB, pointPtoC, h, n, s, t, sub);
            double[] polarValue = calc.rectangularToPolar(realAtGround, imaginaryAtGround );
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
}
	

