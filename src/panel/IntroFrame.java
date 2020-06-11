package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntroFrame {

	protected static final String Enumerate = null;
	private JFrame introFrame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton mark1;
	public JRadioButton mark2;
	public JRadioButton mark3;
	private JLabel lblimageVertical;

	/**
	 * Launch the application.
	 */
	public static void introFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroFrame window = new IntroFrame();
					window.introFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public IntroFrame() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		introFrame = new JFrame();
		introFrame.setResizable(false);
		introFrame.setTitle("Arranjo da Linha de Transmiss\u00E3o");
		introFrame.setBounds(100, 100, 700, 320);
		introFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		introFrame.setLocationRelativeTo(null);

		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAceitar.setBackground(new Color(235, 235, 235));
				btnAceitar.setBackground(new Color(58, 65, 84));
			}
		});
		btnAceitar.setBounds(277, 234, 135, 25);
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mark1.isSelected()) {
					StaticVariable.markConfig = 1;
					HorizontalConfiguration.horizontalFrame();
					introFrame.setVisible(false);
					
				} else if(mark2.isSelected()) {
					StaticVariable.markConfig = 2;
					DeltaConfiguration.deltaFrame();
					introFrame.setVisible(false);
					
				} else if(mark3.isSelected()) {
					StaticVariable.markConfig = 3;
					VerticalConfiguration.verticalFrame();
					introFrame.setVisible(false);	
					
				} else {
					JOptionPane.showMessageDialog(null, "Você precisa marcar uma opção");
				}
			}
		});
		introFrame.getContentPane().setLayout(null);
		btnAceitar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		introFrame.getContentPane().add(btnAceitar);
		
		mark1 = new JRadioButton("Horizontal");
		mark1.setBounds(68, 200, 100, 21);
		buttonGroup.add(mark1);
		mark1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		introFrame.getContentPane().add(mark1);
		
		mark2 = new JRadioButton("Delta");
		mark2.setBounds(313, 200, 65, 21);
		buttonGroup.add(mark2);
		mark2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		introFrame.getContentPane().add(mark2);
		
		mark3 = new JRadioButton("Vertical");
		mark3.setBounds(518, 200, 80, 21);
		buttonGroup.add(mark3);
		mark3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		introFrame.getContentPane().add(mark3);
		
		JLabel lblimageHorizontal = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/horizontal.jpg")).getImage();
		lblimageHorizontal.setIcon(new ImageIcon(img));
		lblimageHorizontal.setBounds(28, 38, 184, 155);
		introFrame.getContentPane().add(lblimageHorizontal);
		
		JLabel lblimageDelta = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/Delta.jpg")).getImage();
		lblimageDelta.setIcon(new ImageIcon(img2));
		lblimageDelta.setBounds(245, 38, 190, 155);
		introFrame.getContentPane().add(lblimageDelta);
		
		lblimageVertical = new JLabel("New label");
		Image img3 = new ImageIcon(this.getClass().getResource("/Vertical.jpg")).getImage();
		lblimageVertical.setIcon(new ImageIcon(img3));
		lblimageVertical.setBounds(473, 38, 184, 155);
		introFrame.getContentPane().add(lblimageVertical);
	}
}
