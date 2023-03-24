import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../models/course.model';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { catchError } from 'rxjs/operators';

//url for api
const API_URL = environment.apiUrl;
const headers = new HttpHeaders().set("Content-Type", "application/json");

@Injectable({
  providedIn: 'root'
})
export class CourseApiService {

  constructor(private http: HttpClient) { }

  createCourse(course: Course): Observable<any> {
    let body = JSON.stringify(course);
    alert(course)
    return this.http.post(API_URL + '/courses', body, { headers }).pipe(catchError(this.handleError));
  }

  getCourses(): Observable<Course[]>{
    return this.http.get<Course[]>(API_URL + '/courses', { headers }).pipe( catchError(this.handleError));
  }

  getCourseById(courseId: number): Observable<Course> {
    return this.http.get<Course>(API_URL + '/courses/' + courseId,{ headers }).pipe(catchError(this.handleError));
  }

  updateCourse(course: Course): Observable<any>{
    return this.http.put(API_URL + '/courses/' + course.id, course, {headers}).pipe(catchError(this.handleError));
  }

  deleteCourse(courseId: number): Observable<any>{
    return this.http.delete(API_URL + '/courses/'+ courseId, { headers}).pipe(catchError(this.handleError));
  }

  private  handleError(error: Response | any){
    //return observable.throw(error)
    return throwError(error);
  }
}
