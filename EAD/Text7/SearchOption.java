import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SearchOption extends JFrame{
    private JLabel wrongJLabel;

    private JButton searchCustomerButton;
    private JButton searchOrderButton;
    private JButton cancelButton;
    SearchOption(){
        setSize(500,150);
		setLocationRelativeTo(null);
		setTitle("Error!");
		setLayout(new FlowLayout());	

        ImageIcon icon = new ImageIcon("check.png");
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        JLabel picLabel = new JLabel(icon);
        add("West",picLabel);

        JPanel wrongNumJPanel = new JPanel();
        wrongJLabel = new JLabel("Please select the option");
        wrongNumJPanel.add(wrongJLabel);
        add("Center", wrongNumJPanel);

        JPanel selectPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        searchCustomerButton = new JButton("Search Customer");
        selectPanel.add(searchCustomerButton);

        searchOrderButton = new JButton("Search Order");
        selectPanel.add(searchOrderButton);

        cancelButton = new JButton("Cancel");
        selectPanel.add(cancelButton);
        selectPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 15, 20));
        add("South",selectPanel);

        cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});

        searchCustomerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchCustomer().setVisible(true);
                dispose();
			}
		});

        searchOrderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchOrder().setVisible(true);
                dispose();
			}
		});

    }
}
