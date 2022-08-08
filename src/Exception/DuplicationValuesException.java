package Exception;
/**
 * 연속된 숫자가 있을 시 오류발생
 * 
 * @author skarita
 *
 */
public class DuplicationValuesException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 0001L;

	public DuplicationValuesException(){
		super();
	}
	
	public DuplicationValuesException(String message){
		super(message);
	}
}
