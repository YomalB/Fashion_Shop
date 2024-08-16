import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class AllOrders extends JFrame{
    private JButton backButton;
     private JTable customerDetailsTable;
	private DefaultTableModel dtm;
    AllOrders(ViewReports viewReports){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("All Orders");
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

        String columnName[] = {"Order Id", "Customer Id", "Size", "QTY", "Amount", "Status"};
        dtm = new DefaultTableModel(columnName, 0);
        customerDetailsTable = new JTable(dtm);

        JScrollPane tablePane = new JScrollPane(customerDetailsTable);
        add("Center", tablePane);

        int orderCount = test.orderList.size();
    
        for (int i = 0; i < orderCount; i++) {
            Orders order = test.orderList.get(i);
            Object[] rowData = {order.getOderId(), order.getCustomerId(), order.getSize(), order.getQty(), order.getAmount(), order.orderStatus()};
            dtm.addRow(rowData);
        }
    }
}
