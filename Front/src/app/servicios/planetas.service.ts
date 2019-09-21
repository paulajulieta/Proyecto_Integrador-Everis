import { Injectable } from "@angular/core"; 
import { HttpClient, HttpParams } from '@angular/common/http';
import { Planet } from 'src/model/planet';
import { Observable } from 'rxjs';
 
@Injectable() export class PlanetasService{ 
         _url:string = 'http://localhost:9001/api/v1/planets/';
         public planeta:Planet;
         public planetas : Planet[] = [];
    // private planetas:Planeta[] =[
    //     {id:"1", nombre:"Tierra",size: "22", star:"luna" },{id:"2", nombre:"Marte", size:"2",star:"lala"  }
    // ]
    constructor(private http:HttpClient){
        
    }
    getAll():Observable<Planet[]>{
        return this.http.get<Planet[]>( this._url)  ;
    }
    getOne(id: number){
        this.http.get(this._url + id);
    }
 
    post(planet:Planet ){
        this.http.post(this._url,planet);
    }
    put(id:number,planet:Planet ){
        this.http.post(this._url,planet);
    }
    delete(id:number):Observable<any>{
       return this.http.delete(this._url + id);
    }
    update(){

    }
 
 } 

