package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public int verify(String candidateSolution) throws LengthException{
		
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
		
		for(int i = 0; i<72; i += 9) {
			
			if(candidateSolution.charAt(i) == candidateSolution.charAt(i+1)) {
				System.out.println(candidateSolution.charAt(i));
				return -3;
			}
			
			if(candidateSolution.charAt(i) == candidateSolution.charAt(i+2)) {
				return -3;
			}
			
			if(candidateSolution.charAt(i) == candidateSolution.charAt(i+3)) {
				return -3;
			}
			
			if(candidateSolution.charAt(i) == candidateSolution.charAt(i+4)) {
				return -3;
			}
			
			if(candidateSolution.charAt(i) == candidateSolution.charAt(i+5)) {
				return -3;
			}
			
			if(candidateSolution.charAt(i) == candidateSolution.charAt(i+6)) {
				return -3;
			}
			
			if(candidateSolution.charAt(i) == candidateSolution.charAt(i+7)) {
				return -3;
			}
			
			if(candidateSolution.charAt(i) == candidateSolution.charAt(i+8)) {
				return -3;
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
