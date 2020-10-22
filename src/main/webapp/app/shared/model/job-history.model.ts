import { Moment } from 'moment';

export interface IJobHistory {
  id?: number;
  doDate?: Moment;
  expireDate?: Moment;
  comment?: string;
  progressPercent?: number;
  performerId?: number;
  jobId?: number;
}

export class JobHistory implements IJobHistory {
  constructor(
    public id?: number,
    public doDate?: Moment,
    public expireDate?: Moment,
    public comment?: string,
    public progressPercent?: number,
    public performerId?: number,
    public jobId?: number
  ) {}
}
