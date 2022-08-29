public class Backward_Propagation 
{
    double[] output_weight_change = new double[Neural_Network.output_weights.length];
    double[][][] hidden_weight_change = new double[Neural_Network.hidden_weights.length][Neural_Network.hidden_weights[0].length][Neural_Network.hidden_weights[0][0].length];
    double error;
        
    public void Start(double target_output, double learning_rate, double[] hidden_input, Forward_Propagation run)
    {
        error = Analysis.Error(run.final_output, target_output);

        output_weight_change = Matrix_Arithmetic.Update_Output_Weights(learning_rate, Neural_Network.output_weights, run.hidden_output[run.hidden_output.length-1], run.final_output, error);
        Neural_Network.output_weights = Matrix_Arithmetic.Matrix_Addition_1D(Neural_Network.output_weights, output_weight_change);
        
        
        for(int j = 0; j < Neural_Network.hidden_layers; j++)
           hidden_weight_change[j] = Matrix_Arithmetic.Update_Hidden_Weights(learning_rate, Neural_Network.hidden_weights[j], run.hidden_output[j], run.hidden_output[j+1], error);
        
        for(int j = 0; j < Neural_Network.hidden_layers; j++)
            Neural_Network.hidden_weights[j] = Matrix_Arithmetic.Matrix_Addition_2D(Neural_Network.hidden_weights[j], hidden_weight_change[j]);
        
    }    
}
