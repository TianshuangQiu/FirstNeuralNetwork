/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstneuralnetwork;

/**
 *
 * @author Ethan
 */
public class Link {

    public static void connectNeuron(Neuron sender, Neuron receiver) {
        int index = sender.getIndex();
        receiver.feedIn(sender.getWeight(), sender.getFinalOutput(), index);
        //System.out.println("taking in " + sender.getFinalOutput());
    }
}
