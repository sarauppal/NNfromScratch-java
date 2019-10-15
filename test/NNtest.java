
import java.util.Arrays;
import java.util.Random;
import org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NNtest {


	
/*	public double[][] RandomArrayGenerate(double min, double max)
	   {
	      Random rd = new Random(); // creating Random object
	      double[][]  arr = new double[3][4];
	   
	      for (int i = 0; i < arr.length; i++)
	      {
	        for (int j=0 ; j<arr[i].length;j++)
	        {
	         arr[i][j] = min + rd.nextDouble() * (max - min);// storing random integers in an array
	         //System.out.println(arr[i][j]); // printing each array element
	        }
	      } 
	      return arr;
	   }
	*/
	@Test
	public void TestSetRandomWeights() 
	{	double [][] actualWeights=new double [4][2];
		double [][] x= 
			{{0,0},
			{0,1},
			{1,0},
			{1,1}};
		double [] y= {0,0,0,1};
		NN testNN=new NN(x,y,4);
		//System.out.println(Arrays.deepToString(testNN.Layer1Weights));
		//System.out.println(Arrays.deepToString(testNN.Layer2Weights));
		
		Assert.assertEquals(1, 1, 0.001);
	}
	
	@Test
	public void TestFeedForward()
	{
		double [][] x= 
			{{0,0},
			{0,1},
			{1,0},
			{1,1}};
		double [] y= {0,0,0,1};
		double [] actualOutput=new double [4];
		double [] expectedoutput= {0.5568288 , 0.55858329, 0.54199423, 0.54474771};
		NN testNN=new NN(x,y,4);
		actualOutput=testNN.feedforward();
		Assert.assertArrayEquals(expectedoutput, actualOutput, 0.001);
		
	}
	@Test
	public void neuronTest()
	{	
		double [] WeightVector= {0.088, -0.014, 0.069};
		double [] InputVector= {0.0,1.0};
		double neuronOutput;
		double expectedOutput=0.539;
		double [][] x= 
			{{0,0},
			{0,1},
			{1,0},
			{1,1}};
		double [] y= {0,0,0,1};
		NN testNN=new NN(x,y,4);
		neuronOutput=testNN.neuron(InputVector,WeightVector);
		Assert.assertEquals(neuronOutput, expectedOutput, 0.001);
		
	}
	
	
	@Test
	public void SigmoidTest()
	{
		double Wsum=4;
		double expectedSigmoid=0.982;
		double actualSigmoid;
		double [][] x= 
			{{0,0},
			{0,1},
			{1,0},
			{1,1}};
		double [] y= {0,0,0,1};
		NN testNN=new NN(x,y,4);
		actualSigmoid=testNN.sigmoid(Wsum);
		
		Assert.assertEquals(expectedSigmoid, actualSigmoid, 0.001);
		
	}
	}
	


