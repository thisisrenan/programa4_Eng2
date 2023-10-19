package org.example;

public class Main {
        public static void main(String[] args) {
                double[] tamanhosPag = {7.0, 12.0, 10.0, 12.0, 10.0, 12.0, 12.0, 12.0, 12.0, 8.0, 8.0, 8.0, 20.0, 14.0, 18.0, 12.0};


                Calculator calculadora = new Calculator();

                double[] averageItem = calculadora.averageSizePerItem(tamanhosPag);
                double average = calculadora.average(averageItem);
                double variance = calculadora.variance(averageItem, average);
                double deviation = calculadora.standardDeviation(variance);
                double[] trackslogs = calculadora.tracks(average, deviation);

                double[] res = calculadora.logarithmForOriginal(trackslogs);
                for (int i = 0; i < res.length; i++) {
                        System.out.println(res[i]);
                }

        }
}
