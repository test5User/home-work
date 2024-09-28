package by.itclass.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Getter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cat {
    private String id;
    @Getter
    private String name;
    @Getter
    private int age;
    private String gender;
}
