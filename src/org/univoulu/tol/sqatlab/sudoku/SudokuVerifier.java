package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
	
	private String cS;

	public int verify(String candidateSolution) throws LengthException{
		cS = candidateSolution;
		
		if (candidateSolution.length() > 81) {
			throw new LengthException("Solution string is too long");
		} 
		else if (candidateSolution.length() < 81) {
			throw new LengthException("Solution string is too short");
		} 
		
		for(char c : candidateSolution.toCharArray()) {
			if(!Character.isDigit(c) || c == '-') {
				return -1;
			}
		}
		int index = 1;
		for(int i = 0; i<80; i++) {
			
			if(compare(i ,index)) {
				return -3;
			}
		}
		return 1;
	}
	
	private boolean compare(int c, int index){
		for(int i = 1; i < 9-index; i++)
		{
			if(cS.charAt(c) == cS.charAt(c+i))
			{
				return true;
			}
		}
		return false;
	}
}


class LengthException extends Exception {
	private static final long serialVersionUID = 1L;

	public LengthException(String msg){
	      super(msg);
	   }
}
