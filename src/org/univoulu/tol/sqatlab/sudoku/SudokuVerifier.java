package org.univoulu.tol.sqatlab.sudoku;
import java.util.logging.*;
public class SudokuVerifier {
	
	private String cS;
	
	private static final Logger LOGGER = Logger.getLogger(SudokuVerifier.class.getName());
	
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
		
		int rowIndex = 1;
		
		for(int i = 0; i<80; i++) {
			
			if(i == 9 || i == 18 || i == 27 || i == 36 || i == 45 || i == 54 || i == 63 || i == 72) {
				rowIndex = 1;
			}
			
			if(compareRow(i ,rowIndex)) {
				return -3;
			}
			
			rowIndex++;
		}
		
		for(int i = 0; i < 9; i++) {
			if(compareColumn(i)) {
				return -4;
			}
		}
		
		for(int i = 0; i<76; i = i+3) {
			if(compareSubGrid(i)) {
				return -2;
			}
			if(i == 6 || i == 33) {
				i = i + 21;
			}
		}
		
		return 0;
	}
	
	private boolean compareRow(int c, int index){
		for(int i = 1; i < 10-index; i++)
		{
			if(cS.charAt(c) == cS.charAt(c+i))
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean compareColumn(int c) {
		for(int i = 1; i < 10; i++)
		{
			if(cS.charAt(c) == cS.charAt(c+9*i))
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean compareSubGrid(int c) {
		for(int subgridRow = 1; subgridRow < 4; subgridRow++)
		{
			if(subgridRow == 1) {
				for(int i = 1; i < 3; i++) {
					if(cS.charAt(c) == cS.charAt(c+i))
					{
						return true;
					}
				}
			}
			
			if(subgridRow == 2 || subgridRow == 3) {
				for(int i = 0; i < 3; i++) {
					LOGGER.info("Logger Name: " + c+9*(subgridRow-1)+i);
					if(cS.charAt(c) == cS.charAt(c+9*(subgridRow-1)+i))
					{
						return true;
					}
				}
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
