export enum FARBE {
  KARO,
  HERZ,
  PIK,
  KREUZ
}

export enum WERT {
  ZWEI = 2,
  DREI,
  VIER,
  FUENF,
  SECHS,
  SIEBEN,
  ACHT,
  NEUN,
  ZEHN,
  BUBE,
  DAME,
  KOENIG,
  ASS
}

export interface KARTE {
  farbe: FARBE;
  wert: WERT;
}

export interface BLATT {
  karten: KARTE[];
}
