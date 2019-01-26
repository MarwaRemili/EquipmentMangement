import { Equipement } from './Equipement';
import { User } from './User';

export class Command{
    id:number;
    ref:string;
    student:User;
    equipement:Equipement;
    quantity:number;
    date:string;
    status:boolean;
    
    }