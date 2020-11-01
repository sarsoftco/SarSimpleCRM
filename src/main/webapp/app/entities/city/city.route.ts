import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ICity, City } from 'app/shared/model/city.model';
import { CityService } from './city.service';
import { CityComponent } from './city.component';
import { CityDetailComponent } from './city-detail.component';
import { CityUpdateComponent } from './city-update.component';

@Injectable({ providedIn: 'root' })
export class CityResolve implements Resolve<ICity> {
  constructor(private service: CityService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICity> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((city: HttpResponse<City>) => {
          if (city.body) {
            return of(city.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new City());
  }
}

export const cityRoute: Routes = [
  {
    path: '',
    component: CityComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'simpleCrmApp.city.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: CityDetailComponent,
    resolve: {
      city: CityResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.city.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: CityUpdateComponent,
    resolve: {
      city: CityResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.city.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: CityUpdateComponent,
    resolve: {
      city: CityResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.city.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
