import { Component, OnInit, Input } from '@angular/core';
import { KpiConfiguration } from '../../shared/kpi-configuration';

@Component({
  selector: 'app-custombox',
  templateUrl: './custombox.component.html',
  styleUrls: ['./custombox.component.css']
})
export class CustomboxComponent implements OnInit {

  @Input()
  title: string;
  @Input()
  subtitle: string;
  @Input()
  configuration: KpiConfiguration;

  constructor() { }

  ngOnInit() {

  }



}
