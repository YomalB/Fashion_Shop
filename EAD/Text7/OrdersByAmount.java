import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class OrdersByAmount extends JFrame{
    private JButton backButton;
    private JTable customerDetailsTable;
	private DefaultTableModel dtm;
    OrdersByAmount(ViewReports viewReports){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Orders By amount ");
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
        int[] orderIndices = new int[orderCount];
    
        for (int i = 0; i < orderCount; i++) {
            orderIndices[i] = i;
        }
    
        for (int i = 0; i < orderIndices.length - 1; i++) {
            for (int j = i + 1; j < orderIndices.length; j++) {
                Orders order1 = test.orderList.get(orderIndices[i]);
                Orders order2 = test.orderList.get(orderIndices[j]);
    
                if (order2.getAmount() > order1.getAmount()) {
                    int temp = orderIndices[i];
                    orderIndices[i] = orderIndices[j];
                    orderIndices[j] = temp;
                }
            }
        }
    
        for (int i = 0; i < orderIndices.length; i++) {
            int index = orderIndices[i];
            Orders order = test.orderList.get(index);
            Object[] rowData = {order.getOderId(), order.getCustomerId(), order.getSize(), order.getQty(), order.getAmount(), order.orderStatus()};
            dtm.addRow(rowData);
        }
    }
}
