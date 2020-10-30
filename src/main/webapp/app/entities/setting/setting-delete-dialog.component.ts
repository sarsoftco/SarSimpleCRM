import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ISetting } from 'app/shared/model/setting.model';
import { SettingService } from './setting.service';

@Component({
  templateUrl: './setting-delete-dialog.component.html',
})
export class SettingDeleteDialogComponent {
  setting?: ISetting;

  constructor(protected settingService: SettingService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.settingService.delete(id).subscribe(() => {
      this.eventManager.broadcast('settingListModification');
      this.activeModal.close();
    });
  }
}
