package model.candies.popsicles;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("MilkPopsicles")
public class MilkPopsicles extends Sweets {

    public MilkPopsicles(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public MilkPopsicles() {

    }


    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: льодяник" + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}