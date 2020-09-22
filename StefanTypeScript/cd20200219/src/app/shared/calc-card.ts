// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FARBE, WERT, KARTE, BLATT } from '../model/cart';

export const isKindOfX = (blatt: BLATT, x: number): boolean => {
  const werte: WERT[] = blatt.karten.map(karte => karte.wert);
  const wertemap = new Map();
  werte.forEach(wert =>
    wertemap.has(wert)
      ? wertemap.set(wert, wertemap.get(wert) + 1)
      : wertemap.set(wert, 1)
  );
  const anzahl = Array.from(wertemap.values()).filter(el => el === x);

  return anzahl.length > 0;
};

export const isFourOfAKind = (blatt: BLATT): boolean => isKindOfX(blatt, 4);
export const isThreeOfAKind = (blatt: BLATT): boolean => isKindOfX(blatt, 3);
export const isTwoOfAKind = (blatt: BLATT): boolean => isKindOfX(blatt, 2);
