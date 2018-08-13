import { NgModule } from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {DatePipe} from '@angular/common';
import {RouterModule} from '@angular/router';
import {StudentAddComponent} from '../student/student-add.component';
import {StudentModule} from '../student/student.module';
import {AdminComponent} from './admin.component';
import {CoachModule} from '../coach/coach.module';
import {StudentListComponent} from '../student/student-list.component';
import {CoachListComponent} from '../coach/coach-list.component';

@NgModule({
  declarations: [AdminComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, StudentModule, CoachModule, RouterModule.forChild([
      { path: 'admin/students', component: StudentListComponent },
      { path: 'admin/coaches', component: CoachListComponent }
    ])
  ],
  exports: [],
  providers: [DatePipe],
})
export class AdminModule { }
