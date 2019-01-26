import { Component, OnInit, Input } from '@angular/core';
import { EquipementServiceService } from 'src/app/Services/equipement-service.service';
import { Equipement } from 'src/app/Entities/Equipement';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators,FormControl,} from "@angular/forms";
import {first} from "rxjs/operators";


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  //@Input() eqid:number;
  @Input() equi: Equipement=
  {
    id:0,name:"mohamed",description:"khemiri", quantity:0, max:0,
  };
  equipement: Equipement=
  {
    id:0,name:"",description:"", quantity:0, max:0,
  };
  
  // email = new FormControl('');
  //firstName = new FormControl('');
  //lastName = new FormControl('');
  constructor(private service: EquipementServiceService, private router: Router,private formBuilder: FormBuilder) 
  {  // this.getEquipmentById(29);
  }

  ngOnInit() {
    
   
  }


Edit()
{
  this.service.edit(this.equipement);
      this.router.navigate(['catalog']);
    
}

  getEquipmentById(){
    this.service.getEquipmentById(this.equi.id).subscribe((data:Equipement)=>this.equipement=data);
    
   }

}
