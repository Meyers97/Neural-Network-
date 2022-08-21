import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class Initialise
{
    int neurons = 3; 
    int training_size = 100;
    int layers = 2; 
    double learning_rate = 0.6;
    boolean bias = false; 

    public static double[] Enable_Bias(double[] input)
    {
        double[] result = new double[input.length];

        for(int j = 0; j < input.length; j++)
        {
            result[j] = input[j];
        }

        result[input.length-1] = 1;

        return result;
    }

    public static int[] Index(int size)
    {
        int[] ran_index = new int[size];
        List<Integer> input = new ArrayList<Integer>(size);

        for(int j = 0; j < size; j++)
            input.add(j);

        Collections.shuffle(input);
        input.toArray();
        
        int k = 0;
        for(int l: input)
        {
            ran_index[k] = l;
            k++;
        }

        return ran_index;
    }

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
    
        public static double[][] Gen_Inputs(int training_size)
        {
            double[][] result = new double[training_size][2];
            Random random = new Random(); 
            
            for(int j = 0; j < training_size; j++)
            {
                for(int k = 0; k < 2; k++)
                {
                    result[j][k] = random.nextInt(100)/100.0;
                }
            }

            return result;
        }

        public static double[] Gen_Outputs(double[][] inputs, int logic)
        {
            double[] result = new double[inputs.length];

            for(int j = 0; j < inputs.length; j++)
            {
                int count = 0;
                switch(logic)
                {
                    //AND 
                    case 1:
                        if(inputs[j][0] > 0.5 & inputs[j][1] > 0.5)
                            result[j] = 1;
                        else 
                            result[j] = 0;
                        break;

                    //OR                            
                    case 2:
                        if(inputs[j][0] > 0.5 || inputs[j][1] > 0.5)
                            result[j] = 1;
                        else 
                            result[j] = 0;
                        break;

                    //NOR
                    case 3: 
                        for(int k = 0; k < inputs[0].length; k++)
                        {
                            if(inputs[j][k] > 0.5)
                                count = count + 1;
                        }
                            if(count == 0)
                                result[j] = 1;
                            else 
                                result[j] = 0;
                        count = 0;
                        break;

                    //XOR
                    case 4:
                        for(int k = 0; k < inputs[0].length; k++)
                        {
                            if(inputs[j][k] < 0.5)
                                count = count + 1;
                        }
                        if(count == 1)
                            result[j] = 1;
                        else 
                            result[j] = 0;
                        
                        count = 0;
                        break;

                }
            }  
            return result;
        }
}
