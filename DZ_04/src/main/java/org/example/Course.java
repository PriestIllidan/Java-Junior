package org.example;

import javax.persistence.*;
import java.util.Random;

/*
Создайте базу данных (например, SchoolDB).
В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
Настройте Hibernate для работы с вашей базой данных.
Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
Убедитесь, что каждая операция выполняется в отдельной транзакции.
 */

@Entity
@Table(name = "Courses_DZ")
public class Course {

    private static final String[] titles = new String[]{"Алгебра", "Геометрия", "Химия", "Биология",
            "Литература", "География", "Черчение"};
    private static final int[] durations = {45, 90, 135, 180};
    private static final Random random = new Random();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course() {
    }

    public static Course create() {
        return new Course(titles[random.nextInt(titles.length)], durations[random.nextInt(durations.length)]);
    }

    public void updateTitle() {
        title = titles[random.nextInt(titles.length)];
    }

    public void updateDuration() {
        duration = durations[random.nextInt(durations.length)];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
