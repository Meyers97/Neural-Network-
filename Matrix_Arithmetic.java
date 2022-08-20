
public class Matrix_Arithmetic
{
    
    public static double[] Amplitude_Matrix_1D(double[] weighted_inputs)
    {
        double[] init_inputs = weighted_inputs;

        for(int j = 0; j < init_inputs.length; j++)
        {
            init_inputs[j] =  Activation_Function.Sigmoid(init_inputs[j]);
            
        }

        return init_inputs; 
    }

    public static double[][] Amplitude_Matrix_2D(double[][] weighted_inputs)
    {
        double[][] init_inputs = weighted_inputs;

        for(int j = 0; j < init_inputs.length; j++)
        {
            for(int k = 0; k < init_inputs[j].length; k++)
            {
                init_inputs[j][k] = Activation_Function.Sigmoid(init_inputs[j][k]);
            }
        }

        return init_inputs;
    }

    public static double Matrix_Dot_1D(double[] input, double[] weight)
    {
        double result = 0; 

        for(int j = 0; j < input.length; j++)
        {
            result += input[j]*weight[j];
        }

        return result;
    }

    public static double[] Matrix_Dot_2D(double[] input, double[][] weights)
    {
        double[] result = new double[weights[0].length];
        
        for(int j = 0; j < weights[0].length; j++)
        {
            for(int k = 0; k < input.length; k++)
            {
                result[j] += weights[k][j]*input[k];
            }
        }
        return result;
    }

    public static double[][] Matrix_Multiplication(double[][] input, double[][] weights)
    {
        double[][] result = new double[input.length][weights[0].length];

        for(int j = 0; j < input.length; j++)
        {
            for(int k = 0; k < weights[0].length; k++)
            {
                for(int l = 0; l < input[0].length; l++)
                {
                    result[j][k] += input[j][l]*weights[l][k];
                }
            }
        }
        return result;
    }

    public static double[] Matrix_Addition_1D(double[] input_1, double[] input_2)
    {
        double[] result = new double[input_1.length];

        for(int j = 0; j < input_1.length; j++)
        {
            result[j] = input_1[j] + input_2[j];
        }
        return result;
    }

    public static double[][] Matrix_Addition_2D(double[][] input_1, double[][] input_2)
    {
        double[][] result = new double[input_1.length][input_1[0].length];
        
        for(int j = 0; j < input_1.length; j++)
        {
            for(int k = 0; k < input_1[0].length; k++)
            {
                result[j][k] = input_1[j][k] +input_2[k][j];
            }
        }
        return result;
    }

    public static double[][] Update_Hidden_Weights(double learning_rate, double[][] hidden_weights, double[] hidden_input, double[] hidden_output, double error)
    {
        double[][] result = new double[hidden_weights.length][hidden_weights[0].length];

        for(int j = 0; j < hidden_weights[0].length; j++)
        {
            for(int k = 0; k < hidden_input.length; k++)
            {
                result[j][k] = learning_rate*error*hidden_input[k]*hidden_output[j]*(1-hidden_output[j]);
                // System.out.println(learning_rate + "*" + error + "*" + hidden_input[j]+ "*" + hidden_output[k]);
                //                      0.25                -0.6439         0                   0.6341
            }
        }
        return result;
    }

    public static double[] Update_Output_Weights(double learning_rate, double[] output_weights, double[] hidden_output, double output, double error)
    {
        double[] result = new double[output_weights.length];

        for(int j = 0; j < output_weights.length; j++)
        {
            result[j] = learning_rate*error*hidden_output[j]*output*(1-output);
        }

        return result;
    }
}