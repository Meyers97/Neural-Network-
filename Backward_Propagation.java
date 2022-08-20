public class Backward_Propagation 
{
    double[] output_weight_change = new double[Neural_Network.output_weights.length];
    double[][] hidden_weight_change = new double[Neural_Network.hidden_weights.length][Neural_Network.hidden_weights[0].length];
    double error;
        
    public void Start(double target_output, double actual_output, double learning_rate, double[] hidden_input, double[] hidden_output)
    {
        error = Analysis.Error(actual_output, target_output);
        output_weight_change = Matrix_Arithmetic.Update_Output_Weights(learning_rate, Neural_Network.output_weights, hidden_output, actual_output, error);
        hidden_weight_change = Matrix_Arithmetic.Update_Hidden_Weights(learning_rate, Neural_Network.hidden_weights, hidden_input, hidden_output, error);

        Neural_Network.output_weights = Matrix_Arithmetic.Matrix_Addition_1D(Neural_Network.output_weights, output_weight_change);
        Neural_Network.hidden_weights = Matrix_Arithmetic.Matrix_Addition_2D(Neural_Network.hidden_weights, hidden_weight_change);
        
    }    
}
