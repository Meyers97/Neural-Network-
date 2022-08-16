import java.util.Random;
// import java.util.List;
// import java.util.Collections;
// import java.util.ArrayList;

public class Matrix_Arithmetic
{
    // initial weights for hidden layer neurons 
    public static double[][] Gen_Hidden_Weights(int n_neurons, boolean bias)
    {
        int length;
        Random random = new Random();

        if(bias == true)
            length = n_neurons + 1;
        else
            length = n_neurons; 

        double[][] weight = new double[length][n_neurons];

        for(int j = 0; j < length; j++)
        {
            for(int k = 0; k < weight[j].length; k++)
            {
                weight[j][k] = (random.nextInt(200)-100)/100.0;
                if(bias == true)
                    weight[length-1][k] = 1;
            }
        }
        return weight; 
    }

    //intial weights for output layer neurons 
    public static double[] Gen_Output_Weights(int n_neurons)
    {
        double[] weight = new double[n_neurons];
        Random random = new Random();

        for(int j = 0; j < weight.length; j++)
        {
            weight[j] = (random.nextInt(200)-100)/100.0;
        }

        return weight; 
    }

    public static double[] Amplitude_Matrix_1D(double[] weighted_inputs)
    {
        double[] init_inputs = weighted_inputs;

        for(int j = 0; j < init_inputs.length; j++)
        {
            // init_inputs[j] =  Activation_Function.Sigmoid(init_inputs[j]);
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
                // init_inputs[j][k] = Activatoin_Function.Sigmoid(init_inputs[j][k]);
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
        return null;
    }

    public static double[][] Matrix_Addition_2D(double[][] input_1, double[][] input_2)
    {
        double[][] result = new double[input_1.length][input_1[0].length];
        
        for(int j = 0; j < input_1.length; j++)
        {
            for(int k = 0; k < input_1[0].length; k++)
            {
                result[j][k] = input_1[j][k] +input_2[j][k];
            }
        }
        return result;
    }
}