import { Component } from '@angular/core';
import {Title} from '@angular/platform-browser';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private titleService: Title) {}

  public setTtile(newTitle: string) {
    this.titleService.setTitle(newTitle);
  }

}
