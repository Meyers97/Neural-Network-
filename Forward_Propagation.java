public class Forward_Propagation
{
    double[] raw_value;
    double[][] hidden_output;
    double initial_output;
    double final_output;

    public void Multi_Hidden(double[] inputs, int hidden_layers)
    {
        hidden_output = new double[hidden_layers+1][];
        hidden_output[0] = inputs;

        for(int j = 0; j < hidden_layers; j++)
        {
            hidden_output[j+1] = Start_Hidden(hidden_output[j], Neural_Network.hidden_weights[j]);
            // if(Analysis.walk_through == true)
                // System.out.println("Layer: " + j+1);
        } 
    }

    public double[] Start_Hidden(double[] inputs, double[][] hidden_weights)
    {
        double[] result;

        raw_value = Matrix_Arithmetic.Matrix_Dot_2D(inputs, hidden_weights);
        result = Matrix_Arithmetic.Amplitude_Matrix_1D(raw_value);
        
        return result;
    }

    public double Start_Output(double[] inputs, double[] output_weights)
    {
        initial_output = Matrix_Arithmetic.Matrix_Dot_1D(hidden_output[hidden_output.length-1], output_weights);
        final_output = Activation_Function.Sigmoid(initial_output);

        return final_output;
    }
}
