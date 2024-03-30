stars = int(input("enter the num of stars to print: "))
for i in range(1, stars + 1):
    print(" " * (stars - i) + "*" * i)