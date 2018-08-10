import { NgModule } from '@angular/core';

import { FeedbackComponent} from './feedback.component';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {DatePipe} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FeedbackAddComponent} from './feedback-add.component';
import {MatRadioModule} from '@angular/material/radio';
import {MatCardModule, MatFormFieldModule, MatInputModule, MatSelectModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    FeedbackComponent, FeedbackAddComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, MatRadioModule, MatFormFieldModule,
    MatInputModule, BrowserAnimationsModule, MatCardModule, MatSelectModule,
    RouterModule.forChild(
      [{path: 'feedback/add/:studentId/:coachId', component: FeedbackAddComponent}
      ]
    )
  ],
  exports: [FeedbackComponent],
  providers: [DatePipe],
})
export class FeedbackModule { }
