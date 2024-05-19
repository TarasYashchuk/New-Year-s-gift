package model.other.chocolatebars;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("NutChocolateBar")
public class NutChocolateBar extends Sweets {
    public NutChocolateBar(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public NutChocolateBar() {

    }
    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: шоколадний батончик " + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}