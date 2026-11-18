package org.yourcompany.yourproject;

public interface IProduct {
    int GetTotalProductsSold();
    double GetAverageProductSold();
    String GetMostPopularProduct();

    int calculateTotal(int[][] data);
    double calculateAverage(int[][] data);
    int findMaximum(int[][] data);
}
