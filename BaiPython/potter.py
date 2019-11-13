# -*- coding: utf-8 -*-

def find_min(x1, x2, x3, x4, x5):
    cart = [x1, x2, x3, x4, x5]
    cart.sort() # let x1>=x2>=x3>=x4>=x5
    
    if cart[0] < 0: raise ValueError("book number can't be zero!")
    
    x1, x2, x3, x4, x5 = cart[4], cart[3], cart[2], cart[1], cart[0] 
    
    if x5 >= 1:
        cost = min([
            8 * 5 * (1 - 0.25) + find_min(x1-1, x2-1, x3-1, x4-1, x5-1),       
            8 * 4 * (1 - 0.20) + find_min(x1-1, x2-1, x3-1, x4-1, x5),       
            8 * 3 * (1 - 0.10) + find_min(x1-1, x2-1, x3-1, x4, x5),       
            8 * 2 * (1 - 0.05) + find_min(x1-1, x2-1, x3, x4, x5)])
    elif x4 >= 1:
        cost = min([
            8 * 4 * (1 - 0.20) + find_min(x1-1, x2-1, x3-1, x4-1, x5),       
            8 * 3 * (1 - 0.10) + find_min(x1-1, x2-1, x3-1, x4, x5),       
            8 * 2 * (1 - 0.05) + find_min(x1-1, x2-1, x3, x4, x5)])
    elif x3>= 1:
        cost = min([
            8 * 3 * (1 - 0.10) + find_min(x1-1, x2-1, x3-1, x4, x5),       
            8 * 2 * (1 - 0.05) + find_min(x1-1, x2-1, x3, x4, x5)])
    elif x2 >= 1:
        cost = min([8 * 2 * (1 - 0.05) + find_min(x1-1, x2-1, x3, x4, x5)])
    elif x1 >= 1:
        cost = 8 * x1
    else:
        cost = 0
    return cost

if __name__ == "__main__":
    
    print("total cost of 2, 2, 2, 1 is ", find_min(2, 2, 2, 1, 1))
