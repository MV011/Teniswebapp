import {Injectable} from '@angular/core';
import {IFeedback} from './feedback';
import {HttpClient} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {ErrorHandler} from '../shared/errorhandler';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  private baseUrl = 'http://localhost:8080/v1/feedback';

  constructor(private http: HttpClient) {}
  getCoachFeedback(coachId: number) {

    return this.http.get<IFeedback[]>( this.baseUrl + `/${coachId}`);
  }
  createFeedback(coachId: number, studentId: number, reqBody: JSON): Observable<JSON> {

    return this.http.post<JSON>(this.baseUrl + `/${coachId}/${studentId}`, reqBody).pipe(
      catchError(ErrorHandler.handleError)
    );
  }
}
