import {Injectable} from '@angular/core';
import {IStudent} from './student';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:8080/v1/students';

  constructor(private http: HttpClient) {}
  getInfo(studentId: number) {

    return this.http.get<IStudent>( this.baseUrl + `/${studentId}`);
  }
}
