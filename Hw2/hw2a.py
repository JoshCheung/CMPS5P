all_list = [[2, 5, 7, 3, 4], [4, 4, 7, 7, 3] ,[2, 4, 6, 5, 3]]
def max_list(a):
    big = None
    for x in a:
        if big is None:
            big = x
            continue
        if x > big:
            big = x
    return big

for test_list in  all_list:
    print('max value: ', max_list(test_list),' for list: ', test_list)
    
    
