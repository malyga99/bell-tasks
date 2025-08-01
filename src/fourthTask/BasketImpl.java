package fourthTask;

import java.util.*;

public class BasketImpl implements Basket {

    private final Map<String, Integer> productsByQuantity = new HashMap<>();

    @Override
    public void addProduct(String product, int quantity) {
        productsByQuantity.put(product, productsByQuantity.getOrDefault(product, 0)  + quantity);
    }

    @Override
    public void removeProduct(String product) {
        checkProduct(product);

        productsByQuantity.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        checkProduct(product);

        productsByQuantity.put(product, quantity);
    }

    @Override
    public void clear() {
        productsByQuantity.clear();
    }

    @Override
    public List<String> getProducts() {
        List<String> products = new ArrayList<>();

        productsByQuantity.keySet()
                .forEach(products::add);

        return products;
    }

    @Override
    public int getProductQuantity(String product) {
        checkProduct(product);

        return productsByQuantity.get(product);
    }

    private void checkProduct(String product) {
        if (!productsByQuantity.containsKey(product)) {
            throw new NoSuchElementException("Продукт: " + product + " не найден");
        }
    }
}
