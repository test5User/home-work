package by.itclass.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "cats")
public class Aggregator {
    @Getter
    @XmlElement(name = "cat")
    private List<Cat> cats;
}
