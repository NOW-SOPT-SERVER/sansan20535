package org.sopt;

import org.sopt.classes.Person;
import org.sopt.classes.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        Person.run();
        //Person 클래스의 객체 생성
        Person person = new Person("김의진", 24, "male");
        //Person 클래스 내부 메소드 호출
        person.walk();
        System.out.println(person.getName());
        person.setName("기미진");
        System.out.println(person.getName());

        Person personWithBuilder = new
                PersonBuilder()
                .name("김의진")
                .age(24)
                .sex("male")
                .build();

        Person personWithFactoryMethod = Person.create("김의진", 24, "male");
    }
}
