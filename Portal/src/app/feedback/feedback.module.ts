import { NgModule } from '@angular/core';

import { FeedbackComponent} from './feedback.component';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    FeedbackComponent
  ],
  imports: [
    BrowserModule, HttpClientModule
  ],
  exports: [
  ],
  providers: [],
  bootstrap: [FeedbackComponent]
})
export class FeedbackModule { }
