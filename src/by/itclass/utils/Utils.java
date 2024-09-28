package by.itclass.utils;

import by.itclass.model.Aggregator;
import by.itclass.model.Cat;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.List;

public class Utils {
    public static final String INPUT = "src/resources/input/input-xml.xml";
    public static final String YOUNG_OUTPUT = "src/resources/output/xml/young.xml";
    public static final String OLD_OUTPUT = "src/resources/output/xml/old.xml";

    @SneakyThrows
    public static List<Cat> readFile() {
        var unmarshaller = JAXBContext.newInstance(Aggregator.class).createUnmarshaller();
        return ((Aggregator) unmarshaller.unmarshal(new FileReader(INPUT))).getCats();
    }

    public static List<Cat> filterAndSorting(List<Cat> participant, boolean isYoung) {
        return participant.stream()
                .filter(isYoung ? it -> it.getAge() <= 3 : it -> it.getAge() > 3)
                .sorted(Comparator.comparingInt(Cat::getAge).thenComparing(Cat::getName))
                .toList();
    }

    @SneakyThrows
    public static void writeXmlResults(boolean isYoung) {
        var aggregator = new Aggregator(filterAndSorting(readFile(), isYoung));

        var jaxbContext = JAXBContext.newInstance(Aggregator.class);
        var marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(aggregator, isYoung ? new FileWriter(YOUNG_OUTPUT) : new FileWriter(OLD_OUTPUT));
    }
}
