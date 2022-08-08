package AnalyzedData;
/**
 * 각 숫자가 나온 횟수를 이용한 가중치 계산
 * 
 * @author skarita
 *
 */
public class WeightNums {
	private int[][] nums = new int[46][2];
	
	public WeightNums(){
		for(int ii = 0; ii < 46; ii++){
			this.nums[ii][0] = ii;
			this.nums[ii][1] = 0;
		}
	}
	
	public void setWeight(int[] jacks){
		for(int ii = 0; ii < jacks.length; ii++)
			this.nums[jacks[ii]][1]++;
	}
	
	public int[][] getWeight(){
		return this.nums;
	}
	
	public void printWeight(){
		for(int ii = 1; ii < 46; ii++)
			System.out.print(nums[ii][1] + ", ");
	}
}
