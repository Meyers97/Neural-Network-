import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Initialise
{
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

    
}
