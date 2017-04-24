package guicassolato.java.n2w.exceptions;

public class UnsupportedSmallNumberException extends UnsupportedInputException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1636691150195658090L;

	public UnsupportedSmallNumberException(int lowerLimit) {
		super(String.format("Unsupported. The number should not be greater or equal to %d", lowerLimit));
	}

}
