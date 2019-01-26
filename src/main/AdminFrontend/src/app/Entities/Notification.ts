import { User } from './User';

export class Notification {
    id:number;
    sender:User;
    receiver: User;
    text:string;
    status:number;
    date:string;
}