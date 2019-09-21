import { Injectable } from "@angular/core"; 
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Star } from 'src/model/star';

@Injectable() export class StarService{ 
    _url:string = 'http://localhost:9001/api/v1/stars/';

    constructor(private http:HttpClient){
        
    }
    ngOnInit(){}
    getAll():Observable<Star[]>{
        return this.http.get<Star[]>( this._url)  ;
    }
    getOne(id: number):Observable<Star>{
      return  this.http.get<Star>(this._url + id);
    }
 
    post(star:Star ):Observable<Star> {
        return this.http.post<Star>(this._url,star);
    }

    put(id:number,star:Star):Observable<Star>{
      return  this.http.post<Star>(this._url,star);
    }
    delete(id:number):Observable<any>{
        return this.http.delete(this._url + id);
    }
}    