module iub.credit_card {
    requires javafx.controls;
    requires javafx.fxml;


    opens iub.credit_card to javafx.fxml;
    exports iub.credit_card;
}