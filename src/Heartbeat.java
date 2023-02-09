public class Heartbeat implements Runnable{

    private int milliSecondsBetweenBeats;

    public Heartbeat(int milliSecondsBetweenBeats){

        this.milliSecondsBetweenBeats = milliSecondsBetweenBeats;
    }

    @Override
    public void run() {

        for (int i = 1; i > 0; i++){

            System.out.println("<3 <3");

            try {
                Thread.sleep(milliSecondsBetweenBeats);
            } catch (InterruptedException e) {
                return;
            }

        }

    }
}
