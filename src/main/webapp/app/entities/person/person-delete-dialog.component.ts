import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IPerson } from 'app/shared/model/person.model';
import { PersonService } from './person.service';

@Component({
  templateUrl: './person-delete-dialog.component.html',
})
export class PersonDeleteDialogComponent {
  person?: IPerson;

  constructor(protected personService: PersonService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.personService.delete(id).subscribe(() => {
      this.eventManager.broadcast('personListModification');
      this.activeModal.close();
    });
  }
}
