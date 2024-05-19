package model.candies.caramel;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("CaramelCandy")
public class CaramelCandy extends Sweets {

    public CaramelCandy(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public CaramelCandy() {

    }

    @Override
    public String toString(){
        return  "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: карамель " + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100  + "%";
    }
}