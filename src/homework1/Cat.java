package homework1;

public class Cat  implements Participable {
    private String name;
    private int h;
    private int l;

    public Cat(String name, int h, int l) {
        this.name = name;
        this.h = h;
        this.l = l;
    }


    @Override
    public boolean jump(Wall wall) {
        if (wall.getHeight() < h){
            System.out.println("Кот " + name + " перепрыгнул барьер высотой " + wall.getHeight()+ " см");
            return true;
        } else {
            System.out.println("Кот " + name + " не смог перепрыгнуть барьер высотой "  + wall.getHeight()+ " см и сошел с дистанции");
            return false;
        }
    }



    @Override
    public boolean run(Treadmill treadmill) {
        if (treadmill.getLength() <= l){
            System.out.println("Кот " + name + " пробежал " + treadmill.getLength() + " м");
            return true;
        } else {
            System.out.println("Кот " + name + " не смог пробежать " + treadmill.getLength() + "м и сошел с дистанции");
            return false;
        }
    }
}
