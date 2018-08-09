import {Component, OnInit} from '@angular/core';
import {ITeam} from './team';
import {DatePipe} from '@angular/common';
import {FeedbackService} from '../feedback/feedback.service';
import {TeamService} from './team.service';
import {StudentService} from '../student/student.service';
import {IStudent} from '../student/student';


@Component({
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.css']
})
export class TeamListComponent implements OnInit {
  teamsList: ITeam[] = [];
  errorMessage: string;
  nextDates: string[] = [];
  dataReady = false;
  emptyStudent: IStudent = {
    id: 0,
    firstName: 'Unassigned',
    lastName: '',
    birthDate : 'null',
    email : 'null',
    phoneNumber : 'null',
    skill : 0,
    teamId : 0
};

  constructor(private datePipe: DatePipe,
              private feedbackService: FeedbackService,
              private teamService: TeamService,
              private studentService: StudentService) {
  }

  getNextDates(): void {

    for (const team of this.teamsList) {

      const tempDate = new Date(Date.parse(team.dateTime.firstOccurrence));
      const today = new Date(Date.now());
      const nextDate = new Date();

      if (tempDate.getDay() >= today.getDay()) {
        nextDate.setDate(today.getDate() + (tempDate.getDay() - today.getDay()));
      } else {
        nextDate.setDate(today.getDate() + (7 - today.getDay() + tempDate.getDay()));
      }
      this.nextDates.push(nextDate.toLocaleDateString('ro-RO'));
    }
  }

  ngOnInit(): void {
    this.teamsList = [];
    this.teamService.getTeams().subscribe(
      teamsList => {
        this.teamsList = teamsList;
        for (const team of this.teamsList) {
          const studentsList: IStudent[] = [];
          let tempStudent: IStudent;
          for (const student of team.students) {
            this.studentService.getInfo(student.id).subscribe(
              temp => {
                tempStudent = temp;
                studentsList.push(tempStudent);
              },
              error => this.errorMessage = <any>error
            );
          }
          for (let i = team.students.length; i < 4; i++) {
            studentsList.push(this.emptyStudent);
          }
          team.students = studentsList;
        }
        this.getNextDates();
        this.dataReady = true;
      },
      error => this.errorMessage = <any>error
    );

  }
}
