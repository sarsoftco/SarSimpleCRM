import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IProvince } from 'app/shared/model/province.model';
import { ProvinceService } from './province.service';

@Component({
  templateUrl: './province-delete-dialog.component.html',
})
export class ProvinceDeleteDialogComponent {
  province?: IProvince;

  constructor(protected provinceService: ProvinceService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.provinceService.delete(id).subscribe(() => {
      this.eventManager.broadcast('provinceListModification');
      this.activeModal.close();
    });
  }
}
