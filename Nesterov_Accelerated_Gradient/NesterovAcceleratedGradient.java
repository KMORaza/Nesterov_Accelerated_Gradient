package Nesterov_Accelerated_Gradient;
// Created: November 2022
public class NesterovAcceleratedGradient {
    public static void main(String[] args) {
        OptimizationProblem problem = new TestFunction();
        double learningRate = 0.01;
        double momentumFactor = 0.9;
        int maxIterations = 1000;
        double tolerance = 1e-6;
        NesterovAcceleratedGradientOptimizer optimizer = new NesterovAcceleratedGradientOptimizer(
                problem, learningRate, momentumFactor, maxIterations, tolerance
        );
        OptimizationResult result = optimizer.optimize();
        System.out.println("Optimal solution: [" + result.getOptimalSolution()[0] + "]");
        System.out.println("Optimal value: " + result.getOptimalValue());
        System.out.println("Converged: " + result.hasConverged());
        System.out.println("Number of iterations: " + result.getIterations());
    }
}

