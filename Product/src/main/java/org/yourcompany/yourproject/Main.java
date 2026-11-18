package org.yourcompany.yourproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] products = {
                "Cozy Nights Monarch mattress",
                "Restonic Barbados mattress",
                "Sealy Phuket mattress"
            };

            int[][] sales = new int[3][3];

            for (int i = 0; i < products.length; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + ": ");
                    sales[i][j] = scanner.nextInt();
                }
            }

            System.out.println("\n");

            Product productManager = new Product(products, sales);
            PrintProduct printer = new PrintProduct(productManager);

            printer.printReport();
        }
    }
}