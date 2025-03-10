package iub.credit_card;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class CreditCardController {

    @FXML
    private TextField cardHolderName;

    @FXML
    private TextField cardNo;


    @FXML
    private ComboBox<String> cardType;


    @FXML
    private TextField creditLimit;


    @FXML
    private TextField creditLimitFilter;

    @FXML
    private DatePicker dateOfExpiry;

    @FXML
    private ComboBox<String> gatewayName;


    @FXML
    private TableView<CreditCard> creditCardsTableView;

    @FXML
    private TableColumn<CreditCard, String> cardNoColumn;
    @FXML
    private TableColumn<CreditCard, Integer> creditLimitColumn;
    @FXML
    private TableColumn<CreditCard, String> holderNameColumn;

    @FXML
    private TableColumn<CreditCard, String> gatewayNameColumn;

    @FXML
    private ComboBox<String> gatewayNameFilter;

    ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();


    @FXML
    void initialize() {
        cardType.getItems().addAll("silver", "gold","platinum","titanium");
        gatewayName.getItems().addAll("Visa", "Mastercard");
        gatewayNameFilter.getItems().addAll("Visa", "Mastercard");


        cardNoColumn.setCellValueFactory(new PropertyValueFactory<CreditCard, String>("cardNo"));
        creditLimitColumn.setCellValueFactory(new PropertyValueFactory<CreditCard,Integer>("creditLimit"));
        holderNameColumn.setCellValueFactory(new PropertyValueFactory<CreditCard,String>("holderName"));
        gatewayNameColumn.setCellValueFactory(new PropertyValueFactory<CreditCard,String>("gatewayName"));

    }




    @FXML
    void searchAndLoadTable(ActionEvent event) {

    }

    @FXML
    void showAvgCreditLimit(ActionEvent event) {

    }

    @FXML
    void validateAndAddNewCard(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
       if(cardNo.getText().trim().isEmpty()) {
           alert.setTitle("Validation Error");
           alert.setContentText("Please enter card number");
           alert.show();
           return;
       }

       if(cardNo.getText().trim().length()!=16){
           alert.setTitle("Validation Error");
           alert.setContentText("Card number must have 16 digits");
           alert.show();
           return;
       }


       if(gatewayName.getValue().isEmpty()){
           alert.setTitle("Validation Error");
           alert.setContentText("Please enter gateway name");
           alert.show();
           return;
       }



       if(gatewayName.getValue().equals("Visa") && !String.valueOf(cardNo.getText().charAt(0)).equals("4")){
                alert.setTitle("Validation Error");
                alert.setContentText("First Digit for Visa card must be 4");
                alert.show();
                return;
       }

        if(gatewayName.getValue().equals("Mastercard") && !String.valueOf(cardNo.getText().charAt(0)).equals("5")){
            alert.setTitle("Validation Error");
            alert.setContentText("First Digit for Mastercard card must be 5");
            alert.show();
            return;
        }


        CreditCard creditCard = new CreditCard(cardNo.getText().trim(), cardHolderName.getText().trim(),
                dateOfExpiry.getValue(), gatewayName.getValue(), Float.parseFloat(creditLimit.getText()),
                cardType.getValue()
                );





       System.out.println(creditCard.toString());


       creditCards.add(creditCard);


       creditCardsTableView.getItems().add(creditCard);

    }

}
