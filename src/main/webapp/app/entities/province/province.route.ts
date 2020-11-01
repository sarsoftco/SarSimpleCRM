import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IProvince, Province } from 'app/shared/model/province.model';
import { ProvinceService } from './province.service';
import { ProvinceComponent } from './province.component';
import { ProvinceDetailComponent } from './province-detail.component';
import { ProvinceUpdateComponent } from './province-update.component';

@Injectable({ providedIn: 'root' })
export class ProvinceResolve implements Resolve<IProvince> {
  constructor(private service: ProvinceService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IProvince> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((province: HttpResponse<Province>) => {
          if (province.body) {
            return of(province.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Province());
  }
}

export const provinceRoute: Routes = [
  {
    path: '',
    component: ProvinceComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'simpleCrmApp.province.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: ProvinceDetailComponent,
    resolve: {
      province: ProvinceResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.province.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: ProvinceUpdateComponent,
    resolve: {
      province: ProvinceResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.province.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: ProvinceUpdateComponent,
    resolve: {
      province: ProvinceResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.province.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
