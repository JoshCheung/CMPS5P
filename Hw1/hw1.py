#cmps5P
#hw1
#1485979

#1a

def average(a, b):
    result = (a+b)/2
    return result
# average(7, 3) == 5.0

#1b

def square(a):
    result = a**2
    return result
# square(2) == 4

#1c

def sum_squares(a, b):
    result = (a**2)+(b**2)
    return result
# sum_squares(7, 3) == 58

#1d

def square_sum(a, b):
    result = (a + b)**2
    return result
# square_sum(7, 3) == 100

#1e

def f(a, b):
    result = (square_sum(a, b)/4) - (sum_squares(a, b)/2)
    return result
# f(7, 3) == -4.0

#
#
# A little moving help

#2a

def boxes207():
    num = int(input("How many items do you need to move? "))
    big = num//20 if num >= 20 else 0
    small = num%20//7
    if num%20/7 == 0:
        small = 0
    else:
        small += 1
    print ('You will need {0} large box(es) and {1} small box(es)'.format(big, small))


#2b

def boxes(a, b):
    x = ""
    y = ""
    num = int(input("How many items do you need to move? "))
    big = num//a if num >= a else 0
    small = num%a//b if num%a%b == 0 else (num%a//b) + 1
    if big != 1:
        x = "es"
    if small != 1:
        y = "es"
    print('You will need {0} large box{2} and {1} small box{3}'.format(big, small, x, y))

#
#
#
#3a

orders = []
menu = ['spaghetti', 'pizza', 'gnocchi', 'lasagna']
sales = {'gnocchi': 0, 'lasagna': 0, 'pizza': 0, 'spaghetti': 0}

print("Here is the menu:", menu)
    
def take_order(new_order):
    table = new_order['table']
    dish = new_order['dish']
    if table not in range(1, 21):
        print('Please make a valid table')
    elif dish not in menu:
        print('Please make a valid order')
    else:
        orders.append(new_order)

def fill_order():
    fill_ord =  orders.pop(0)
    print('Order for table {0}: {1}'.format(fill_ord['table'], fill_ord['dish']))
    return fill_ord

#Order for table 7: lasagna
#{'table': 7, 'dish': 'lasagna'}

#3b

def take_ord_acc(order):
    take_order(order)
    sales[order['dish']] += 1

#3c
    
def init_Tutto_Italiano():
    sales = {'gnocchi': 0, 'lasagna': 0, 'pizza': 0, 'spaghetti': 0}
    orders = []


#3d

#>>>init_Tutto_Italiano()
#>>> take_order({'table': 7, 'dish': 'lasagna'})
#>>> take_order({'table': 11, 'dish': 'gnocchi'})
#>>> fill_order()
#Order for table 7: lasagna
#{'dish': 'lasagna', 'table': 7}
#>>> orders
#[{'dish': 'gnocchi', 'table': 11}]
#>>> sales
#{'pizza': 0, 'gnocchi': 0, 'lasagna': 0, 'spaghetti': 0}
