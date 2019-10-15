import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;



public class NN 
{

	private int NumInputs;
	private int NumHidden;
	private double argLearningRate;
	private double argMomentumTerm;
	private double [][] X;
	private double [] Y;
	public double [][] Layer1Weights;
	public double [][] Layer2Weights;

	
	
	public NN(double[][] X,double [] Y,int HidLayerSize) 
	{
		
		this.NumInputs=X[0].length;
		this.NumHidden=HidLayerSize;
		this.X=X;
		this.Y=Y;
		this.Layer1Weights=SetRandomWeights(NumHidden,NumInputs+1,-0.5,0.5);
		this.Layer2Weights=SetRandomWeights(1,NumHidden+1,-0.5,0.5);
		
		
		
	}
	
	public double[][] SetRandomWeights(int rows, int columns, double min, double max) 
	{
		Random rd = new Random(1); 
		// creating Random object with seed
	    double[][]  arr = new double[rows][columns];
	    for (int i = 0; i < arr.length; i++)
	      {
	        for (int j=0 ; j<arr[i].length;j++)
	        {
	         arr[i][j] = min + rd.nextDouble() * (max - min);// storing random integers in an array
	        // System.out.println(arr[i][j]); // printing each array element
	        }
	      } 
	      return arr;
	   }
	
	
	public double[] feedforward()
	{	
		double [][] H1=new double[X.length][NumHidden];
		for (int i=0;i<X.length;i++)
		{
			for(int j=0;j<Layer1Weights.length;j++)
			{
				H1[i][j]=neuron(X[i],Layer1Weights[j]);
			}
				
		}
		System.out.println(Arrays.deepToString(H1));
		double [] output=new double [4];
		for (int i=0;i<H1.length;i++)
		{
			output[i]=neuron(H1[i],arr2Dto1D(Layer2Weights));
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
	
	public double[] arr2Dto1D(double[][] arr) 
	{
	    ArrayList<Double> list = new ArrayList<Double>();
	    for (int i = 0; i < arr.length; i++) 
	    {

	        for (int j = 0; j < arr[i].length; j++) { 
	  
	            list.add(arr[i][j]); 
	        }
	    }


	    double[] vector = new double[list.size()];
	    for (int i = 0; i < vector.length; i++) {
	        vector[i] = list.get(i);
	    }
	    return vector;
	}
	
	public double neuron(double [] inputVector,double [] weight )
	{	double weightedSum=0.0;
		if(weight.length!=inputVector.length+1)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		else 
		{
			weightedSum+=weight[0];
			for (int i=1;i<weight.length;i++)
			{
				weightedSum+=weight[i]*inputVector[i-1];
			}
		}
		
		return sigmoid(weightedSum);
	}
		
	
	public double sigmoid(double Wsum)
	{
		return (1 / (1 + Math.exp(-Wsum)));
	}
	

}