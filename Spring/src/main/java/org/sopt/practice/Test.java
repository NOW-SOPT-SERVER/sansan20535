package org.sopt.practice;

public record Test (
        String name,
        int age,
        int id
){
    public Test(Entity entity){
        this(entity.getName(), entity.getAge(), entity.getId());
    }
}
