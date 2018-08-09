import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {FeedbackModule} from './feedback/feedback.module';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {WelcomeComponent} from './welcome/welcome.component';
import {FeedbackComponent} from './feedback/feedback.component';
import {TeamListComponent} from './team/team-list.component';
import {TeamModule} from './team/team.module';
import {StudentAddComponent} from './student/student-add.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatCardModule, MatFormFieldModule, MatInputModule, MatNativeDateModule, MatSliderModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AdminModule} from './admin/admin.module';
import {AdminComponent} from './admin/admin.component';

@NgModule({
  declarations: [
    AppComponent, WelcomeComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, FeedbackModule, TeamModule, AdminModule,
    MatDatepickerModule, MatFormFieldModule, MatNativeDateModule, MatInputModule,
    BrowserAnimationsModule, MatSliderModule, MatCardModule,
    RouterModule.forRoot([
      {path: 'feedback', component: FeedbackComponent},
      {path: 'teams', component: TeamListComponent},
      {path: 'admin', component: AdminComponent},
      {path: 'welcome', component: WelcomeComponent},
      {path: '', redirectTo: 'welcome', pathMatch: 'full'}], {useHash: true})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
