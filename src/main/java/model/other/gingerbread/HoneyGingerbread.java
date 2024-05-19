package model.other.gingerbread;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("HoneyGingerbread")
public class HoneyGingerbread extends Sweets {
    public HoneyGingerbread(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public HoneyGingerbread() {

    }

    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: пряник " + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }

}