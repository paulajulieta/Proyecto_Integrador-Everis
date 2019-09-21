import { Injectable } from "@angular/core"; 
import { HttpClient, HttpParams } from '@angular/common/http';
import { Planet } from 'src/model/planet';
import { Observable } from 'rxjs';
 
@Injectable() export class PlanetasService{ 
         _url:string = 'http://localhost:9001/api/v1/planets/';
        //  public planeta:Planet;
        //  public planetas : Planet[] = [];

    constructor(private http:HttpClient){
        
    }
    getAll():Observable<Planet[]>{
        return this.http.get<Planet[]>( this._url)  ;
    }
    getOne(id: number):Observable<Planet>{
      return  this.http.get<Planet>(this._url + id);
    }
 
    post(planet:Planet):Observable<Planet>{
      return  this.http.post<Planet>(this._url,planet);
    }
    put(id:number,planet:Planet ):Observable<Planet>{
      return  this.http.post<Planet>(this._url,planet);
    }
    delete(id:number):Observable<any>{
       return this.http.delete(this._url + id);
    }
    // update(){

    // }
 
 } 

