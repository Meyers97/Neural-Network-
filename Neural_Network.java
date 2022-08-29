public class Neural_Network 
{
    static double[][] inputs = {{0,1},{1,1}};  
    static double[] outputs = {0,1};
    static double[][][] hidden_weights = {{{0.62,0.55}, {0.42,-0.17}, {0.53,0.21}},{{0.62,0.55,-0.8}, {0.42,-0.17,0.34}, {0.53,0.21,-0.43}},{{0.62,0.55,-0.8}, {0.42,-0.17,0.34}, {0.53,0.21,-0.43}}}; 
    static double[] output_weights = {0.35,0.81,0.9};
    static double[] errors;
    static double learning_rate = 0.25;
    static int max_iteration = 100;
    static int iteration = 0;
    static int hidden_layers = 3;
    static int n_neurons = 5;


    public static void main(String[] args) throws Exception
    {        
        Forward_Propagation[] forward_training_set = new Forward_Propagation[inputs.length];
        Backward_Propagation[] backward_training_set = new Backward_Propagation[inputs.length];
        inputs = Initialise.Gen_Inputs(2);
        outputs = Initialise.Gen_Outputs(inputs, 4);
        for(int j = 0; j < hidden_layers; j++)
            hidden_weights[j] = Initialise.Gen_Hidden_Weights(n_neurons, false);
        output_weights = Initialise.Gen_Output_Weights(n_neurons);
        // Graph.run();

        System.out.println("Hello World");
        
        while(iteration < max_iteration)
        {
            Forward_Propagation clockwise_iterator = new Forward_Propagation();
            Backward_Propagation anticlockwise_iterator = new Backward_Propagation(); 

            errors = new double[inputs.length];
            for(int j = 0; j < inputs.length; j++)
            {
                clockwise_iterator.Multi_Hidden(inputs[j], hidden_layers);
                clockwise_iterator.Start_Output(inputs[j], output_weights);
                forward_training_set[j] = clockwise_iterator;

            
                anticlockwise_iterator.Start(outputs[j], learning_rate, inputs[j], forward_training_set[j]);
                backward_training_set[j] = anticlockwise_iterator;

                errors[j] = backward_training_set[j].error;
                

            }
            
            System.out.println(Analysis.MSE(errors));
            iteration++;
        }
      
    }     
}
