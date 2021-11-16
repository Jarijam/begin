package thread.basic;
//인터럽트를 발생시켜 쓰레드 종료하기 => 현재 상태를 확인하고 작업
class StopThread02 implements Runnable{
	public void run() {
		//Thread.currentThread()는 현재 실행중인 쓰레드 객체를 구하기
		try {
			while(!Thread.currentThread().isInterrupted()) {
			System.out.println("쓰레드 실행중~~~~");
			
				Thread.sleep(1000);
				//try-catch위치에 따라 while문이 계속 도냐 안도냐 중요함
			}
		} catch (InterruptedException e) {
			//e.printStackTrace();
		} finally {
			System.out.println("현재 쓰레드 종료:");
		}
		System.out.println("현재상태: 종료상태로 들어감....");
	}
}

public class StopThreadTest02 {
	public static void main(String[] args) {
		System.out.println("*****main 쓰레드 시작 ******");
		Thread t1 = new Thread(new StopThread02());
		t1.start();
		System.out.println("쓰레드의 이름: "+t1.getName());
		System.out.println("쓰레드의 현재 인터럽트 상태: "+t1.isInterrupted());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//인터럽트 발생
		t1.interrupt();
		System.out.println("쓰레드의 현재 인터럽트 상태: "+t1.isInterrupted());
		System.out.println("*****main 쓰레드 종료 ******");
	}

}
