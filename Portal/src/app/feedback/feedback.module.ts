import { NgModule } from '@angular/core';

import { FeedbackComponent} from './feedback.component';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {DatePipe} from '@angular/common';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    FeedbackComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, RouterModule
  ],
  exports: [FeedbackComponent],
  providers: [DatePipe],
})
export class FeedbackModule { }
