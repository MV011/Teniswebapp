import {Component, OnInit, ViewChild} from '@angular/core';
import {ICoach} from './coach';
import {CoachService} from './coach.service';
import {DatePipe} from '@angular/common';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

@Component({
  templateUrl: './coach-list.component.html',
  styleUrls: ['./coach-list.component.css']
})
export class CoachListComponent implements OnInit {

  coachList: ICoach[] = [];
  errorMessage: string;
  displayedColumns: string[] = ['firstName', 'lastName', 'feedbackRating'];
  dataSource: MatTableDataSource<ICoach>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private datePipe: DatePipe, private coachService: CoachService) {
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  ngOnInit() {
    this.coachService.getList().subscribe(coachList => {
        this.coachList = coachList;
        this.dataSource = new MatTableDataSource(this.coachList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      error => this.errorMessage = <any>error
    );
  }
}
