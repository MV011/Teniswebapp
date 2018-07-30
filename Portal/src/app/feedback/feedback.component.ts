import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const source: Observable<[]>;

@Component({
  selector: 'active-component',
  templateUrl: './feedback.component.html',
  styleUrls: []
})
export class FeedbackComponent {


  source.pipe()
  studentsList: any[] = [
    { firstName: 'Test',
      lastName: 'Name'},
    { firstName: 'Test2',
      lastName: 'Name2'}
  ];
}
