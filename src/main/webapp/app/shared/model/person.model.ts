import { Moment } from 'moment';
import { IJob } from 'app/shared/model/job.model';
import { IPerformance } from 'app/shared/model/performance.model';
import { SexEnum } from 'app/shared/model/enumerations/sex-enum.model';

export interface IPerson {
  id?: number;
  name?: string;
  birthDate?: Moment;
  sex?: SexEnum;
  address?: string;
  phone?: string;
  mobile?: string;
  comment?: string;
  jobs?: IJob[];
  performances?: IPerformance[];
}

export class Person implements IPerson {
  constructor(
    public id?: number,
    public name?: string,
    public birthDate?: Moment,
    public sex?: SexEnum,
    public address?: string,
    public phone?: string,
    public mobile?: string,
    public comment?: string,
    public jobs?: IJob[],
    public performances?: IPerformance[]
  ) {}
}
