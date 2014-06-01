def Fibonacci(n):
	lst = []
	if n == 0:
		return []
	elif n == 1:
		return [1]
	else:
		lst = [1, 1]
		for x in range(2, n):
			lst.append(lst[x-1] + lst[x-2])
		return lst
print Fibonacci(7)
		
