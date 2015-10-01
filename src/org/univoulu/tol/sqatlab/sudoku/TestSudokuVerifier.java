package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {
	
	SudokuVerifier sV;
	
	@Before
	public void init() {
		sV = new SudokuVerifier();
	}

	@Test
	public void testVerifyStringLength81Characters() {
		String characters81 = "417369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		assertEquals(1, sV.verify(characters81));
	}
	
	@Test
	public void testVerifyStringLength82Characters() {
		String characters82 = "17369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		boolean thrown = false;
		try {
			sV.verify(characters82);
		}
		catch (Exception e) {
			thrown = true;						
		}
		
		assertEquals(true, thrown);
	}

}
