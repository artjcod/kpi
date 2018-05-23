import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  @Input()
  cssClass: string;
  @Input()
  body: string;

  @Input()
  withSetting = false;

  @Input()
  settingTemplate: string;

  @Input()
  title: string;
  constructor() { }

  ngOnInit() {
  }

}
