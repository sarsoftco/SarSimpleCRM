export interface IPerformance {
  id?: number;
  comment?: string;
  jobId?: number;
  personId?: number;
  performanceTypeId?: number;
}

export class Performance implements IPerformance {
  constructor(
    public id?: number,
    public comment?: string,
    public jobId?: number,
    public personId?: number,
    public performanceTypeId?: number
  ) {}
}
