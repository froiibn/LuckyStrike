import AnalyzedData.*;

public class Analize {
	WeightNums weight = null;
	Slurping slur = null;
	Continuation continuation = null;
	DisappearInSec disapp = null;
	Frequency frequency = null;
	Section section = null;

	public Analize(JackpotHistory jackpotHistory){
		weight = new WeightNums();
		slur = new Slurping(jackpotHistory.count());
		frequency = new Frequency();
		disapp = new DisappearInSec();
		section = new Section();
		continuation = new Continuation();
	}
	
	public void setAnalyzedData(JackpotHistory jackpotHistory){
		System.out.println("Analizing and Storing Jackpot Datas...");
		//각 번호별 가중치를 구한다.
		jackpotHistory.setWeight(weight);
		
		//각 회차별 홀 짝수 비율을 구한다.
		jackpotHistory.setSlurping(slur);
		
		//각 번호의 출현 빈도수를 구한다.
		jackpotHistory.setFrequency(frequency);
		
		//각 번호의 구간별 패턴을 구한다.
		jackpotHistory.setSection(section);
		
		//최근 5회동안 나오지 않은 번호를 구한다.
		jackpotHistory.setDisappear(disapp);
		
		System.out.println("Analize and Store Completed!");
	}
	
	public Continuation getContinuation(){
		return this.continuation;
	}
	
	public DisappearInSec getDisapperInSec(){
		return this.disapp;
	}
	
	public Frequency getFrequency(){
		return this.frequency;
	}
	
	public Section getSection(){
		return this.section;
	}
	
	public Slurping getSlurping(){
		return this.slur;
	}
	
	public WeightNums getWeightNums(){
		return this.weight;
	}
}