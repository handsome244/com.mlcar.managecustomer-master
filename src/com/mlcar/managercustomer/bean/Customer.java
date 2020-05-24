package com.mlcar.managercustomer.bean;

/**
 * @Description 实体类 Modal层
 * @auther Admin
 * @date 2020/5/23 9:06
 */
public class Customer {

    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    public Customer() {
        super();
    }

    public Customer(String name, char gender, int age, String phone,
                    String email) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "\t " + gender + "\t " + age + "\t" + phone + "\t\t"
                + email;

    }

//    Customer customer = new Customer("lili", '女', 12, "197979", "131231@qq.com");


}
