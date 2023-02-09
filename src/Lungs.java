public class Lungs implements Runnable{

    private boolean lungsFull;


    @Override
    public void run() {

        for (int i = 1; i > 0; i++){
            if (i % 2 == 0){
                lungsFull = false;
                System.out.println("Breathe in");
            } else {
                lungsFull = true;
                System.out.println("Breathe out");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }


    }
}
