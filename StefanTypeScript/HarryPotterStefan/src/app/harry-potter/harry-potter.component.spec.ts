import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HarryPotterComponent } from './harry-potter.component';
import { Cart } from '../model/cart';
import { roundTwo, discountSets, calcBestPrice } from '../shared/calc-price';

describe('HarryPotterComponent', () => {
  let component: HarryPotterComponent;
  let fixture: ComponentFixture<HarryPotterComponent>;

  beforeEach(
    waitForAsync(() => {
      void TestBed.configureTestingModule({
        imports: [BrowserAnimationsModule, FormsModule, AppMaterialModule],
        declarations: [HarryPotterComponent]
      }).compileComponents();
    })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(HarryPotterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    void expect(component).toBeTruthy();
  });

  it('1 book', () => {
    const cart: Cart = { band1: 0, band2: 1, band3: 0, band4: 0, band5: 0 };

    void expect(calcBestPrice(cart)).toEqual(discountSets[0]);
  });

  it('3 same books', () => {
    const cart: Cart = { band1: 0, band2: 0, band3: 0, band4: 3, band5: 0 };

    void expect(calcBestPrice(cart)).toEqual(roundTwo(3 * discountSets[0]));
  });

  it('2 different books', () => {
    const cart: Cart = { band1: 1, band2: 0, band3: 0, band4: 0, band5: 1 };

    void expect(calcBestPrice(cart)).toEqual(discountSets[1]);
  });

  it('2 + 1 books', () => {
    const cart: Cart = { band1: 0, band2: 2, band3: 0, band4: 0, band5: 1 };

    void expect(calcBestPrice(cart)).toEqual(
      roundTwo(discountSets[1] + discountSets[0])
    );
  });

  it('2 + 2 books', () => {
    const cart: Cart = { band1: 0, band2: 2, band3: 0, band4: 2, band5: 0 };

    void expect(calcBestPrice(cart)).toEqual(roundTwo(2 * discountSets[1]));
  });

  it('1 + 1 + 1 books', () => {
    const cart: Cart = { band1: 0, band2: 1, band3: 1, band4: 1, band5: 0 };

    void expect(calcBestPrice(cart)).toEqual(discountSets[2]);
  });

  it('2 + 1 + 1 books', () => {
    const cart: Cart = { band1: 0, band2: 2, band3: 1, band4: 1, band5: 0 };

    void expect(calcBestPrice(cart)).toEqual(
      roundTwo(discountSets[2] + discountSets[0])
    );
  });

  it('2 + 2 + 2 + 1 + 1 books (special case)', () => {
    const cart: Cart = { band1: 2, band2: 2, band3: 2, band4: 1, band5: 1 };

    void expect(calcBestPrice(cart)).toEqual(roundTwo(2 * discountSets[3]));
  });
});
