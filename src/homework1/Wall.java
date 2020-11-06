package homework1;

public class Wall implements Barrierable {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }
    public int getHeight(){
        return this.height;
    }

    @Override
    public void barrier() {

    }
}
