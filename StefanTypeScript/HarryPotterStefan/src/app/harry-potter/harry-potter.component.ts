import { Component, OnInit } from '@angular/core';
import { Cart } from '../model/cart';
import { calcBestPrice } from '../shared/calc-price';

@Component({
  selector: 'app-harry-potter',
  templateUrl: './harry-potter.component.html',
  styleUrls: ['./harry-potter.component.css']
})
export class HarryPotterComponent implements OnInit {
  cart: Cart;
  bestPrice: number;

  constructor() {
    this.cart = { band1: 2, band2: 2, band3: 2, band4: 1, band5: 1 };
    this.bestPrice = 0;
  }

  ngOnInit() {
  }

  onClickCalculate() {
    this.bestPrice = calcBestPrice(this.cart);
  }
}
