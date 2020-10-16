CLASSES = src/goosegame/cell/*.java src/goosegame/util/*.java src/goosegame/random/*.java src/goosegame/board/*.java src/goosegame/*.java 

goosegame : $(CLASSES) 
	javac -d build $(CLASSES)

launch : goosegame 
	cd build && java goosegame.Launch