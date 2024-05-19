package model.candies.popsicles;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("FruitPopsicles")
public class FruitPopsicles extends Sweets {
    public FruitPopsicles(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public FruitPopsicles() {

    }

    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: льодяник " + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}