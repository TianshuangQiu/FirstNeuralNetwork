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
public class FirstNeuralNetwork {

    /**
     * @param args the command line arguments
     */
    static Neuron[] firstLayer;
    static Neuron[] secondLayer;
    static Neuron[] thirdLayer;
    static Neuron[] finalLayer;

    public static void getResults() {
        for (Neuron n : finalLayer)
            System.out.println(n.getFinalOutput());
    }

    public static void runSimulation() {
        for (int j = 0; j < secondLayer.length; j++)
            for (int k = 0; k < firstLayer.length; k++)
                Link.connectNeuron(firstLayer[k], secondLayer[j]);
        for (int j = 0; j < thirdLayer.length; j++)
            for (int k = 0; k < secondLayer.length; k++)
                Link.connectNeuron(secondLayer[k], thirdLayer[j]);
        for (int j = 0; j < finalLayer.length; j++)
            for (int k = 0; k < thirdLayer.length; k++)
                Link.connectNeuron(thirdLayer[k], finalLayer[j]);
    }

    public static void initiateNeurons() {
        // initiating logic
        firstLayer = new Neuron[784];
        secondLayer = new Neuron[50];
        thirdLayer = new Neuron[20];
        finalLayer = new Neuron[10];
        //there has to be a better way to do this but
        for (int i = 0; i < firstLayer.length; i++)
            firstLayer[i] = new Neuron(i);
        for (int i = 0; i < secondLayer.length; i++)
            secondLayer[i] = new Neuron(i);
        for (int i = 0; i < thirdLayer.length; i++)
            thirdLayer[i] = new Neuron(i);
        for (int i = 0; i < finalLayer.length; i++)
            finalLayer[i] = new Neuron(i);

    }

    public static void main(String[] args) {
        initiateNeurons();
        //connecting neurons
        runSimulation();
        getResults();
    }

}
