module com.nara.java8.examples.java8examples {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.nara.java8.examples.java8examples to javafx.fxml;
    exports com.nara.java8.examples.java8examples;
}