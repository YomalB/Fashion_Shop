public class Orders {
    private String orderId;
	private String customerId;
	private String size;
	private int qty;
	private int status;
	private double amount;
	
	Orders(){
    }

    Orders(String orderId, String customerId, String size, int qty,double amount){
		this.orderId = orderId;
		this.customerId = customerId;
		this.size = size;
		this.qty = qty;
		this.amount = amount;
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	
	public void setCustomerId(String customerId){
		this.customerId = customerId;
	}
	
	public void setSize(String size){
		this.size = size;
	}
	
	public void setQty(int qty){
		this.qty = qty;
	}
	
	public void setStatus(int status){

		this.status = status;
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	public String getOderId(){
		return orderId;
	}
	
	public String getCustomerId(){
		return customerId;
	}
	
	public String getSize(){
		return size;
	}
	
	public int getQty(){
		return qty;
	}
	
	public int getStatus(){
		return status;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public String orderStatus(){
		switch(status){
			case 0 : return "PROCESSING";
			case 1 : return "DELIVERING";
			case 2 : return "DELIVERED";
			default : return null;
		}
	}
	
	public String toString(){
		return "{orderId="+orderId+", customerId="+customerId+", size="+size+", qty="+qty+", amount="+amount+", status="+orderStatus()+"}";
	}
}
