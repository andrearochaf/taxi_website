package ksftaxispringback.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate disableDate;
    private String lienImage;

    public CourseType(String name, String description, String lienImage) {
        this.name = name;
        this.description = description;
        this.lienImage = lienImage;
    }

    public CourseType() {
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDisableDate() {
        return disableDate;
    }
    public String getLienImage() {
        return lienImage;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }
    public void setDisableDate(LocalDate disableDate) {
        this.disableDate = disableDate;
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "disableDate=" + disableDate +
                '}';
    }
}
