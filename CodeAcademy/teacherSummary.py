lloyd = {
    "name": "Lloyd",
    "homework": [90.0, 97.0, 75.0, 92.0],
    "quizzes": [88.0, 40.0, 94.0],
    "tests": [75.0, 90.0]
}
alice = {
    "name": "Alice",
    "homework": [100.0, 92.0, 98.0, 100.0],
    "quizzes": [82.0, 83.0, 91.0],
    "tests": [89.0, 97.0]
}
tyler = {
    "name": "Tyler",
    "homework": [0.0, 87.0, 75.0, 22.0],
    "quizzes": [0.0, 75.0, 78.0],
    "tests": [100.0, 100.0]
}
students = [lloyd, alice, tyler]

# Add your function below!
def average(lst):
    sum = 0
    for x in lst:
        sum += x
    return float(sum)/(len(lst))
    
def get_average(dic):
    return (average(dic["homework"])*0.1 + average(dic["quizzes"])*0.3 + average(dic["tests"])*0.6)

def get_letter_grade(score):
    if score >= 90:
        return "A"
    elif score >= 80:
        return "B"
    elif score >= 70:
        return "C"
    elif score >= 60:
        return "D"
    else:
        return "F"
print get_letter_grade(get_average(lloyd))

def get_class_average(lst):
    class_averages = []
    for x in lst:
        class_averages.append(get_average(x))
    return average(class_averages)
print get_class_average(students)
print get_letter_grade(get_class_average(students))

#Code developed under the guidance of codeacademy.com