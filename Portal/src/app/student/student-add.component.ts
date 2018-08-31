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
    joinDate: '',
    phoneNumber: '',
    skill: 0,
    teamId: 0,
    availability: {
      day: 0,
      hour: ''
    }
  };
  submitted = false;
  birthDate = new Date();
  errorMessage: string;
  days: string[] = ['Luni', 'Marti', 'Miercuri', 'Joi', 'Vineri', 'Sambata', 'Duminica'];
  tempMinutes;
  tempHour;
  currentDate: Date = new Date(Date.now());

  constructor(private datePipe: DatePipe, private studentService: StudentService) {}
  ngOnInit() {
  }

  isSubmitted() {
    window.history.back();
  }
  ngOnUpdate() {
    console.log(this.tempHour);
    this.submitted = true;
    // this.tempStudent.birthDate = this.datePipe.transform(this.birthDate.toLocaleDateString(), 'yyy-MM-dd');
    // this.tempStudent.joinDate = this.datePipe.transform(this.currentDate.toLocaleDateString(), 'yyy-MM-dd');
    // this.tempStudent.availability.hour = this.tempHour;
    // console.log(this.tempStudent);
    // this.studentService.create(JSON.parse(JSON.stringify(this.tempStudent))).subscribe(
    //   error => this.errorMessage = <any>error
    // );
  }
}
