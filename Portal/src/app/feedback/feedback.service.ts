import {Injectable} from '@angular/core';
import {IFeedback} from './feedback';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  private baseUrl = 'localhost/v1/feedback';

  constructor(private http: HttpClient) {}
  getCoachFeedback(coachId: number) {

    return this.http.get<IFeedback[]>( this.baseUrl + `/${coachId}`);
  }
}
