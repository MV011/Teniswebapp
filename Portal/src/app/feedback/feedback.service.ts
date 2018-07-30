import {Injectable} from '@angular/core';
import {IFeedback} from './feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  getFeedback(coachId: number): IFeedback[] {

    return null;
  }
}
