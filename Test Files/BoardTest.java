import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest{
    
	// Testing clear
	@Test
    public void test_clear(){

	//Clear after using an initially clean board
        	Board b = new Board();
	b.clear();
	int [] array = b.getBoard();
	for(int i=0; i<9; i++){
	assertEquals("Expected blank at "+i, 0, array[i], 0.00001);
	}

	//Clear after setting the entire board to O
	for(int j=0; j<9; j++){
	b.setO(j);
	}
	b.clear();
	array = b.getBoard();
	for(int k=0; k<9; k++){
	assertEquals("Expected blank at "+k, 0, array[k], 0.00001);
	}
    }

	// Testing setO
	@Test
    public void test_setO(){
        	Board b = new Board();
	b.clear();

	//Set the first row all O
	b.setO(0);
	b.setO(1);
	b.setO(2);
	int [] array = b.getBoard();

	//Test the first row, should return all 1
	for(int i=0; i<3; i++){
	assertEquals("Expected 1 at "+i, 1, array[i], 0.00001);
	}

	//Test the rest of the rows, should return all 0
	for(int i=3; i<9; i++){
	assertEquals("Expected 0 at "+i, 0, array[i], 0.00001);
	}
    }

	// Testing setX
	@Test
    public void test_setX(){
        	Board b = new Board();
	b.clear();

	//Set the first row all X
	b.setX(0);
	b.setX(1);
	b.setX(2);
	int [] array = b.getBoard();

	//Test the first row, should return all 2
	for(int i=0; i<3; i++){
	assertEquals("Expected 2 at "+i, 2, array[i], 0.00001);
	}

	//Test the rest of the rows, should return all 0
	for(int i=3; i<9; i++){
	assertEquals("Expected 0 at "+i, 0, array[i], 0.00001);
	}
    }

	// Testing checkEmpty when the board is completely empty
	@Test
    public void test_checkEmpty_allEmpty(){
        	Board b = new Board();
	b.clear();
	for(int i=0; i<9; i++){
	assertEquals("Expected true at "+i, 1, (b.checkEmpty(i))?1:0, 0.00001);
	}
    }
    

	// Testing checkEmpty when the board is completely full
	@Test
    public void test_checkEmpty_full(){
        	Board b = new Board();
	b.clear();
	for(int j=0; j<9; j++){
	b.setO(j);
	}
	for(int i=0; i<9; i++){
	assertEquals("Expected false at "+i, 0, (b.checkEmpty(i))?1:0, 0.00001);
	}
    }

	// Testing getStatus for all the winning conditions of O
	@Test
    public void test_getStatus_allWinningConditionsO(){
        	Board b = new Board();
	b.clear();
	b.setO(0);
	b.setO(1);
	b.setO(2);
	assertEquals("Expected 1", 1, b.getStatus(), 0.00001);
	b.clear();
	b.setO(0);
	b.setO(3);
	b.setO(6);
	assertEquals("Expected 1", 1, b.getStatus(), 0.00001);
	b.clear();
	b.setO(0);
	b.setO(4);
	b.setO(8);
	assertEquals("Expected 1", 1, b.getStatus(), 0.00001);
	b.clear();
	b.setO(1);
	b.setO(4);
	b.setO(7);
	assertEquals("Expected 1", 1, b.getStatus(), 0.00001);
	b.clear();
	b.setO(2);
	b.setO(5);
	b.setO(8);
	assertEquals("Expected 1", 1, b.getStatus(), 0.00001);
	b.clear();
	b.setO(3);
	b.setO(4);
	b.setO(5);
	assertEquals("Expected 1", 1, b.getStatus(), 0.00001);
	b.clear();
	b.setO(6);
	b.setO(7);
	b.setO(8);
	assertEquals("Expected 1", 1, b.getStatus(), 0.00001);
    }

	// Testing getStatus for all the winning conditions of X
	@Test
    public void test_getStatus_allWinningConditionsX(){
        	Board b = new Board();
	b.clear();
	b.setX(0);
	b.setX(1);
	b.setX(2);
	assertEquals("Expected 2", 2, b.getStatus(), 0.00001);
	b.clear();
	b.setX(0);
	b.setX(3);
	b.setX(6);
	assertEquals("Expected 2", 2, b.getStatus(), 0.00001);
	b.clear();
	b.setX(0);
	b.setX(4);
	b.setX(8);
	assertEquals("Expected 2", 2, b.getStatus(), 0.00001);
	b.clear();
	b.setX(1);
	b.setX(4);
	b.setX(7);
	assertEquals("Expected 2", 2, b.getStatus(), 0.00001);
	b.clear();
	b.setX(2);
	b.setX(5);
	b.setX(8);
	assertEquals("Expected 2", 2, b.getStatus(), 0.00001);
	b.clear();
	b.setX(3);
	b.setX(4);
	b.setX(5);
	assertEquals("Expected 2", 2, b.getStatus(), 0.00001);
	b.clear();
	b.setX(6);
	b.setX(7);
	b.setX(8);
	assertEquals("Expected 2", 2, b.getStatus(), 0.00001);
    }

	// Testing getStatus for a tie condition
	@Test
    public void test_getStatus_tie(){
        	Board b = new Board();
	b.clear();
	b.setX(0);
	b.setO(1);
	b.setO(2);
	b.setO(3);
	b.setO(4);
	b.setX(5);
	b.setX(6);
	b.setX(7);
	b.setO(8);
	assertEquals("Expected 3", 3, b.getStatus(), 0.00001);
    } 

	// Testing getStatus for no winning conditions
	@Test
    public void test_getStatus_null(){
        	Board b = new Board();
	b.clear();
	assertEquals("Expected 0", 0, b.getStatus(), 0.00001);
	b.setX(0);
	assertEquals("Expected 0", 0, b.getStatus(), 0.00001);
	b.setO(1);
	assertEquals("Expected 0", 0, b.getStatus(), 0.00001);
	b.setO(2);
	assertEquals("Expected 0", 0, b.getStatus(), 0.00001);
	b.setO(3);
	assertEquals("Expected 0", 0, b.getStatus(), 0.00001);
	b.setO(4);
	assertEquals("Expected 0", 0, b.getStatus(), 0.00001);
	b.setX(5);
	assertEquals("Expected 0", 0, b.getStatus(), 0.00001);
	b.setX(6);
	assertEquals("Expected 0", 0, b.getStatus(), 0.00001);
	b.setX(7);
	assertEquals("Expected 0", 0, b.getStatus(), 0.00001);
    } 
	
}
