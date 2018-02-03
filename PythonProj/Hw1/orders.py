orders = []
sales = {'gnocchi': 0, 'lasagna': 0, 'pizza': 0, 'spaghetti': 0}
valid_dishes = sales.keys()

print("Here are your dish options:", valid_dishes)

def init_Tutto_Italiano():
  orders = []
  sales = {'gnocchi': 0, 'lasagna': 0, 'pizza': 0, 'spaghetti': 0}
  valid_dishes = sales.keys()


def print_sales():
  for dish in sales.keys():
    count = sales[dish]
    print ('Sales for {0} is {1}'.format(dish, count))

def take_order(new_order):
  print ('take_order({0})'.format(new_order))
  if new_order['table'] not in range(1,20):
    print('Invalid table {0}, pick a valid table'.format(new_order['table']))
    return None
  if new_order['dish'] not in valid_dishes:
    print('Invalid dish {0}, pick from the menu'.format(new_order['dish']))
    return None
  sales[new_order['dish']] += 1
  orders.append(new_order)
  return new_order

def fill_order():
  fill_ord =  orders.pop(0)
  print('Order for table {0}: {1}'.format(fill_ord['table'], fill_ord['dish']))
  return fill_ord

def unit_test1():
  init_Tutto_Italiano()
  ORDER_1 = {'table': 2, 'dish': 'spaghetti'}
  take_order(ORDER_1)
  order = fill_order()
  if order != ORDER_1:
    print('Error test failed.')

def unit_test2():
  init_Tutto_Italiano()
  ORDER_1 = {'table': 3, 'dish': 'soup'}
  ORDER_2 = {'table': 20, 'dish': 'spaghetti'}
  torder = take_order(ORDER_1)
  if torder != None:
    print('Error, failed to validate dish.')
    order = fill_order()

def print_order(order):
  print ('ORDER: table {0} order dish {1}'.format(order['table'],
                                                  order['dish']))

def unit_test3():
  init_Tutto_Italiano()
  take_order({'table': 2, 'dish': 'spaghetti'})
  take_order({'table': -1, 'dish': 'pizza'})
  take_order({'table': 1, 'dish': 'lasagna'})
  take_order({'table': 20, 'dish': 'gnocchi'})
  take_order({'table': 21, 'dish': 'pizza'})
  take_order({'table': 4, 'dish': 'pizza'})
  take_order({'table': 4, 'dish': 'pizza'})
  take_order({'table': 5, 'dish': 'spaghetti'})
  f1 = fill_order()
  print_order(f1)
  f2 = fill_order()
  print_order(f2)
  f3 = fill_order()
  print_order(f3)
  print_sales()

def test():
  unit_test1()
  unit_test2()
  unit_test3()

def main():
  test()

if __name__ == '__main__':
  main()

