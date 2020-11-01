import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICity, City } from 'app/shared/model/city.model';
import { CityService } from './city.service';
import { IProvince } from 'app/shared/model/province.model';
import { ProvinceService } from 'app/entities/province/province.service';

@Component({
  selector: 'jhi-city-update',
  templateUrl: './city-update.component.html',
})
export class CityUpdateComponent implements OnInit {
  isSaving = false;
  provinces: IProvince[] = [];

  editForm = this.fb.group({
    id: [],
    title: [null, [Validators.required]],
    provinceId: [null, Validators.required],
  });

  constructor(
    protected cityService: CityService,
    protected provinceService: ProvinceService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ city }) => {
      this.updateForm(city);

      this.provinceService.query().subscribe((res: HttpResponse<IProvince[]>) => (this.provinces = res.body || []));
    });
  }

  updateForm(city: ICity): void {
    this.editForm.patchValue({
      id: city.id,
      title: city.title,
      provinceId: city.provinceId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const city = this.createFromForm();
    if (city.id !== undefined) {
      this.subscribeToSaveResponse(this.cityService.update(city));
    } else {
      this.subscribeToSaveResponse(this.cityService.create(city));
    }
  }

  private createFromForm(): ICity {
    return {
      ...new City(),
      id: this.editForm.get(['id'])!.value,
      title: this.editForm.get(['title'])!.value,
      provinceId: this.editForm.get(['provinceId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICity>>): void {
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

  trackById(index: number, item: IProvince): any {
    return item.id;
  }
}
