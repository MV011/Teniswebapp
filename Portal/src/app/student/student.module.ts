import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {StudentAddComponent} from './student-add.component';
import {RouterModule} from '@angular/router';
import {
  MatCardModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatInputModule,
  MatNativeDateModule,
  MatSliderModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
@NgModule({
  declarations: [
    StudentAddComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule,
    MatDatepickerModule, MatFormFieldModule, MatNativeDateModule, MatInputModule,
    BrowserAnimationsModule, MatSliderModule, MatCardModule,
    RouterModule
  ],
  providers: [],
  exports: [StudentAddComponent]
})
export class StudentModule {
}
