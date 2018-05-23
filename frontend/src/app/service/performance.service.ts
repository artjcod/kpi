import { Injectable } from '@angular/core';
import { delay, map, mergeMap, filter } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { PagerService } from './pager.service';
import { Indicator } from '../shared/indicator';
import { AppComponent } from '../app.component';

@Injectable({
  providedIn: 'root'
})

export class PerformanceService {

  constructor(public http: HttpClient, public _pagerService: PagerService) { }


  public getIndicators(term: string = null): Observable<Indicator[]> {
   return this.http.get<Indicator[]>(AppComponent.API_URL + '/api/indicators').pipe(
     map((response) => {
      return response.filter(x => x.name.search(term) > -1);
     }));
  }

}
