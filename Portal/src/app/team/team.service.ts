import {Injectable} from '@angular/core';
import {ITeam} from './team';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {ErrorHandler} from '../shared/errorhandler';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private baseUrl = 'http://localhost:8080/v1/teams';

  constructor(private http: HttpClient) {}

  getTeams(): Observable<ITeam[]> {

    // origin: ${this.router.url}
    return this.http.get<ITeam[]>(this.baseUrl).pipe(
      // tap(data => console.log('All: ' + JSON.stringify(data))),
      catchError(ErrorHandler.handleError)
    );
  }
}
