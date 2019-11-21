package ru.stqa.pft.addressbook.generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator<groups> {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<GroupData> groups = generateGroups(count);
        save(groups, file);
    }

    private static void save(List<GroupData> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private static List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupData().withName(String.format("name %s", i))
                    .withFooter(String.format("footer %s", i)).withHeader(String.format("header %s", i)));
        }
        return groups;
    }

}