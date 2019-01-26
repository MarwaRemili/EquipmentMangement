import { Component, OnInit } from '@angular/core';
import { CommandService } from 'src/app/Services/command.service';
import { Router } from '@angular/router';
import { Command } from 'src/app/Entities/Command';
import { EquipementServiceService } from 'src/app/Services/equipement-service.service';
import { Notification } from 'src/app/Entities/Notification';
import { User } from 'src/app/Entities/User';

@Component({
  selector: 'app-command',
  templateUrl: './command.component.html',
  styleUrls: ['./command.component.css']
})
export class CommandComponent implements OnInit {

  notif:Notification={
    "id":2,"date":"qsff","receiver":{"id":1,"name":"mohamed","lastname":"khemiri","birthdate":"23-08-1995"
    ,"email":"","adress":""},"sender":{"id":1,"name":"mohamed","lastname":"khemiri","birthdate":"23-08-1995"
    ,"email":"","adress":""},"status":0,"text":"hi"
  };
  
  commands:Command[]=[];
  constructor(private service:CommandService, private router:Router,private EqService:EquipementServiceService) {
   }

  ngOnInit() {
   this.getAllCommands();
  }
  
  getAllCommands(){
    this.service.getAllCommands().subscribe((data:Command[])=>this.commands=data);
  }
  delete(id:number){
    this.service.delete(id);
    this.delay(3000);
    this.router.navigate(['command']);
  }
  async delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
   }
   validate(command:Command)
   {
     command.status=true;
     command.equipement.quantity= command.equipement.quantity-command.quantity;
     
    console.log(this.service.validate(command));
    this.EqService.validate(command.equipement);
    this.notif.sender=command.student;
    this.notif.receiver=command.student;
    this.notif.date="12-02-2017";
    this.notif.text="your command ";
    this.notif.status=0;
    this.service.notifValid(this.notif);
   }
}
