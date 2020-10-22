import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IPerformanceType } from 'app/shared/model/performance-type.model';
import { PerformanceTypeService } from './performance-type.service';

@Component({
  templateUrl: './performance-type-delete-dialog.component.html',
})
export class PerformanceTypeDeleteDialogComponent {
  performanceType?: IPerformanceType;

  constructor(
    protected performanceTypeService: PerformanceTypeService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.performanceTypeService.delete(id).subscribe(() => {
      this.eventManager.broadcast('performanceTypeListModification');
      this.activeModal.close();
    });
  }
}
