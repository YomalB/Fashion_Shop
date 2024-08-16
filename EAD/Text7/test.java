import java.util.*;

public class test {

    public static Scanner input = new Scanner(System.in);
    public static OrderList orderList = new OrderList();
   

	public static final double XS = 600;
	public static final double S = 800;
	public static final double M = 900;
	public static final double L = 1000;
	public static final double XL = 1100;
	public static final double XXL = 1200;
	
	public static final int PROCESSING = 0;
	public static final int DELIVERING = 1;
	public static final int DELIVERED = 2;
    public static void main(String args[]){
        new FashionShop().setVisible(true);
    }

    public static String genarateId() {
        if (orderList.size() > 0) {
            Orders lastOrder = orderList.get(orderList.size() - 1); 
            String lastOrderId = lastOrder.getOderId(); 
            int number = Integer.parseInt(lastOrderId.split("[#]")[1]) + 1;
            return String.format("ODR#%05d", number);
        } else {
            return "ODR#00001";
        }
    }
    public static boolean isValidUserName(String name) {
        for (int i = 0; i < orderList.size(); i++) {
            if (name.equals(orderList.get(i).getCustomerId())) {
                return false;
            }
        }
        return true;
    }
}
