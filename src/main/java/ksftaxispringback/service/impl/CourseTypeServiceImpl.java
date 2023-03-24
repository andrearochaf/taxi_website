package ksftaxispringback.service.impl;

import ksftaxispringback.entity.CourseType;
import ksftaxispringback.entity.dto.CourseTypeDto;
import ksftaxispringback.repository.CourseTypeDao;
import ksftaxispringback.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    private CourseTypeDao courseTypeDao;

    @Override
    public List<CourseType> findAllActivatedCourseType() {
        return courseTypeDao.findAllActivateServices();
    }

    @Override
    public CourseType saveCourseType(CourseTypeDto courseTypeDto) {
        CourseType courseType = new CourseType(courseTypeDto.getName(), courseTypeDto.getDescription(),courseTypeDto.getLienImage());
        courseTypeDao.save(courseType);
        return courseType;
    }



    @Autowired
    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }
}
