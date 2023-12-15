import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    transient double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, возраст: %s, средний бал: %s не серилизован из-за модификатора transient!",
                name, age, GPA);
    }
}
