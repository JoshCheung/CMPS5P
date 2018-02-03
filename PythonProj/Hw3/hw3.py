#cmps5
#hw3
#1485979


#1a

def squares(numlist):
    new_list = [i*i for i in numlist]
    return new_list

# squares([0, 2, 4, 6, 8, 10]) == [0, 4, 16, 36, 64, 100]
# squares([1, 3, 5, 7, 9, 11]) == [1, 9, 25, 49, 81, 121]


#1b

def first_n_squares(nn):
    new_list = [number*number for number in range(nn)]
    return new_list

# first_n_squares(6) == [0, 1, 4, 9, 16, 25]
# first_n_squares(10) == [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]


#1c

def squares_range(nn0, nn1):
    new_list = [number*number for number in range(nn0, nn1)]
    return new_list
#squares_range(0, 5) == [0, 1, 4, 9, 16]
#squares_range(10, 20) == [100, 121, 144, 169, 196, 225, 256, 289, 324, 361]


#1d

def odds(numlist):
    new_list =[number for number in numlist if number%2 == 1]
    return new_list

#odds([0, 1, 4, 9, 16]) == [1, 9]
#odds([2, 2, 3, 3, 4, 4, 5, 5]) == [3, 3, 5, 5]


#1e

def rem_list(numlist, nn, rem):
    new_list = [number for number in numlist if number%nn == rem]
    return new_list

#rem_list([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3, 1) == [1, 4, 7, 10]
#rem_list(range(16, 65), 4, 1) == [17, 21, 25, 29, 33, 37, 41, 45, 49, 53, 57, 61]


#1f

def rem_list_all(numlist, nn):
    new_list = [rem_list(numlist, nn, remain) for remain in range(nn)]
    return new_list

# rem_list_all([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 4) == [[0, 4, 8], [1, 5, 9], [2, 6, 10], [3, 7]]
# rem_list_all(first_n_squares(10), 3 == [[0, 9, 36, 81], [1, 4, 16, 25, 49, 64]]
# rem_list_all(squares_range(100, 110), 3) == [[10404, 11025, 11664], [10000, 10201, 10609, 10816, 11236, 11449, 11881]]

#2a

def reverse(s):
    if len(s) == 1:
        return s
    return reverse(s[len(s)//2:]) + reverse(s[0:len(s)//2])

# reverse([2, 3, 5, 7, 11, 13]) == [13, 11, 7, 5, 3, 2]
# reverse("whatever") == 'revetahw'

#2b

def quicksort(numlist):
    if len(numlist) == 0:
        return numlist
    small, big = divide(numlist)
    mid = [big[0]]
    small_numlist = quicksort(small)
    big_numlist = quicksort(big[1:])
    return small_numlist + mid + big_numlist
              

def divide(numlist, cmp):
    pivot = numlist[0]
    small = [number for number in numlist if number < pivot]
    big = [number for number in numlist if number >= pivot ]
    return small, big

#2c

def gquicksort(seq, cmp):
    if len(seq) == 0:
        return seq
    small, big = divide1(seq, cmp)
    mid = [big[0]]
    small_numlist = gquicksort(small, cmp)
    big_numlist = gquicksort(big[1:], cmp)
    return small_numlist + mid + big_numlist

"""def divide1(numlist, cmp):
    pivot = numlist[0]
    small = [number for number in numlist if cmp(number, pivot) < 0]
    big = [number for number in numlist if cmp(number, pivot) >= 0]
    return small, big
    # This is for gquicksort for 2C
""" 

#gquicksort for number 3d
def divide1(numlist, cmp):
    pivot = numlist[0]
    small = [number for number in numlist if cmp(number, pivot)]
    big = [number for number in numlist if not cmp(number, pivot)]
    return small, big           


def compare(x,y):
    if (x > y):
        return False
    elif (x < y):
        return True
    elif x == y:
        return False


##gquicksort([6, 5, 7, 9, 8, 6, 4, 5, 6, 7, 8], compare) == [4, 5, 5, 6, 6, 6, 7, 7, 8, 8, 9]

#3a

global alphanums

def filter_alphanum(word):
    alphanums = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789"
    new_str = ""
    for char in word:
        if char in alphanums:
            new_str += char
    return new_str

# filter_alphanum('Easy as 1, 2, 3!') == 'Easyas123'
# filter_alphanum('1, 2, 3, etc.') == '123etc'


#3b

def lex_cmp(str1, str2):
     if str1 == str2:
         print("They are the same")
     i = 0
     while i  < len(str1) and i < len(str2):
         if alphanums.index(str1[i]) == alphanums.index(str2[i]):
             i += 1
             continue
         if alphanums.index(str1[i]) < alphanums.index(str2[i]):
             return True
         else:
             return False
     return len(str1) < len(str2)
         

# lex_cmp("abc", "abcde") == True
# lex_cmp('abc', 'abC') == True
# lex_cmp('aBC', 'acC') == True


#3c

def reduced_lines(filename):
    open_file = open(filename)
    list_a = [(filter_alphanum(line),line.strip()) for line in open_file if line not ""]
    return list_a

#reduced_lines("testfile3.txt") == 
#[('howsitgoing', "how's it going?"), ('Great', 'Great!'), ('howboutyou', "how 'bout you?"),
#('couldntbebetter', "couldn't be better!"), ('Couldyoudomeafavor', 'Could you do me a favor?'), ('Ofcourse', 'Of course!')]

#3d

def file_sort(in_fn, out_fn):
    sequence = reduced_lines(in_fn)
    result = gquicksort([x for x, y in sequence], lex_cmp)
    outf = open(out_fn, 'w')
    """for line in result: 
        outf.write(line + "\n")"""
    outf.write('\n'.join(result))
    outf.close()

# new_file.txt ==

#couldntbebetter
#Couldyoudomeafavor
#Great
#howboutyou
#howsitgoing
#Ofcourse


    

    
