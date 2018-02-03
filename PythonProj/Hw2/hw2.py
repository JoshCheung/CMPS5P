#cmps5
#hw2
#1485979


#1a

def max2a(a, b):
	if a > b:
		return a
	else:
		return b

# max2a(7,3) == 7
# max2a(3.5, 6.5) == 6.5


#1b

def max2(a, b):
    return a if a > b else b

#max2(3, 4) == 4
#max2(10, 9) == 10
#max2(8, 8) == 8

#1c

def max3(a, b, c):
    return max2(a, b) if max2(a, b) > c else c

#1d
#max3(7, 3, 5) == 7
#max3(6.5, 5.5, 3.5) == 6.5
#max3(1, 1, 1) == 1

#1e

def max_list(a):
    big = None
    for x in a:
        if big is None:
            big = x
            continue
        if x > big:
            big = x
    return big
#>>> max_list( [2, 5, 7, 3, 4])
#7
#>>> max_list([4, 4, 7, 7, 3])
#7
#>>> max_list([2, 4, 6, 5, 3])
#6


#2a
def square(a):
    return a*a
#square(0)
#0
#>>> square(2)
#4
#>>> square(5)
#25

#2b

import math

def nearest_square(nn):
    nrt = math.sqrt(nn)
    upper = math.ceil(nrt)
    lower = math.floor(nrt)
    upsq = square(upper)
    lowsq = square(lower)
    if ((upsq - nn) > (nn - lowsq)):
        return lowsq
    return upsq

#>>> nearest_square(0)
#0
#>>> nearest_square(1)
#1
#>>> nearest_square(6)
#4
#>>> nearest_square(7)
#9

#2c

def find_nearest_square():
    value = int(input("Please enter a positive integer: "))
    if value < 0:
        print("please enter something positive")
    else:
        print('The nearest square of', value, "is", nearest_square(value))

#find_nearest_square()
#Please enter a positive integer: 6
#The nearest square of 6 is 4
#>>> find_nearest_square()
#Please enter a positive integer: 7
#The nearest square of 7 is 9

#3a

def numbers_w_squares(al):
    ret = []
    for i in al:
        ret.append((i, square(i)))
    return ret

#3b

def read_numbers_from_file1(fn):
	open_file = open(fn)
	list_a = []
	for s in open_file.read().split():
		list_a.append(int(s))
	return list_a
    
#3c

def read_number_from_file2(fn):
    open_file = open(fn)
    list_a = []
    for s in open_file.readlines():
        list_a.append(int(s))
    return list_a

#3d

def read_numbers_from_file3(fn):
    list_a = []
    f = open(fn)
    for line in f:
        list_a.append(int(line))
    return list_a

#3e

def write_numbers_w_squares_to_file(infn, outfn):
    in_fn = read_number_from_file2(infn)
    list_pairs = numbers_w_squares(in_fn)
    outf = open(outfn, 'w')
    for (x, y) in list_pairs:
    	 outf.write("%d, %d\n" % (x, y))
    outf.close()    
    
#10, 100
#20, 400
#30, 900
#40, 1600

