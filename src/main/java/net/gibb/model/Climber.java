package net.gibb.model;

import java.util.HashMap;

public class Climber {
    private Integer id;
    private String name;
    private Float wingspan;
    private Integer height;
    private Integer age;
    private String birthday;
    private String proficiency;

    public Climber() {
    }

    public Climber(String name, Float wingspan, Integer age, String birthday, String proficiency,Integer height) {
        this.name = name;
        this.wingspan = wingspan;
        this.age = age;
        this.birthday = birthday;
        this.proficiency = proficiency;
        this.height=height;
    }

    public String toString(){
        return "Name: " + this.getName() + "\n" +
                "ID: " + this.getId() + "\n" +
                "Wingspan: " + this.getWingspan() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Birthday: " + this.getBirthday() + "\n" +
                "Proficiency: " + this.getProficiency() + "\n"+
                "Height: " +this.getHeight() + "\n";
    }

    public HashMap<String, Object> getClimberAsHashmap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", this.name);
        map.put("wingspan", this.wingspan);
        map.put("age", this.age);
        map.put("birthday", this.birthday);
        map.put("proficiency", this.proficiency);
        map.put("height", this.height);
        return map;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getWingspan() {
        return wingspan;
    }

    public void setWingspan(Float wingspan) {
        this.wingspan = wingspan;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
