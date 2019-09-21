import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HeaderComponent} from './components/header.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { PlanetComponent } from './components/planet/planet.component';
import { StarComponent } from './components/star/star.component';
 import { PlanetasService } from './servicios/planetas.service';

import {  HttpClientModule } from '@angular/common/http';
import { StarService } from './servicios/star.service';
import { ModalComponent } from './components/modal/modal.component';
import { ModalService } from './servicios/modal.service';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    PlanetComponent,
    StarComponent,
    ModalComponent

    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PlanetasService,StarService,ModalService], 
  bootstrap: [AppComponent]
})
export class AppModule { }
