# BINARY TREE
class Node:
    def __init__(self, item):
        self.data = item

        self.left = None
        self.right = None

class BST:
    def __init__(self):
        self.root = None
    
    # call __insert with current root
    def put(self, item):
        self.root = self.__insert(self.root, item)

    def __insert(self, root, item):
        global comparisons
        global assignemets

        comparisons += 1
        if not root:
            assignemets += 1
            root = Node(item)
            return root
        
        assignemets += 1
        comparisons += 1
        if  item < root.data:
            root.left = self.__insert(root.left, item)
        elif item > root.data:
            root.right = self.__insert(root.right, item)

        return root 
    
    def get(self):
        self.__print(self.root)

    def __print(self, root):
        if root:
            self.__print(root.left)
            print(str(root.data) + " ")
            self.__print(root.right)

def treeSort(data):
    lst = BST()

    for element in data:
        lst.put(element)
    
    # lst.get()





def linear_search(arr, x: int):
    global comparisons
    for i in range(len(arr)):
        comparisons += 1 
        if arr[i] == x:
            return i
    return -1

def call_binary_search(data, x): # for easier calling
    return binary_search(data, 0, len(data)-1, x)

def binary_search(arr, low, high, x: int):
    global comparisons
    comparisons += 1
    if high >= low:
        mid = (high+low) // 2

        comparisons += 1
        if arr[mid] == x:
            return mid
        elif arr[mid] > x:
            return binary_search(arr, low, mid-1, x)
        return binary_search(arr, mid+1, high, x)
    else: # element not found
        return low # should be set to 'low' when using with insertion sort to find place to insert

def bubble_sort(arr):
    global comparisons
    global assignemets

    n = len(arr)
    for i in range(n-1):
        swapped = False
        for x in range(0, n-i-1):
            comparisons += 1
            if arr[x] > arr[x+1]:
                arr[x], arr[x+1] = arr[x+1], arr[x]
                swapped = True
                assignemets += 1
        
        if not swapped:
            break
        
def cocktail_sort(arr):
    global comparisons
    global assignemets

    n = len(arr)
    swapped = True
    start = 0
    end = n-1

    while swapped:
        swapped = False

        for i in range (start, end):
            comparisons += 1
            if(arr[i] > arr[i+1]):
                arr[i], arr[i+1] = arr[i+1], arr[i]
                swapped = True
                assignemets += 1
        
        if not swapped:
            break

        swapped = False
        end -= 1

        for i in range (end-1, start-1, -1):
            comparisons += 1
            if(arr[i] > arr[i+1]):
                arr[i], arr[i+1] = arr[i+1], arr[i]
                swapped = True
                assignemets += 1
        
        start += 1

def selection_sort(arr):
    global comparisons
    global assignemets

    n = len(arr)
    for i in range(n-1):
        min_idx = i

        for x in range(i+1, n):
            comparisons += 1
            if arr[min_idx] > arr[x]:
                min_idx = x

        assignemets += 1
        arr[i], arr[min_idx] = arr[min_idx], arr[i]

def insertion_sort(arr):
    global comparisons
    global assignemets

    for i in range(1, len(arr)):
        assignemets +=1
        key = arr[i]
        j = i-1 

        while j >=0 and key < arr[j]:
            comparisons +=1
            assignemets += 1
            arr[j+1] = arr[j]
            j -= 1

        assignemets += 1
        arr[j+1] = key

def binary_insertion_sort(arr):
    global assignemets

    for i in range(1, len(arr)):
        key = arr[i]
        pos = binary_search(arr, 0, i, key)
        assignemets += 3
        arr = arr[:pos] + [key] + arr[pos:i] + arr[i+1:]
    return arr

def shell_sort(arr):
    global comparisons
    global assignemets

    n = len(arr)
    gap = n // 2

    while gap > 0:
        for i in range(gap,n):
            temp = arr[i]
            j = i

            while  j >= gap and arr[j-gap] >temp:
                comparisons += 1
                assignemets += 1
                arr[j] = arr[j-gap]
                j -= gap
  
            assignemets += 1
            arr[j] = temp

        gap //= 2
    
def partition(array, start, end):
    global assignemets
    global comparisons

    pivot_index = random.randint(start, end)
    pivot = array[pivot_index]

    while start < end:
        while start < len(array) and array[start] <= pivot:
            comparisons += 1
            start += 1
        
        while array[end] > pivot:
            comparisons += 1
            end -= 1

        if(start < end):
            comparisons += 1
            assignemets += 1
            array[start], array[end] = array[end], array[start]
    
    assignemets += 2
    array[end], array[pivot_index] = array[pivot_index], array[end]
    return end

def call_quick_sort(arr):
    quick_sort(arr, 0, len(arr)-1)

def quick_sort(arr, start, end):
    if start < end:
        p = partition(arr, start, end)
        quick_sort(arr, start, p - 1)
        quick_sort(arr, p + 1, end)



from threading import Thread
import time
import random

def generate(data, count, max):
    for i in range(count):
        data.append(random.randint(0, 4.5*max))

def call_search(function, data, x):
    global comparisons
    comparisons = 0

    start_time = time.time()
    index = function(data, x)
    elapsed = time.time() - start_time

    return "Number: " + str(x) + " Index:" + str(index) + " Time: "\
    + str(elapsed*1000) + "ms Comparisons: " + str(comparisons) + "\n"

def search_test(n):
    data: list=[]
    rand: list=[]
    linear_stats = ""
    binary_stats = ""
    
    generate(data, n, n) 
    generate(rand, 10, n)
    print(str(n) + " data generated")

    quick_sort(data, 0, len(data)-1)
    print("Data sorted!")
    
    for num in rand:
        linear_stats += call_search(linear_search, data, num)
        binary_stats += call_search(call_binary_search, data, num)

    return linear_stats + "\n" + binary_stats

def partially_generate(data, n):
    for i in range(n):
        if i == 0:
            data.append(random.randint(0, n))
        else:
            data.append(data[i-1] + random.randint(0, 50)-20)

def call_sort(function, data):
    global comparisons
    global assignemets
    global counter

    comparisons = 0
    assignemets = 0
    counter += 1
    print(counter)

    start_time = time.time()
    function(data.copy())
    elapsed = time.time() - start_time

    return str(elapsed*1000) + " Porovnania: " + str(comparisons) + " Priradenia: " + str(assignemets)

def sort_test(n, option=True):
    stats = ""
    for i in range(5):
        data = []
        if option:
            generate(data, n, n)
        else:
            partially_generate(data, n)
        
        # stats += "Bubble sort: " + call_sort(bubble_sort, data) + "\n"
        # stats += "Cocktail sort: " + call_sort(cocktail_sort, data)+ "\n"
        # stats += "Selection sort: " + call_sort(selection_sort, data)+ "\n"
        # stats += "Insertion sort: " + call_sort(insertion_sort, data)+ "\n"
        # stats += "Binary insertion sort: " + call_sort(binary_insertion_sort, data)+ "\n"
        # stats += "Shell sort: " + call_sort(shell_sort, data)+ "\n"
        # stats += "Quick sort: " + call_sort(call_quick_sort, data)+ "\n"
        stats += "Tree sort: " + call_sort(treeSort, data)+ "\n\n"

    return stats

def menu():
    data: list=[]
    while True:
        print("-----------------")
        print("1. Nove data")
        print("2. Linearne vyhladavanie")
        print("3. Binarne vyhladavanie")
        entry = input()

        if entry == '1':
            print("Zadajte data: ")
            data = [int(i) for i in input().strip().split()]

        elif entry == '2':
            print("Ake cislo hladame?")
            print("Pozicia: " + str(linear_search(data, int(input()))))

        elif entry == '3':
            print("Make sure that array is sorted!")
            print("Do you want to procede? (y/n): ")
            if input() == 'y':
                print("Ake cislo hladame?")
                print("Pozicia: " + str(binary_search(data, 0, len(data), int(input()))))

        else:
            break

counter = 0
comparisons = 0
assignemets = 0
if __name__ == "__main__":

    # ----------------------------
    # testing program
    # ----------------------------
    # menu()

    # ----------------------------
    # search test 
    # ----------------------------
    # with open("output.txt", 'w') as f:
    #     f.write(search_test(10**6))
    #     f.write("\n")
    #     f.write(search_test(10**7))
    #     f.close()

    # ----------------------------
    # sort test 
    # ----------------------------
    with open("sort_output.txt", 'w') as f:
        f.write("Randomly sorted\n")
        f.write(sort_test(10**3))
        f.write(sort_test(10**4))

        f.write("Partially sorted\n")
        f.write(sort_test(10**3))
        f.write(sort_test(10**4))

        f.close()