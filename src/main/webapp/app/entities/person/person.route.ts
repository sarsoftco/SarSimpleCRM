import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IPerson, Person } from 'app/shared/model/person.model';
import { PersonService } from './person.service';
import { PersonComponent } from './person.component';
import { PersonDetailComponent } from './person-detail.component';
import { PersonUpdateComponent } from './person-update.component';

@Injectable({ providedIn: 'root' })
export class PersonResolve implements Resolve<IPerson> {
  constructor(private service: PersonService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IPerson> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((person: HttpResponse<Person>) => {
          if (person.body) {
            return of(person.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Person());
  }
}

export const personRoute: Routes = [
  {
    path: '',
    component: PersonComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'simpleCrmApp.person.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: PersonDetailComponent,
    resolve: {
      person: PersonResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.person.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: PersonUpdateComponent,
    resolve: {
      person: PersonResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.person.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: PersonUpdateComponent,
    resolve: {
      person: PersonResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'simpleCrmApp.person.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
