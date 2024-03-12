package net.gibb.model;

public class Climber {
    private Integer id;
    private String name;
    private Float wingspan;
    private Integer age;
    private String birthday;
    private String proficiency;

    public String toString(){
        return "Name: " + this.getName() + "\n" +
                "ID: " + this.getId() + "\n" +
                "Wingspan: " + this.getWingspan() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Birthday: " + this.getBirthday() + "\n" +
                "Proficiency: " + this.getProficiency() + "\n";
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
}
