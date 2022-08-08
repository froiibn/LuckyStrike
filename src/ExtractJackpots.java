import Exception.DuplicationValuesException;




public class ExtractJackpots {
	private int[][] tarExtract;
	private Jackpot jackpot;
	
	public ExtractJackpots(int[][] srcExtract) throws DuplicationValuesException{
		this.tarExtract = srcExtract;
		this.jackpot = new Jackpot();
	}
	
	public Jackpot getJackpot(){
		return this.jackpot;
	}
	
	public void print(){
		if(this.jackpot != null)
			this.jackpot.print();
	}
	
	public void sort(){
		int ff = 1;
		while(ff != 0){
			ff = 0;
			for(int ii = 0; ii < 44; ii++)
				if (this.tarExtract[ii][1] < this.tarExtract[ii+1][1]) {
					this.swap4sort(ii, ii+1);
					ff++;
				}
		}	
	}
	
	private void swap4sort(int src, int tar){
		int temp = this.tarExtract[src][1];
		this.tarExtract[src][1] = this.tarExtract[tar][1];
		this.tarExtract[tar][1] = temp;
		
		temp = this.tarExtract[src][0];
		this.tarExtract[src][0] = this.tarExtract[tar][0];
		this.tarExtract[tar][0] = temp;
	}
	
	public Jackpot tset() throws InterruptedException{
		int ii = 0;
		while(ii < 6){
			int temp = this.tarExtract[(int)(Math.random()*45)][0];
			if(!this.jackpot.isInNumber(temp))
				this.jackpot.setNumber(ii++, temp);
		}
		this.jackpot.sort();
		//this.jackpot.print();
		
		return this.jackpot;
	}
	
	public void SetWeightArray(){
		int arraySum = 0;
		
		for(int ii = 0; ii < 45; ii++){
			arraySum += this.tarExtract[ii][1];			
		}
		int [] tempArr = new int[arraySum];
		
		int ttInd = 0;
		for(int ii = 0; ii < 45; ii++){
			for(int jj = 0; jj < this.tarExtract[ii][1]; jj++){
				tempArr[ttInd++] = this.tarExtract[ii][0];
			}
		}

		/*
		for(int ii = 0; ii < arraySum; ii++)
			System.out.print(tempArr[ii] + ",");
		System.out.println();*/
	}
}
