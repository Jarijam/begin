package thread.basic;

class Super2{
	
}

class AlphaThread2 extends Super2 implements Runnable {
	
	@Override
	public void run() {
		
		char[] arr = new char[26];
		int num = 65;
		for(int i = 1 ; i<27 ; i++) {
			arr[i-1] = (char)num;
			System.out.print(arr[i-1]+"("+Thread.currentThread().getName()+")");
			num++;
			if(i%5==0) {
				System.out.println();
			}
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}
class DigitThread2 extends Super implements Runnable {


	@Override
	public void run() {
		
		for (int j=1 ; j<=100 ; j++) {
			System.out.print(j+"("+Thread.currentThread().getName()+")");
			
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
public class RunnableTest02 {

	public static void main(String[] args) {
		//AlphaThread2 obj1 = new AlphaThread2();
		//DigitThread2 obj2 = new DigitThread2();
		
		Thread th1 = new Thread(new AlphaThread2());
		Thread th2 = new Thread(new DigitThread2());
		
		System.out.println("시작");
		th1.start();
		th2.start();
		System.out.println("종료");
		
		
	}

}
