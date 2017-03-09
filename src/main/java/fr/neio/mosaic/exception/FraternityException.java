package fr.neio.mosaic.exception;

public class FraternityException extends Exception {
	
	private String answer;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7281608439830948680L;
	
	public FraternityException() {
		super();
	}

	/**
	 * @param answer
	 */
	public FraternityException(String answer) {
		super();
		this.answer = answer;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
