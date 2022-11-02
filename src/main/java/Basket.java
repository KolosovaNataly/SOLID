import java.util.Map;

public class Basket {
    protected Purchase[] purchases; // создаем объект корзины

    public Basket(int productsCount) {
        purchases = new Purchase[productsCount]; // принимает размеры корзины размер мапы с ассортиментом товаров из main.
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        } // метод добавления товаров в корзину переносим в класс Basket.
    }
    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += (long) purchase.count * prices.get(purchase.title);
        }
        return sum;
    } // метод печати содержимого корзины переносим в класс Basket.
}

