import { IPerformance } from 'app/shared/model/SimpleCRM/performance.model';

export interface IProduct {
  id?: number;
  title?: string;
  performances?: IPerformance[];
}

export class Product implements IProduct {
  constructor(public id?: number, public title?: string, public performances?: IPerformance[]) {}
}
