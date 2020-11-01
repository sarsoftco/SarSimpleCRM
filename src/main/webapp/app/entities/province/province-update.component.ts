import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IProvince, Province } from 'app/shared/model/province.model';
import { ProvinceService } from './province.service';

@Component({
  selector: 'jhi-province-update',
  templateUrl: './province-update.component.html',
})
export class ProvinceUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    title: [null, [Validators.required]],
  });

  constructor(protected provinceService: ProvinceService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ province }) => {
      this.updateForm(province);
    });
  }

  updateForm(province: IProvince): void {
    this.editForm.patchValue({
      id: province.id,
      title: province.title,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const province = this.createFromForm();
    if (province.id !== undefined) {
      this.subscribeToSaveResponse(this.provinceService.update(province));
    } else {
      this.subscribeToSaveResponse(this.provinceService.create(province));
    }
  }

  private createFromForm(): IProvince {
    return {
      ...new Province(),
      id: this.editForm.get(['id'])!.value,
      title: this.editForm.get(['title'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IProvince>>): void {
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
