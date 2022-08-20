public class Neural_Network 
{
    static double[][] inputs = {{0,1}, {1.1}};  
    static double[] outputs = {0,1};
    static double[][] hidden_weights = {{0.62, 0.42},{0.55,-0.17}};
    static double[] output_weights = {0.35,0.81};
    static double[] errors;
    static double learning_rate = 0.25;
    static int max_iteration = 2;
    static int iteration = 0;

    public static void main(String[] args) throws Exception
    {        
        Forward_Propagation[] forward_training_set = new Forward_Propagation[max_iteration];
        Backward_Propagation[] backward_training_set = new Backward_Propagation[max_iteration];

        System.out.println("Hello World");

        while(iteration < max_iteration)
        {
            errors = new double[inputs.length];
            for(int j = 0; j < inputs.length; j++)
            {
                Forward_Propagation  test = new Forward_Propagation();
                Backward_Propagation test1 = new Backward_Propagation();

                test.Start(inputs[0], hidden_weights, output_weights);
                test1.Start(outputs[0], test.final_output, learning_rate, inputs[0], test.hidden_output);

                errors[j] = test1.error;
                forward_training_set[j] = test;
                backward_training_set[j] = test1;
            }
            // Analysis.Print_Matrix_1D(output_weights);
            System.out.println(Analysis.MSE(errors));
            iteration++;
        }

        

        
    }    
}
