#scope1.py

a = 10

def f(x):
    x1 = x + 1
    def g(y):
        x2 = x1 * 10
        def h(z):
            nonlocal x1
            x1 = 1
            x2 = 2
            a = x1 + x2
            return a
        print('h(x2): ' + str(h(x2)))
        print('x2: ' + str(x2))
        print('a: ' + str(a))
    g(x1)
    print('x1: ' + str(x1))

print('a: ' + str(a))

f(a)
