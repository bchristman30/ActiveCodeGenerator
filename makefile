JFLAGS = -cp . -g -d
CLASSESDIR = bin
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(CLASSESDIR) $*.java

CLASSES = \
	ActiveCodeGenerator.java \
	Language.java \
	CLanguage.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) bin/*.class