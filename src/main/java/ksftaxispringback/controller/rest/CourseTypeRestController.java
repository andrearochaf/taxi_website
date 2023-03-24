package ksftaxispringback.controller.rest;

import ksftaxispringback.entity.CourseType;
import ksftaxispringback.entity.dto.CourseTypeDto;
import ksftaxispringback.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseTypeRestController {

    private CourseTypeService courseTypeService;

    @GetMapping("/courses")
    public List<CourseType> findAllActiveCourseType() {
        return courseTypeService.findAllActivatedCourseType();
    }

    @PostMapping("/courseType")
    public CourseType saveService(@RequestBody CourseTypeDto courseTypeDto) {
        return courseTypeService.saveCourseType(courseTypeDto);
    }

    /// Setters ///

    @Autowired
    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

}
