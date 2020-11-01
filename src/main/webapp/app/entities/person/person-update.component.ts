import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IPerson, Person } from 'app/shared/model/person.model';
import { PersonService } from './person.service';
import { ICity } from 'app/shared/model/city.model';
import { CityService } from 'app/entities/city/city.service';

@Component({
  selector: 'jhi-person-update',
  templateUrl: './person-update.component.html',
})
export class PersonUpdateComponent implements OnInit {
  isSaving = false;
  cities: ICity[] = [];

  editForm = this.fb.group({
    id: [],
    name: [null, [Validators.required]],
    birthDate: [],
    sex: [],
    address: [],
    comment: [],
    phone: [],
    mobile: [],
    cityId: [null, Validators.required],
  });

  constructor(
    protected personService: PersonService,
    protected cityService: CityService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ person }) => {
      if (!person.id) {
        const today = moment().startOf('day');
        person.birthDate = today;
      }

      this.updateForm(person);

      this.cityService
        .query({ filter: 'person-is-null' })
        .pipe(
          map((res: HttpResponse<ICity[]>) => {
            return res.body || [];
          })
        )
        .subscribe((resBody: ICity[]) => {
          if (!person.cityId) {
            this.cities = resBody;
          } else {
            this.cityService
              .find(person.cityId)
              .pipe(
                map((subRes: HttpResponse<ICity>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: ICity[]) => (this.cities = concatRes));
          }
        });
    });
  }

  updateForm(person: IPerson): void {
    this.editForm.patchValue({
      id: person.id,
      name: person.name,
      birthDate: person.birthDate ? person.birthDate.format(DATE_TIME_FORMAT) : null,
      sex: person.sex,
      address: person.address,
      comment: person.comment,
      phone: person.phone,
      mobile: person.mobile,
      cityId: person.cityId,
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
      comment: this.editForm.get(['comment'])!.value,
      phone: this.editForm.get(['phone'])!.value,
      mobile: this.editForm.get(['mobile'])!.value,
      cityId: this.editForm.get(['cityId'])!.value,
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

  trackById(index: number, item: ICity): any {
    return item.id;
  }
}
