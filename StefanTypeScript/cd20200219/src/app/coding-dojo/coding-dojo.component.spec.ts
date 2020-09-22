import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { CodingDojoComponent } from './coding-dojo.component';
import { FARBE, WERT, BLATT } from '../model/cart';
import {
  isFourOfAKind,
  isThreeOfAKind,
  isTwoOfAKind
} from '../shared/calc-card';

describe('CodingDojoComponent', () => {
  // let component: CodingDojoComponent;
  let fixture: ComponentFixture<CodingDojoComponent>;

  beforeEach(
    waitForAsync(() => {
      TestBed.configureTestingModule({
        imports: [BrowserAnimationsModule, FormsModule, AppMaterialModule],
        declarations: [CodingDojoComponent]
      }).compileComponents();
    })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(CodingDojoComponent);
    // component = fixture.componentInstance;
    fixture.detectChanges();
  });

  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });

  it('Vierer echt', () => {
    const blatt: BLATT = {
      karten: [
        { farbe: FARBE.KARO, wert: WERT.DREI },
        { farbe: FARBE.PIK, wert: WERT.DREI },
        { farbe: FARBE.HERZ, wert: WERT.VIER },
        { farbe: FARBE.HERZ, wert: WERT.DREI },
        { farbe: FARBE.KARO, wert: WERT.ASS },
        { farbe: FARBE.KREUZ, wert: WERT.DREI },
        { farbe: FARBE.KREUZ, wert: WERT.ASS }
      ]
    };

    expect(isFourOfAKind(blatt)).toEqual(true);
  });

  it('Vierer falsch', () => {
    const blatt: BLATT = {
      karten: [
        { farbe: FARBE.KARO, wert: WERT.DREI },
        { farbe: FARBE.PIK, wert: WERT.DREI },
        { farbe: FARBE.HERZ, wert: WERT.VIER },
        { farbe: FARBE.HERZ, wert: WERT.KOENIG },
        { farbe: FARBE.KARO, wert: WERT.ASS },
        { farbe: FARBE.KREUZ, wert: WERT.DREI },
        { farbe: FARBE.KREUZ, wert: WERT.ASS }
      ]
    };

    expect(isFourOfAKind(blatt)).toEqual(false);
  });

  it('Dreier echt', () => {
    const blatt: BLATT = {
      karten: [
        { farbe: FARBE.KARO, wert: WERT.DREI },
        { farbe: FARBE.PIK, wert: WERT.DREI },
        { farbe: FARBE.HERZ, wert: WERT.VIER },
        { farbe: FARBE.HERZ, wert: WERT.KOENIG },
        { farbe: FARBE.KARO, wert: WERT.ASS },
        { farbe: FARBE.KREUZ, wert: WERT.DREI },
        { farbe: FARBE.KREUZ, wert: WERT.ASS }
      ]
    };

    expect(isThreeOfAKind(blatt)).toEqual(true);
  });
  it('Dreier falsch', () => {
    const blatt: BLATT = {
      karten: [
        { farbe: FARBE.KARO, wert: WERT.DREI },
        { farbe: FARBE.PIK, wert: WERT.DREI },
        { farbe: FARBE.HERZ, wert: WERT.VIER },
        { farbe: FARBE.HERZ, wert: WERT.KOENIG },
        { farbe: FARBE.KARO, wert: WERT.ASS },
        { farbe: FARBE.KREUZ, wert: WERT.BUBE },
        { farbe: FARBE.KREUZ, wert: WERT.ASS }
      ]
    };

    expect(isThreeOfAKind(blatt)).toEqual(false);
  });
  it('Zweier echt', () => {
    const blatt: BLATT = {
      karten: [
        { farbe: FARBE.KARO, wert: WERT.BUBE },
        { farbe: FARBE.PIK, wert: WERT.DREI },
        { farbe: FARBE.HERZ, wert: WERT.VIER },
        { farbe: FARBE.HERZ, wert: WERT.KOENIG },
        { farbe: FARBE.KARO, wert: WERT.ASS },
        { farbe: FARBE.KREUZ, wert: WERT.DREI },
        { farbe: FARBE.KREUZ, wert: WERT.ASS }
      ]
    };

    expect(isTwoOfAKind(blatt)).toEqual(true);
  });
  it('Zweier falsch', () => {
    const blatt: BLATT = {
      karten: [
        { farbe: FARBE.KARO, wert: WERT.BUBE },
        { farbe: FARBE.PIK, wert: WERT.DREI },
        { farbe: FARBE.HERZ, wert: WERT.VIER },
        { farbe: FARBE.HERZ, wert: WERT.KOENIG },
        { farbe: FARBE.KARO, wert: WERT.SECHS },
        { farbe: FARBE.KREUZ, wert: WERT.FUENF },
        { farbe: FARBE.KREUZ, wert: WERT.ASS }
      ]
    };

    expect(isTwoOfAKind(blatt)).toEqual(false);
  });
});
