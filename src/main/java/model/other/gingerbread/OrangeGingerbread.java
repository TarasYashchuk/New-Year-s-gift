package model.other.gingerbread;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.Sweets;

@Entity
@DiscriminatorValue("OrangeGingerbread")
public class OrangeGingerbread extends Sweets {

    public OrangeGingerbread(Long id, String name, double weight, double sugarContent){
        super(id, name,weight,sugarContent);
    }

    public OrangeGingerbread() {

    }


    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "ID: " + getId() + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: пряник " + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%" + "\n";
    }
}