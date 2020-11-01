import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { SimpleCrmTestModule } from '../../../test.module';
import { CityDetailComponent } from 'app/entities/city/city-detail.component';
import { City } from 'app/shared/model/city.model';

describe('Component Tests', () => {
  describe('City Management Detail Component', () => {
    let comp: CityDetailComponent;
    let fixture: ComponentFixture<CityDetailComponent>;
    const route = ({ data: of({ city: new City(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [SimpleCrmTestModule],
        declarations: [CityDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(CityDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CityDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load city on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.city).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
