package AnalyzedData;

import java.util.*;

/**
 * 구간별 나타나지 않은 숫자
 * 
 * @author skarita
 *
 */
public class DisappearInSec {
	ArrayList<Integer> disapps;
	
	public DisappearInSec(){
		this.disapps = new ArrayList<Integer>();
		
		for(int ii = 1; ii < 46; ii++){
			this.disapps.add(ii);
		}
	}
	
	public void setDisappear(int[] jacks){
		for(int ii = 0; ii < jacks.length; ii++)
			if(disapps.contains(jacks[ii]))
				disapps.remove(disapps.indexOf(jacks[ii]));
	}
	
	public ArrayList<Integer> getDisappear(){
		return this.disapps;
	}
	
	public void print(){
		Iterator<Integer> i = this.disapps.iterator();
		while(i.hasNext()){
			System.out.println((int)i.next() + " ");
		}
	}
}
