import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {CoachAddComponent} from './coach-add.component';
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
    CoachAddComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule,
    MatDatepickerModule, MatFormFieldModule, MatNativeDateModule, MatInputModule,
    BrowserAnimationsModule, MatSliderModule, MatCardModule,
    RouterModule
  ],
  providers: [],
  exports: [CoachAddComponent]
})
export class CoachModule {
}
