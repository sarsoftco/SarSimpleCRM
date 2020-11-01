import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICity } from 'app/shared/model/city.model';

@Component({
  selector: 'jhi-city-detail',
  templateUrl: './city-detail.component.html',
})
export class CityDetailComponent implements OnInit {
  city: ICity | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ city }) => (this.city = city));
  }

  previousState(): void {
    window.history.back();
  }
}
