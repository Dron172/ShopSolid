package orders;

import products.ProductsGroup;

public class RushOrder extends Order{ // Liskov substitution principle

    private String termExecution;

    public RushOrder(int id, ProductsGroup productList, String termExecution) {
        super(id, productList);
        this.termExecution = termExecution;
    }

    @Override
    public String toString() {
        return "Заказ №" + getId() +
                ", сумма заказа - " + productsGroup.sumOfProducts() +
                ", количество позиций - " + productsGroup.productList.size() +
                ", дата исполнения - " + termExecution;
    }
}
