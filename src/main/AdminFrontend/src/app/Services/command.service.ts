import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Command } from '../Entities/Command';
import { Notification } from 'src/app/Entities/Notification';


@Injectable({
  providedIn: 'root'
})
export class CommandService {

  constructor(private http: HttpClient) { }
  getAllCommands(){
    return this.http.get("http://localhost:8080/command/all");
  }
  delete(id:number){
    
    this.http.delete("http://localhost:8080/command/delete/"+id).subscribe();
  }
  getUnvalidated(){
    return this.http.get("http://localhost:8080/command/unvalidated");
  }
  validate(c:Command){

    this.http.post("http://localhost:8080/command/validate",c)
    .subscribe((data)=>{console.log(data);},(error)=>{console.log(error);});
  }

  notifValid(n:Notification){
    this.http.post("http://localhost:8080/notification/add",n)
    .subscribe((data)=>{console.log(data);},(error)=>{console.log(error);});
  }
}
