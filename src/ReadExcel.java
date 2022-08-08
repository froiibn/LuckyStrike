import java.io.File;
import java.io.IOException;

import Exception.DuplicationValuesException;

import jxl.*;
import jxl.read.biff.BiffException;

/**
 * 엑셀파일에서 당첨번호를 읽어들이는 객체
 * 
 * @author skarita
 *
 */
public class ReadExcel {
	private Workbook jacks;
	private Sheet sheet;
	private JackpotHistory jacksList;
	
	public ReadExcel() throws BiffException, IOException, Exception{
		try{
			this.jacksList = new JackpotHistory();
			System.out.println("Jackpot History file Reading...");
			this.jacks = Workbook.getWorkbook(new File("D://Lotto Project/LuckyStrike/resources/Jackpots.xls"));
			this.sheet = jacks.getSheet(0);
			System.out.println("Jackpot History file Read Completed!");
			System.out.println("Result : "+sheet.getRows()+"(ea) Jackpots found.");
		}catch(IOException e){
			System.out.println("Can not find file : " + e.getMessage());
		}catch(BiffException e){
			System.out.println("Can not read file : " + e.getMessage());
		}catch(Exception e){
			System.out.println("Unknown Error : " + e.getMessage());
		}
	}
	
	public JackpotHistory getJackpotNumbers() throws Exception{
		try{
			for(int ii = 0; ii < sheet.getRows(); ii++){
				Jackpot numbers = new Jackpot();
				for(int jj = 0; jj < sheet.getColumns(); jj++){
					numbers.setNumber(jj, Integer.parseInt(sheet.getCell(jj, ii).getContents()));
				}
				numbers.callValidation();
				this.jacksList.setJackPot(numbers);
			}
		}catch(DuplicationValuesException e){
			System.out.println("Duplication Values : " + e.getMessage());
		}catch(Exception e){
			System.out.println("Unknown Error : " + e.getMessage());
		}
		return this.jacksList;
	}
}
