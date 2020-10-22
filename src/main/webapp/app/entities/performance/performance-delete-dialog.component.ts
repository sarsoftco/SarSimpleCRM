import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IPerformance } from 'app/shared/model/performance.model';
import { PerformanceService } from './performance.service';

@Component({
  templateUrl: './performance-delete-dialog.component.html',
})
export class PerformanceDeleteDialogComponent {
  performance?: IPerformance;

  constructor(
    protected performanceService: PerformanceService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.performanceService.delete(id).subscribe(() => {
      this.eventManager.broadcast('performanceListModification');
      this.activeModal.close();
    });
  }
}
