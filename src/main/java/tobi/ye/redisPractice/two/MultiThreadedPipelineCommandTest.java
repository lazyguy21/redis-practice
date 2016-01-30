package tobi.ye.redisPractice.two;

public class MultiThreadedPipelineCommandTest {
    public static void main(String[] args) throws InterruptedException {
        Thread pipelineClient = new Thread(new PipelineCommand());
        Thread singleCommandClient = new Thread(new SingleCommand());
        pipelineClient.start();
        Thread.currentThread().sleep(50);
        singleCommandClient.start();
    }
}