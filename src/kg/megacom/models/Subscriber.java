package kg.megacom.models;

import kg.megacom.exceptions.MaxCountSubsWishes;

public class Subscriber{

    private double id;
    private String phone;
    private boolean isActive;
    private int countWishes;

    public Subscriber() {
    }

    public Subscriber(String phone) {
        this.phone = phone;
        this.id = Math.random();
        this.isActive = false;
    }

    public void setId(double id) {
        this.id = id;
    }

    public int getCountWishes() {
        return countWishes;
    }

    public void incrementSubsWish() {
        if (countWishes >= 2){
            throw new MaxCountSubsWishes("Вы достигли максимального кол-во отправок");
        }else {
            this.countWishes = countWishes++;
        }
    }

    public double getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}