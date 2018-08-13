import {Component, OnInit} from '@angular/core';
import {IStudent} from './student';
import {StudentService} from './student.service';
import {DatePipe} from '@angular/common';

@Component({
  templateUrl: './student-add.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentAddComponent implements OnInit {
  tempStudent: IStudent = {
    birthDate: '',
    email: '',
    firstName: '',
    id: 0,
    lastName: '',
    phoneNumber: '',
    skill: 0,
    teamId: 0
  };
  submitted = false;
  birthDate = new Date();
  errorMessage: string;

  constructor(private datePipe: DatePipe, private studentService: StudentService) {}
  ngOnInit() {
  }

  isSubmitted() {
    window.history.back();
  }
  ngOnUpdate() {
    this.submitted = true;
    this.tempStudent.birthDate = this.datePipe.transform(this.birthDate.toLocaleDateString(), 'yyy-MM-dd');
    console.log(this.tempStudent);
    this.studentService.create(JSON.parse(JSON.stringify(this.tempStudent))).subscribe(
      error => this.errorMessage = <any>error
    );
  }
}
