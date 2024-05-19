package model;

import model.candies.caramel.CaramelCandy;
import model.candies.caramel.Gum;
import model.candies.chocolatecandy.DarkChocolate;
import model.candies.chocolatecandy.MilkChocolate;
import model.candies.marmalade.FruitMarmalade;
import model.candies.marmalade.JellyMarmalade;
import model.candies.popsicles.FruitPopsicles;
import model.candies.popsicles.MilkPopsicles;
import model.other.chocolatebars.CaramelChocolateBar;
import model.other.chocolatebars.NutChocolateBar;
import model.other.cookies.ButterCookie;
import model.other.cookies.ChocolateCookie;
import model.other.gingerbread.HoneyGingerbread;
import model.other.gingerbread.OrangeGingerbread;

import java.util.ArrayList;
import java.util.List;

public class SweetsList {
    public static List<Sweets> getSweetsList() {

        List<Sweets> sweets = new ArrayList<>();

        sweets.add(new CaramelCandy(1L,"Карамельна мелодія", 25.0, 0.2));
        sweets.add(new Gum(2L, "Золотий шарм", 15.0, 0.4));

        sweets.add(new DarkChocolate(3L, "Шоколадний розкіш", 40.0, 0.25));
        sweets.add(new MilkChocolate(4L, "Кокосова мрія", 35.0, 0.5));

        sweets.add(new FruitMarmalade(5L, "Фруктовий експрес", 10.0, 0.3));
        sweets.add(new JellyMarmalade(6L, "Сонячні мармелади", 10.0, 0.4));

        sweets.add(new FruitPopsicles(7L,"Апельсиновий відпочинок", 15.0, 0.6));
        sweets.add(new MilkPopsicles(8L, "Молочний куш", 10.0, 0.6));

        sweets.add(new CaramelChocolateBar(9L, "Шоколадний спокусник", 70.0, 0.5));
        sweets.add(new NutChocolateBar(10L, "Горішкова феєрія", 65.0, 0.4));

        sweets.add(new ButterCookie(11L, "Вишукана ніжність", 30.0, 0.6));
        sweets.add(new ChocolateCookie(12L, "Шоколадний трепет", 45.0, 0.7));

        sweets.add(new HoneyGingerbread(13L, "Медова кульбаба", 55.0, 0.3));
        sweets.add(new OrangeGingerbread(14L, "Мандаринова історія", 50.0, 0.4));

        return sweets;
    }
}
