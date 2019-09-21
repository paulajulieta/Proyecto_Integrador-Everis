import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PlanetComponent } from './components/planet/planet.component';
import { StarComponent } from './components/star/star.component';
import { ModalComponent } from './components/modal/modal.component';


const routes: Routes = [
  //path de la ruta, Componente asociado  
     { path: 'home', component: HomeComponent },
     { path: 'planet', component: PlanetComponent },
     { path: 'star', component: StarComponent },

      { path: 'star/:id', component: ModalComponent }, 
      { path: 'planet/:id', component: ModalComponent },
      { path: 'star/', component: ModalComponent }, 
      { path: 'planet/', component: ModalComponent },
      // ruta comodin en caso de que no encuentre la ruta buscada    
   { path: '**', pathMatch: 'full', redirectTo: 'home' }   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
