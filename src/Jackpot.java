import Exception.DuplicationValuesException;

/**
 * 회차별 당첨번호를 저장하는 VO 객체
 * 
 * @author skarita
 *
 */
public class Jackpot {
	private int[] jackpot = new int[6];
	
	public Jackpot() throws DuplicationValuesException{
		for(int ii = 0; ii < 6; ii++)
			jackpot[ii] = 0;
	}
	
	public Jackpot(int[] jp) throws DuplicationValuesException {
		this.jackpot = jp;
	}
	
	private boolean validation(){
		for(int ii = 0; ii < 6; ii++)
			for(int jj = ii + 1; jj < 6; jj++)
				if(this.jackpot[ii] == this.jackpot[jj]
					|| this.jackpot[ii] > 45
					|| this.jackpot[ii] < 1)
					return false;
		return true;
	}
	
	public void callValidation() throws DuplicationValuesException{
		if(!validation())
			throw new DuplicationValuesException("Duplication values");
	}
	
	public void setNumber(int index, int param){
		this.jackpot[index] = param;
	}
	
	public int[] getNumber(){
		return this.jackpot;
	}
	
	public void print(){
		for(int ii = 0; ii < 6; ii++){
			System.out.print(this.jackpot[ii] + "\t");
		}
		System.out.println("");
	}
	
	public boolean isInNumber(int param){
		for(int ii = 0; ii < 6; ii++){
			if(this.jackpot[ii] == param)
				return true;
		}
		return false;
	}
	
	public void sort(){
		int ff = 1;
		while(ff != 0){
			ff = 0;
			for(int ii = 0; ii < 5; ii++)
				if (this.jackpot[ii] > this.jackpot[ii+1]) {
					this.swap4sort(ii, ii+1);
					ff++;
				}
		}	
	}
	
	public boolean eq(Jackpot temp){
		for(int ii = 0; ii < 6; ii++){
			if(this.jackpot[ii] != temp.jackpot[ii])
				return false;
		}
		return true;
	}
	
	private void swap4sort(int src, int tar){
		int temp = this.jackpot[src];
		this.jackpot[src] = this.jackpot[tar];
		this.jackpot[tar] = temp;
	}
}
