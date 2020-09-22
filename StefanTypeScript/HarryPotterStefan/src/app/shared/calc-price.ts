import { Cart } from '../model/cart';

export const roundTwo = (value: number): number => {
  return Math.round(value * 100) / 100;
};
const discounts: number[] = [1, 0.95, 0.9, 0.8, 0.75];

export const discountSets: number[] = discounts.map((val, index) => {
  const PRICE_FOR_ONE_BOOK = 8;
  return roundTwo(val * PRICE_FOR_ONE_BOOK * (index + 1));
});

function bestPrice(books: [string, number][]): number {
  let specialCaseFlag = true;
  const specialCase = [2, 2, 2, 1, 1];
  specialCase.forEach((val, index) => {
    if (books[index][1] !== val) {
      specialCaseFlag = false;
    }
  });

  if (specialCaseFlag) {
    return roundTwo(2 * discountSets[3]);
  }

  let used = 0;
  let price = 0;
  for (let ibook = 4; ibook >= 0; ibook--) {
    if (books[ibook][1] - used > 0) {
      price = roundTwo(price + (books[ibook][1] - used) * discountSets[ibook]);
      used += books[ibook][1];
      // console.log(`#${books[ibook][1]} set(s) of ${ibook + 1}, used: ${used} price: ${price}`);
    }
  }

  return roundTwo(price);
}

export const calcBestPrice = (cart: Cart): number => {
  const sortable: [string, number][] = [];
  for (const book of Object.keys(cart)) {
    sortable.push([book, cart[book]]);
  }

  sortable.sort((a: [string, number], b: [string, number]) => {
    return b[1] - a[1];
  });

  return bestPrice(sortable);
};
