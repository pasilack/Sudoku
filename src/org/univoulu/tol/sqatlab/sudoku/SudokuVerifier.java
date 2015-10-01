package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public int verify(String candidateSolution) {
		if (candidateSolution.length() > 81) {
			throw new Exception();
		}
		return 1;
	}
}


class MyOwnException extends Exception {
	   public MyOwnException(String msg){
	      super(msg);
	   }
	}
