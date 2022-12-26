package orders;

import products.ProductsGroup;

public class Order {

    private int id;
    ProductsGroup productsGroup;

    public Order(int id, ProductsGroup productsGroup) {
        this.id = id;
        this.productsGroup = productsGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Заказ №" + id +
                ", сумма заказа - " + productsGroup.sumOfProducts() +
                ", количество позиций - " + productsGroup.productList.size();
    }

    public void displayOrder() {
        System.out.println("Вы заказали:");
        productsGroup.display();
        System.out.println(toString());
    }
}
