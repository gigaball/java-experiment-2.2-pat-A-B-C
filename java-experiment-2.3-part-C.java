import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class StreamProducts {
    static class Product {
        String name;
        double price;
        String category;

        Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        @Override
        public String toString() {
            return String.format("%-10s | Price: %.2f | Category: %s", name, price, category);
        }
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 85000, "Electronics"),
            new Product("Phone", 60000, "Electronics"),
            new Product("Tablet", 40000, "Electronics"),
            new Product("Shirt", 1500, "Clothing"),
            new Product("Jeans", 2500, "Clothing"),
            new Product("Blender", 3500, "Appliances"),
            new Product("Microwave", 6500, "Appliances")
        );

        System.out.println("Products Grouped by Category:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        grouped.forEach((cat, list) -> {
            System.out.println("\nCategory: " + cat);
            list.forEach(System.out::println);
        });

        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> maxByCategory = products.stream()
                .collect(Collectors.groupingBy(
                    p -> p.category,
                    Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        maxByCategory.forEach((cat, prod) ->
            System.out.println(cat + " -> " + prod.get().name + " (" + prod.get().price + ")")
        );

        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
