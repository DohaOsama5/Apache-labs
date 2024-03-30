num =int(input("enter the num of your multiplied table: "))

res=[]
for i in range(1,(num+1)):
    muliplied=[]
    for j in range(1,(i+1)):
        muliplied.append(i*j)

    res.append(muliplied)

print(res)