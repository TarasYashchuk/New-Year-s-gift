package model.candies.marmalade;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("JellyMarmalade")
public class JellyMarmalade extends Sweets {
    public JellyMarmalade(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public JellyMarmalade() {

    }

    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: фруктовий мармелад" + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}