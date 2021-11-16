package thread.basic;

class Super{
	
}
//이미 상속하고 있는 클래스가 있는 경우 Thread프로그래밍을 하기 위해서 Runnable인터페이스를 상속한다
class RunnableDemo01 extends Super implements Runnable{
	
	@Override
	public void run() { //만약 네트워크 통신할게 있다면 run안에 만들어준다. 예를 들어 원하는 시점에(버튼을 눌러서) 네트워크 시작하기
		//안드로이드 경우 oncreate, onclick 등에 적절히 배치!
		//1부터 20까지 출력
		for (int i=1 ; i<=20; i++) {
			System.out.print(i+"("+Thread.currentThread().getName()+")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i%5==0) {
				System.out.println();
			}
		}
	}
}

public class RunnableTest01 {
	public static void main(String[] args) {
		System.out.println("*************프로그램시작************");
		
		RunnableDemo01 obj1 = new RunnableDemo01();
		RunnableDemo01 obj2 = new RunnableDemo01();
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start();
		t2.start();
		for (int i=1; i<=10; i++) {
			System.out.println("main: "+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("***************프로그램종료***********");
		
	}
}


