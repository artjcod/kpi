import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ChartsModule } from 'ng2-charts';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PagerService } from './service/pager.service';
import { PerformanceService } from './service/performance.service';
import { CardComponentComponent } from './component/card-component/card-component.component';
import { BodyLayoutComponent } from './component/body-layout/body-layout.component';
import { HeaderLayoutComponent } from './component/header-layout/header-layout.component';
import { SidebarLayoutComponent } from './component/sidebar-layout/sidebar-layout.component';
import { ArticleComponent } from './component/article/article.component';
import { EnhancedPanelComponent } from './component/enhanced-panel/enhanced-panel.component';
import { PiechartPanelComponent } from './component/piechart-panel/piechart-panel.component';
import { ChartComponent } from './component/chart/chart.component';
import { CardComponent } from './component/card/card.component';
import { KpiComponent } from './component/kpi/kpi.component';
import { CustomboxComponent } from './component/custombox/custombox.component';
import { BreadcrumbComponent } from './component/breadcrumb/breadcrumb.component';
import { WelcomeComponent } from './component/welcome/welcome.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { FullCalendarModule } from 'ng-fullcalendar';
import { CalendarWrapperComponent } from './component/calendar-wrapper/calendar-wrapper.component';


@NgModule({
  declarations: [
    AppComponent,
    CardComponentComponent,
    BodyLayoutComponent,
    HeaderLayoutComponent,
    SidebarLayoutComponent,
    CalendarWrapperComponent,
    ArticleComponent,
    EnhancedPanelComponent,
    PiechartPanelComponent,
    ChartComponent,
    CardComponent,
    KpiComponent,
    CustomboxComponent,
    BreadcrumbComponent,
    WelcomeComponent,
    PageNotFoundComponent
  ],
  entryComponents: [],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule.forRoot(),
    AngularFontAwesomeModule,
    ChartsModule,
    HttpClientModule,
    FormsModule,
    FullCalendarModule
  ],
  providers: [
    PerformanceService , PagerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
