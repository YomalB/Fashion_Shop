import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PlaceOder extends JFrame{
    private JButton deleteButton;
    private JButton plaveOderButton;

    private JLabel oderIdJLabel;
    private JLabel oderIdLabel;

    private JLabel customerIdJLabel;
    private JLabel sizeJLabel;
    private JLabel qtyJLabel;
    private JLabel amountJLabel;

    private JTextField customerIdTextField;
    private JTextField sizeTextField;
    private JTextField qtyTextField;
    
    private JLabel amountCalJLabel;

    private JLabel sizeNameJLabel;

    private static int orderCounter = 1;
    private String generateOrderId() {
        String orderId = "ODR#" + String.format("%05d", orderCounter);
        return orderId;
    }

    PlaceOder(FashionShop fashionShop){
        setSize(600, 600);
        setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        setTitle("Place Oder");
        setLocationRelativeTo(null);

        JPanel deleteBtnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        deleteButton  = new JButton("Back");
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setOpaque(true);
        deleteButton.setPreferredSize(new Dimension(90, 40));
        deleteButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        deleteBtnPanel.add(deleteButton);
        add("North",deleteBtnPanel);

        JPanel oderJPanel = new JPanel(new GridLayout(5,1,0,0));

        oderIdJLabel = new JLabel("Order ID : ");
        oderIdJLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        oderJPanel.add(oderIdJLabel);
        customerIdJLabel = new JLabel("Customer ID : ");
        customerIdJLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        oderJPanel.add(customerIdJLabel);
        sizeJLabel = new JLabel("Size : ");
        sizeJLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        oderJPanel.add(sizeJLabel);
        qtyJLabel = new JLabel("QTY : ");
        qtyJLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        oderJPanel.add(qtyJLabel);
        amountJLabel = new JLabel("Amount : ");
        amountJLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        oderJPanel.add(amountJLabel);

        oderJPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 30, 10));

        add("West", oderJPanel);

        JPanel oderTextJPanel = new JPanel(new GridLayout(5,1,0,30));

        String oderId =  test.genarateId();
        oderIdLabel = new JLabel(oderId );
        oderTextJPanel.add(oderIdLabel);

        customerIdTextField = new JTextField();
        customerIdTextField.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        oderTextJPanel.add(customerIdTextField);
        sizeTextField = new JTextField();

        sizeTextField.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        oderTextJPanel.add(sizeTextField);
        qtyTextField = new JTextField();

        qtyTextField.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        oderTextJPanel.add(qtyTextField);

        amountCalJLabel = new JLabel();
        oderTextJPanel.add(amountCalJLabel);
       
        oderTextJPanel.setBorder(BorderFactory.createEmptyBorder(25, 20,45, 10));
        add("Center", oderTextJPanel);

        JPanel placeOderBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        plaveOderButton  = new JButton("Place");
        plaveOderButton.setBackground(Color.CYAN);
        plaveOderButton.setOpaque(true);
        plaveOderButton.setPreferredSize(new Dimension(90, 40));
        plaveOderButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        placeOderBtnPanel.add(plaveOderButton);
        add("South",placeOderBtnPanel);

        JPanel qtySizPanel = new JPanel(new GridLayout(1,1));
        sizeNameJLabel = new JLabel("(XS/S/M/L/XL/XXL)");
        sizeNameJLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        qtySizPanel.add(sizeNameJLabel);
        qtySizPanel.setBorder(BorderFactory.createEmptyBorder(25, 10,45, 10));
        add("East", qtySizPanel);

        //-------------------------------------------------------------------------

        deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
                fashionShop.setVisible(true);
                setVisible(false);
			}
		});

        customerIdTextField.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent evt){
                String text = customerIdTextField.getText();

                    if(!(text.length() != 11 && text.charAt(0) == '0')){
                        new WrongNumber().setVisible(true);
                        customerIdTextField.setText("");
				    }
			}
		});

        sizeTextField.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent evt){
                String text = sizeTextField.getText().toUpperCase();

                    if(!(text.equals("X") || text.equals("XX") || text.equals("XS") || text.equals("S") || text.equals("M")  || text.equals("L")  || text.equals("XL") || text.equals("XXL") )){
                        sizeTextField.setText("");
				    }
			}
		});

        qtyTextField.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent evt){
				if(49<evt.getKeyCode() && evt.getKeyCode()>58){
					qtyTextField.setText("");
				} 
                        try {
                    int qty = Integer.parseInt(qtyTextField.getText());
                    String size = sizeTextField.getText().toUpperCase();
                    double amount = 0.0;

                    if (size.equals("XS")) {
                        amount = test.XS * qty;
                    } else if (size.equals("S")) {
                        amount = test.S * qty;
                    } else if (size.equals("M")) {
                        amount = test.M * qty;
                    } else if (size.equals("L")) {
                        amount = test.L * qty;
                    } else if (size.equals("XL")) {
                        amount = test.XL * qty;
                    } else if (size.equals("XXL")) {
                        amount = test.XXL * qty;
                    }

                    String amountStr = String.valueOf(amount);
                    amountCalJLabel.setText(amountStr);
                } catch (NumberFormatException e) {
                    amountCalJLabel.setText("");
                }
            }
        });

        plaveOderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String orderId = generateOrderId();
                String customerId = customerIdTextField.getText();
                String size = sizeTextField.getText();
                int qty = Integer.parseInt(qtyTextField.getText());
                double amount = Double.parseDouble(amountCalJLabel.getText());

                Orders order = new Orders(orderId, customerId, size, qty, amount);
                test.orderList.add(order);

                JOptionPane.showMessageDialog(null, "Order placed successfully!");
                orderCounter++;
                oderIdLabel.setText(generateOrderId());

                customerIdTextField.setText("");
                sizeTextField.setText("");
                qtyTextField.setText("");
                amountCalJLabel.setText("");
            }
        });

    }
}

