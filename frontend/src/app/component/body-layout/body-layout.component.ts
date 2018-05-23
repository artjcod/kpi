import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-body-layout',
  templateUrl: './body-layout.component.html',
  styleUrls: ['./body-layout.component.css']
})
export class BodyLayoutComponent implements OnInit {

  bluePieChartId: string;
  bluePieChartTitle: string;
  bluePieChartDataPercent = 92;
  orangePieChartId: string;
  orangePieChartTitle: string;
  orangePieChartDataPercent = 65;
  tealPieChartId: string;
  tealPieChartTitle: string;
  tealPieChartDataPercent = 56;
  redPieChartId: string;
  redPieChartTitle: string;
  redPieChartDataPercent = 30;

  settingtemplate = `<li><a href="#"><em class="fa fa-cog"></em> Settings 1</a></li>
  <li class="divider"></li>
  <li><a href="#"><em class="fa fa-cog"></em> Settings 2</a></li>
  <li class="divider"></li>
  <li><a href="#"><em class="fa fa-cog"></em> Settings 3</a></li>` ;

  ChartData: Array<any> = [
    {data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A'},
    {data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B'},
    {data: [18, 48, 77, 9, 100, 27, 40], label: 'Series C'}
  ];

  public doughnutChartLabels: Array<any>  = ['Download Sales', 'In-Store Sales', 'Mail-Order Sales'];
  public doughnutChartData: Array<any>  = [ { data: [65, 59, 80] }
  ];
  public doughnutChartType = 'doughnut';

  ChartLabels: Array<any> = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

  ChartOptions: any = {
    responsive: true
  };

  ChartLegend = true;

  ChartColors: Array<any> = [
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    },
    { // dark grey
      backgroundColor: 'rgba(77,83,96,0.2)',
      borderColor: 'rgba(77,83,96,1)',
      pointBackgroundColor: 'rgba(77,83,96,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(77,83,96,1)'
    },
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
  ];


  constructor() {
    this.bluePieChartId = 'easypiechart-blue';
    this.bluePieChartTitle = 'Failed Executions';
    this.orangePieChartId = 'easypiechart-orange';
    this.orangePieChartTitle = 'Successful Executions';
    this.tealPieChartId = 'easypiechart-teal';
    this.tealPieChartTitle = 'Indicators';
    this.redPieChartId = 'easypiechart-red';
    this.redPieChartTitle = 'Configurations';
   }

  ngOnInit() {
  }

}
