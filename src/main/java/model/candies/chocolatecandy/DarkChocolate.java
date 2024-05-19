package model.candies.chocolatecandy;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("DarkChocolate")
public class DarkChocolate extends Sweets {
    public DarkChocolate(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public DarkChocolate() {

    }
    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: чорний шоколад " + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}