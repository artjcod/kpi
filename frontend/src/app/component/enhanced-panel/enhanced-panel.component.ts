import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-enhanced-panel',
  templateUrl: './enhanced-panel.component.html',
  styleUrls: ['./enhanced-panel.component.css']
})
export class EnhancedPanelComponent implements OnInit {

  @Input()
  cssClass: string;

  constructor() { }

  ngOnInit() {
  }

}

