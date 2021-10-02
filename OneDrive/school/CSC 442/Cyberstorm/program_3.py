###############################################################################
# Names: Abdullah Alshamdayn, Joy Brown, Caitlin Burke, Samantha Gnagey
#        Robert Morton, Kyler Parker
# Group: Chariot
# Date: 10/1/2021
# Assignment: Program 3: FTP (Storage) Covert Channel
###############################################################################

from ftplib import FTP

# The Global Variables
# The IP address for the server to which we connect to
IP = '138.47.157.5'
# The port number
PORT = 21
# The username when login to the FTP server
USER = "anonymous"
# The password for the FTP server
PASSWORD = ""
# The method to which it determines if it is a 7-bits or 10-bits
# Chose either 0 for the 7-bits OR 1 for the 10-bits
METHOD = 1
# The folder where our program access and read the permissions from
FOLDER = ''
# The choice of the folder is based on the METHOD
FOLDER = "7" if (METHOD == 0) else "10"
# set to False if the connection times out
USE_PASSIVE = True
# Store the data from the server
files = []

# We utilized our function from the previous assignment with some small modifications
# Which now this function takes 2 parameters instead of 1, the input and length, respectively
def ConvertToA(i, n):
    final = ""
    for index in range(0, n-6, 7):
        num = int(i[index:index + 7], 2)
        if num == 8:
            final = final[:-1]
        else:
            final += chr(num)
    print(final)
    return

# Picks up only the permissions that starts with "---" for the 7-bits and "-" for the 10-bit
def formBinStr():
    # To store the value of the binary string
    BStr = ""
    if (METHOD == 0):
        for i in files:
            if i[:3] == ("---"):
                for j in i[3:]:
                    if j == ("-"):
                        BStr += "0"
                    else:
                        BStr += "1"
    else:
        for i in files:
            for j in i:
                if j == ("-"):
                    BStr += "0"
                else:
                    BStr += "1"

    ConvertToA(BStr, len(BStr))

# Put the string together from the permissions from the folders located at the server
def appedPer():
    ftp.dir(FOLDER, files.append)
    for i in range(len(files)):
        # Only takes the 1st 10 chars form each file permission
        files[i] = files[i][0:10]
        i += 1

# The Main
if __name__ == '__main__':
    # Connect and login to the FTP server
    ftp = FTP()
    ftp.connect(IP, PORT)
    ftp.login(USER, PASSWORD)
    ftp.set_pasv(USE_PASSIVE)
    # Calling the functions
    appedPer()
    formBinStr()
    ftp.cwd(FOLDER)
    # Exit the FTP server
    ftp.quit()

