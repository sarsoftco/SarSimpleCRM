import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IPerformanceType, PerformanceType } from 'app/shared/model/performance-type.model';
import { PerformanceTypeService } from './performance-type.service';

@Component({
  selector: 'jhi-performance-type-update',
  templateUrl: './performance-type-update.component.html',
})
export class PerformanceTypeUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    title: [null, [Validators.required]],
    comment: [],
  });

  constructor(
    protected performanceTypeService: PerformanceTypeService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ performanceType }) => {
      this.updateForm(performanceType);
    });
  }

  updateForm(performanceType: IPerformanceType): void {
    this.editForm.patchValue({
      id: performanceType.id,
      title: performanceType.title,
      comment: performanceType.comment,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const performanceType = this.createFromForm();
    if (performanceType.id !== undefined) {
      this.subscribeToSaveResponse(this.performanceTypeService.update(performanceType));
    } else {
      this.subscribeToSaveResponse(this.performanceTypeService.create(performanceType));
    }
  }

  private createFromForm(): IPerformanceType {
    return {
      ...new PerformanceType(),
      id: this.editForm.get(['id'])!.value,
      title: this.editForm.get(['title'])!.value,
      comment: this.editForm.get(['comment'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPerformanceType>>): void {
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
