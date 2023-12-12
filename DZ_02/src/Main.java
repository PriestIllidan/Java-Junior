/*
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Animal[] animals = new Animal[]{
                new Dog("Рекс", 2, "Немецкая"),
                new Dog("Бим", 5, "Бульдог"),
                new Cat("Василий", 1, "Дворовый"),
                new Dog("Борис", 2, "Борзая"),
                new Cat("Мурка", 12, "Ангорка"),
        };
        for (Animal animal : animals) {
            info(animal);
        }
    }

    private static <T> void info(T object) throws IllegalAccessException, InvocationTargetException {
        Class<?> objectClass = object.getClass();

        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.print(objectClass.getName() + " " + field.getName() + " " + field.get(object) + " ");
        }
        Method[] methods = objectClass.getDeclaredMethods();
        for (Method method : methods) {
//            System.out.println(method.getName());
            if (method.getName().equals("makeSound")) {
                method.invoke(object);
            }
        }
    }
}