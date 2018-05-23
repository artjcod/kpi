import { Component, OnInit, AfterViewInit, Input } from '@angular/core';

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent {

  @Input()
  public ChartData: Array<any>;
  @Input()
  public ChartLabels: Array<any>;
  @Input()
  public ChartOptions: any;
  @Input()
  public ChartColors: Array<any>;
  @Input()
  public ChartLegend: boolean;
  @Input()
  public ChartType: string;

  @Input()
  title: string;
  @Input()
  subtitle: string;

  @Input()
  footerText: string;
  @Input()
  footerIconClass: string;

  @Input()
  cssClass: string;

// events
public chartClicked(e: any): void {
  console.log(e);
}

public chartHovered(e: any): void {
  console.log(e);
}

}
