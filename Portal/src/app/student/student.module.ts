import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {StudentAddComponent} from './student-add.component';
import {RouterModule} from '@angular/router';
import {
  MatCardModule, MatCellDef,
  MatDatepickerModule, MatExpansionModule,
  MatFormFieldModule,
  MatInputModule,
  MatNativeDateModule, MatPaginatorModule, MatProgressSpinnerModule, MatSelectModule,
  MatSliderModule, MatTableModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {StudentListComponent} from './student-list.component';
import {StudentDetailsComponent} from './student-details.component';
import {Angular5TimePickerModule} from 'angular5-time-picker';

@NgModule({
  declarations: [
    StudentAddComponent, StudentListComponent, StudentDetailsComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule,
    MatDatepickerModule, MatFormFieldModule, MatNativeDateModule, MatInputModule,
    BrowserAnimationsModule, MatSliderModule, MatCardModule, MatTableModule,
    MatPaginatorModule, MatExpansionModule, MatProgressSpinnerModule, MatSelectModule, Angular5TimePickerModule,
    RouterModule.forChild(
      [
        {path: 'admin/students/add', component: StudentAddComponent},
        {path: 'admin/students/:id', component: StudentDetailsComponent}
      ]
    )
  ],
  providers: [],
  exports: [StudentListComponent]
})
export class StudentModule {
}
