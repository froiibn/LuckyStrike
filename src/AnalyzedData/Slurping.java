package AnalyzedData;
/**
 * 홀수 짝수에 대한 통계
 * 
 * @author skarita
 *
 */
public class Slurping {
	/*
	 * [0] : Index
	 * [1] : 홀수
	 * [2] : 짝수
	 */
	private int[][] slur = null;
	private int cursor = 0;
	
	public Slurping(int hisSize){
		this.slur = new int[3][hisSize];
		for(int ii = 0; ii < hisSize; ii++){
			this.slur[0][ii] = ii+1;
			this.slur[1][ii] = 0;
			this.slur[2][ii] = 0;
		}
	}
	
	public void setSlurping(int[] jacks){
		int hh = 0, zz = 0;
		for(int ii = 0; ii < jacks.length; ii++){
			if(jacks[ii]%2 == 0)
				zz++;
			else
				hh++;
		}
		this.slur[1][cursor] = hh;
		this.slur[2][cursor] = zz;
		this.cursor++;
	}
	
	public void print(){
		for(int ii = 0; ii < this.cursor; ii++){
			for(int jj = 0; jj < 3; jj++){
				System.out.print(this.slur[jj][ii] + " ");
			}
			System.out.println("");
		}
	}
}
