import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class AllCustomer extends JFrame {
    private JButton backButton;
    private JTable customerDetailsTable;
    private DefaultTableModel dtm;

    AllCustomer(ViewReports viewReports) {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Best In Customers");
        setLocationRelativeTo(null);

        JPanel backJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButton = new JButton("Back");
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setPreferredSize(new Dimension(90, 40));
        backButton.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        backJPanel.add(backButton);
        backJPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        add("North", backJPanel);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewReports.setVisible(true);
                setVisible(false);
            }
        });

        String columnName[] = {"Customer ID", "XS", "S", "M", "L", "XL", "XXL", "Total Amount"};
        dtm = new DefaultTableModel(columnName, 0);
        customerDetailsTable = new JTable(dtm);

        JScrollPane tablePane = new JScrollPane(customerDetailsTable);
        add("Center", tablePane);

        String[] processedCustomers = new String[test.orderList.size()]; 
        int processedCount = 0; 

        for (int i = 0; i < test.orderList.size(); i++) {
            String customerId = test.orderList.get(i).getCustomerId();

            boolean isProcessed = false;
            for (int j = 0; j < processedCount; j++) {
                if (customerId.equals(processedCustomers[j])) {
                    isProcessed = true;
                    break;
                }
            }

            if (isProcessed) {
                continue;
            }

            double customerTotal = 0.0;
            int xs = 0;
            int s = 0;
            int m = 0;
            int l = 0;
            int xl = 0;
            int xxl = 0;

            for (int j = i; j < test.orderList.size(); j++) {
                if (customerId.equals(test.orderList.get(j).getCustomerId())) {
                    double orderAmount = test.orderList.get(j).getQty() * test.orderList.get(j).getAmount();
                    customerTotal += orderAmount;

                    String size = test.orderList.get(j).getSize().toLowerCase();
                    switch (size) {
                        case "xs":
                            xs += test.orderList.get(j).getQty();
                            break;
                        case "s":
                            s += test.orderList.get(j).getQty();
                            break;
                        case "m":
                            m += test.orderList.get(j).getQty();
                            break;
                        case "l":
                            l += test.orderList.get(j).getQty();
                            break;
                        case "xl":
                            xl += test.orderList.get(j).getQty();
                            break;
                        case "xxl":
                            xxl += test.orderList.get(j).getQty();
                            break;
                    }
                }
            }

            processedCustomers[processedCount] = customerId;
            processedCount++;

            Object[] rowData = {customerId, xs, s, m, l, xl, xxl, customerTotal};
            dtm.addRow(rowData);
        }
    }
}
