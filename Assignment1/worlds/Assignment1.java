package worlds;
import stanford.karel.*;
//9-28-2020

public class Assignment1 extends Karel {
	public void run() {
		checkBallot();
	}
//enters ballot. Does nothing if there is a wall. This is where the program starts and ends.
	private void checkBallot() {
		 if (frontIsClear()) {
			 move();
			 checkMiddle();
		 }
		
	}
	//checks for a vote if yes moves to top of ballet, if no moves to next ballot to check
	private void checkMiddle() {
		if(beepersPresent()) {
			move();
			checkBallot();
		
			
		}
		else {
			turnLeft();
			move();
			checkTop();
				
		}
	}
	/*checks top of ballot for hanging Chads and then moves to bottom of ballot
	 for loops start at 1 and increment to number of desired cycles +1 as opposed
	 to 0 to cycle number, either way meh... */
	private void checkTop() {
		while (beepersPresent()) {
			pickBeeper();
			}
			moveToBottom();
			}
	private void moveToBottom() {
		for (int i = 1; i<3; i++) {
			turnLeft();
		}
		for (int i = 1; i<3; i++) {
			move();
		}
		checkBottom();
	}
	//checks bottom of ballot for Chads then calls a repositioning method
	private void checkBottom() {
		while (beepersPresent()) {
			pickBeeper();
			}
			nextBallot();
		}
	//repositions Karel to start the program from the top.
	private void nextBallot() {
		for(int i=1; i<3; i++) {
			turnLeft();
		}
		move();
		for(int i=1; i<4; i++) {
		turnLeft();
		}
		move();
		checkBallot();
	}
		
	}

