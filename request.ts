import { NeedyPeople } from "./needy-people";

export class Request {
    id!: number;
    title!: string;
    description!: string;
    raised!: number;
    goal!: number;
    msg!:string | undefined;
    status!: boolean;
    amount!: number;
    needyPeople!: NeedyPeople;
    needyPersonId !: number;
}
