import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class CaesarCracker extends JFrame {
	private JTextField txtCode;
	private JLabel lblDecoded;
	private JSlider sliderCC;
	private JTextPane textpn;
	String code = "";
	private JLabel lblhintUseThe;
	
	public void sUpdate() {
		code = txtCode.getText(); 
		String output = "";
		char key = (char)sliderCC.getValue();
		for (int x = 0; x < code.length(); x++) {
			char input = code.charAt(x);
			if (input >= 'A' && input <= 'Z') 
			{
				input += key;
				if (input > 'Z')
					input -= 26;
				if (input < 'A')
					input += 26;
			} 
			else if (input >= 'a' && input <= 'z') 
			{
				input += key;
				if (input > 'z')
					input -= 26;
				if (input < 'a')
					input += 26;
			}
			output += input;
		}
		textpn.setText(output);
		lblDecoded.setText("The key is: " + sliderCC.getValue());
	}
	public CaesarCracker() {
		
		setTitle("Caesar Cracker");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblTopText = new JLabel("Enter the message");
		lblTopText.setBounds(0, 5, 584, 21);
		lblTopText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTopText.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTopText);
		
		txtCode = new JTextField();
		txtCode.setToolTipText("Message to crack");
		txtCode.setHorizontalAlignment(SwingConstants.CENTER);
		txtCode.setBounds(200, 45, 200, 20);
		getContentPane().add(txtCode);
		txtCode.setColumns(10);
		
		sliderCC = new JSlider();
		sliderCC.setPaintLabels(true);
		sliderCC.setMajorTickSpacing(3);
		sliderCC.setValue(0);
		sliderCC.setMinimum(-26);
		sliderCC.setMaximum(26);
		sliderCC.setBounds(0, 105, 584, 26);
		getContentPane().add(sliderCC);
		
		lblDecoded = new JLabel("");
		lblDecoded.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDecoded.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecoded.setBounds(0, 142, 584, 33);
		getContentPane().add(lblDecoded);
		
		textpn = new JTextPane();
		textpn.setToolTipText("Drag then over press CTRL+C to copy");
		textpn.setEditable(false);
		textpn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textpn.setText("The Message will appear here");
		textpn.setBounds(0, 186, 584, 27);
		textpn.setBackground(null);
		getContentPane().add(textpn);
		
		lblhintUseThe = new JLabel("(Hint: Use the inverse of the key the message was coded with)");
		lblhintUseThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblhintUseThe.setBounds(0, 76, 584, 14);
		getContentPane().add(lblhintUseThe);
		
		event e = new event();
		sliderCC.addChangeListener(e);
	}

	public static void main(String[] args) {
		CaesarCracker gui = new CaesarCracker();
		gui.setSize(new Dimension(600, 300));
		gui.setVisible(true);
	}
	public class event implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			sUpdate();
		}
	}
}
