import { Component, OnInit } from '@angular/core';
import { FARBE, WERT, KARTE, BLATT } from '../model/cart';
import { isFourOfAKind } from '../shared/calc-card';

@Component({
  selector: 'app-coding-dojo',
  templateUrl: './coding-dojo.component.html',
  styleUrls: ['./coding-dojo.component.css']
})
export class CodingDojoComponent implements OnInit {
  // cart: Cart;
  // bestPrice: number;

  constructor() {
  }

  ngOnInit() {
  }

  onClickCalculate() {
    // this.isFourOfAKind = isFourOfAKind(this.cart);
  }
}
