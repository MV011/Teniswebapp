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

  constructor(private datePipe: DatePipe,
              private feedbackService: FeedbackService,
              private teamService: TeamService,
              private studentService: StudentService) {
  }

  getNextDates(): void {

    for(const team of this.teamsList) {

      const tempDate = new Date(Date.parse(team.dateTime.firstOccurrence));

      console.log(tempDate.getDay());

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
            team.students = studentsList;
          }
        }
        this.getNextDates();
      },
      error => this.errorMessage = <any>error
    );

  }
}
