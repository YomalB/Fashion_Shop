import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrderStatus extends JFrame{
    JButton backButton;
    OrderStatus(FashionShop fashionShop){
         setSize(600, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Search Order");
        setLocationRelativeTo(null);

        JPanel maiPanel = new JPanel(new GridLayout(2,1));

        JPanel backJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButton  = new JButton("Back");
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setPreferredSize(new Dimension(90, 40));
        backButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        backJPanel.add(backButton);
        backJPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel searchPanel = new JPanel(new GridLayout(1,3,1,6));
        JLabel enterOrderIdLabel = new JLabel("Enter Order ID : ");
        enterOrderIdLabel.setFont(new Font("", Font.BOLD, 18));
        searchPanel.add(enterOrderIdLabel);

        JTextField enterTextField = new JTextField();
        enterTextField.setFont(new Font("", Font.BOLD, 18));
        searchPanel.add(enterTextField);

        JButton searchIdButton = new JButton("Search");
        searchIdButton.setFont(new Font("", Font.BOLD, 18));
        searchIdButton.setForeground(Color.BLACK);
        searchIdButton.setBackground(Color.CYAN);
        searchPanel.add(searchIdButton);

        searchPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 140, 20));

        JPanel setDetaiPanel = new JPanel(new GridLayout(1,2));

        JPanel detailPanel = new JPanel(new GridLayout(5,1));
        JLabel customerIdLabel = new JLabel("Customer Id : ");
        customerIdLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        detailPanel.add(customerIdLabel);

        JLabel sizeLabel = new JLabel("Size : ");
        customerIdLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        detailPanel.add(sizeLabel);

        JLabel qtyLabel = new JLabel("QTY : ");
        qtyLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        detailPanel.add(qtyLabel);

        JLabel amountLabel = new JLabel("Amount : ");
        amountLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        detailPanel.add(amountLabel);

        JLabel statusLabel = new JLabel("Status : ");
        statusLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        detailPanel.add(statusLabel);
        setDetaiPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 20));
        setDetaiPanel.add(detailPanel);

        JPanel changePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton changeButton  = new JButton("Delete");
        changeButton.setBackground(Color.RED);
        changeButton.setForeground(Color.WHITE);
        changeButton.setOpaque(true);
        changeButton.setPreferredSize(new Dimension(90, 40));
        changeButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        changePanel.add(changeButton);

        add("North",backJPanel);
        maiPanel.add(searchPanel);
        maiPanel.add(setDetaiPanel);

        add(maiPanel);
        add("South", changePanel);

        backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
                fashionShop.setVisible(true);
                setVisible(false);
			}
		});


        searchIdButton.addActionListener(new ActionListener() {
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

                        setDetaiPanel.add(showDetailyPanel);
                        showDetailyPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 20));
                    }
                }
                if(!validId){
                        JOptionPane.showMessageDialog(null, "Invalid Order ID");
                        enterTextField.setText("");
                    }
            }
        });

        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String orderId = enterTextField.getText();
                boolean validId = false;
        
                for (int i = 0; i < test.orderList.size(); i++) {
                    if (test.orderList.get(i).getOderId().equals(orderId)) {
                        validId = true;
                        int currentStatus = test.orderList.get(i).getStatus();
        
                        if (currentStatus == test.DELIVERED) {
                            JOptionPane.showMessageDialog(null, "Cannot change status for delivered order.");
                        } else {
                            String[] options = {"DELIVERING", "DELIVERED"};
                            int choice = JOptionPane.showOptionDialog(null, "Select the new status:", "Change Order Status",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
                            if (choice != JOptionPane.CLOSED_OPTION) {
                                int newStatus = (choice == 0) ? test.DELIVERING : test.DELIVERED;
                                test.orderList.get(i).setStatus(newStatus);
                                JOptionPane.showMessageDialog(null, "Order status changed to " + (newStatus == test.DELIVERING ? "DELIVERING" : "DELIVERED"));
        
                                Component[] components = setDetaiPanel.getComponents();
                                for (Component component : components) {
                                    if (component instanceof JPanel) {
                                        JPanel detailPanel = (JPanel) component;
                                        if (detailPanel.getComponentCount() == 5) {
                                            JLabel showStatusLabel = (JLabel) detailPanel.getComponent(4);
                                            showStatusLabel.setText(newStatus == test.DELIVERING ? "DELIVERING" : "DELIVERED");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
        
                if (!validId) {
                    JOptionPane.showMessageDialog(null, "Invalid Order ID");
                    enterTextField.setText("");
                }
            }
        });
        
        
    
    }
}