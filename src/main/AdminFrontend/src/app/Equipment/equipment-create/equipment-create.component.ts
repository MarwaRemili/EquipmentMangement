import { Component, OnInit } from '@angular/core';
import { Equipement } from 'src/app/Entities/Equipement';
import { EquipementServiceService } from 'src/app/Services/equipement-service.service';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-equipment-create',
  templateUrl: './equipment-create.component.html',
  styleUrls: ['./equipment-create.component.css']
})
export class EquipmentCreateComponent implements OnInit {
//name:string="marwa";
addForm: FormGroup;
equipement:Equipement={
  id:0,name:"",description:"", quantity:0, max:0
};
  formBuilder: any;
  constructor(private service:EquipementServiceService,private router: Router) { 
    this.addForm = new FormGroup({
      name : new FormControl(''),
      description : new FormControl(''),
      quantity : new FormControl(''),
      max : new FormControl(''),
    });
  }

  ngOnInit() {
  
  this.onClick();
  }


  onClick()
  {
    console.log(this.equipement);
  }
  create()
  {
      this.service.create(this.equipement);
     this.delay(3000);
      this.router.navigate(['catalog']);
  }
  async delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
   }
 }
 
