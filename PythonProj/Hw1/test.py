orders = []
menu = ['spaghetti', 'pizza', 'gnocchi', 'lasagna']
sales = {m: 0 for m in menu}

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

def fill_orders():
    fill_ord =  orders.pop(0)
    print('Order for table {0}: {1}'.format(fill_ord['table'], fill_ord['dish']))
    return fill_ord

def take_ord_acc(order):
    take_order(order)
    sales[order['dish']] += 1
    
def init_Tutto_italiano():
    sales = {m: 0 for m in menu}
    orders = []
	
