import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IPerformance } from 'app/shared/model/performance.model';

type EntityResponseType = HttpResponse<IPerformance>;
type EntityArrayResponseType = HttpResponse<IPerformance[]>;

@Injectable({ providedIn: 'root' })
export class PerformanceService {
  public resourceUrl = SERVER_API_URL + 'api/performances';

  constructor(protected http: HttpClient) {}

  create(performance: IPerformance): Observable<EntityResponseType> {
    return this.http.post<IPerformance>(this.resourceUrl, performance, { observe: 'response' });
  }

  update(performance: IPerformance): Observable<EntityResponseType> {
    return this.http.put<IPerformance>(this.resourceUrl, performance, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IPerformance>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IPerformance[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
