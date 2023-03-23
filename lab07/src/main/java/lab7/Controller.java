package lab7;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import  java.util.List;

public class Controller {

    @FXML
    private Button AddToListB;
    @FXML
    private TextArea AddToListList1;
    @FXML
    private TextField FullNameT;
    @FXML
    private TextField AddressT;
    @FXML
    private TextField PhoneNumberT;
    @FXML
    private TextField CardNumberT;
    @FXML
    private TextField DiagnosisT;
    @FXML
    private Button RemoveB;
    @FXML
    private TextArea RemoveList;
    @FXML
    private TextField RemoveT;
    @FXML
    private Button getPatientsWithPhoneNumberStartingWithB;
    @FXML
    private TextField PhoneNumberStartsWithT;
    @FXML
    private TextArea getPatientsWithPhoneNumberStartingWithList;
    @FXML
    private TextArea NumberOfPatients;
    @FXML
    private Button getPatientsWithDiagnosisSortedByCardNumberB;
    @FXML
    private TextField DiagnosisTT;
    @FXML
    private TextArea getPatientsWithDiagnosisSortedByCardNumberList;
    @FXML
    private Button getPatientsWithCardNumberInRangeB;
    @FXML
    private TextField CardNumber1T;
    @FXML
    private TextField CardNumber2T;
    @FXML
    private TextArea getPatientsWithCardNumberInRangeList;
    @FXML
    private TextArea getDistinctDiagnosesSortedByCountList;
    @FXML
    private TextArea getSetOfDiagnosisList;
    @FXML
    private TextArea countPatientsByDiagnosisList;

    @FXML
    void list () {
        Logic logic = new Logic();
        FileProcessor fileProcessor = new FileProcessor();
        AddToListB.setOnAction(event -> {
            boolean success = true;
            String addFullName = null;
            String addAddress = null;
            String addPhoneNumber = null;
            int addCardNumber = 0;
            String addDiagnosis = null;
            try {
                addFullName = (FullNameT.getText());
                addAddress = (AddressT.getText());
                addPhoneNumber = (PhoneNumberT.getText());
                addCardNumber = (Integer.parseInt((CardNumberT.getText())));
                addDiagnosis = (DiagnosisT.getText());
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<Patient> patients = logic.fillList();
                AddToListList1.setText(String.valueOf(logic.AddToList(patients, addFullName, addAddress, addPhoneNumber, addCardNumber, addDiagnosis)));
                fileProcessor.writeFile(patients);
            }
        });
    }

    @FXML
    void remove() {
        Logic logic = new Logic();
        FileProcessor fileProcessor = new FileProcessor();
        RemoveB.setOnAction(event -> {
            boolean success = true;
            int index = 0;
            try {
                index = (Integer.parseInt(RemoveT.getText()));
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<Patient> list = logic.fillList();
                RemoveList.setText(String.valueOf(logic.remove(list, index)));
                System.out.println("button clicked");
                fileProcessor.writeFile(list);
            }
        });
    }

    @FXML
    void getPatientsWithPhoneNumberStartingWith () {
    Logic logic = new Logic();
    getPatientsWithPhoneNumberStartingWithB.setOnAction(event -> {
    boolean success = true;
    int phoneNumberStartsWith = 0;
    try{
        phoneNumberStartsWith = Integer.parseInt((PhoneNumberStartsWithT.getText()));
    } catch (NumberFormatException err) {
        Alert b = new Alert(Alert.AlertType.ERROR);
        b.setTitle("Помилка");
        b.setHeaderText("Некоректно введено значення");
        b.show();
        success = false;
    }
    if(success) {
        List<Patient> patients = logic.fillList();
        getPatientsWithPhoneNumberStartingWithList.
                setText(String.valueOf(logic.getPatientsWithPhoneNumberStartingWith(
                        patients, phoneNumberStartsWith)));
        NumberOfPatients.
                setText(String.valueOf(logic.countPatientsWithPhoneNumberStartingWith(
                        patients, phoneNumberStartsWith)));
    }
});

    }
    @FXML
    void getPatientsWithDiagnosisSortedByCardNumber () {
        Logic logic = new Logic();
        getPatientsWithDiagnosisSortedByCardNumberB.setOnAction(event -> {
            boolean success = true;
            String diagnosis = null;
            try {
                diagnosis = (DiagnosisTT.getText());
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if(success){
                List<Patient> patients = logic.fillList();
                getPatientsWithDiagnosisSortedByCardNumberList.
                        setText(String.valueOf(logic.getPatientsWithDiagnosisSortedByCardNumber(
                                patients, diagnosis)));
            }
        });
    }

    @FXML
    void getPatientsWithCardNumberInRange () {
        Logic logic = new Logic();
        getPatientsWithCardNumberInRangeB.setOnAction(event -> {
            boolean success = true;
            int cardNumber1 = 0;
            int cardNumber2 = 0;
            try{
                cardNumber1 = Integer.parseInt((CardNumber1T.getText()));
                cardNumber2 = Integer.parseInt((CardNumber2T.getText()));
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if(success){
                List<Patient> patients = logic.fillList();
                getPatientsWithCardNumberInRangeList.
                        setText(String.valueOf(logic.getPatientsWithCardNumberInRange(
                                patients, cardNumber1, cardNumber2)));
            }
        });
    }

    @FXML
    void getDistinctDiagnosesSortedByCount() {
        Logic logic = new Logic();
        List <Patient> patients = logic.fillList();
        getDistinctDiagnosesSortedByCountList.
                setText(String.valueOf(logic.getDistinctDiagnosesSortedByCount(patients)));
    }

    @FXML
    void getSetOfDiagnosis() {
        Logic logic = new Logic();
        List <Patient> patients = logic.fillList();
        getSetOfDiagnosisList.
                setText(String.valueOf(logic.getSetOfDiagnosis(patients)));
    }

    @FXML
    void countPatientsByDiagnosis() {
        Logic logic = new Logic();
        List <Patient> patients = logic.fillList();
        countPatientsByDiagnosisList.
                setText(String.valueOf(logic.countPatientsByDiagnosis(patients)));
    }

}