package Java1.DZ1.Java1.DZ7;

public class Main {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Seva", 1),
                new Cat("Eva", 11),
                new Cat("Ivan", 13),
                new Cat("Buldog", 23),
                new Cat("Kara", 11)
        };

        Plate plate = new Plate(30);

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }

        plate.addFood(50);
        plate.info();
    }

}