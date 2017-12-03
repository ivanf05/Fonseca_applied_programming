#Ivan Fonseca
# List of words found
wordList = []
notFoundList = []
foundWordList = []
#Will contain list of row letters
rowList =[]
#Will contain list of cloumnletters
columnList =[]
#reads row and looks for 
 
def findWord(rowOrCol, inRow, number) :
    #Joins entire row or col into one string
    rowColString = ""
    rowColString = "".join(rowOrCol)
    #print(rowColString)
    for word in wordList :
        if (word in rowColString) :
            #Sees if word is in row
            if (inRow == True) :
                foundWordList.append(word + " row " + str(number))
            #Sees if word is in columns
            else : 
                foundWordList.append(word + " column " + str(number))
            #If word is found it removes from not found list    
            notFoundList.remove(word)
#Opens each file
puzzleFile = open('puzzle.txt','r')
wordFile = open('wordList.txt','r')
#reads wordList file and adds each word to wordList
for line in wordFile:
    #each row in file is a word and is
    #added to not foundwordlist
    wordString = line.split()
    wordList.append(wordString[0])
    notFoundList.append(wordString[0])
#print(wordList)
# each row is added to rowlist
for line in puzzleFile:
    rowList.append(line.split())
#Alterative way of Transposing rows into columns using zip function
columnList=list(zip(*rowList))


#for i in range(columnSize):
#    columnList.append([row[i] for row in rowList])
#print("col list: ",columnList)

#iterates through each row 
#passes the row, true(used to identify a row), index number
for index,row in enumerate(rowList) : 
    findWord(row,True,index)
#iterates through each column 
#passes the column, false(used to identify a column), index number 
for count, column in enumerate(columnList) :
    findWord(column,False,count)
#Prints words found
print("Words found : ")
for foundWord in foundWordList :
    print(foundWord)
#Prints words not found
print("Not found list : ") 
for notFoundWord in notFoundList :
    print(notFoundWord)
    


    
