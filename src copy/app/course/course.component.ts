import { Component, OnInit } from '@angular/core';
import { Course } from '../models/course.model';
import { CourseApiService }   from '../services/course-api.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit{

  constructor(private api: CourseApiService){}

    ngOnInit(): void {
        this.getCourses();
    }

    _courses: Course[] = [];

    getCourses(){
      console.log("Je suis dans le getCourses");
    this.api.getCourses().subscribe(data => {this._courses = data});
  }
  
  selectCourse(course: Course){
    console.log('Vous avez selectionné '+ course.name);
  }

}
