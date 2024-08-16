import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class ByCategory extends JFrame{
    private JButton backButton;
     private JTable customerDetailsTable;
    private DefaultTableModel dtm;
    ByCategory(ViewReports viewReports){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Best In Customers");
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



        String columnName[] = {"Size", "QTY", "Amount"};
        dtm = new DefaultTableModel(columnName, 0);
        customerDetailsTable = new JTable(dtm);

        JScrollPane tablePane = new JScrollPane(customerDetailsTable);
        add("Center", tablePane);

        String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};
        int[] sizeTotalQuantities = new int[sizes.length];
        double[] sizeTotalAmounts = new double[sizes.length];
    
        int orderCount = test.orderList.size();
    
        for (int i = 0; i < orderCount; i++) {
            Orders order = test.orderList.get(i);
            String size = order.getSize().toUpperCase();
            int sizeIndex = Arrays.asList(sizes).indexOf(size);
    
            if (sizeIndex != -1) {
                sizeTotalQuantities[sizeIndex] += order.getQty();
                sizeTotalAmounts[sizeIndex] += order.getQty() * order.getAmount();
            }
        }
    
        for (int i = 0; i < sizes.length - 1; i++) {
            for (int j = 0; j < sizes.length - i - 1; j++) {
                if (sizeTotalQuantities[j] < sizeTotalQuantities[j + 1]) {
                    int tempQuantity = sizeTotalQuantities[j];
                    sizeTotalQuantities[j] = sizeTotalQuantities[j + 1];
                    sizeTotalQuantities[j + 1] = tempQuantity;

                    double tempAmount = sizeTotalAmounts[j];
                    sizeTotalAmounts[j] = sizeTotalAmounts[j + 1];
                    sizeTotalAmounts[j + 1] = tempAmount;
    
                    String tempSize = sizes[j];
                    sizes[j] = sizes[j + 1];
                    sizes[j + 1] = tempSize;
                }
            }
        }
        for (int i = 0; i < sizes.length; i++) {
            Object[] rowData = {sizes[i], sizeTotalQuantities[i], sizeTotalAmounts[i]};
            dtm.addRow(rowData);}
    }
}
