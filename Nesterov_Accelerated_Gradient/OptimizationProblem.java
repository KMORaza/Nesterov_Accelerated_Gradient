package Nesterov_Accelerated_Gradient;
// Created: November 2022
public interface OptimizationProblem {
    double computeValue(double[] parameters);
    double[] computeGradient(double[] parameters);
    int getDimension();
}
