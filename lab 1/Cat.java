public class Cat {
    private String name;
    private int age;
    private String ownerName;

    public Cat(String name, int age, String ownerName) {
        this.name = name;
        this.age = age;
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public String getOwnerName() {
        return ownerName;
    }

    public void meow() {
        System.out.println("Кот по имени "+ name + " говорит: Мяу!");
    }

    public void drinkMilk() {
        System.out.println("Кот по имени " + name + " пьет молоко.");
    }

    public void jump() {
        System.out.println("Кот по имени " + name + " прыгает.");
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Кит", 3, "Хозяйка");

        System.out.println("Имя кота: " + cat.getName());
        System.out.println("Возраст кота: " + cat.getAge());
        System.out.println("Имя хозяйки: " + cat.getOwnerName());

        cat.meow();
        cat.drinkMilk();
        cat.jump();
    }
}
