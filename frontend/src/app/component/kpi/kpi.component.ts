import { Component, OnInit, ViewChild, ElementRef, AfterViewInit, ChangeDetectorRef } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { tap, distinctUntilChanged, debounceTime, switchMap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Indicator } from '../../shared/indicator';
import { PagerService } from '../../service/pager.service';
import { PerformanceService } from '../../service/performance.service';
import { AppComponent } from '../../app.component';
import { KpiConfiguration } from '../../shared/kpi-configuration';

@Component({
  selector: 'app-kpi',
  templateUrl: './kpi.component.html',
  styleUrls: ['./kpi.component.css']
})
export class KpiComponent implements OnInit {
  indicators: Indicator[] = [];
  selectedindicators: Indicator[] = [];

  pager: any = {};
  pagedItems: any[];
  closeResult: string;
  value: KpiConfiguration;
  clicked = false;
  constructor(public http: HttpClient, public _service: PerformanceService,
     public _pagerService: PagerService) { }

  ngOnInit() {
    this.loadPerformanceKeyByPage();
    this.value = new KpiConfiguration();
    }

public loadPerformanceKeyByPage() {
  this.http.get<any[]>(AppComponent.API_URL + '/api/indicators')
   // map((response: Response) => response.json())
  .subscribe(data => {
              // set items to json response
              this.indicators = data;
              // initialize to page 1
               this.setPage(1);
          });
}
 setPage(page: number) {
  // get pager object from service
  this.pager = this._pagerService.getPager(this.indicators.length, page);

  // get current page of items
  this.pagedItems = this.indicators.slice(this.pager.startIndex, this.pager.endIndex + 1);
}

addPerfKey(item) {
this.selectedindicators.push(item);
this.value.indicators = this.selectedindicators;
this.clicked = true;
}
removePerfKey(item) {
  this.selectedindicators.splice(this.selectedindicators.indexOf(item), 1);
  this.value.indicators = this.selectedindicators;
  this.clicked = false;

 }
 clickHandler(item) {
   if (this.isClicked(item)) {
    this.removePerfKey(item);
    console.log('remove');

   } else {
     this.addPerfKey(item);
     console.log('add');
    }
 }

 isClicked(item): boolean {
   return this.selectedindicators.indexOf(item) > -1;
 }
}
