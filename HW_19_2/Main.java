package JavaPVT.HW_19_2;
/*
Создать класс Person с полями firstname, age.
Создать класс Family c полями типа Person mother, father, список children, строка lastname.
Создать список объектов класса Family и записать его в json. Название json файла,
в который будет записываться список, передавать программе как параметр.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Family> families = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            families.add(new FamilyPerson()
                    .addLastName("Family" + i)
                    .addFather(new Person("Father " + i, new Random().nextInt(10) + 18))
                    .addMother(new Person("Mother " + i, new Random().nextInt(10) + 18))
                    .addChildren(new Person("ChildOne " + i, new Random().nextInt(3) + 3))
                    .addChildren(new Person("ChildTwo " + i, new Random().nextInt(3) + 3))
                    .addChildren(new Person("ChildThree " + i, new Random().nextInt(3) + 3))
                    .createFamily());
        }
        File file = new File("families.json");
        try {
            jsonWriter(families, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void jsonWriter(List<Family> families, File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(file, families);
    }
}
