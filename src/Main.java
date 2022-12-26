import orders.ConsoleSaveOrder;
import orders.Order;
import orders.RushOrder;
import orders.SaveOrder;
import products.AdderRemoverProduct;
import products.Product;
import products.ProductsGroup;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductsGroup warehouse = new ProductsGroup();
        ProductsGroup basket = new ProductsGroup();
        AdderRemoverProduct adder;
        SaveOrder saveOrder = new ConsoleSaveOrder();
        int idOrder = 1;
        warehouse.addProduct(new Product("Cheese", "Food", 890), 100);
        warehouse.addProduct(new Product("Bread", "Food", 90), 200);
        warehouse.addProduct(new Product("Bread", "Food", 50), 100);
        warehouse.addProduct(new Product("Spoon", "Not food", 120), 500);

        warehouse.addProduct(new Product("Ham", "Food", 550), 10);
        warehouse.removeProduct(new Product("Ham", "Food", 550), 9);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Здравствуйте! Что бы вы хотели сделать (для выхода введите \"end\" ):");
            System.out.println("1. Купить товары");
            System.out.println("2. Вернуть товар");
            System.out.println("3. Сделать заказ");
            System.out.println("4. Показать все продовольственные товары");
            System.out.println("5. Показать все непродовольственные товары");

            String inputString = scanner.nextLine();
            if (inputString.equals("end")) {
                break;
            }
            switch (inputString) {
                case ("1"):
                    adder = new AdderRemoverProduct(warehouse, basket);
                    adder.adding();
                    break;
                case ("2"):
                    System.out.println("Выберите товары для возврата:");
                    adder = new AdderRemoverProduct(basket, warehouse);
                    adder.refund();
                    break;
                case ("3"):
                    System.out.println("В корзине:");
                    basket.display();
                    System.out.println("Для срочного заказа введите 1, для обычного 2:");
                    inputString = scanner.nextLine();
                    Order order;
                    if (Integer.parseInt(inputString) == 1) {
                        idOrder++;
                        order = new RushOrder(idOrder, basket, "27.12.2022");

                    } else {
                        idOrder++;
                        order = new Order(idOrder, basket);
                    }
                    order.displayOrder();
                    saveOrder.save(order);
                    break;
                case ("4"):
                    System.out.println("Продовольственные товары:");
                    warehouse.filter("Food");
                    break;
                case ("5"):
                    System.out.println("Непродовольственные товары:");
                    warehouse.filter("Not food");
                    break;
            }


        }
    }
}







