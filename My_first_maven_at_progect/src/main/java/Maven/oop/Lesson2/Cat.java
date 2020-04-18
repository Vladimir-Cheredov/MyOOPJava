package Maven.oop.Lesson2;

public class Cat implements Member {
    private int runPossible;
    private int jumpPossible;
    private boolean kann;

    Cat() {
        this.kann = true;
    }

    public void setRun(int inta1) {
        this.runPossible =  inta1;
    }

    public void setJump(int inta2) {
        this.jumpPossible = inta2;
    }

    public void run(int inta3) {
        if (runPossible >= inta3) {
            System.out.println("Кот успешно пробежал");
        } else {
            System.out.println("Кот не смог пробежать");
            this.kann = false;
        }
    }

    public void jump(int inta4) {
        if (jumpPossible >= inta4) {
            System.out.println("Кот успешно перепрыгнул");
        } else {
            System.out.println("Кот не смог перепрыгнуть");
            this.kann = false;
        }
    }

    public boolean kann() {
        return kann;
    }
}
