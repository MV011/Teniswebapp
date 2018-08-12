import { NgModule } from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {DatePipe} from '@angular/common';
import {RouterModule} from '@angular/router';
import {StudentAddComponent} from '../student/student-add.component';
import {StudentModule} from '../student/student.module';
import {AdminComponent} from './admin.component';
import {CoachAddComponent} from '../coach/coach-add.component';
import {CoachModule} from '../coach/coach.module';
import {StudentListComponent} from '../student/student-list.component';

@NgModule({
  declarations: [AdminComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, StudentModule, CoachModule, RouterModule.forChild([
      { path: 'admin/students', component: StudentListComponent },
      { path: 'admin/coaches', component: CoachAddComponent }
    ])
  ],
  exports: [],
  providers: [DatePipe],
})
export class AdminModule { }
