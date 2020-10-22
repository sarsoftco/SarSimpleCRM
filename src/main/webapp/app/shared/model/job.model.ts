import { Moment } from 'moment';
import { IJobHistory } from 'app/shared/model/job-history.model';
import { PriorityEnum } from 'app/shared/model/enumerations/priority-enum.model';

export interface IJob {
  id?: number;
  title?: string;
  createDate?: Moment;
  doneDate?: Moment;
  comment?: string;
  periority?: PriorityEnum;
  performanceId?: number;
  jobHistories?: IJobHistory[];
  creatorId?: number;
}

export class Job implements IJob {
  constructor(
    public id?: number,
    public title?: string,
    public createDate?: Moment,
    public doneDate?: Moment,
    public comment?: string,
    public periority?: PriorityEnum,
    public performanceId?: number,
    public jobHistories?: IJobHistory[],
    public creatorId?: number
  ) {}
}
