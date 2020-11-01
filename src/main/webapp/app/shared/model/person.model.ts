import { Moment } from 'moment';
import { IJob } from 'app/shared/model/SimpleCRM/job.model';
import { IPerformance } from 'app/shared/model/SimpleCRM/performance.model';
import { SexEnum } from 'app/shared/model/enumerations/sex-enum.model';

export interface IPerson {
  id?: number;
  name?: string;
  birthDate?: Moment;
  sex?: SexEnum;
  address?: string;
  comment?: string;
  phone?: string;
  mobile?: string;
  jobs?: IJob[];
  performances?: IPerformance[];
  cityId?: number;
}

export class Person implements IPerson {
  constructor(
    public id?: number,
    public name?: string,
    public birthDate?: Moment,
    public sex?: SexEnum,
    public address?: string,
    public comment?: string,
    public phone?: string,
    public mobile?: string,
    public jobs?: IJob[],
    public performances?: IPerformance[],
    public cityId?: number
  ) {}
}
