public class Forward_Propagation
{
    double[] raw_value;
    double[] hidden_output;
    double initial_output;
    double final_output;

    public void Start(double[] inputs, double[][] hidden_weights, double[] output_weights)
    {
            raw_value = Matrix_Arithmetic.Matrix_Dot_2D(inputs, hidden_weights);
            hidden_output = Matrix_Arithmetic.Amplitude_Matrix_1D(raw_value);
            initial_output = Matrix_Arithmetic.Matrix_Dot_1D(hidden_output, output_weights);
            final_output = Activation_Function.Sigmoid(initial_output);

            System.out.print(final_output);
    }
}
