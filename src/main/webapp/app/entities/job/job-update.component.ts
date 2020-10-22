import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IJob, Job } from 'app/shared/model/job.model';
import { JobService } from './job.service';
import { IPerformance } from 'app/shared/model/performance.model';
import { PerformanceService } from 'app/entities/performance/performance.service';
import { IPerson } from 'app/shared/model/person.model';
import { PersonService } from 'app/entities/person/person.service';

type SelectableEntity = IPerformance | IPerson;

@Component({
  selector: 'jhi-job-update',
  templateUrl: './job-update.component.html',
})
export class JobUpdateComponent implements OnInit {
  isSaving = false;
  performances: IPerformance[] = [];
  people: IPerson[] = [];

  editForm = this.fb.group({
    id: [],
    title: [null, [Validators.required]],
    createDate: [null, [Validators.required]],
    doneDate: [null, [Validators.required]],
    comment: [],
    periority: [],
    performanceId: [],
    creatorId: [null, Validators.required],
  });

  constructor(
    protected jobService: JobService,
    protected performanceService: PerformanceService,
    protected personService: PersonService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ job }) => {
      if (!job.id) {
        const today = moment().startOf('day');
        job.createDate = today;
        job.doneDate = today;
      }

      this.updateForm(job);

      this.performanceService
        .query({ filter: 'job-is-null' })
        .pipe(
          map((res: HttpResponse<IPerformance[]>) => {
            return res.body || [];
          })
        )
        .subscribe((resBody: IPerformance[]) => {
          if (!job.performanceId) {
            this.performances = resBody;
          } else {
            this.performanceService
              .find(job.performanceId)
              .pipe(
                map((subRes: HttpResponse<IPerformance>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: IPerformance[]) => (this.performances = concatRes));
          }
        });

      this.personService.query().subscribe((res: HttpResponse<IPerson[]>) => (this.people = res.body || []));
    });
  }

  updateForm(job: IJob): void {
    this.editForm.patchValue({
      id: job.id,
      title: job.title,
      createDate: job.createDate ? job.createDate.format(DATE_TIME_FORMAT) : null,
      doneDate: job.doneDate ? job.doneDate.format(DATE_TIME_FORMAT) : null,
      comment: job.comment,
      periority: job.periority,
      performanceId: job.performanceId,
      creatorId: job.creatorId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const job = this.createFromForm();
    if (job.id !== undefined) {
      this.subscribeToSaveResponse(this.jobService.update(job));
    } else {
      this.subscribeToSaveResponse(this.jobService.create(job));
    }
  }

  private createFromForm(): IJob {
    return {
      ...new Job(),
      id: this.editForm.get(['id'])!.value,
      title: this.editForm.get(['title'])!.value,
      createDate: this.editForm.get(['createDate'])!.value ? moment(this.editForm.get(['createDate'])!.value, DATE_TIME_FORMAT) : undefined,
      doneDate: this.editForm.get(['doneDate'])!.value ? moment(this.editForm.get(['doneDate'])!.value, DATE_TIME_FORMAT) : undefined,
      comment: this.editForm.get(['comment'])!.value,
      periority: this.editForm.get(['periority'])!.value,
      performanceId: this.editForm.get(['performanceId'])!.value,
      creatorId: this.editForm.get(['creatorId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IJob>>): void {
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
