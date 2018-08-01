import {HttpErrorResponse} from '@angular/common/http';
import {throwError} from 'rxjs';

export class ErrorHandler {

  static handleError(err: HttpErrorResponse) {
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      errorMessage = `${err.error.message}`;
    } else {
      errorMessage = `${err.status}: ${err.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }
}
