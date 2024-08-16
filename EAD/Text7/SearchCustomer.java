import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class SearchCustomer extends JFrame{
    private JButton backButton;
    SearchCustomer(){
        setSize(600, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Search Customer");
        setLocationRelativeTo(null);

        //-------------- back button -----------------

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

        // -------------------- get id ---------------------
        JPanel getIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel enterIdLabel = new JLabel("Enter Customer ID :     ");
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

        add(getIdPanel);

        //------------- check id ----------------

        getIdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String customerId = enterTextField.getText();

                if (!test.isValidUserName(customerId)) {
                    for (Component component : getIdPanel.getComponents()) {
                        if (component instanceof JScrollPane || component instanceof JLabel) {
                            getIdPanel.remove(component);
                        }
                    }

                    String[] columnNames = { "Size", "Qty", "Amount" };
                    DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
                    JTable customerDetailsTable = new JTable(dtm);

                    double totalAmount = 0.0;
                    for (int i = 0; i < test.orderList.size(); i++) {
                        if (test.orderList.get(i).getCustomerId().equals(customerId)) {
                            Object[] rowData = { test.orderList.get(i).getSize(), test.orderList.get(i).getQty(),
                                    test.orderList.get(i).getAmount() };
                            dtm.addRow(rowData);
                            totalAmount += test.orderList.get(i).getAmount();
                        }
                    }

                    JLabel totalAmountLabel = new JLabel("Total Amount:                        "+ totalAmount);

                    JPanel tableAndTotalPanel = new JPanel(new GridBagLayout());

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.gridwidth = 1;
                    gbc.gridheight = 1;
                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.weightx = 1.0;
                    gbc.weighty = 1.0;
                    tableAndTotalPanel.add(new JScrollPane(customerDetailsTable), gbc);

                    gbc.gridy = 1;
                    gbc.weighty = 0.0;
                    tableAndTotalPanel.add(totalAmountLabel, gbc);

                    getIdPanel.add(tableAndTotalPanel);

                    getIdPanel.revalidate();
                } else {
                    new WrongNumber().setVisible(true);
                    enterTextField.setText("");
                }
            }
        });    

    }
}

