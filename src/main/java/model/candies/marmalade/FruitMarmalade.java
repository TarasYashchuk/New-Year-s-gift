package model.candies.marmalade;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("FruitMarmalade")
public class FruitMarmalade extends Sweets {
    public FruitMarmalade(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public FruitMarmalade() {

    }

    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: мармелад" + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}