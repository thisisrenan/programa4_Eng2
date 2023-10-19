package org.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest extends TestCase {

        private Calculator calculadora;

        @Before
        public void setUp() {
                calculadora = new Calculator();
        }

        @Test
        public void testAverageSizePerItem() {
                double[] tamanhosLoc = {18.0, 18.0, 25.0, 31.0, 37.0, 82.0, 82.0, 87.0, 89.0, 230.0, 85.0, 87.0, 558.0};
                double[] quantidadeMetodos = {3, 3, 3, 3, 3, 5, 4, 4, 4, 10, 3, 3, 10};

                double[] resultados = {1.791759469228055, 1.791759469228055, 2.120263536200091, 2.3353749158170367, 2.512305623976115, 2.797281334830153, 3.0204248861443626, 3.079613757534693, 3.1023420086122493, 3.1354942159291497, 3.3440389678222067, 3.367295829986474, 4.021773869387265};

                double[] teste = calculadora.averageSizePerItem(tamanhosLoc, quantidadeMetodos);
                for (int i = 0; i < teste.length; i++) {
                        assertEquals(resultados[i], teste[i], 0.01);
                }
        }

        @Test
        public void testTestAverageSizePerItem() {
                double[] quantidades = {7, 12, 10, 12, 10, 12, 12, 12, 12, 8, 8, 8, 20, 14, 18, 12};

                double[] resultados = {1.9459101490553132, 2.4849066497880004, 2.302585092994046, 2.4849066497880004, 2.302585092994046, 2.4849066497880004, 2.4849066497880004, 2.4849066497880004, 2.4849066497880004, 2.0794415416798357, 2.0794415416798357, 2.0794415416798357, 2.995732273553991, 2.6390573296152584, 2.8903717578961645, 2.4849066497880004};
                double[] teste = calculadora.averageSizePerItem(quantidades);
                for (int i = 0; i < teste.length; i++) {
                        assertEquals(resultados[i], teste[i], 0.01);
                }
        }

        @Test
        public void testAverage() {
                double[] tamanhosLoc = {18.0, 18.0, 25.0, 31.0, 37.0, 82.0, 82.0, 87.0, 89.0, 230.0, 85.0, 87.0, 558.0};
                double[] quantidadeMetodos = {3, 3, 3, 3, 3, 5, 4, 4, 4, 10, 3, 3, 10};
                double[] averageSize = calculadora.averageSizePerItem(tamanhosLoc, quantidadeMetodos);
                assertEquals(2.80, calculadora.average(averageSize), 0.01);
        }

        @Test
        public void testVariance() {
                double[] tamanhosLoc = {18.0, 18.0, 25.0, 31.0, 37.0, 82.0, 82.0, 87.0, 89.0, 230.0, 85.0, 87.0, 558.0};
                double[] quantidadeMetodos = {3, 3, 3, 3, 3, 5, 4, 4, 4, 10, 3, 3, 10};
                double[] averageSize = calculadora.averageSizePerItem(tamanhosLoc, quantidadeMetodos);
                double average = calculadora.average(averageSize);
                assertEquals(0.43, calculadora.variance(averageSize, average), 0.01);
        }

        @Test
        public void testStandardDeviation() {
                assertEquals(0.65, calculadora.standardDeviation(0.43), 0.01);
        }

        @Test
        public void testTabelaPag() {
                double[] tamanhosPag = {7.0, 12.0, 10.0, 12.0, 10.0, 12.0, 12.0, 12.0, 12.0, 8.0, 8.0, 8.0, 20.0, 14.0, 18.0, 12.0};
                double[] averageItem = calculadora.averageSizePerItem(tamanhosPag);
                double average = calculadora.average(averageItem);
                double variance = calculadora.variance(averageItem, average);
                double deviation = calculadora.standardDeviation(variance);
                double[] trackslogs = calculadora.tracks(average, deviation);

                double[] res = calculadora.logarithmForOriginal(trackslogs);
                double[] resCerta = {6.3375, 8.4393, 11.2381, 14.9650, 19.9280};


                for (int i = 0; i < res.length; i++) {
                        assertEquals(resCerta[i], res[i], 0.01);
                }

        }

        @Test
        public void testTabelaLoc() {

                double[] tamanhosLoc = {18.0, 18.0, 25.0, 31.0, 37.0, 82.0, 82.0, 87.0, 89.0, 230.0, 85.0, 87.0, 558.0};
                double[] quantidadeMetodos = {3, 3, 3, 3, 3, 5, 4, 4, 4, 10, 3, 3, 10};
                double[] averageItem = calculadora.averageSizePerItem(tamanhosLoc, quantidadeMetodos);
                double average = calculadora.average(averageItem);
                double variance = calculadora.variance(averageItem, average);
                double deviation = calculadora.standardDeviation(variance);
                double[] trackslogs = calculadora.tracks(average, deviation);

                double[] res = calculadora.logarithmForOriginal(trackslogs);

                double[] resCerta = {4.3953, 8.5081, 16.4696, 31.8811, 61.7137};

                for (int i = 0; i < res.length; i++) {
                        assertEquals(resCerta[i], res[i], 0.01);
                }
        }
}
