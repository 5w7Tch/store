package store;

import java.util.HashMap;

public class Cart {
    public static final String AMOUNT = "amount";
    private HashMap<String, Integer> cart;
    private Double total;
    public Cart(){
        cart = new HashMap<>();
        total = (double) 0;
    }
    public void addItem(Product item){
        Integer oldVal = 0;
        if(cart.containsKey(item.getID())){
            oldVal = cart.get(item.getID());
        }
        cart.remove(item.getID());
        cart.put(item.getID(), oldVal+1);
        total+=item.getPrice();
    }
    public void replaceItemAmount(Product item, int count){
        if(cart.containsKey(item.getID())){
            total-=cart.get(item.getID())*item.getPrice();

            if(count > 0){
                cart.replace(item.getID(), count);
                total+=item.getPrice()*count;
            }else{
                cart.replace(item.getID(), 0);
            }
        }
    }
    public double getTotalCost(){
        return total;
    }
    public HashMap<String, Integer> getCart(){
        return cart;
    }
}
