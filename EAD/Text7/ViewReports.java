import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewReports extends JFrame{
    private JButton backButton;
    ViewReports(FashionShop fashionShop){
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("View Reports");
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
                fashionShop.setVisible(true);
                setVisible(false);
			}
		});

        JPanel maiPanel = new JPanel(new GridLayout(1,3));

        JPanel firstPanel = new JPanel(new GridLayout(3,1,400,20));

        JButton viewCustomersButton = new JButton("View Customers");
        viewCustomersButton.setBackground(Color.GREEN);
        viewCustomersButton.setForeground(Color.WHITE);
        viewCustomersButton.setOpaque(true);
        viewCustomersButton.setPreferredSize(new Dimension(160, 40));
        viewCustomersButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        firstPanel.add(viewCustomersButton);

        JButton bestInCustomersButton = new JButton("Best In Customers");
        bestInCustomersButton.setBackground(Color.GREEN);
        bestInCustomersButton.setForeground(Color.WHITE);
        bestInCustomersButton.setOpaque(true);
        bestInCustomersButton.setPreferredSize(new Dimension(160, 40));
        bestInCustomersButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        firstPanel.add(bestInCustomersButton);

        JButton allCustomersButton = new JButton("All Customers");
        allCustomersButton.setBackground(Color.GREEN);
        allCustomersButton.setForeground(Color.WHITE);
        allCustomersButton.setOpaque(true);
        allCustomersButton.setPreferredSize(new Dimension(160, 40));
        allCustomersButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        firstPanel.add(allCustomersButton);

        maiPanel.add(firstPanel);

        JPanel secondPanel = new JPanel(new GridLayout(2,1,400,20));

        JButton byCaregoryButton = new JButton("Categorized By QTY");
        byCaregoryButton.setBackground(Color.BLUE);
        byCaregoryButton.setForeground(Color.WHITE);
        byCaregoryButton.setOpaque(true);
        byCaregoryButton.setPreferredSize(new Dimension(160, 40));
        byCaregoryButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        secondPanel.add(byCaregoryButton);

        JButton byAmountButton = new JButton("Categorized By Amount");
        byAmountButton.setBackground(Color.BLUE);
        byAmountButton.setForeground(Color.WHITE);
        byAmountButton.setOpaque(true);
        byAmountButton.setPreferredSize(new Dimension(160, 40));
        byAmountButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        secondPanel.add(byAmountButton);

        maiPanel.add(secondPanel);

        JPanel thirdPanel  = new JPanel(new GridLayout(2,1,400,20));

        JButton OrdersbyAmountButton = new JButton("Orders By Amount");
        OrdersbyAmountButton.setBackground(Color.GRAY);
        OrdersbyAmountButton.setForeground(Color.WHITE);
        OrdersbyAmountButton.setOpaque(true);
        OrdersbyAmountButton.setPreferredSize(new Dimension(160, 40));
        OrdersbyAmountButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        thirdPanel.add(OrdersbyAmountButton);

        JButton allOrdersButton = new JButton("All Orders");
        allOrdersButton.setBackground(Color.GRAY);
        allOrdersButton.setForeground(Color.WHITE);
        allOrdersButton.setOpaque(true);
        allOrdersButton.setPreferredSize(new Dimension(160, 40));
        allOrdersButton.setFont(new Font("Helvetica Neue", Font.BOLD,15));
        thirdPanel.add(allOrdersButton);

        maiPanel.add(thirdPanel);

        firstPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 30, 10));
        firstPanel.setPreferredSize(new Dimension(160, 40));
        secondPanel.setBorder(BorderFactory.createEmptyBorder(80, 20, 70, 10));
        secondPanel.setPreferredSize(new Dimension(160, 40));
        thirdPanel.setBorder(BorderFactory.createEmptyBorder(80, 20, 70, 10));
        thirdPanel.setPreferredSize(new Dimension(160, 40));

        add("Center",maiPanel);

        bestInCustomersButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				BestInCustomer bestInCustomerWindow = new BestInCustomer(ViewReports.this);
                bestInCustomerWindow.setVisible(true); 
                setVisible(false);
			}
		});

        viewCustomersButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewCustomer viewCustomerWindow = new ViewCustomer(ViewReports.this);
                viewCustomerWindow.setVisible(true); 
                setVisible(false);
			}
		});

        allCustomersButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AllCustomer allCustomerWindow = new AllCustomer(ViewReports.this);
                allCustomerWindow.setVisible(true); 
                setVisible(false);
			}
		});

        byCaregoryButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ByCategory ByCategoryWindow = new ByCategory(ViewReports.this);
                ByCategoryWindow.setVisible(true); 
                setVisible(false);
			}
		});

        byAmountButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ByAmount ByAmountWindow = new ByAmount(ViewReports.this);
                ByAmountWindow.setVisible(true); 
                setVisible(false);
			}
		});

        allOrdersButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AllOrders allOrdersWindow = new AllOrders(ViewReports.this);
                allOrdersWindow.setVisible(true); 
                setVisible(false);
			}
		});

        OrdersbyAmountButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				OrdersByAmount ordersByAmountWindow = new OrdersByAmount(ViewReports.this);
                ordersByAmountWindow.setVisible(true); 
                setVisible(false);
			}
		});



    }
}
