import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IPerformanceType } from 'app/shared/model/performance-type.model';

@Component({
  selector: 'jhi-performance-type-detail',
  templateUrl: './performance-type-detail.component.html',
})
export class PerformanceTypeDetailComponent implements OnInit {
  performanceType: IPerformanceType | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ performanceType }) => (this.performanceType = performanceType));
  }

  previousState(): void {
    window.history.back();
  }
}
