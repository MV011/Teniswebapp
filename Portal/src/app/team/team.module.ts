import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {TeamListComponent} from './team-list.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [TeamListComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule,
  ],
  providers: [],
  exports: [TeamListComponent]
})
export class TeamModule {
}
