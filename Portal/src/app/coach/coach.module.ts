import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {CoachAddComponent} from './coach-add.component';
import {RouterModule} from '@angular/router';
import {
  MatCardModule,
  MatDatepickerModule, MatExpansionModule,
  MatFormFieldModule,
  MatInputModule,
  MatNativeDateModule, MatPaginatorModule, MatProgressSpinnerModule,
  MatSliderModule, MatTableModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {CoachListComponent} from './coach-list.component';
import {CoachDetailsComponent} from './coach-details.component';
@NgModule({
  declarations: [
    CoachAddComponent, CoachListComponent, CoachDetailsComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule,
    MatDatepickerModule, MatFormFieldModule, MatNativeDateModule, MatInputModule,
    BrowserAnimationsModule, MatSliderModule, MatCardModule, MatTableModule,
    MatPaginatorModule, MatExpansionModule, MatProgressSpinnerModule, MatExpansionModule,
    RouterModule.forChild(
      [
        {path: 'admin/coaches/:id', component: CoachDetailsComponent},
        {path: 'admin/coaches/add', component: CoachAddComponent}
      ]
    )
  ],
  providers: [],
  exports: [CoachListComponent]
})
export class CoachModule {
}
