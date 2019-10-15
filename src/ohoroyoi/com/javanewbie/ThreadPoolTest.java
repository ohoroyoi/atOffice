package ohoroyoi.com.javanewbie;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//[출처] 자바 스레드풀 사용하기(2) 작업 생성과 처리 요청|작성자 예비개발자
public class ThreadPoolTest {
    public static void main(String []args) throws ArithmeticException {
        // 최대 스레드 개수가 2인 스레드풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 10; i++) {
            // 작업 생성
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    // 스레드풀 사이즈
                    int size = threadPoolExecutor.getPoolSize();
                    // 현재 작업 스레드 이름
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수: " + size + ", 작업 스레드 이름: " + threadName + "]");
                    // 일부러 예외 발생
                    int a = 5 / 0;
                }
            };

            // 작업 처리 요청
            executorService.execute(runnable);
            executorService.submit(runnable);
        }

        // 스레드풀 종료
        executorService.shutdown();
    }
}


