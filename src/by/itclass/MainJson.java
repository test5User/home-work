package by.itclass;

import by.itclass.model.Aggregator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.FileReader;

import static by.itclass.utils.Utils.filterAndSorting;

public class MainJson {
    public static final String INPUT_JSON = "src/resources/input/inpit-json.json";
    public static final String YOUNG_OUTPUT = "src/resources/output/json/young.json";
    public static final String OLD_OUTPUT = "src/resources/output/json/old.json";

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        writeJsonResults(true);
        writeJsonResults(false);
    }

    @SneakyThrows
    public static void writeJsonResults(boolean isYoung) {
        var cats = filterAndSorting(GSON.fromJson(new FileReader(INPUT_JSON), Aggregator.class).getCats(), isYoung);
        try (var os = isYoung ? new FileOutputStream(YOUNG_OUTPUT) : new FileOutputStream(OLD_OUTPUT)){
            os.write(GSON.toJson(new Aggregator(cats)).getBytes());
        }
    }
}
