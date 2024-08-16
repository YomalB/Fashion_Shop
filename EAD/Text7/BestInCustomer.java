import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class BestInCustomer extends JFrame{
    private JButton backButton;
    private JTable customerDetailsTable;
	private DefaultTableModel dtm;
    BestInCustomer(ViewReports viewReports){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("All Reports");
        setLocationRelativeTo(null);

        JPanel backJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButton  = new JButton("Back");
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setPreferredSize(new Dimension(90, 40));
        backButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        backJPanel.add(backButton);
        backJPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        add("North", backJPanel);

        backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
                viewReports.setVisible(true);
                setVisible(false);
			}
		});

        String columnName[]={"Customer Id","QTY","Amount"};
		dtm=new DefaultTableModel(columnName,0);
		customerDetailsTable=new JTable(dtm);
		
		JScrollPane tablePane=new JScrollPane(customerDetailsTable);
		add("Center",tablePane);

        for (int i = 0; i < test.orderList.size(); i++) {
            String customerId = test.orderList.get(i).getCustomerId();
            int qty = test.orderList.get(i).getQty();
            double amount = test.orderList.get(i).getAmount();
    
            int totalQty = qty;
            double totalAmount = amount;
    
            for (int j = i + 1; j < test.orderList.size(); j++) {
                if (customerId.equals(test.orderList.get(j).getCustomerId())) {
                    totalQty += test.orderList.get(j).getQty();
                    totalAmount += test.orderList.get(j).getAmount();
                }
            }
    
            Object[] rowData={customerId, totalQty, totalAmount};
            dtm.addRow(rowData);
           
            while (i + 1 < test.orderList.size() && customerId.equals(test.orderList.get(i + 1).getCustomerId())) {
                i++;
            }
        }

    }
}
