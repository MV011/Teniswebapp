import {Injectable} from '@angular/core';
import {ICoach} from './coach';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {ErrorHandler} from '../shared/errorhandler';

@Injectable({
  providedIn: 'root'
})
export class CoachService {

  private baseUrl = 'http://localhost:8080/v1/coaches';

  constructor(private http: HttpClient) {}
  getInfo(coachId: number) {

    return this.http.get<ICoach>( this.baseUrl + `/${coachId}`);
  }

  getList() {
    return this.http.get<ICoach[]>(this.baseUrl);
  }

  update(coachId: number, reqBody: JSON): Observable<JSON> {
    return this.http.put<JSON>(this.baseUrl + `/${coachId}`, reqBody).pipe(catchError(ErrorHandler.handleError));
  }

  create(reqBody: JSON): Observable<JSON> {
    return this.http.post<JSON>(this.baseUrl, reqBody).pipe(catchError(ErrorHandler.handleError));
  }
}
