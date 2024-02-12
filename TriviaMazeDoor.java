
public class TriviaMazeDoor {

    private boolean isLocked;


    public TriviaMazeDoor() {
       
        this.isLocked = false;
    }


    public void unlock() {
        isLocked = false;
    }


    public void lock() {
        isLocked = true;
    }


    public boolean isLocked() {
        return isLocked;
    }
}