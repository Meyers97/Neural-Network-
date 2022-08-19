public class Neural_Network 
{
    static double[][] inputs = {{0,1}, {1.1}};  
    static double[][] weight = {{0.62, 0.42},{0.55,-0.17}};
    static double[] output_weights = {0.35,0.81};

    public static void main(String[] args) throws Exception
    {        
        System.out.println("Hello World");

        Forward_Propagation test = new Forward_Propagation();

        test.Start(inputs[0], weight, output_weights);

    }    
}
