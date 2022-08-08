import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import AnalyzedData.*;
import Exception.OutofIndex;

/**
 * 전체 당첨번호를 저장하고 있는 객체
 * 
 * @author skarita
 *
 */
public class JackpotHistory {
	private List<Jackpot> jackpotList;
	
	public JackpotHistory(){
		this.jackpotList = new ArrayList<Jackpot>();
	}
	
	public void setJackPot(Jackpot jackpot){
		jackpotList.add(jackpot);
	}
	
	public int count(){
		return jackpotList.size();
	}
	
	public List<Jackpot> getJackpotHistory(){
		return this.jackpotList;
	}
	
	public WeightNums setWeight(WeightNums weight){
		Iterator<Jackpot> iterator = jackpotList.iterator();
		while(iterator.hasNext()){
			Jackpot jacks = (Jackpot)iterator.next();
			weight.setWeight(jacks.getNumber());
		}
		return weight;
	}
	
	public Slurping setSlurping(Slurping slur){
		Iterator<Jackpot> iterator = jackpotList.iterator();
		while(iterator.hasNext()){
			Jackpot jacks = (Jackpot)iterator.next();
			slur.setSlurping(jacks.getNumber());
		}
		return slur;
	}
	
	public Frequency setFrequency(Frequency frequency){
		int freq = 0, sum = 0, count = 0;
		for(int ii = 0; ii < 45; ii++){
			Iterator<Jackpot> iterator = jackpotList.iterator();
			while(iterator.hasNext()){	
				Jackpot jacks = (Jackpot)iterator.next();
				if(jacks.isInNumber(ii+1)) count++; sum += freq; freq = 0;
				freq++;
			}
			frequency.setFrequency(ii, sum/count);
			freq = 0; sum = 0; count = 0;
		}
		return frequency;
	}
	
	public Section setSection(Section section){
		try{
			Iterator<Jackpot> iterator = jackpotList.iterator();
			while(iterator.hasNext()){
				Jackpot jacks = (Jackpot)iterator.next();
				section.setSection(jacks.getNumber());
			}
		}catch(OutofIndex e){
			System.out.println("Out of value : " + e);
		}
		return section;
	}
	
	public DisappearInSec setDisappear(DisappearInSec disapp){
		List<Jackpot> tempList = this.jackpotList;
		while(tempList.size() > 5)
			tempList.remove(0);
		Iterator<Jackpot> iterator = tempList.iterator();
		while(iterator.hasNext()){
			Jackpot jacks = (Jackpot) iterator.next();
			disapp.setDisappear(jacks.getNumber());
		}
		return disapp;
	}
}
