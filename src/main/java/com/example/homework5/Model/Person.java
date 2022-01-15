package com.example.homework5.Model;

import com.example.homework5.dto.PersonDto;

public class Person {
    private final Integer id;
    private final String lastName;
    private Integer phone;
    private final Cart cart;
    private static Integer generatedId = 0;

    public Person(final String lastName, final Integer phone) {
        this.id = ++generatedId;
        this.lastName = lastName;
        this.phone = phone;
        this.cart = new Cart();
    }

    public Person(PersonDto personDto){
        this(personDto.getLastName(), personDto.getPhone());
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person))
            return false;
        Person other = (Person) o;
        boolean lastNameEquals = (this.lastName == null && other.lastName == null)
                || (this.lastName != null && this.lastName.equals(other.lastName));
        boolean phoneEquals = (this.phone == null && other.phone == null)
                || (this.phone != null && this.phone.equals(other.phone));
        return lastNameEquals && phoneEquals;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (lastName != null) {
            result = 31 * result + lastName.hashCode();
        }
        if (phone != null) {
            result = 31 * result + phone.hashCode();
        }
        return result;
    }
}
