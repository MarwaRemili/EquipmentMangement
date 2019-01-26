import { Component, OnInit } from '@angular/core';
import { EquipementServiceService } from 'src/app/Services/equipement-service.service';
import { Equipement } from 'src/app/Entities/Equipement';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {

  equipements:Equipement[]=[];
  eq:Equipement={
    id:0,name:"",description:"", quantity:0, max:0
  };
  editVisible:boolean=false;
  equi:Equipement;
  constructor(private service:EquipementServiceService, private router:Router)
  { 
    
  }

  ngOnInit() {
    this.getAllEquipements();
  
  }
  getAllEquipements(){
   this.service.getAllEquipements().subscribe((data:Equipement[])=>this.equipements=data);
   

  }
  delete(id:number){
    this.service.delete(id);
    this.delay(3000);
    this.router.navigate(['EquipmentCreate']);
    //this.router.navigate(['catalog']);
  }

 
  async delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
   }
   edit(equ:Equipement){
   // localStorage.removeItem("editeqId");
    //localStorage.setItem("editeqId", equ.id.toString());
    this.equi=equ;
    this.editVisible=!this.editVisible;
    //this.router.navigate(['edit']);
   }
   addNew(){
    this.router.navigate(['EquipmentCreate']);
   }
}
