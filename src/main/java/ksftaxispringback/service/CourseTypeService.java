package ksftaxispringback.service;

import ksftaxispringback.entity.CourseType;
import ksftaxispringback.entity.dto.CourseTypeDto;

import java.util.List;

public interface CourseTypeService {

    List<CourseType> findAllActivatedCourseType();
    CourseType saveCourseType(CourseTypeDto courseTypeDto);
}
