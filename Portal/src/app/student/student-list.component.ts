import {Component, OnInit, ViewChild} from '@angular/core';
import {IStudent} from './student';
import {StudentService} from './student.service';
import {DatePipe} from '@angular/common';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

@Component({
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  studentsList: IStudent[] = [];
  errorMessage: string;
  displayedColumns: string[] = ['firstName', 'lastName'];
  dataSource: MatTableDataSource<IStudent>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private datePipe: DatePipe, private studentService: StudentService) {
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  ngOnInit() {
    this.studentService.getList().subscribe(studentsList => {
        this.studentsList = studentsList;
        this.dataSource = new MatTableDataSource(this.studentsList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      error => this.errorMessage = <any>error
    );
  }
}
