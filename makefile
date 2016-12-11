JFLAGS = -cp . -g -d
XLINT = -Xlint:unchecked
CLASSESDIR = bin
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(XLINT) $(JFLAGS) $(CLASSESDIR) $*.java

CLASSES = \
	ActiveCodeGenerator.java \
	Language.java \
	CLanguage.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) bin/*.class