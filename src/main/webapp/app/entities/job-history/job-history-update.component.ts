import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IJobHistory, JobHistory } from 'app/shared/model/job-history.model';
import { JobHistoryService } from './job-history.service';
import { IPerson } from 'app/shared/model/person.model';
import { PersonService } from 'app/entities/person/person.service';
import { IJob } from 'app/shared/model/job.model';
import { JobService } from 'app/entities/job/job.service';

type SelectableEntity = IPerson | IJob;

@Component({
  selector: 'jhi-job-history-update',
  templateUrl: './job-history-update.component.html',
})
export class JobHistoryUpdateComponent implements OnInit {
  isSaving = false;
  performers: IPerson[] = [];
  jobs: IJob[] = [];

  editForm = this.fb.group({
    id: [],
    doDate: [null, [Validators.required]],
    expireDate: [null, [Validators.required]],
    comment: [null, [Validators.required]],
    progressPercent: [null, [Validators.required, Validators.min(0), Validators.max(100)]],
    performerId: [null, Validators.required],
    jobId: [null, Validators.required],
  });

  constructor(
    protected jobHistoryService: JobHistoryService,
    protected personService: PersonService,
    protected jobService: JobService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ jobHistory }) => {
      if (!jobHistory.id) {
        const today = moment().startOf('day');
        jobHistory.doDate = today;
        jobHistory.expireDate = today;
      }

      this.updateForm(jobHistory);

      this.personService
        .query({ filter: 'jobhistory-is-null' })
        .pipe(
          map((res: HttpResponse<IPerson[]>) => {
            return res.body || [];
          })
        )
        .subscribe((resBody: IPerson[]) => {
          if (!jobHistory.performerId) {
            this.performers = resBody;
          } else {
            this.personService
              .find(jobHistory.performerId)
              .pipe(
                map((subRes: HttpResponse<IPerson>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: IPerson[]) => (this.performers = concatRes));
          }
        });

      this.jobService.query().subscribe((res: HttpResponse<IJob[]>) => (this.jobs = res.body || []));
    });
  }

  updateForm(jobHistory: IJobHistory): void {
    this.editForm.patchValue({
      id: jobHistory.id,
      doDate: jobHistory.doDate ? jobHistory.doDate.format(DATE_TIME_FORMAT) : null,
      expireDate: jobHistory.expireDate ? jobHistory.expireDate.format(DATE_TIME_FORMAT) : null,
      comment: jobHistory.comment,
      progressPercent: jobHistory.progressPercent,
      performerId: jobHistory.performerId,
      jobId: jobHistory.jobId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const jobHistory = this.createFromForm();
    if (jobHistory.id !== undefined) {
      this.subscribeToSaveResponse(this.jobHistoryService.update(jobHistory));
    } else {
      this.subscribeToSaveResponse(this.jobHistoryService.create(jobHistory));
    }
  }

  private createFromForm(): IJobHistory {
    return {
      ...new JobHistory(),
      id: this.editForm.get(['id'])!.value,
      doDate: this.editForm.get(['doDate'])!.value ? moment(this.editForm.get(['doDate'])!.value, DATE_TIME_FORMAT) : undefined,
      expireDate: this.editForm.get(['expireDate'])!.value ? moment(this.editForm.get(['expireDate'])!.value, DATE_TIME_FORMAT) : undefined,
      comment: this.editForm.get(['comment'])!.value,
      progressPercent: this.editForm.get(['progressPercent'])!.value,
      performerId: this.editForm.get(['performerId'])!.value,
      jobId: this.editForm.get(['jobId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IJobHistory>>): void {
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
