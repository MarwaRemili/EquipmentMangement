import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Equipement } from '../Entities/Equipement';


@Injectable({
  providedIn: 'root'
})
export class EquipementServiceService {

  constructor(private http: HttpClient) { }

  create(eq:Equipement)
  {
      this.http.post("http://localhost:8080/equipement/add",eq)
      .subscribe((data)=>{console.log(data);},(error)=>{console.log(error);});
  }
  getAllEquipements(){
    return this.http.get("http://localhost:8080/equipement/all");
  }
  delete(id:number){
    console.log("marwa");
    this.http.delete("http://localhost:8080/equipement/delete/"+id).subscribe();
  }
  edit(eq: Equipement) {
    return this.http.post("http://localhost:8080/equipement/edit",eq)
    .subscribe((data)=>{console.log(data);},(error)=>{console.log(error);});
  }
  getEquipmentById(id:number){
    return this.http.get("http://localhost:8080/equipement/get/"+ id);
    

  }
  validate(e:Equipement){

    this.http.post("http://localhost:8080/equipement/validate",e)
    .subscribe((data)=>{console.log(data);},(error)=>{console.log(error);});
  }


}
