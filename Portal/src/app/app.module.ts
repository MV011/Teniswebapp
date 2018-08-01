import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {FeedbackModule} from './feedback/feedback.module';
import {FeedbackComponent} from './feedback/feedback.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, FeedbackModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent, FeedbackComponent]
})
export class AppModule {
}
