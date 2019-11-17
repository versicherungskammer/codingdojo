# -*- coding: utf-8 -*-
from collections import defaultdict

_dp_combi_value = defaultdict(lambda: 0)

def find_best_price(x1: int, x2: int, x3: int, x4: int, x5: int) -> float:
    cart = [x1, x2, x3, x4, x5]
    cart.sort() # let x1>=x2>=x3>=x4>=x5
    
    if any(isinstance(x, int) == False for x in cart): raise ValueError("input must be integer")
    
    if cart[0] < 0: raise ValueError("book number can't be less than zero!")
    
    x1, x2, x3, x4, x5 = cart[4], cart[3], cart[2], cart[1], cart[0] 
    
    if _dp_combi_value[x1, x2, x3, x4, x5] > 0: 
        return _dp_combi_value[x1, x2, x3, x4, x5]
    
    if x5 >= 1:
        cost = min([8 * 5 * (1 - 0.25) + find_best_price(x1-1, x2-1, x3-1, x4-1, x5-1),       
                    8 * 4 * (1 - 0.20) + find_best_price(x1-1, x2-1, x3-1, x4-1, x5),       
                    8 * 3 * (1 - 0.10) + find_best_price(x1-1, x2-1, x3-1, x4, x5),       
                    8 * 2 * (1 - 0.05) + find_best_price(x1-1, x2-1, x3, x4, x5)])
        _dp_combi_value[x1, x2, x3, x4, x5] = cost
        return cost
    
    if x4 >= 1:
        cost = min([8 * 4 * (1 - 0.20) + find_best_price(x1-1, x2-1, x3-1, x4-1, x5),       
                    8 * 3 * (1 - 0.10) + find_best_price(x1-1, x2-1, x3-1, x4, x5),       
                    8 * 2 * (1 - 0.05) + find_best_price(x1-1, x2-1, x3, x4, x5)])
        _dp_combi_value[x1, x2, x3, x4, x5] = cost
        return cost
    
    if x3>= 1:
        cost = min([8 * 3 * (1 - 0.10) + find_best_price(x1-1, x2-1, x3-1, x4, x5),       
                    8 * 2 * (1 - 0.05) + find_best_price(x1-1, x2-1, x3, x4, x5)])
        _dp_combi_value[x1, x2, x3, x4, x5] = cost
        return cost
    
    if x2 >= 1:
        cost = min([8 * 2 * (1 - 0.05) + find_best_price(x1-1, x2-1, x3, x4, x5)])
        _dp_combi_value[x1, x2, x3, x4, x5] = cost        
        return cost
    
    if x1 >= 1:
        cost = 8 * x1
        _dp_combi_value[x1, x2, x3, x4, x5] = cost
        return cost
    
    if all (x == 0 for x in cart):
        return 0


if __name__ == "__main__":
    print("total cost is ", find_best_price(2, 2, 2, 1, 1))