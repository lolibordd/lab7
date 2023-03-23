package lab7;

import javafx.collections.FXCollections;

import java.util.*;

public class Logic {

    public List<Patient> fillList() {
        FileProcessor fileProcessor = new FileProcessor();
        List<Patient> patients = fileProcessor.readFile();
        return patients;
    }

    public List<Patient> AddToList(List<Patient> patients, String fullName, String address, String phoneNumber, int cardNumber, String diagnosis) {
        patients.add(new Patient(fullName, address, phoneNumber, cardNumber, diagnosis));
        return patients;
    }

    public List<Patient> remove(List<Patient> patients, int index) {
        boolean remove = patients.removeIf(patient -> patient.getId() == index);
        return patients;
    }

    // a) список пацієнтів, які мають вказаний діагноз в порядку зростання номерів медичної картки;
    public List<Patient> getPatientsWithDiagnosisSortedByCardNumber(List<Patient> patients, String diagnosis) {
        List<Patient> patientsWithDiagnosisSortedByCardNumber = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equals(diagnosis)) {
                patientsWithDiagnosisSortedByCardNumber.add(patient);
            }
        }
        Collections.sort(patientsWithDiagnosisSortedByCardNumber, Comparator.comparingInt(Patient::getCardNumber));
        return patientsWithDiagnosisSortedByCardNumber;
    }

    //b) список пацієнтів, номер медичної карти у яких знаходиться взаданому інтервалі;
    public List<Patient> getPatientsWithCardNumberInRange(List<Patient> patients, int cardNumber1, int cardNumber2) {
        List<Patient> patientsWithCardNumberInRange = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getCardNumber() >= cardNumber1
                    && patient.getCardNumber() <= cardNumber2) {
                patientsWithCardNumberInRange.add(patient);
            }
        }
        return patientsWithCardNumberInRange;
    }

    // c) кількість та список пацієнтів, номер телефону яких починається з вказаної цифри;
    public List<Patient> getPatientsWithPhoneNumberStartingWith(List<Patient> patients, int phoneNumberStartsWith) {
        List<Patient> patientsWithPhoneNumberStartingWith = new ArrayList<>();
        for (Patient patient : patients) {
            if (String.valueOf(patient.getPhoneNumber()).startsWith(String.valueOf(phoneNumberStartsWith))) {
                patientsWithPhoneNumberStartingWith.add(patient);
            }
        }
        return patientsWithPhoneNumberStartingWith;
    }

    public int countPatientsWithPhoneNumberStartingWith(List<Patient> patients, int phoneNumberStartsWith) {
        int count = 0;
        for (Patient patient : patients) {
            if (String.valueOf(patient.getPhoneNumber()).startsWith(String.valueOf(phoneNumberStartsWith))) {
                count++;
            }
        }
        return count;
    }

    // d) список діагнозів пацієнтів (без повторів) із зазначенням кількості пацієнтів, що мають цей діагноз у порядку спадання цієї кількості;
    public List<String> getDistinctDiagnosesSortedByCount(List<Patient> patients) {
        Map<String, Integer> diagnosisCountMap = new HashMap<>();
        for (Patient patient : patients) {
            String diagnosis = patient.getDiagnosis();
            diagnosisCountMap.put(diagnosis, diagnosisCountMap.getOrDefault(diagnosis, 0) + 1);
        }
        List<String> distinctDiagnoses = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(diagnosisCountMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : entryList) {
            distinctDiagnoses.add(entry.getKey() + " (" + entry.getValue() + ")");
        }
        return distinctDiagnoses;
    }

    // e) список діагнозів пацієнтів, зареєстрованих у системі без повторів;
    public Set<String> getSetOfDiagnosis(List<Patient> patients) {
        Set<String> setOfDiagnosis = new HashSet();
        for (Patient patient : patients) {
            String diagnose = patient.getDiagnosis();
            setOfDiagnosis.add(diagnose);
        }
        return setOfDiagnosis;
    }

    // f) для кожного діагнозу визначити кількість пацієнтів, яким він поставлений.
    public Map<String, Integer> countPatientsByDiagnosis(List<Patient> patients) {
        Map<String, Integer> diagnosisCountMap = new HashMap<>();
        for (Patient patient : patients) {
            String diagnosis = patient.getDiagnosis();
            if (!diagnosisCountMap.containsKey(diagnosis)) {
                diagnosisCountMap.put(diagnosis, 0);
            }
            diagnosisCountMap.put(diagnosis, diagnosisCountMap.get(diagnosis) + 1);
        }
        return diagnosisCountMap;
    }

}
