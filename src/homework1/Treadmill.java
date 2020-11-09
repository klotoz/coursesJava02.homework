package homework1;

public class Treadmill implements Barrierable {

    private final int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength(){
        return this.length;
    }

    @Override
    public void barrier() {

    }
}
