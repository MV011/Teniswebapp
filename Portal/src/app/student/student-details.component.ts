import {Component, OnInit, ViewChild} from '@angular/core';
import {IStudent} from './student';
import {StudentService} from './student.service';
import {DatePipe} from '@angular/common';
import {ActivatedRoute} from '@angular/router';

@Component({
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-add.component.css']
})
export class StudentDetailsComponent implements OnInit {
  selectedStudent: IStudent = {
    id: 0,
    firstName: '',
    lastName: '',
    email: '',
    phoneNumber: '',
    birthDate: '',
    skill: 0,
    teamId: 0
  };
  dataReady = false;
  errorMessage: string;
  update: boolean[] = [false, false, false, false, false, false];
  updateSet = new Set(this.update);

  constructor(private datePipe: DatePipe,
              private studentService: StudentService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    console.log(this.activatedRoute.snapshot.params['id']);
    this.studentService.getInfo(this.activatedRoute.snapshot.params['id']).subscribe(
      selectedStudent => {
        this.selectedStudent = selectedStudent;
        this.dataReady = true;
      },
      error => this.errorMessage = <any>error
    );
  }
}
