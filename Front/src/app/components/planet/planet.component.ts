import { Component, OnInit } from '@angular/core';
import { PlanetasService } from 'src/app/servicios/planetas.service';
import { Router } from '@angular/router';
import { Planet } from 'src/model/planet';

@Component({
  selector: 'app-planet',
  templateUrl: './planet.component.html',
  styleUrls: ['./planet.component.css']
})
export class PlanetComponent implements OnInit {
   planetas:Planet[] = [];
  constructor(private servicioPlaneta: PlanetasService,private router:Router) { //,, private router:Router
      this.getAll();
      
   }
  
  ngOnInit(   ) {
    // this.planetas = this._planetService.getPlanetas();
    // console.log(this.planetas);
  }

  getAll(){
    this.servicioPlaneta.getAll().subscribe((data)=>{
      this.planetas = data; 
      console.log(this.planetas);
    }   );
    
  }
  delete(id:number){
    this.servicioPlaneta.delete(id).subscribe(()=>{
              window.location.reload();
     });
  }
  update(id:number){
    this.router.navigate(["planet/"+ id]);
  }
  
  agregar(){
    
    this.router.navigate(["planet/nuevo"]);
    

  }
}
