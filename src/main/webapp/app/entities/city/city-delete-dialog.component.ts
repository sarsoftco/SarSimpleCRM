import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICity } from 'app/shared/model/city.model';
import { CityService } from './city.service';

@Component({
  templateUrl: './city-delete-dialog.component.html',
})
export class CityDeleteDialogComponent {
  city?: ICity;

  constructor(protected cityService: CityService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.cityService.delete(id).subscribe(() => {
      this.eventManager.broadcast('cityListModification');
      this.activeModal.close();
    });
  }
}
