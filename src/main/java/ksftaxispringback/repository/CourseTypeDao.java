package ksftaxispringback.repository;

import ksftaxispringback.entity.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseTypeDao extends JpaRepository<CourseType, Long> {

    @Query("SELECT c FROM CourseType c WHERE c.disableDate>CURRENT_DATE OR c.disableDate is null ")
    List<CourseType> findAllActivateServices();
}
