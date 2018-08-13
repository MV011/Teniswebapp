import {Component, OnInit} from '@angular/core';
import {ICoach} from './coach';
import {CoachService} from './coach.service';
import {DatePipe} from '@angular/common';

@Component({
  templateUrl: './coach-add.component.html',
  styleUrls: ['./coach-add.component.css']
})
export class CoachAddComponent implements OnInit {
  tempCoach: ICoach = {
    firstName: '',
    id: 0,
    lastName: '',
    phoneNumber: '',
    startDate: '',
    feedbackRating: 0
  };
  submitted = false;
  startDate = new Date();
  errorMessage: string;

  constructor(private datePipe: DatePipe, private coachService: CoachService) {}
  ngOnInit() {
  }

  isSubmitted() {
    console.log('Submitted');
  }
  ngOnUpdate() {
    this.submitted = true;
    this.tempCoach.startDate = this.datePipe.transform(this.startDate.toLocaleDateString(), 'yyy-MM-dd');
    console.log(this.tempCoach);
    this.coachService.create(JSON.parse(JSON.stringify(this.tempCoach))).subscribe(
      error => this.errorMessage = <any>error
    );
    console.log(this.startDate.toLocaleDateString('ro-RO'));
  }
}
