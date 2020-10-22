import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IPerson, Person } from 'app/shared/model/person.model';
import { PersonService } from './person.service';

@Component({
  selector: 'jhi-person-update',
  templateUrl: './person-update.component.html',
})
export class PersonUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    name: [null, [Validators.required]],
    birthDate: [],
    sex: [],
    address: [],
    mapLocationLat: [],
    mapLocationLng: [],
    comment: [],
  });

  constructor(protected personService: PersonService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ person }) => {
      if (!person.id) {
        const today = moment().startOf('day');
        person.birthDate = today;
      }

      this.updateForm(person);
    });
  }

  updateForm(person: IPerson): void {
    this.editForm.patchValue({
      id: person.id,
      name: person.name,
      birthDate: person.birthDate ? person.birthDate.format(DATE_TIME_FORMAT) : null,
      sex: person.sex,
      address: person.address,
      mapLocationLat: person.mapLocationLat,
      mapLocationLng: person.mapLocationLng,
      comment: person.comment,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const person = this.createFromForm();
    if (person.id !== undefined) {
      this.subscribeToSaveResponse(this.personService.update(person));
    } else {
      this.subscribeToSaveResponse(this.personService.create(person));
    }
  }

  private createFromForm(): IPerson {
    return {
      ...new Person(),
      id: this.editForm.get(['id'])!.value,
      name: this.editForm.get(['name'])!.value,
      birthDate: this.editForm.get(['birthDate'])!.value ? moment(this.editForm.get(['birthDate'])!.value, DATE_TIME_FORMAT) : undefined,
      sex: this.editForm.get(['sex'])!.value,
      address: this.editForm.get(['address'])!.value,
      mapLocationLat: this.editForm.get(['mapLocationLat'])!.value,
      mapLocationLng: this.editForm.get(['mapLocationLng'])!.value,
      comment: this.editForm.get(['comment'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPerson>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
