import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class FashionShop extends JFrame{
    private JLabel titJLabel;

    private JButton btnSearch;
    private JButton btnStatus;
    private JButton btnReports;
    private JButton btnDelete;

    private JButton btnPlaceOder;

    FashionShop(){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fashion Shop");
        setLocationRelativeTo(null);


        //------------------------------ main GUI --------------------------

        titJLabel = new JLabel("Fashion Shop");
        titJLabel.setFont(new Font("Helvetica Neue", Font.BOLD,35));
        titJLabel.setForeground(Color.WHITE);
        titJLabel.setBackground(Color.BLUE);
        titJLabel.setOpaque(true);
        titJLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North", titJLabel);

        JPanel btPanel = new JPanel(new GridLayout(4,1, 100,30));
        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Helvetica Neue", 0,15));
        btPanel.add(btnSearch);
        btnStatus = new JButton("Status");
        btnStatus.setFont(new Font("Helvetica Neue", 0,15));
        btPanel.add(btnStatus);
        btnReports = new JButton("Reports");
        btnReports.setFont(new Font("Helvetica Neue", 0,15));
        btPanel.add(btnReports);
        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Helvetica Neue", 0,15));
        btPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 15, 0));
        btPanel.setPreferredSize(new Dimension(200, 100));
        btPanel.add(btnDelete);

        add("West", btPanel);

        JPanel placeOderBtnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnPlaceOder  = new JButton("Place Oder");
        btnPlaceOder.setBackground(Color.CYAN);
        btnPlaceOder.setOpaque(true);
        btnPlaceOder.setPreferredSize(new Dimension(180, 60));
        btnPlaceOder.setFont(new Font("Helvetica Neue", Font.BOLD,25));
        placeOderBtnPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 15, 0));
        placeOderBtnPanel.add(btnPlaceOder);
        add("South",placeOderBtnPanel);

        JPanel picJPanel = new JPanel();
        JLabel picLabel = new JLabel(new ImageIcon ("fashion.png"));
        picJPanel.add(picLabel);
        add("Center",picJPanel);


        //------------------------------  button events ---------------------

        btnPlaceOder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				PlaceOder placeOrderWindow = new PlaceOder(FashionShop.this);
                placeOrderWindow.setVisible(true); 
                setVisible(false);
			}
		});

        btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchOption().setVisible(true);
                
			}
		});

        btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				DeleteOrder deleteOrderWindow = new DeleteOrder(FashionShop.this);
                deleteOrderWindow.setVisible(true); 
                setVisible(false);
			}
		});

        btnReports.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewReports viewRepotsWindow = new ViewReports(FashionShop.this);
                viewRepotsWindow.setVisible(true); 
                setVisible(false);
			}
		});

        btnStatus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				OrderStatus statusWindow = new OrderStatus(FashionShop.this);
                statusWindow.setVisible(true); 
                setVisible(false);
			}
		});

    }
}