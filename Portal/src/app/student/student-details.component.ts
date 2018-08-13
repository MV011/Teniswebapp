import {Component, OnInit, ViewChild} from '@angular/core';
import {IStudent} from './student';
import {StudentService} from './student.service';
import {DatePipe} from '@angular/common';
import {ActivatedRoute} from '@angular/router';
import {MatIconRegistry} from '@angular/material';
import {DomSanitizer} from '@angular/platform-browser';
import {NgForm} from '@angular/forms';

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
  update: false;

  constructor(private datePipe: DatePipe,
              private studentService: StudentService,
              private activatedRoute: ActivatedRoute,
              iconRegistry: MatIconRegistry,
              sanitizer: DomSanitizer) {
    iconRegistry.addSvgIcon(
      'edit',
      sanitizer.bypassSecurityTrustResourceUrl('assets/img/baseline-create-24px.svg'));
  }

  submitUpdates() {
    this.studentService.updateStudent(this.selectedStudent.id, JSON.parse(JSON.stringify(this.selectedStudent))).subscribe(
      error => this.errorMessage = <any>error
    );
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
