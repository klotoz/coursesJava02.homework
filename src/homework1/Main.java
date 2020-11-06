package homework1;

public class Main {

    public static void main(String[] args) {

    	Participable[] p = {
    			new Human("Mike", 100, 19),
				new Cat("Murzik", 40, 100),
				new Cat("Vaska", 60, 100),
				new Robot("Bender", 300, 100)
		};

    	Barrierable[] b = {
    			new Treadmill(20),
				new Wall(50),
				new Wall(200),
				new Treadmill(100)
		};

		for (Participable participable : p) {
			for (Barrierable barrierable : b) {
				if (barrierable instanceof Treadmill) {
					if (!participable.run((Treadmill) barrierable)) {
						break;
					}
				} else {
					if (!participable.jump((Wall) barrierable)) {
						break;
					}
				}
			}


		}


    }
}
