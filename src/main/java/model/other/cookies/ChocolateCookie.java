package model.other.cookies;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("ChocolateCookie")
public class ChocolateCookie extends Sweets {
    public ChocolateCookie(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public ChocolateCookie() {

    }


    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: печиво" + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}