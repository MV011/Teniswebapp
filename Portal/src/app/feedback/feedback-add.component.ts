import {Component, OnInit} from '@angular/core';
import {IFeedback} from './feedback';
import {FeedbackService} from './feedback.service';
import {DatePipe} from '@angular/common';
import {ActivatedRoute} from '@angular/router';

@Component({
  templateUrl: './feedback-add.component.html',
  styleUrls: []
})
export class FeedbackAddComponent implements OnInit {

  tempDate = new Date(Date.now());
  tempFeedback: IFeedback = null;
  errorMessage: string;
  rating: number;
  description: string;
  ratingSelected = false;

  constructor(private datePipe: DatePipe,
              private feedbackService: FeedbackService,
              private activatedRoute: ActivatedRoute) {
  }

  submitFeedback() {
    this.tempFeedback.description = this.description;
    this.tempFeedback.rating = this.rating;
    this.feedbackService.createFeedback(this.tempFeedback.coachID,
      this.tempFeedback.studentID, JSON.parse(JSON.stringify(this.tempFeedback)))
      .subscribe(
        error => this.errorMessage = <any>error
      );
  }

  ngOnInit() {
    this.tempFeedback = {
      id: 0,
      dateTime: this.datePipe.transform(this.tempDate.toLocaleDateString(), 'yyy-MM-dd'),
      studentID: this.activatedRoute.snapshot.params['studentId'],
      coachID: this.activatedRoute.snapshot.params['coachId'],
      rating: 0,
      description: ''
    };
  }
}
