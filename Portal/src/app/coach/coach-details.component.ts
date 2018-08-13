import {Component, OnInit, ViewChild} from '@angular/core';
import {ICoach} from './coach';
import {CoachService} from './coach.service';
import {DatePipe} from '@angular/common';
import {ActivatedRoute} from '@angular/router';
import {MatIconRegistry} from '@angular/material';
import {DomSanitizer} from '@angular/platform-browser';
import {NgForm} from '@angular/forms';
import {IFeedback} from '../feedback/feedback';
import {FeedbackService} from '../feedback/feedback.service';
import {StudentService} from '../student/student.service';

@Component({
  templateUrl: './coach-details.component.html',
  styleUrls: ['./coach-details.component.css']
})
export class CoachDetailsComponent implements OnInit {
  selectedCoach: ICoach = {
    id: 0,
    firstName: '',
    lastName: '',
    phoneNumber: '',
    feedbackRating: 0,
    startDate: ''
  };
  feedbackList: IFeedback[] = [];
  dataReady = false;
  errorMessage: string;
  update: false;
  studentFirstName: string;
  studentLastName: string;

  constructor(private datePipe: DatePipe,
              private coachService: CoachService,
              private feedbackService: FeedbackService,
              private studentService: StudentService,
              private activatedRoute: ActivatedRoute,
              iconRegistry: MatIconRegistry,
              sanitizer: DomSanitizer) {
    iconRegistry.addSvgIcon(
      'edit',
      sanitizer.bypassSecurityTrustResourceUrl('assets/img/baseline-create-24px.svg'));
  }

  navigateBack() {
    window.history.back();
  }
  submitUpdates() {
    this.coachService.update(this.selectedCoach.id, JSON.parse(JSON.stringify(this.selectedCoach))).subscribe(
      error => this.errorMessage = <any>error
    );
  }

  getStudentDetails(studentId: number) {
    this.studentService.getInfo(studentId).subscribe(
      student => {
        this.studentFirstName = student.firstName;
        this.studentLastName = student.lastName;
      }
    );
  }

  ngOnInit() {
    console.log(this.activatedRoute.snapshot.params['id']);
    this.coachService.getInfo(this.activatedRoute.snapshot.params['id']).subscribe(
      selectedCoach => {
        this.selectedCoach = selectedCoach;
        this.feedbackService.getCoachFeedback(selectedCoach.id).subscribe(
          feedbackList => this.feedbackList = feedbackList,
          error => this.errorMessage = <any>error
        );
        this.dataReady = true;
      },
      error => this.errorMessage = <any>error
    );
  }
}
