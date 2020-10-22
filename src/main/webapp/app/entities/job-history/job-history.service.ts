import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IJobHistory } from 'app/shared/model/job-history.model';

type EntityResponseType = HttpResponse<IJobHistory>;
type EntityArrayResponseType = HttpResponse<IJobHistory[]>;

@Injectable({ providedIn: 'root' })
export class JobHistoryService {
  public resourceUrl = SERVER_API_URL + 'api/job-histories';

  constructor(protected http: HttpClient) {}

  create(jobHistory: IJobHistory): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(jobHistory);
    return this.http
      .post<IJobHistory>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(jobHistory: IJobHistory): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(jobHistory);
    return this.http
      .put<IJobHistory>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IJobHistory>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IJobHistory[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(jobHistory: IJobHistory): IJobHistory {
    const copy: IJobHistory = Object.assign({}, jobHistory, {
      doDate: jobHistory.doDate && jobHistory.doDate.isValid() ? jobHistory.doDate.toJSON() : undefined,
      expireDate: jobHistory.expireDate && jobHistory.expireDate.isValid() ? jobHistory.expireDate.toJSON() : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.doDate = res.body.doDate ? moment(res.body.doDate) : undefined;
      res.body.expireDate = res.body.expireDate ? moment(res.body.expireDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((jobHistory: IJobHistory) => {
        jobHistory.doDate = jobHistory.doDate ? moment(jobHistory.doDate) : undefined;
        jobHistory.expireDate = jobHistory.expireDate ? moment(jobHistory.expireDate) : undefined;
      });
    }
    return res;
  }
}
