package ariketa5;

public class contador extends Thread {

	private int c = 0;
	private boolean stopHilo = false;

	public int getContador() {
		return c;
	}
	
	public void pararHilo() {
		stopHilo = true;
	}
	
	public void run() {
		while(!stopHilo) {
			 try {
	                long sleepTime;

	                if (this.getPriority() == Thread.MAX_PRIORITY) {
	                    sleepTime = 500; 
	                } else if (this.getPriority() == Thread.NORM_PRIORITY) {
	                    sleepTime = 1000; 
	                } else {
	                    sleepTime = 2000; 
	                }

	                Thread.sleep(sleepTime);
	                c++;

	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
		}
	}
}
