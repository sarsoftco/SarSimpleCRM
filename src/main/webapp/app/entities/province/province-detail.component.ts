import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IProvince } from 'app/shared/model/province.model';

@Component({
  selector: 'jhi-province-detail',
  templateUrl: './province-detail.component.html',
})
export class ProvinceDetailComponent implements OnInit {
  province: IProvince | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ province }) => (this.province = province));
  }

  previousState(): void {
    window.history.back();
  }
}
