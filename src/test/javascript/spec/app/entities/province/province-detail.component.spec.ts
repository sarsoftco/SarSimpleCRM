import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { SimpleCrmTestModule } from '../../../test.module';
import { ProvinceDetailComponent } from 'app/entities/province/province-detail.component';
import { Province } from 'app/shared/model/province.model';

describe('Component Tests', () => {
  describe('Province Management Detail Component', () => {
    let comp: ProvinceDetailComponent;
    let fixture: ComponentFixture<ProvinceDetailComponent>;
    const route = ({ data: of({ province: new Province(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [SimpleCrmTestModule],
        declarations: [ProvinceDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(ProvinceDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ProvinceDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load province on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.province).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
