package JavaPVT.HW_19_3;
/*
Считать список пончиков из файла example.json и вывести его на консоль.
Для этого создать класс, соответствующий объектам, хранимым в json.
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String file = "example.json";
        try {
            for (Donut donut : readerJson(file)) {
                System.out.println(donut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Donut> readerJson(String file) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(file));
        ObjectMapper objectMapper = new ObjectMapper();
        return Arrays.asList(objectMapper.readValue(jsonData, Donut[].class));
    }

}

