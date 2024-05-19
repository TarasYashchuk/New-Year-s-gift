package model.candies.chocolatecandy;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("MilkChocolate")
public class MilkChocolate extends Sweets {

    public MilkChocolate(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public MilkChocolate() {

    }

    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: молочний шоколад " + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}