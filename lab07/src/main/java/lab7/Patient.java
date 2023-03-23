package lab7;

import java.util.Objects;

public class Patient {

    transient private int id;
    private static int tempId=1;
    private String FullName;
    private String Address;
    private String PhoneNumber;
    private int cardNumber;
    private String Diagnosis;

    public Patient(String fullName, String address, String phoneNumber,
                   int cardNumber, String diagnosis) {
        this.id = tempId;
        FullName = fullName;
        Address = address;
        PhoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
        Diagnosis = diagnosis;
        ++tempId;
    }

    public Patient() {
        this("", "", "",0,"");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        Diagnosis = diagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && FullName.equals(patient.FullName) &&
                Address.equals(patient.Address) && PhoneNumber == patient.PhoneNumber &&
                cardNumber == patient.cardNumber && Diagnosis.equals(patient.Diagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FullName, Address, PhoneNumber,
                cardNumber, Diagnosis);
    }

    @Override
    public String toString() {
        return "\nPatient{" +
                "id=" + id +
                ", fullName=" + FullName +
                ", address=" + Address +
                ", phoneNumber=" + PhoneNumber +
                ", cardNumber=" + cardNumber +
                ", diagnosis='" + Diagnosis + '\'' +
                '}';
    }

}