import java.util.Random;

public class Person implements Runnable{

    private String name;
    private int age;
    private Thread heart;
    private Thread breathing;
    private Thread life;

    public Person(String name, int age, int heartBeatMilliSeconds){
        this.name = name;
        this.age = age;
        this.heart = new Thread(new Heartbeat(heartBeatMilliSeconds));
        this.breathing = new Thread(new Lungs());
        this.life = new Thread(this);

    }


    @Override
    public void run() {

        Random random = new Random();
        heart.start();
        breathing.start();

        for (int i = age; i < 100; i++){
            int dieByChance = random.nextInt(21);

            if (dieByChance != 13){
                System.out.println(name + " is "+i+" years old");
                this.age = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                this.endLife();
                return;
            }
        }

        heart.interrupt();
        breathing.interrupt();
        System.out.println(name + " died of old age at like 100");
    }

    public void startlife(){

        life.start();

    }

    public void endLife(){

        life.interrupt();
        heart.interrupt();
        breathing.interrupt();
        System.out.println("Bad luck, "+name+" has died at the age of "+this.age);
    }


}


