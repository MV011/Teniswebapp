import {Component, OnInit} from '@angular/core';
import {TeamService} from '../team/team.service';
import {StudentService} from '../student/student.service';
import {ITeam} from '../team/team';
import {IStudent} from '../student/student';
import {FeedbackService} from './feedback.service';
import {IFeedback} from './feedback';
import { DatePipe } from '@angular/common';

@Component({
  templateUrl: './feedback.component.html',
  styleUrls: []
})
export class FeedbackComponent implements OnInit {

  teamsList: ITeam[] = [];
  errorMessage: string;
  studentsList: IStudent[] = [];
  tempStudent: IStudent;
  teamId: number;
  studentId: number;
  coachId: number;
  studentSelected = false;

  constructor(private datePipe: DatePipe,
              private feedbackService: FeedbackService,
              private teamService: TeamService,
              private studentService: StudentService) {
  }

  tempCreateFeedback(): void {
  }

  getStudentNames(): void {
    this.studentsList = [];
    this.coachId = this.teamsList[this.teamId].coachId;
    for (const student of this.teamsList[this.teamId].students) {
      this.studentService.getInfo(student.id).subscribe(
        tempStudent => {
          this.tempStudent = tempStudent;
          this.studentsList.push(tempStudent);
        },
        error => this.errorMessage = <any>error
      );
    }
  }

  ngOnInit(): void {
    this.teamsList = [];
    this.teamService.getTeams().subscribe(
      teamsList => this.teamsList = teamsList,
      error => this.errorMessage = <any>error
    );

  }
}
