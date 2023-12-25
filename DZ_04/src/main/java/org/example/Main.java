package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {


    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()){

            // Создание сессии
            Session session = sessionFactory.getCurrentSession();

            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Course course = Course.create();
            session.save(course);
            System.out.println("Object course save successfully");

            // Чтение объекта из базы данных
            Course retrievedCourse = session.get(Course.class, course.getId());
            System.out.println("Object course retrieved successfully");
            System.out.println("Retrieved course object: " + retrievedCourse);

            // Обновление объекта
            retrievedCourse.updateDuration();
            retrievedCourse.updateTitle();
            session.update(retrievedCourse);
            System.out.println("Object scourse update successfully");


            session.delete(retrievedCourse);
            System.out.println("Object course delete successfully");


            session.getTransaction().commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
