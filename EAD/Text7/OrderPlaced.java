import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class OrderPlaced extends JFrame{
    private JLabel wrongJLabel;
    private JButton okButton;
    OrderPlaced(){
        setSize(300,100);
		setLocationRelativeTo(null);
		setTitle("Error!");
		setLayout(new FlowLayout());	

        ImageIcon icon = new ImageIcon("check.png");
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        JLabel picLabel = new JLabel(icon);
        add("West",picLabel);

        JPanel wrongNumJPanel = new JPanel();
        wrongJLabel = new JLabel("Order Placed");
        wrongNumJPanel.add(wrongJLabel);
        add("Center", wrongNumJPanel);

        okButton = new JButton("Ok");
        add("South", okButton);

        okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});

    }
}
