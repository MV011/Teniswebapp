import {Injectable} from '@angular/core';
import {IStudent} from './student';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {ErrorHandler} from '../shared/errorhandler';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:8080/v1/students';

  constructor(private http: HttpClient) {}
  getInfo(studentId: number) {

    return this.http.get<IStudent>( this.baseUrl + `/${studentId}`);
  }

  create(reqBody: JSON): Observable<JSON> {
    return this.http.post<JSON>(this.baseUrl, reqBody).pipe(catchError(ErrorHandler.handleError));
  }
}
