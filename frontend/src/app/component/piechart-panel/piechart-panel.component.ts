import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-piechart-panel',
  templateUrl: './piechart-panel.component.html',
  styleUrls: ['./piechart-panel.component.css']
})
export class PiechartPanelComponent implements OnInit {

  @Input() title: string;
  @Input() htmlId: string;
  @Input() data_percent: number;

  constructor() { }

  ngOnInit() {
  }

}
