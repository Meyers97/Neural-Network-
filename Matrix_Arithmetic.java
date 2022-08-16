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

        for(int ind_1 = 0; ind_1 < length; ind_1++)
        {
            for(int ind_2 = 0; ind_2 < weight[ind_1].length; ind_2++)
            {
                weight[ind_1][ind_2] = (random.nextInt(200)-100)/100.0;
                if(bias == true)
                    weight[length-1][ind_2] = 1;
            }
        }
        return weight; 
    }

    //intial weights for output layer neurons 
    public static double[] Gen_Output_Weights(int n_neurons)
    {
        double[] weight = new double[n_neurons];
        Random random = new Random();

        for(int ind_1 = 0; ind_1 < weight.length; ind_1++)
        {
            weight[ind_1] = (random.nextInt(200)-100)/100.0;
        }

        return weight; 
    }

    public static double[] Amplitude_Matrix_1D(double[] weighted_inputs)
    {
        return null; 
    }
}