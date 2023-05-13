class Driver{
    public static void main(String[] args) {
        SalesPerson[] salesPeople = new SalesPerson[6];

        salesPeople[0] = new SalesPerson("100");
        salesPeople[1] = new SalesPerson("101");
        salesPeople[2] = new SalesPerson("102");

        salesPeople[0].setSalesHistory(new Sales("A100", 300.00, 10));
        salesPeople[0].setSalesHistory(new Sales("A200", 1000.00, 2));
        salesPeople[1].setSalesHistory(new Sales("A300", 2550.40, 10));

        System.out.println(salesPeople[2].getId());
        System.out.println(salesPeople[0].getCount());
        System.out.println(salesPeople[1].getSalesHistory()[0].getValue());
        System.out.println(salesPeople[0].calcTotalSales());

        
    }
}

class Sales{
    private String itemId; //id of the item
    private int quantity; //quantity of the item
    private double value;// values of item

    public Sales(String itemId, double value, int quantity){
        this.itemId=itemId;
        this.value=value;
        this.quantity=quantity;
    }

    public double getValue(){
        return value;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getitemId(){
        return itemId;
    }

    public double getTotal(){
        return value*quantity;
    }
}


class SalesPerson{
    private String id;
    private Sales[] salesHistory;
    private int count=0;
    public SalesPerson(String id) {
        this.id = id;
        salesHistory = new Sales[100];
    }
    
    public SalesPerson(String id, Sales[] s, int c) {
        this.id = id;
        this.salesHistory = s;
        this.count = c;
    }

    public Sales[] getSalesHistory(){
        return salesHistory;
    }
    public int getCount(){
        return count;
    }

    public void setSalesHistory(Sales s){
        salesHistory[count]=s;
        count++;
    }
    public String getId(){
        return id;
    }

    public double calcTotalSales() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total = total + salesHistory[i].getTotal();
        }
        return total;
    }

    Sales largestSale(){
        Sales ls= salesHistory[0];
        for(Sales salesvaluSales: salesHistory){
            if(salesvaluSales.getTotal()>ls.getTotal()){
                ls=salesvaluSales;
            }
    }
    return ls;
}
}
