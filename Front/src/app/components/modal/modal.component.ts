import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgModule } from '@angular/core';
import { Planet } from 'src/model/planet';
import { Star } from 'src/model/star';
import { StarService } from 'src/app/servicios/star.service';
import { PlanetasService } from 'src/app/servicios/planetas.service';
@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
resultado:string;
  planet:Planet={
    id:0,
    name:" ",
    size:0,
    star: null,
  }

star: Star={
  id: 0,
  nombre: "",
  densidad: 0,
}
  

 

  constructor(private route: ActivatedRoute, private starSer : StarService, private router:Router, private planetService: PlanetasService ) {
    
   // if(route.snapshot){}
  // console.log(route.snapshot.url[0].path);
  this.resultado = route.snapshot.url[0].path;



    this.route.params.subscribe( (data)=>{
      if(data['id'] != "nuevo" ){
        this.getOne(data['id']);
      }
    }


    )
   }
   
  ngOnInit() {
  //  bootstrapValidate('#nombre','alphanum:no puede estar vacio este campo');
  }
  cerrar(){
    window.location.reload(); //cambiar
  }

  add(){ 
    if(this.resultado == 'star'){
      this.starSer.post(this.star).subscribe( (data)=>{
        this.cerrar();
        this.router.navigate(['/']);
      });  
      
    } else if(this.resultado == 'planet'){
      this.planetService.post(this.planet).subscribe((data)=>{
        this.cerrar();
        this.router.navigate(['/']);
      });
    }

}
  update(id:number){
    if(this.resultado == 'star'){ 
    this.starSer.put(id, this.star).subscribe( (data)=>{
     // this.cerrar();
      this.router.navigate(['/']);
      });
    } else if(this.resultado == 'planet'){
      this.planetService.put(id, this.planet).subscribe((data)=>{
        this.router.navigate(['/']);

      });
    
    }
  }
  getOne(id:number){
    if(this.resultado == 'star'){
    this.starSer.getOne(id).subscribe((data)=>{
    this.star = data;
    });   
  } else if(this.resultado == 'planet'){
      this.planetService.getOne(id).subscribe((data)=>{
        this.planet = data;
      });

  }

}

  save(){

    if(this.resultado == 'star'){
    this.route.params.subscribe((data)=>{
      if(data['id'] =="nuevo" ){
        this.add();
      }
      else {
        this.update(data['id']);
      }
  
     });    
    } else if(this.resultado == 'planet'){
      this.route.params.subscribe((data)=>{
        if(data['id'] =="nuevo" ){
          this.add();
        }
        else {
          this.update(data['id']);
        }
    
       });
    }



  }
}
