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
		try {
			assertEquals(1, sV.verify(characters81));
		}
		catch (Exception e) {						
		}
	}
	
	@Test
	public void testVerifyStringLength82Characters() {
		String characters82 = "4417369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		boolean thrown = false;
		try {
			sV.verify(characters82);
		}
		catch (Exception e) {
			thrown = true;	
		}
		
		assertEquals(true, thrown);
	}
	
	@Test
	public void testVerifyStringLength80Characters() {
		String characters80 = "17369825632158947958724316825437169791586432346912758289643571573291684164875293"; 
		boolean thrown = false;
		
		try {
			sV.verify(characters80);
		}
		catch (Exception e) {
			thrown = true;	
		}
		
		assertEquals(true, thrown);
	}
	
	@Test
	public void testStringHasNoEmptySpaces() {
		String characters81emptyspaces = "4 736982563215894 95872431 825437169791586432346912758289643571573291684164875293"; 
		int result = 0;
		
		try {
			result = sV.verify(characters81emptyspaces);
		}
		catch (Exception e) {
		}
		
		assertEquals(-1, result);
	}
	
	@Test
	public void testStringContainsDigits(){
		String characters81 = "41736982563a158947958724316825437b697915864f2346912758289643571573291684164875293";
		int result = 0;
		
		try {
			result = sV.verify(characters81);
		}
		catch (Exception e) {
		}
		
		assertEquals(-1, result);
	}
	
	@Test
	public void testStringContainsOnlyPositiveDigits(){
		String characters81 = "-1736982-63a158947958724316825437b697915864f2346912758289643571573291684164875293";
		int result = 0;
		
		try {
			result = sV.verify(characters81);
		}
		catch (Exception e) {
		}
		
		assertEquals(-1, result);
	}
	
	@Test
	public void testStringRowContainsOnlyUniqueDigits(){
		String characters81 = "477369825632158947958724316825437169791586432346912758289643571573291684164875233";
		int result = 0;
		
		try {
			result = sV.verify(characters81);
		}
		catch (Exception e) {
		}
		
		assertEquals(-3, result);
	}
	

}
