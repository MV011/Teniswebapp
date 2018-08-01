import {Component, OnInit} from '@angular/core';
import {TeamService} from '../team/team.service';
import {StudentService} from '../student/student.service';
import {ITeam} from '../team/team';
import {IStudent} from '../student/student';

@Component({
  selector: 'active-component',
  templateUrl: './feedback.component.html',
  styleUrls: []
})
export class FeedbackComponent implements OnInit {

  teamsList: ITeam[] = [];
  errorMessage: string;
  constructor(private teamService: TeamService, private studentService: StudentService) {
  }

  studentsList: IStudent[] = [];
  tempStudent: IStudent;
  teamId: number;

  getStudentNames(): void {
    this.studentsList = [];
    for (const student of this.teamsList[this.teamId - 1].students) {
      console.log(this.teamId);
      this.studentService.getInfo(student.id).subscribe(
        tempStudent => {
          this.tempStudent = tempStudent;
          console.log(JSON.stringify(tempStudent));
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
