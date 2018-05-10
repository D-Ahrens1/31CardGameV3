package game.logic;

public class Timer {
	float currentTime;
	float startTime = -1;
	
	public Timer() {
		 new Thread(() -> {
			 currentTime = System.currentTimeMillis();
		 }).start();
	}
	
	public boolean wait(int timeToWait) {
		if(startTime == -1) {
			startTime = System.currentTimeMillis();
			return false;
		}else if((currentTime - startTime) >= timeToWait){
			startTime = -1;
			return true;
		}else {
			return false;
		}
		
	}
}
