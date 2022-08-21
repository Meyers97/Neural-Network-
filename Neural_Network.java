public class Neural_Network 
{
    static double[][] inputs = {{0,1},{1,1}};  
    static double[] outputs = {0,1};
    static double[][] hidden_weights = {{0.62, 0.42},{0.55,-0.17}};
    static double[] output_weights = {0.35,0.81};
    static double[] errors;
    static double learning_rate = 0.25;
    static int max_iteration = 1000;
    static int iteration = 0;
    static int hidden_layers = 2;

    public static void main(String[] args) throws Exception
    {        
        Forward_Propagation[][] forward_training_set = new Forward_Propagation[max_iteration][hidden_layers];
        Backward_Propagation[][] backward_training_set = new Backward_Propagation[max_iteration][hidden_layers];
        
        inputs = Initialise.Gen_Inputs(10);
        outputs = Initialise.Gen_Outputs(inputs, 4);

        System.out.println("Hello World");
        
        while(iteration < max_iteration)
        {
            Forward_Propagation clockwise_iterator = new Forward_Propagation();
            Backward_Propagation anticlockwise_iterator = new Backward_Propagation(); 

            errors = new double[inputs.length];
            for(int j = 0; j < inputs.length; j++)
            {
                for(int k = 0; k < hidden_layers; k++)
                {    
                    clockwise_iterator.Start(inputs[j], hidden_weights, output_weights);
                    forward_training_set[j][k] = clockwise_iterator;
                }

                for(int k = 0; k < hidden_layers; k++)
                {
                    anticlockwise_iterator.Start(outputs[j], forward_training_set[j][k].final_output, learning_rate, inputs[j], forward_training_set[j][k].hidden_output);
                    backward_training_set[j][k] = anticlockwise_iterator;
                }                    

                errors[j] = backward_training_set[j][hidden_layers-1].error;
            }
            
            if(iteration%10 == 0)
                System.out.println(Analysis.MSE(errors));
            iteration++;
        }
      
    }    
}
