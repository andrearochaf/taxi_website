package ksftaxispringback.entity.dto;

import java.time.LocalDate;

public class CourseTypeDto {

    private String name;
    private String description;
    private LocalDate disableDate;
    private String lienImage;

    public CourseTypeDto() {
    }

    public CourseTypeDto(String name, String description, String lienImage) {
        this.name = name;
        this.description = description;
        this.lienImage = lienImage;
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

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDisableDate(LocalDate disableDate) {
        this.disableDate = disableDate;
    }
    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }
}
