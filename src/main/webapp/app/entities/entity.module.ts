import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'person',
        loadChildren: () => import('./person/person.module').then(m => m.SimpleCrmPersonModule),
      },
      {
        path: 'job',
        loadChildren: () => import('./job/job.module').then(m => m.SimpleCrmJobModule),
      },
      {
        path: 'performance',
        loadChildren: () => import('./performance/performance.module').then(m => m.SimpleCrmPerformanceModule),
      },
      {
        path: 'performance-type',
        loadChildren: () => import('./performance-type/performance-type.module').then(m => m.SimpleCrmPerformanceTypeModule),
      },
      {
        path: 'job-history',
        loadChildren: () => import('./job-history/job-history.module').then(m => m.SimpleCrmJobHistoryModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class SimpleCrmEntityModule {}
