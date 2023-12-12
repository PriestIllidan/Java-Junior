public class Cat extends Animal {
    String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    void makeSound() {
        System.out.println("Мяу");
    }

    void purr() {
        System.out.println("Кошка урчит");
    }
}
