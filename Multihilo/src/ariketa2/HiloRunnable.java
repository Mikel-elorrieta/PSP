package ariketa2;

public class HiloRunnable implements Runnable {

	public static void main(String[] args) {

		HiloRunnable hilo1 = new HiloRunnable();
		HiloRunnable hilo2 = new HiloRunnable();

		Thread t1 = new Thread(hilo1);
		Thread t2 = new Thread(hilo2);

		t1.start();
		t2.start();

		while (t1.isAlive() || t2.isAlive()) {
			System.out.println("Hilo 1 bizirk = " + t1.isAlive() + " Hilo 2 bizirik: " + t2.isAlive());
			try {
				t1.join();
				t2.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Hilos terminados");
	}

	@Override
	public void run() {

		System.out.println("Bizirk dago " + Thread.currentThread().getName());
		// TODO Auto-generated method stub

	}

}
