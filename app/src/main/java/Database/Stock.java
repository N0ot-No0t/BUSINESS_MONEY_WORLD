package Database;

/**
 * Created by Adrian on 2018-05-01.
 */

public class Stock {

    private String stockName;
    private int stockPrice;

    public Stock(){}
    public Stock(String name, int price){
        this.stockName = name;
        this.stockPrice = price;
    }

    public void setName(String name){
        this.stockName = name;
    }
    public String getName(){
        return this.stockName;
    }
    public void setStockPrice(int price){
        this.stockPrice = price;
    }
    public int getStockPrice(){
        return this.stockPrice;
    }

}
