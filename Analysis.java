public class Analysis 
{
    public static void Print_Matrix_1D(double[] matrix)
    {
        for(int j = 0; j < matrix.length; j++)
        {
            System.out.print(matrix[j]);
            System.out.println();
        }
    }    

    public static void Print_Matrix_2D(double[][] matrix)
    {
        for(int j = 0; j < matrix.length; j++)
        {
            for(int k = 0; k < matrix[j].length; k++)
            {
                System.out.print(matrix[j][k] + ", ");
            }
            System.out.println();
        }
    } 

    public static double Error(double actual_output, double target_output)
    {
        return (target_output - actual_output);
    }
}