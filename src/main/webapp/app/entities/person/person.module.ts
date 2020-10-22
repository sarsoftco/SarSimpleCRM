import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SimpleCrmSharedModule } from 'app/shared/shared.module';
import { PersonComponent } from './person.component';
import { PersonDetailComponent } from './person-detail.component';
import { PersonUpdateComponent } from './person-update.component';
import { PersonDeleteDialogComponent } from './person-delete-dialog.component';
import { personRoute } from './person.route';

@NgModule({
  imports: [SimpleCrmSharedModule, RouterModule.forChild(personRoute)],
  declarations: [PersonComponent, PersonDetailComponent, PersonUpdateComponent, PersonDeleteDialogComponent],
  entryComponents: [PersonDeleteDialogComponent],
})
export class SimpleCrmPersonModule {}
