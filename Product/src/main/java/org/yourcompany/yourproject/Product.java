package org.yourcompany.yourproject;

public class Product implements IProduct {
    private final String[] productNames;
    private final int[][] salesData;

    public Product(String[] productNames, int[][] salesData) {
        this.productNames = productNames;
        this.salesData = salesData;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] productSales : salesData) {
            for (int sales : productSales) {
                total += sales;
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = 0;
        for (int[] productSales : salesData) {
            count += productSales.length;
        }
        return (count == 0) ? 0 : (double) total / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxSales = -1;
        int maxIndex = 0;

        for (int i = 0; i < salesData.length; i++) {
            int productTotal = 0;
            for (int sales : salesData[i]) {
                productTotal += sales;
            }
            if (productTotal > maxSales) {
                maxSales = productTotal;
                maxIndex = i;
            }
        }
        return productNames[maxIndex] + " (" + maxSales + ")";
    }

    @Override
    public int calculateTotal(int[][] data) {
        int total = 0;
        for (int[] row : data) {
            for (int value : row) {
                total += value;
            }
        }
        return total;
    }

    @Override
    public double calculateAverage(int[][] data) {
        int total = calculateTotal(data);
        int count = 0;
        for (int[] row : data) {
            count += row.length;
        }
        return count == 0 ? 0 : (double) total / count;
    }

    @Override
    public int findMaximum(int[][] data) {
        int maximum = 0;
        for (int[] row : data) {
            for (int value : row) {
                maximum = Math.max(maximum, value);
            }
        }
        return maximum;
    }
}