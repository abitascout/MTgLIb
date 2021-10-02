import sys

###Check for bad user input###
if(len(sys.argv) != 3):
  print("This program takes two arguments: Whether or not the message is being encrypted or decrypted and the key")
  sys.exit()

#If encrypt mode, this varible is set to 1
#-1 for decrypt, 0 for anything else
enOrD = 1 if sys.argv[1] == "-e" else -1 if sys.argv[1] == "-d" else 0
key = sys.argv[2].replace(' ', '')

if(enOrD == 0):
  print("Invalid mode. Use -e or -d")
  sys.exit()


###Get message###
inputs = ""

while(True):
  try:
    inputs += input() + "\n"
  except:
    #Code will throw exception upon seeing
    #EOF character (ctrl + d)
    break

inputs = list(inputs) #Turn string into list of char

###Convert###
indexKey = 0
for index in range(len(inputs)):
  #Get ASCII of letters
  letter = ord(inputs[index])
  keyLetter = ord(key[indexKey])

  #Check if letters are in the alphabet
  if not(letter <= 122 and letter >= 97 or
         letter  <= 90  and letter >= 65):
    continue
  while not(keyLetter <= 122 and keyLetter >= 97 or
            keyLetter  <= 90  and keyLetter >= 65):
    indexKey = (indexKey + 1)%len(key)
    keyLetter = ord(key[indexKey])

  # capital and keyCapital are set to the ASCII  #
  # character for 'a' or 'A' depending on if     #
  # letter or keyLetter are capital respectively #
  capital = 96 if letter > 90 else 64
  keyCapital = 97 if keyLetter > 90 else 65

  # The character becomes:                          #  
  # capital + (the sum of letter and keyLetter's    # 
  # alphabetical positions)%26                      #
  # # # # # # # # # # # # # # # # # # # # # # # # # #
  # Note: keyLetter's position becomes negative in  #
  # decrypt mode                                    #
  newNum = ((letter - capital) + enOrD*(keyLetter - keyCapital))%26
  if(newNum == 0):
    newNum = 26
  inputs[index] = chr(capital + newNum)

  
  indexKey = (indexKey + 1)%len(key)

#Print results
print(*inputs, sep='')