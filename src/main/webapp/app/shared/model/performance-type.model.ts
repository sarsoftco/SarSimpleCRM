import { IPerformance } from 'app/shared/model/performance.model';

export interface IPerformanceType {
  id?: number;
  title?: string;
  comment?: string;
  performances?: IPerformance[];
}

export class PerformanceType implements IPerformanceType {
  constructor(public id?: number, public title?: string, public comment?: string, public performances?: IPerformance[]) {}
}
