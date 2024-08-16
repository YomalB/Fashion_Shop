class OrderList{
    Node top;

    private boolean isFull(){
        return top==null;
    }

    public void add(Orders orders){
        Node n1= new Node(orders);
        if(isFull()){
            top = n1;
        }else{
            Node temp = top;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = n1;
        }
    }
    public void prntList(){
        System.out.print("[");
        Node temp = top;
        while(temp != null){
            System.out.print(temp.orders+", ");
            temp = temp.next;
        }
        System.out.println(isFull() ? "Empty]" : "\b\b]");
    }
    public Orders get(int index){
        Node temp= top;
        int count=0;
        while(count++ < index){
            temp = temp.next;
        }
        return temp.orders;
    }
    public Orders remove(int index) {
        if (index == 0) {
            Orders removedOrder = top.orders;
            top = top.next;
            return removedOrder;
        }
    
        Node temp = top;
        int count = 0;
        while (temp != null && count++ < index - 1) {
            temp = temp.next;
        }
    
        if (temp != null && temp.next != null) {
            Orders removedOrder = temp.next.orders;
            temp.next = temp.next.next;
            return removedOrder;
        }
    
        return null;
    }
    public void add(int index, Orders orders){
        Node n1 = new Node(orders);
        int count = 0;
        if(index ==0){
            n1.next = top;
            top = n1;
        }else{
            Node temp = top;
            while(count++ < index-1){
            temp=temp.next;
        }
        n1.next = temp.next;
        temp.next = n1;
        }
    }
    public int search(Orders orders){
        Node temp = top;
        int count =0;
        while(temp !=null){
            if(temp.orders.getOderId() == orders.getOderId()){
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }
    public Orders remove(Orders orders){
        Node temp = top;
        while(temp.next!= null){
            if(temp.orders.getOderId() == orders.getOderId()){
                Orders removeOder = temp.next.orders;
                temp.next = temp.next.next;
                return removeOder;
            }
            temp = temp.next;
        }
        return null;
    }
    public int size() {
        int count = 0;
        Node temp = top;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    class Node{
        Orders orders;
        Node next;

        Node(Orders orders){
        this.orders = orders;
        }
    }
}