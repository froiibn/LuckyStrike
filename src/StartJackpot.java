import java.io.IOException;

import Exception.DuplicationValuesException;
import jxl.read.biff.BiffException;

/**
 * 로또 당첨번호 추출머신(Lucky Strike)
 * 
 * @version 1.00
 * @date 2013/06/24
 * @author skarita
 *
 */
public class StartJackpot {
	public static void main(String args[]) throws BiffException, IOException, Exception{
		JackpotHistory jackpotHistory = null;
		try{
			System.out.println("Start to Extract Jackpot Numbers!!");
			jackpotHistory = new ReadExcel().getJackpotNumbers();
			
			Analize analize = new Analize(jackpotHistory);
			analize.setAnalyzedData(jackpotHistory);
			
			BasicDataResult basicDataResult = new BasicDataResult(analize.getWeightNums(), 
																	analize.getFrequency(), 
																	analize.getDisapperInSec());
			ExtractJackpots extract = new ExtractJackpots(basicDataResult.getBasicDataResults());
			extract.sort();
			extract.SetWeightArray();
			
			Jackpot th = new Jackpot(new int[]{15,21,31,32,41,43});
			
			int cnt = 0;
			String mode = "ts"; //ex : 당첨되보기 / ts : 번호추출
			
			while(mode == "ex"){
				//int[] ass = new int [6];
				//for(int ii = 0; ii < 6; ii++){
				//	ass[ii] = (int)Math.random()*45;
				//}
				//Jackpot js = new Jackpot(ass);
				//js.sort();
				Jackpot js = extract.tset();
				cnt++;
				if(th.eq(js)){
					System.out.println("Matched!" + cnt); 
					js.print();
					cnt = 0;
				}
				//if(cnt%100 == 0)
				//	System.out.println(cnt);
			}
			// Temporary print module
			Jackpot js;
			while(mode == "ts"){

					js = extract.tset();
					cnt++;
					if(cnt == 6457918){
						js.print();
						break;
					}
				
			}
			
			int [][] arr = new int[45][2];
			for(int ss = 0; ss < 45; ss++){
				arr[ss][0] = ss + 1;
				arr[ss][1] = 0;
			}

			if(mode == "ssd"){
				for(int ii = 0; ii < 1000; ii++){
					js = extract.tset();
					js.print();
					//int[] aa = js.getNumber();
					//for(int ss = 0; ss < aa.length; ss++){
					//	arr[aa[ss]-1][1] ++;
					//	}
				}
			}
/*
			for(int in = 0; in < 45; in ++){
				for(int jn = 0; jn < 2; jn++){
					System.out.print(arr[in][jn] + "\t");
				}
				System.out.println("");
			}
	*/		
			//for(int ii = 0; ii < 4835802; ii++)
			//	extract.tset();
			// to here
			//Validation4Jacks validation = new Validation4Jacks();
			System.out.println("done");
		}catch(BiffException e){
			System.out.println("Can not find file : " + e.getMessage());
		}catch(IOException e){
			System.out.println("Can not read file : " + e.getMessage());
		}catch(DuplicationValuesException e){
			System.out.println("Duplication Numners : " + e.getMessage());
		}catch(Exception e){
			System.out.println("Unknown Error : " + e.getMessage());
		}
	}
}


