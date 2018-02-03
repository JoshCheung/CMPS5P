#project

def story_time():
    print("1: Christina's adoption story")
    print("2: Famous Rapper")
    print("3: Frank's Night Out")
    print("4: My Crush (for guys)")
    print("5: Rosette's Story")
    story_list = ["garbage", "Christina's_adoption.txt", "famous_rapper.txt" , "franks_night_out.txt", "my_crush.txt", "rosette's_story.txt"]
    print("Please select one of the following stories with a number: ")
    choice = (int(input("Your choice is: ")))
    while choice:
            if choice > 5 or choice < 1:
                choice = int(input("Please try again: "))
            else:
                return story_list[choice]
                
def readline_in_file(fn): #reads each line of the file
    open_file = open(fn)
    list_a = []
    for s in range(file_len(fn)):
        line = open_file.readline().split()
        list_a.append(line)
    return list_a

def replacement(fn): #does the substitution in the program
    big_list = readline_in_file(fn)
    i = 0
    for sm_lists in big_list:
        for words in sm_lists:
            if check_for_change(words):
                sub_word = input(("Please write something for " + words + ": "))
                sm_lists.insert(sm_lists.index(words), sub_word)
                sm_lists.pop(sm_lists.index(words)) 
                i+=1
    return big_list

def check_for_change(str): #checks for replacements
    p1, p2 = "(",")"
    if p1 and p2 in str:
        return True

def file_len(fname): #counts how many line there are in the file
    with open(fname) as f:
        for i, l in enumerate(f):
            pass
    return i + 1


def write_to_file(old, new): #writes output into a new file
    outf = open(new, 'w')
    thelist = replacement(old)
    for item_list in thelist:
	    for item in item_list:
		    outf.write("%s " % item)
    outf.close()


def main():
    prefer = story_time()
    write_to_file(prefer, "new_story.txt")
    if prefer == 0:
        print("Try again")
        story_time()
    


