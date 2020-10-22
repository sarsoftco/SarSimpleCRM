import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IPerformanceType, PerformanceType } from 'app/shared/model/performance-type.model';
import { PerformanceTypeService } from './performance-type.service';
import { PerformanceTypeComponent } from './performance-type.component';
import { PerformanceTypeDetailComponent } from './performance-type-detail.component';
import { PerformanceTypeUpdateComponent } from './performance-type-update.component';

@Injectable({ providedIn: 'root' })
export class PerformanceTypeResolve implements Resolve<IPerformanceType> {
  constructor(private service: PerformanceTypeService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IPerformanceType> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((performanceType: HttpResponse<PerformanceType>) => {
          if (performanceType.body) {
            return of(performanceType.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new PerformanceType());
  }
}

export const performanceTypeRoute: Routes = [
  {
    path: '',
    component: PerformanceTypeComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'simpleCrmApp.performanceType.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: PerformanceTypeDetailComponent,
    resolve: {
      performanceType: PerformanceTypeResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.performanceType.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: PerformanceTypeUpdateComponent,
    resolve: {
      performanceType: PerformanceTypeResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.performanceType.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: PerformanceTypeUpdateComponent,
    resolve: {
      performanceType: PerformanceTypeResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.performanceType.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
