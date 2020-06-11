package panel;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImageFrame extends JFrame {

	private static final long serialVersionUID = 6294689542092367723L;
	private JPanel imageFrame;

	/**
	 * Launch the application.
	 */
	public static void imageFrame() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageFrame frame = new ImageFrame();
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
	public ImageFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 862, 571);
		imageFrame = new JPanel();
		imageFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(imageFrame);
		imageFrame.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				}
			
		});
		
		btnVoltar.setBounds(349, 488, 140, 38);
		imageFrame.add(btnVoltar);
		
		JLabel lblimageFios = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/TabelaFios.jpg")).getImage();
		lblimageFios.setIcon(new ImageIcon(img));
		lblimageFios.setBounds(10, 11, 836, 440);
		imageFrame.add(lblimageFios);
	}
}
