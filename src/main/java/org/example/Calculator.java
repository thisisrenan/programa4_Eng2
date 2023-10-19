package org.example;

public class Calculator {

        public double[] averageSizePerItem(double[] quant, double[] meth) {
                if (quant.length != meth.length) {
                        return null;
                }
                double[] average = new double[quant.length];

                for (int i = 0; i < quant.length; i++) {
                        average[i] = Math.log(quant[i] / meth[i]);
                }

                return average;
        }

        public double[] averageSizePerItem(double[] quant) {
                double[] average = new double[quant.length];

                for (int i = 0; i < quant.length; i++) {
                        average[i] = Math.log(quant[i]);
                }

                return average;
        }

        public double average(double[] logs) {
                double sum = 0;
                for (int i = 0; i < logs.length; i++) {
                        sum += logs[i];
                }
                return (sum / logs.length);
        }

        public double variance(double[] logs, double average) {
                double sum = 0;
                for (int i = 0; i < logs.length; i++) {
                        sum += Math.pow(logs[i] - average, 2);
                }
                return (sum / (logs.length - 1));
        }

        public double standardDeviation(double variance) {
                return Math.sqrt(variance);
        }

        public double[] tracks(double average, double standardDeviation) {
                double[] tracksLog = new double[5];
                tracksLog[0] = average - (2 * standardDeviation);
                tracksLog[1] = average - (standardDeviation);
                tracksLog[2] = average;
                tracksLog[3] = average + (standardDeviation);
                tracksLog[4] = average + (2 * standardDeviation);

                return  tracksLog;
        }

        public double[] logarithmForOriginal(double[] tracksLog) {
                double[] tracks = new double[5];

                for (int i = 0; i < tracksLog.length; i++) {
                        tracks[i] = Math.exp(tracksLog[i]);
                }

                return  tracks;
        }

}
