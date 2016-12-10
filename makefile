JFLAGS = -g -d bin
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(classpath)$*.java

CLASSES = \
	ActiveCodeGenerator.java \
	Language.java \

ifndef classpath
export classpath = $(PWD)/src/
endif

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) bin/*.class