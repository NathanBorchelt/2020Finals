with open("SWData.txt", "w") as outFile:
    with open("StarWarsCharacters.txt","r") as file:
        fileLines = file.readlines()
        for line in range(len(fileLines)):
            splitLine = fileLines[line].split("\t");
            for part in range(len(splitLine)):
                if(splitLine[part] == '' or splitLine[part] == '\n'):
                    splitLine[part] = 0
                elif(splitLine[part] == 'x' or splitLine[part] == 'x\n'):
                    splitLine[part] = 1
            outFile.write(str(splitLine)+"\n")       
