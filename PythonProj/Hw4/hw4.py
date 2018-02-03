#cmps5P
#hw4
#1485979

#1a

def countup(num, ntimes):
    n = num
    while n <= num+ntimes:
        yield n
        n += 1
        
#print(", ".join(str(i) for i in countup(num, ntimes))) # just put in the numbers
                                                       # for num and ntimes
                                                       # or just use gen2list

#countup(0,6) == 0, 1, 2, 3, 4, 5, 6
#countup(-6, 6) == -6, -5, -4, -3, -2, -1, 0
#gen2list(countup(0, 6)) == [0, 1, 2, 3, 4, 5, 6]

#1b

def countup_squares(num, ntimes):
    n = num
    for n in countup(num, ntimes):
        yield n*n
    
#print(", ".join(str(i) for i in countup_squares(num, ntimes)))

#countup_squares(0, 6) == 0, 1, 4, 9, 16, 25, 36
#gen2list(countup_squares(0, 6)) == [0, 1, 4, 9, 16, 25, 36]

#1c

def countup_image(start, ntimes, fun):
    n = start
    for i in countup(start, ntimes):
        yield fun(n)
        n += 1
    
#print(", ".join(str(i) for i in countup_image(5, 10, lambda n: n*n)))

#gen2list(countup_image(0, 6, lambda x: x*10)) == [0, 10, 20, 30, 40, 50, 60]


#1d

def countby(start, ntimes, step):
    n = start
    for i in countup(start, ntimes):
        yield n
        n = step(n)

#print(", ".join(str(i) for i in countby(3, 4, lambda n: 2*n)))

#gen2list(countby(0, 5, lambda n: n+3)) == [0, 3, 6, 9, 12, 15]

#1e

def gen2list(gen):
    a_list = []
    for i in gen:
        a_list.append(i)
    return a_list







#2a

## Data structure for squares encountered  ----------------------------- 

# hash table size is a prime number
HTSIZE = 101

# hash table
# ht gets true initial value from load(fn)
ht = []

def stored(n2):
    global ht
    print("Checking whether {0} is in {1} ...".format(n2, ht[n2%HTSIZE]))
    print("Answer: {0}".format(n2 in ht[n2 % HTSIZE]))
    # stored() test failed because of missing "return", leading to duplicates in hash table
    return n2 in ht[n2 % HTSIZE]

def store(n2):
    global ht
    if stored(n2):
        print("**** Warning: Value to store is already in hash table: {0}".format(n2))
    else:
        ht[n2 % HTSIZE].append(n2)
        if not stored(n2):
            print("*** Warning: {0} failed stored test after storing ...".format(n2))
    
## persistent storage -----------------------------------------
# load hash table from and save to file
# casq_main restores ht from and saves it to file 'htcasq.txt'
    
def ht_init():
    global ht
    ht = [ [] for i in range(HTSIZE) ]

def load(fn):
    '''loads ht from file with name fn'''
    global ht
    try:
        with open(fn, 'r') as f:
            ht = [ [int(s) for s in line.split()] for line in f ]
            if ht == []:
                ht_init() 
    except FileNotFoundError:
        ht_init()
    if check_ht():
        print("Problems loading hash table ...")
        print("Reinitializing hash table ...")
        ht_init()
              
    
# check for problems with hash table
# should be done via user defined exceptions (to come)
def check_ht():
    global ht
    errors = 0
    if len(ht) != HTSIZE:
        print("*** Warning: Hash table size is {0} but should be {1}".format(len(ht), HTSIZE))
        errors += 1
    dupls = duplicates(ht)
    if dupls:
        print("*** Warning: Hash table has duplicates in the following lines:\n{0}".format(dupls))
        errors +=1
    return errors

def duplicates(ht):
    '''returns a list of lines that contain duplicate entries
    '''
    lines_with_dupls = []
    for i in range(len(ht)):
        bucket = ht[i]
        # for each element of bucket record its number of occurrences in the bucket
        counts = [bucket.count(bucket[j]) for j in range(len(bucket))]
        # there are no duplicates in bucket exactly when counts contains only 1s
        if len(counts) != counts.count(1):
            lines_with_dupls.append(i)
    return lines_with_dupls                
        
def save(fn):
    '''saves ht to file with name fn'''
    global ht
    with open(fn, 'w') as f:
        buckets = [str.join(' ', [str(n) for n in ht[i]]) for i in range(HTSIZE)]
        htstring = str.join('\n', buckets)
        # need to add trailing newline character to force empty line if ht[HTSIZE-1] is empty
        # otherwise there is no line in file corresponding to hash value HTSIZE-1
        # causing the hash table to have wrong size when reconstructed from file
        htstring += '\n'
        f.write(htstring)
##-----------------------------------------------------------------------

## Core functions: checking whether a number is a perfect square --------

def casq(n2):
    '''checks whether natural number n2 is a perfect square'''
    n = 0
    i = 0
    # loop invariant: n = i*i
    while n < n2:
       n += 2*i + 1
       i += 1
    return n == n2
 

def casq_m(n2):
    '''memoed version of casq: stores square numbers encountered'''
    if not casq(n2): #Where the changes were made
        n2 = -n2
        store(n2)
        return False
    else:
        store(n2)       
        return True
        
        
 ## User interface --------------------------------------------------------

def casq_ui():
    s = input("What's your number? ")
    while s:
        n = int(s)
        if casq_m(n):
            print("Your number is a perfect square!")
        else:
            print("Sorry, your number is not a perfect square.")
        s = input("Try another one: ")
    print("Thanks for playing.")
    
## Main program -----------------------------------------------------------

def main():
    load('htcasq.txt')
    casq_ui()
    save('htcasq.txt')
