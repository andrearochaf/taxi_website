package ksftaxispringback.CourseTypeTest;

import ksftaxispringback.entity.CourseType;
import ksftaxispringback.entity.dto.CourseTypeDto;
import ksftaxispringback.service.CourseTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CoursesTypeServiceTest {

    private CourseTypeService courseTypeService;
    private CourseTypeDto courseTypeDto = new CourseTypeDto();

    @BeforeEach
    public void setup(){
        courseTypeDto.setName("AEROPORT");
        courseTypeDto.setDescription("vers l'infini et l'au dela");
        courseTypeDto.setLienImage("lien");
    }


    @Test
    void shouldSaveACourseType() {
        CourseType courseTypeToSave = courseTypeService.saveCourseType(courseTypeDto);
        assertNotNull(courseTypeToSave);
        assertEquals(courseTypeDto.getName(), courseTypeToSave.getName());
    }


//    @Test
//    public void shouldUpdateACourseType(){
//
//    }

//    @Test
//    void findAllActivatedCourseType() {
//        List<CourseType> courseTypesFounded = courseTypeService.findAllActivatedCourseType();
//        assertNotNull(courseTypesFounded);
//    }

    @Autowired
    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }
}
