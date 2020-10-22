import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IPerformanceType } from 'app/shared/model/performance-type.model';

type EntityResponseType = HttpResponse<IPerformanceType>;
type EntityArrayResponseType = HttpResponse<IPerformanceType[]>;

@Injectable({ providedIn: 'root' })
export class PerformanceTypeService {
  public resourceUrl = SERVER_API_URL + 'api/performance-types';

  constructor(protected http: HttpClient) {}

  create(performanceType: IPerformanceType): Observable<EntityResponseType> {
    return this.http.post<IPerformanceType>(this.resourceUrl, performanceType, { observe: 'response' });
  }

  update(performanceType: IPerformanceType): Observable<EntityResponseType> {
    return this.http.put<IPerformanceType>(this.resourceUrl, performanceType, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IPerformanceType>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IPerformanceType[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
