#Iterator Notation
my_dict = { 1:'a', 2:'b', 3:'c', 4:'d'}
print my_dict.keys()
print my_dict.values()
for key in my_dict:
    print key, my_dict[key]   
    
#List Comprehension
threes_and_fives = [x for x in range(1,16) if x % 3 == 0 or x % 5 == 0]

#List Slicing
garbled = "!XeXgXaXsXsXeXmX XtXeXrXcXeXsX XeXhXtX XmXaX XI"
message = garbled[::-2]

#Lambda Expression
garbled = "IXXX aXXmX aXXXnXoXXXXXtXhXeXXXXrX sXXXXeXcXXXrXeXt mXXeXsXXXsXaXXXXXXgXeX!XX"
message = filter(lambda x: x != 'X', garbled)
print message

#Code developed under the guidance of codeacademy.com