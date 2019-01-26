import { TestBed } from '@angular/core/testing';

import { EquipementServiceService } from './equipement-service.service';

describe('EquipementServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EquipementServiceService = TestBed.get(EquipementServiceService);
    expect(service).toBeTruthy();
  });
});
