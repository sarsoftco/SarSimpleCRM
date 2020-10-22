import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SimpleCrmSharedModule } from 'app/shared/shared.module';
import { PerformanceTypeComponent } from './performance-type.component';
import { PerformanceTypeDetailComponent } from './performance-type-detail.component';
import { PerformanceTypeUpdateComponent } from './performance-type-update.component';
import { PerformanceTypeDeleteDialogComponent } from './performance-type-delete-dialog.component';
import { performanceTypeRoute } from './performance-type.route';

@NgModule({
  imports: [SimpleCrmSharedModule, RouterModule.forChild(performanceTypeRoute)],
  declarations: [
    PerformanceTypeComponent,
    PerformanceTypeDetailComponent,
    PerformanceTypeUpdateComponent,
    PerformanceTypeDeleteDialogComponent,
  ],
  entryComponents: [PerformanceTypeDeleteDialogComponent],
})
export class SimpleCrmPerformanceTypeModule {}
