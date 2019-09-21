import { Component, OnInit } from '@angular/core';
import { Star } from 'src/model/star';
import { StarService } from 'src/app/servicios/star.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-star',
  templateUrl: './star.component.html',
  styleUrls: ['./star.component.css']
})
export class StarComponent implements OnInit {
  stars: Star[]=[];

  constructor(private servicioStar:StarService,private router:Router) { 
    this.getAll();
  }

  ngOnInit() {
  }
  getAll(){
    this.servicioStar.getAll().subscribe((data)=>{
      this.stars = data; 
      console.log(this.stars);
    }   );
    
  }
  delete(id:number){
    this.servicioStar.delete(id).subscribe(()=>{
      console.log("delete exitoso");
      window.location.reload();
     });
  }
  update(id:number){
      this.router.navigate(["star/"+ id]);
    }

    agregar(){
      this.router.navigate(["star/nuevo"]);
    }

}
