import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SearchOrder extends JFrame{
    private JButton backButton;
    SearchOrder(){
        setSize(600, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Search Order");
        setLocationRelativeTo(null);

        JPanel backJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButton  = new JButton("Back");
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setPreferredSize(new Dimension(90, 40));
        backButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        backJPanel.add(backButton);
        add("North",backJPanel);

        backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});

        JPanel getIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel enterIdLabel = new JLabel("Enter Order ID :     ");
        getIdPanel.add(enterIdLabel);

        JTextField enterTextField = new JTextField();
        enterTextField.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        enterTextField.setPreferredSize(new Dimension(200, 30));
        getIdPanel.add(enterTextField);

        JButton getIdButton = new JButton("Search");
        getIdButton.setPreferredSize(new Dimension(100, 30));
        getIdButton.setBackground(Color.BLUE);
        getIdButton.setForeground(Color.WHITE);
        getIdPanel.add(getIdButton);

        add("Center",getIdPanel);

        JPanel displayPanel = new JPanel(new GridLayout(5,1));
        JLabel customerIdLabel = new JLabel("Customer Id : ");
        customerIdLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        displayPanel.add(customerIdLabel);

        JLabel sizeLabel = new JLabel("Size : ");
        customerIdLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        displayPanel.add(sizeLabel);

        JLabel qtyLabel = new JLabel("QTY : ");
        qtyLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        displayPanel.add(qtyLabel);

        JLabel amountLabel = new JLabel("Amount : ");
        amountLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        displayPanel.add(amountLabel);

        JLabel statusLabel = new JLabel("Status : ");
        statusLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        displayPanel.add(statusLabel);

        add("West", displayPanel);
        displayPanel.setBorder(BorderFactory.createEmptyBorder(100, 10, 35, 0));

        getIdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String orderId = enterTextField.getText();
                boolean validId = false;

                for (int i = 0; i < test.orderList.size(); i++) {
                    if (test.orderList.get(i).getOderId().equals(orderId)) {
                        validId = true;
                        String customerId = test.orderList.get(i).getCustomerId();
                        String size = test.orderList.get(i).getSize();
                        int qty = test.orderList.get(i).getQty();
                        double amount = test.orderList.get(i).getAmount();

                        int status = test.orderList.get(i).getStatus();
                        String statusString;
                        switch (status) {
                            case 0:
                                statusString = "PROCESSING";
                                break;
                            case 1:
                                statusString = "DELIVERING";
                                break;
                            case 2:
                                statusString = "DELIVERED";
                                break;
                            default:
                                statusString = "UNKNOWN";
                        }

                        JPanel showDetailyPanel = new JPanel(new GridLayout(5, 1));
                        JLabel showCustomerIdLabel = new JLabel(customerId);
                        showCustomerIdLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
                        showDetailyPanel.add(showCustomerIdLabel);

                        JLabel showSizeLabel = new JLabel(size);
                        showSizeLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
                        showDetailyPanel.add(showSizeLabel);

                        JLabel showQtyLabel = new JLabel(Integer.toString(qty));
                        showQtyLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
                        showDetailyPanel.add(showQtyLabel);

                        JLabel showAmountLabel = new JLabel(Double.toString(amount));
                        showAmountLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
                        showDetailyPanel.add(showAmountLabel);

                        JLabel showStatusLabel = new JLabel(statusString);
                        showStatusLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
                        showDetailyPanel.add(showStatusLabel);

                        add(showDetailyPanel);
                        showDetailyPanel.setBorder(BorderFactory.createEmptyBorder(100, 150, 35, 0));

                    }
                }
                if(!validId){
                        JOptionPane.showMessageDialog(null, "Invalid Order ID");
                        enterTextField.setText("");
                    }
            }
        });
    }
}