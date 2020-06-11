package panel;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Splash extends JFrame {

	Calculos calc = new Calculos();
	
	private static final long serialVersionUID = 1L;
	
	Font fonte = new Font("Arial", Font.BOLD, 20);
	JLabel numero = new JLabel("0");
	
	private JFrame splashFrame;
	
	public static void splashFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash window = new Splash();
					window.splashFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int contador() {
		while(StaticVariable.numCont < 101) {
			numero.setText(StaticVariable.numCont + "");
			StaticVariable.numCont++;
			try {Thread.sleep(22);}catch(Exception e) {}
		}
		return StaticVariable.numCont;
	}
	
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
		Splash sp = new Splash();
		sp.contador();
		if(StaticVariable.numCont  == 101) {
			try {sp.setVisible(false);}catch(Exception e) {}
			IntroFrame.introFrame();
		}
	}

	public Splash() {
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\temp\\ws-eclipse\\FinalProjetc\\images\\imageSplash_Smaller.jpg"));
		lblNewLabel.setBounds(0, 0, 600, 574);
		getContentPane().add(lblNewLabel);
		numero.setBackground(new Color(0, 0, 0));
		numero.setBounds(0, 0, 600, 600);
		numero.setFont(fonte);
		numero.setHorizontalAlignment(SwingConstants.CENTER);
		numero.setVerticalAlignment(SwingConstants.BOTTOM);
		getContentPane().add(numero);
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
	
	}
}


