import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { SimpleCrmTestModule } from '../../../test.module';
import { ProvinceUpdateComponent } from 'app/entities/province/province-update.component';
import { ProvinceService } from 'app/entities/province/province.service';
import { Province } from 'app/shared/model/province.model';

describe('Component Tests', () => {
  describe('Province Management Update Component', () => {
    let comp: ProvinceUpdateComponent;
    let fixture: ComponentFixture<ProvinceUpdateComponent>;
    let service: ProvinceService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [SimpleCrmTestModule],
        declarations: [ProvinceUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(ProvinceUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ProvinceUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ProvinceService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Province(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new Province();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
