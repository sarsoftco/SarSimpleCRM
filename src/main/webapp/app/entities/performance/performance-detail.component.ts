import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IPerformance } from 'app/shared/model/performance.model';

@Component({
  selector: 'jhi-performance-detail',
  templateUrl: './performance-detail.component.html',
})
export class PerformanceDetailComponent implements OnInit {
  performance: IPerformance | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ performance }) => (this.performance = performance));
  }

  previousState(): void {
    window.history.back();
  }
}
