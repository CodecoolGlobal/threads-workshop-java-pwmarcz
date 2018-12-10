import game.CoffeeGame;
import game.Order;

public class CoffeeShopTemplate {
    public static void main(String[] args) {
        CoffeeShopTemplate shop = new CoffeeShopTemplate();
        shop.run();
    }

    private CoffeeGame game = new CoffeeGame();

    public void run() {
        while (true) {
            Order order = game.takeOrder();

            // Don't make coffee yet
            // game.makeCoffee(order);

            // Don't make sandwich yet
            // game.makeSandwich(order);
        }
    }
}
