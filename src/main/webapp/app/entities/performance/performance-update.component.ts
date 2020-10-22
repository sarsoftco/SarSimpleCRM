import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IPerformance, Performance } from 'app/shared/model/performance.model';
import { PerformanceService } from './performance.service';
import { IPerson } from 'app/shared/model/person.model';
import { PersonService } from 'app/entities/person/person.service';
import { IPerformanceType } from 'app/shared/model/performance-type.model';
import { PerformanceTypeService } from 'app/entities/performance-type/performance-type.service';

type SelectableEntity = IPerson | IPerformanceType;

@Component({
  selector: 'jhi-performance-update',
  templateUrl: './performance-update.component.html',
})
export class PerformanceUpdateComponent implements OnInit {
  isSaving = false;
  people: IPerson[] = [];
  performancetypes: IPerformanceType[] = [];

  editForm = this.fb.group({
    id: [],
    comment: [],
    personId: [null, Validators.required],
    performanceTypeId: [null, Validators.required],
  });

  constructor(
    protected performanceService: PerformanceService,
    protected personService: PersonService,
    protected performanceTypeService: PerformanceTypeService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ performance }) => {
      this.updateForm(performance);

      this.personService.query().subscribe((res: HttpResponse<IPerson[]>) => (this.people = res.body || []));

      this.performanceTypeService.query().subscribe((res: HttpResponse<IPerformanceType[]>) => (this.performancetypes = res.body || []));
    });
  }

  updateForm(performance: IPerformance): void {
    this.editForm.patchValue({
      id: performance.id,
      comment: performance.comment,
      personId: performance.personId,
      performanceTypeId: performance.performanceTypeId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const performance = this.createFromForm();
    if (performance.id !== undefined) {
      this.subscribeToSaveResponse(this.performanceService.update(performance));
    } else {
      this.subscribeToSaveResponse(this.performanceService.create(performance));
    }
  }

  private createFromForm(): IPerformance {
    return {
      ...new Performance(),
      id: this.editForm.get(['id'])!.value,
      comment: this.editForm.get(['comment'])!.value,
      personId: this.editForm.get(['personId'])!.value,
      performanceTypeId: this.editForm.get(['performanceTypeId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPerformance>>): void {
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

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
