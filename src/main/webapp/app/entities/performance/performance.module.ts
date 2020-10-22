import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SimpleCrmSharedModule } from 'app/shared/shared.module';
import { PerformanceComponent } from './performance.component';
import { PerformanceDetailComponent } from './performance-detail.component';
import { PerformanceUpdateComponent } from './performance-update.component';
import { PerformanceDeleteDialogComponent } from './performance-delete-dialog.component';
import { performanceRoute } from './performance.route';

@NgModule({
  imports: [SimpleCrmSharedModule, RouterModule.forChild(performanceRoute)],
  declarations: [PerformanceComponent, PerformanceDetailComponent, PerformanceUpdateComponent, PerformanceDeleteDialogComponent],
  entryComponents: [PerformanceDeleteDialogComponent],
})
export class SimpleCrmPerformanceModule {}
