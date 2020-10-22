import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IPerformance, Performance } from 'app/shared/model/performance.model';
import { PerformanceService } from './performance.service';
import { PerformanceComponent } from './performance.component';
import { PerformanceDetailComponent } from './performance-detail.component';
import { PerformanceUpdateComponent } from './performance-update.component';

@Injectable({ providedIn: 'root' })
export class PerformanceResolve implements Resolve<IPerformance> {
  constructor(private service: PerformanceService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IPerformance> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((performance: HttpResponse<Performance>) => {
          if (performance.body) {
            return of(performance.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Performance());
  }
}

export const performanceRoute: Routes = [
  {
    path: '',
    component: PerformanceComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'simpleCrmApp.performance.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: PerformanceDetailComponent,
    resolve: {
      performance: PerformanceResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.performance.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: PerformanceUpdateComponent,
    resolve: {
      performance: PerformanceResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.performance.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: PerformanceUpdateComponent,
    resolve: {
      performance: PerformanceResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.performance.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
