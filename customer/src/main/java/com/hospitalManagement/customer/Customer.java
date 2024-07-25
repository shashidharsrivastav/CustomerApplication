package com.hospitalManagement.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Customer{
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Double weight;
    private String mobileNo;
    @Lob
    private byte[] image;

    public Customer() {
        super();
    }

    public Customer(Integer id, String name, Integer age, String gender, Double weight, String mobileNo) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.mobileNo = mobileNo;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", mobileNo='" + mobileNo + '\'' +
                ",image='" +image+ '\'' +
                '}';
    }
}
