import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {FeedbackModule} from './feedback/feedback.module';
import {FeedbackComponent} from './feedback/feedback.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, FeedbackModule
  ],
  providers: [],
  bootstrap: [AppComponent, FeedbackComponent]
})
export class AppModule {
}
