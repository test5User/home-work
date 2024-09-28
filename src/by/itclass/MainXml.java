package by.itclass;

import java.io.IOException;

import static by.itclass.utils.Utils.writeXmlResults;

public class MainXml {
    public static void main(String[] args) throws IOException {
        writeXmlResults(true);
        writeXmlResults(false);
    }
}
