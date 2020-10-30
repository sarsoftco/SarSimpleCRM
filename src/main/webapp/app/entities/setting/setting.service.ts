import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ISetting } from 'app/shared/model/setting.model';

type EntityResponseType = HttpResponse<ISetting>;
type EntityArrayResponseType = HttpResponse<ISetting[]>;

@Injectable({ providedIn: 'root' })
export class SettingService {
  public resourceUrl = SERVER_API_URL + 'api/settings';

  constructor(protected http: HttpClient) {}

  create(setting: ISetting): Observable<EntityResponseType> {
    return this.http.post<ISetting>(this.resourceUrl, setting, { observe: 'response' });
  }

  update(setting: ISetting): Observable<EntityResponseType> {
    return this.http.put<ISetting>(this.resourceUrl, setting, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ISetting>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ISetting[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
