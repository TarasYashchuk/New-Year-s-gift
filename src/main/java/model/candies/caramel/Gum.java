package model.candies.caramel;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("Gum")
public class Gum extends Sweets {

    public Gum(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public Gum() {
    }

    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: жувальна гумка " + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}