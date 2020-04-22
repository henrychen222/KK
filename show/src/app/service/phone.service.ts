import {Injectable} from '@angular/core';
import {Combination} from '../model/combination';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {baseUrl} from '../../environments/environment';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PhoneService {

  constructor(private http: HttpClient) {
  }

  getCombination(phoneNumber: string): Observable<Combination> {
    const url = `${baseUrl}/getAllCombinations/${phoneNumber}`;  // path parameter
    return this.http.get<Combination>(url)
      .pipe(catchError(this.handleError<Combination>('Error in getting combinations')));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  private log(message: string) {
    console.log('error' + message);
  }
}
