package lab7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    private final String fileName = "patients";
    private final String fileExtension = ".json";
    private final String directory = "userfiles/";
    private final String filePath = "userfiles/patients.json";

    public FileProcessor() {
    }

    public void checkFileExists() {
        File file = new File("userfiles/patients.json");
        if (!file.exists()) {
            this.createFile();
        }

    }

    public void createFile() {
        File file = new File("userfiles/patients.json");

        try {
            file.createNewFile();
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public void writeFile(List<Patient> list) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("userfiles/patients.json"), list);
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public List<Patient> readFile() {
        File file = new File("userfiles/patients.json");
        List<Patient> list = new ArrayList();
        if (file.length() == 0L) {
            return (List)list;
        } else {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                list = (List)objectMapper.readValue(new File("userfiles/patients.json"), new TypeReference<List<Patient>>() {
                });
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            return (List)list;
        }
    }
}