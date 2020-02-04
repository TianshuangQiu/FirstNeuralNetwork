/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstneuralnetwork;

import java.util.ArrayList;

/**
 *
 * @author Ethan
 */
public class Neuron {

    private final double e = Math.E;
    private double weight;//the weight for the next neuron
    private double bias;
    private double buffer;//linear combination of all previous entries & their weights
    private double value; //the output
    private ArrayList<double[]> weightInput = new ArrayList<>();
    private int location;

    public Neuron() {
        weight = bias = buffer = value = Math.random();
    }

    public Neuron(int i) {
        weight = bias = buffer = value = Math.random();
        location = i;
    }

    public double sigmoid(double x) {
        return Math.pow(e, x) / (Math.pow(e, x + 1));
    }

    public void feedIn(double newWeight, double newValue, int place) {
        double[] temp = new double[]{newWeight, newValue};
        weightInput.add(place, temp);
        //System.out.println("adding " + this.toString() + " to " + place);
    }

    public void computeLinearCombination() {
        buffer = 0;
        for (double[] row : weightInput)
            buffer += row[0] * row[1];
    }

    public void computeFinalOutput() {
        value = sigmoid(buffer + bias);
    }

    public double getFinalOutput() {
        return value;
    }

    public void setWeight(double w) {
        weight = w;
    }

    public double getWeight() {
        return weight;
    }

    public void setIndex(int i) {
        location = i;
    }

    public int getIndex() {
        return location;
    }

    @Override
    public String toString() {
        return ("Neuron at " + location);
    }

}
