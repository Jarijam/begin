package thread.basic;

class AlphaThread extends Thread {
	AlphaThread(String name){
		super(name);
	}
	@Override
	public void run() {
		
		char[] arr = new char[26];
		int num = 65;
		for(int i = 1 ; i<27 ; i++) {
			arr[i-1] = (char)num;
			System.out.print(arr[i-1]);
			num++;
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}
class DigitThread extends Thread {
	DigitThread(String name){
		super(name);
	}

	@Override
	public void run() {
		
		for (int j=1 ; j<=100 ; j++) {
			System.out.print(j+"//");
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			if(j%10==0) {
				System.out.println();
			}
		}
	}
	
	
}
public class ThreadTest02 {

	public static void main(String[] args) {
		AlphaThread AlphaThread = new AlphaThread("Alpha");
		DigitThread DigitThread = new DigitThread("Digit");
		
		System.out.println("시작");
		DigitThread.start();
		AlphaThread.start();
		System.out.println("종료");
		
		
	}

}
