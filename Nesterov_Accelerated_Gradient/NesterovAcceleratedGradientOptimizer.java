package Nesterov_Accelerated_Gradient;
// Created: November 2022
public class NesterovAcceleratedGradientOptimizer {
    private OptimizationProblem problem;
    private double learningRate;
    private double momentumFactor;
    private int maxIterations;
    private double tolerance;
    public NesterovAcceleratedGradientOptimizer(OptimizationProblem problem, double learningRate,
                                                double momentumFactor, int maxIterations, double tolerance) {
        this.problem = problem;
        this.learningRate = learningRate;
        this.momentumFactor = momentumFactor;
        this.maxIterations = maxIterations;
        this.tolerance = tolerance;
    }
    public OptimizationResult optimize() {
        int dimension = problem.getDimension();
        double[] parameters = new double[dimension];
        double[] velocity = new double[dimension];
        double[] prevVelocity = new double[dimension];
        double[] gradient = new double[dimension];
        int iteration = 0;
        double prevValue = problem.computeValue(parameters);
        boolean converged = false;
        while (iteration < maxIterations && !converged) {
            for (int i = 0; i < dimension; i++) {
                velocity[i] = momentumFactor * prevVelocity[i] - learningRate * problem.computeGradient(parameters)[i];
            }
            for (int i = 0; i < dimension; i++) {
                parameters[i] += -momentumFactor * prevVelocity[i] + (1 + momentumFactor) * velocity[i];
            }
            gradient = problem.computeGradient(parameters);
            for (int i = 0; i < dimension; i++) {
                prevVelocity[i] = velocity[i];
            }
            double value = problem.computeValue(parameters);
            if (Math.abs(value - prevValue) < tolerance) {
                converged = true;
            }
            prevValue = value;
            iteration++;
        }
        return new OptimizationResult(parameters, prevValue, converged, iteration);
    }
}