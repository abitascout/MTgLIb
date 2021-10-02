###############################################################################
# Names: Abdullah Alshamdayn, Joy Brown, Caitlin Burke, Samantha Gnagey
#        Robert Morton, Kyler Parker
# Group: Chariot
# Date: 9/22/2021
# Assignment: Program 1: Binary Decoder
###############################################################################

import sys

dividedText = []

# checks string length to decide whether to use 7 or 8 bit. Then it appends the
# strings broken up in to the correct number of bits into an array
def SplitString(n):
    splitText = []
    num = 0
    if(len(n) % 8 == 0):
        num = 8
        for index in range(0, len(n), num):
            splitText.append(n[index : index + num])
        return splitText
        
    elif (len(n) % 7 == 0):
        num = 7
        for index in range(0, len(n), num):
            splitText.append(n[index : index + num])
        return splitText

    else:
        print("I don't know if I can do this, you can have it back " + n)

# loops over the given array, putting each element into a string. Then
# it loops over the string and converts it from binary to decimal and creates
# a new array of the decimal numbers for each character of the code.
def ConvertToA(n):
    arrayNum = []
    for index in range(len(n)):
        num = 0
        element = n[index]
        for i in range(1, len(element) + 1):
            if element[len(element) - i] == "1":
                num = num + pow(2, (i - 1))
        arrayNum.append(num)
    return arrayNum


final = ""

for line in sys.stdin:
    if 'Exit' == line.rstrip():
        break
    line = line.strip()
    printedString = sys.stdout
    
    dividedText = SplitString(line)
    # print(dividedText)

    if dividedText != None:
        converted = ConvertToA(dividedText)
        # print(converted)

        for i in range(len(converted)):
            final = final + chr(converted[i])
        printedString.write(final)
        
    

# Infection Text file asks for you to code, compile, and execute the following
# on a variety of operating systems. (at least Linux and Windows). He wants
# comments on our observations. then comment on what we think the code is, what
# it does and how an attacker might use it, and what you might do to deal with
# such and attack
#
#int main(int argc, char** argv)
# {
#       for(;;)
#           system(argc[0]);
# }



