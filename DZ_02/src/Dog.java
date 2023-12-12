public class Dog extends Animal {
    String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Гав");
    }

    void jump() {
        System.out.println("Собака прыгает");
    }
}
