module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires com.dlsc.formsfx;
    requires log4j;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires com.jfoenix;

    opens model to org.hibernate.orm.core;
    opens model.candies.caramel to org.hibernate.orm.core;
    opens model.candies.marmalade to org.hibernate.orm.core;
    opens model.candies.popsicles to org.hibernate.orm.core;
    opens model.candies.chocolatecandy to org.hibernate.orm.core;
    opens model.other.chocolatebars to org.hibernate.orm.core;
    opens model.other.cookies to org.hibernate.orm.core;
    opens model.other.gingerbread to org.hibernate.orm.core;

    opens com.example.demo2 to javafx.fxml;
    opens com.example.demo2.controllers to javafx.fxml;
    exports com.example.demo2;
}