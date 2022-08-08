package AnalyzedData;

/**
 * 숫자별 발생 빈도수
 * 
 * @author skarita
 *
 */
public class Frequency {
	/*
	 * [0] : Index
	 * [1] : Number
	 * [2] : Frequency
	 */
	private int[][] frequency;
	
	public Frequency(){
		this.frequency = new int [45][3];
		for(int ii = 0; ii < 45; ii++){
			this.frequency[ii][0] = ii;
			this.frequency[ii][1] = ii+1;
			this.frequency[ii][2] = 0;
		}
	}
	
	public void setFrequency(int Number, int freq){
		this.frequency[Number][2] = freq;
	}
	
	public int[][] getFrequency(){
		return this.frequency;
	}
	
	public void print(){
		for(int ii = 0; ii < 45;ii++){
			for(int jj = 0; jj < 3; jj++){
				System.out.print(this.frequency[ii][jj]+" ");
			}
			System.out.println("");
		}
	}
}
