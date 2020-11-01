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
      {
        path: 'setting',
        loadChildren: () => import('./setting/setting.module').then(m => m.SimpleCrmSettingModule),
      },
      {
        path: 'province',
        loadChildren: () => import('./province/province.module').then(m => m.SimpleCrmProvinceModule),
      },
      {
        path: 'city',
        loadChildren: () => import('./city/city.module').then(m => m.SimpleCrmCityModule),
      },
      {
        path: 'product',
        loadChildren: () => import('./product/product.module').then(m => m.SimpleCrmProductModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class SimpleCrmEntityModule {}
