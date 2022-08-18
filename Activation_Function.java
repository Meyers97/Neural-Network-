
public class Activation_Function 
{
    //Sigmoid function 
    public static double Sigmoid(double val)
    {
        return 1/(1+Math.exp(-val)); 
    }

    
    public static double[] Leaky_RELU(double[] val)
    {
        double[] result = new double[val.length];

        for(int j = 0; j < val.length; j++)
        {
            if(val[j] > 0 )
                result[j] = val[j];
            else
                result[j] = val[j]*0.01;
        }

        return result; 
    }
}
