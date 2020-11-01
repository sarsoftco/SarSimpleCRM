import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IProvince } from 'app/shared/model/province.model';

type EntityResponseType = HttpResponse<IProvince>;
type EntityArrayResponseType = HttpResponse<IProvince[]>;

@Injectable({ providedIn: 'root' })
export class ProvinceService {
  public resourceUrl = SERVER_API_URL + 'api/provinces';

  constructor(protected http: HttpClient) {}

  create(province: IProvince): Observable<EntityResponseType> {
    return this.http.post<IProvince>(this.resourceUrl, province, { observe: 'response' });
  }

  update(province: IProvince): Observable<EntityResponseType> {
    return this.http.put<IProvince>(this.resourceUrl, province, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IProvince>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IProvince[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
