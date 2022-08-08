package AnalyzedData;

import java.util.*;

import Exception.OutofIndex;

/**
 * 구간별 내의 숫자가 나온 수
 * 
 * @author skarita
 *
 */
public class Section {
	private List<SecPattern> secList;
	
	public Section(){
		secList = new ArrayList<SecPattern>();
	}
	
	public void setSection(int[] jacks) throws OutofIndex{
		SecPattern secPattern = new SecPattern();
		for(int ii = 0; ii < jacks.length; ii++){
			if(jacks[ii] > 0 && jacks[ii] <= 10)
				secPattern.setNumber(0);
			else if(jacks[ii] > 10 && jacks[ii] <= 20)
				secPattern.setNumber(1);
			else if(jacks[ii] > 20 && jacks[ii] <= 30)
				secPattern.setNumber(2);
			else if(jacks[ii] > 30 && jacks[ii] <= 40)
				secPattern.setNumber(3);
			else if(jacks[ii] > 40 && jacks[ii] <= 45)
				secPattern.setNumber(4);
			else
				throw new OutofIndex("n");
		}
		this.secList.add(secPattern);
	}
	
	
	public void print(){
		Iterator<SecPattern> iterator = this.secList.iterator();
		while(iterator.hasNext()){
			SecPattern secp = (SecPattern) iterator.next();
			secp.print();
			System.out.println();
		}
	}
	
	private class SecPattern {
		int[] secPattern;
		public SecPattern(){
			this.secPattern = new int[5];
			for(int ii = 0; ii < 5; ii++)
				this.secPattern[ii] = 0;
		}
		public void setNumber(int index){
			this.secPattern[index]++;
		}
		public void print(){
			for(int ii = 0; ii < this.secPattern.length; ii++)
				System.out.print(this.secPattern[ii] + " ");
		}
	}
}


