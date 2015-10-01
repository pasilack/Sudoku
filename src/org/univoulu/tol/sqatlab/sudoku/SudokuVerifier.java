package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public int verify(String candidateSolution) throws LengthException{
		
		if (candidateSolution.length() > 81) {
			throw new LengthException("Solution string is too long");
		} 
		else if (candidateSolution.length() < 81) {
			throw new LengthException("Solution string is too long");
		} 
		
		for(char c : candidateSolution.toCharArray()) {
			if(!Character.isDigit(c) || c == '-') {
				return -1;
			}
		}
		
		return 1;
	}
}


class LengthException extends Exception {
	private static final long serialVersionUID = 1L;

	public LengthException(String msg){
	      super(msg);
	   }
}
