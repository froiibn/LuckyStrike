import AnalyzedData.*;


public class BasicDataResult {
	private WeightNums weight;
	private Frequency frequency;
	private DisappearInSec disapp;
	
	private int[][] basicDataResult;
	
	public BasicDataResult(WeightNums weight, Frequency frequency, DisappearInSec disapp){
		this.weight = weight;
		this.frequency = frequency;
		this.disapp = disapp;
		 
		this.basicDataResult = new int[45][2];
		for(int ii = 0; ii < 45; ii++){
			this.basicDataResult[ii][0] = ii+1;
			this.basicDataResult[ii][1] = 0;
		}
		
		InitializeWeight();
		InitializeFrequency();
		InitializeDisappearInSec();	
		System.out.println("Basic Data Calculate Completed!");
		
	}
	
	private void InitializeWeight(){
		for(int ii = 0; ii < this.basicDataResult.length; ii++){
			this.basicDataResult[ii][1] = this.weight.getWeight()[ii+1][1];
		}
	}
	
	private void InitializeFrequency(){
		for(int ii = 0; ii < this.basicDataResult.length; ii++){
			this.basicDataResult[ii][1] /= this.frequency.getFrequency()[ii][2];
		}
	}
	
	private void InitializeDisappearInSec(){
		for(int ii = 0; ii < this.basicDataResult.length; ii++){
			if(this.disapp.getDisappear().contains(this.basicDataResult[ii][0])){
				this.basicDataResult[ii][1] *= 1.5;
			}
		}
	}
	
	public int[][] getBasicDataResults(){
		return this.basicDataResult;
	}
	
	public void print(){
		for(int ii = 0; ii < 2; ii++){
			for(int jj = 0; jj < 45; jj++){
				System.out.print(this.basicDataResult[jj][ii] + "\t");
			}
			System.out.println();
		}
	}
}
