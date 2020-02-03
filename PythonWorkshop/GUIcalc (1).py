from tkinter import *
from tkinter.ttk import *
import math

class Calc(Frame):

    #sorta constructor
    def __init__(self):
        super().__init__()
        self.initUI()

    #replaces the text in the field
    def replaceText(self, text):
         self.entry.configure(state='normal')
         self.entry.delete(0, END)
         self.entry.insert(0,text)
         self.entry.configure(state='readonly')

    #adds numbers to the entry
    def appendToDisplay(self, text):
        self.entry.configure(state='normal')
        self.entryText = self.entry.get()
        self.textLen = len(self.entryText)
        if self.entryText == "0":
            self.replaceText(text)
        else:
            self.entry.insert(self.textLen,text)
        self.entry.configure(state='readonly')

    #deletes the last number from the entry
    def backSpace(self):
        self.entry.configure(state='normal')
        self.entryText = self.entry.get()
        self.textLen = len(self.entryText)
        self.entry.delete(self.textLen-1)
        self.entry.configure(state='readonly')

    #clears all text from the box
    def clearText(self):
        self.entry.configure(state='normal')
        self.replaceText("0")
        self.entry.configure(state='readonly')

    #calculates the expression
    def calcExpression(self):
        self.entry.configure(state='normal')
        self.expression = self.entry.get()
        self.result = eval(self.expression)
        #print(self.result)
        self.replaceText(self.result)
        self.entry.configure(state='readonly')
        

    #initializes the calculator buttons
    def initUI(self):

        self.master.title("Calculator")

        Style().configure("TButton", padding=(5,5,5,5),
            font='Impact 10')

        self.columnconfigure(0, pad=3)
        self.columnconfigure(1, pad=3)
        self.columnconfigure(2, pad=3)
        self.columnconfigure(3, pad=3)

        self.rowconfigure(0, pad=3)
        self.rowconfigure(1, pad=3)
        self.rowconfigure(2, pad=3)
        self.rowconfigure(3, pad=3)
        self.rowconfigure(4, pad=3)
        self.rowconfigure(5, pad=3)

        #Creates the text entry space
        self.entry = Entry(self, state='readonly')
        self.entry.insert(0,"0")
        self.entry.grid(row=0, columnspan=4, sticky=W+E)

        #Creates the various buttons of the calculator
        
        self.cls = Button(self, text="Clear", command=lambda: self.clearText())
        self.cls.grid(row=1, column=0)

        self.bck = Button(self, text="Back", command=lambda: self.backSpace())
        self.bck.grid(row=1, column=1)

        self.lbl = Button(self)
        self.lbl.grid(row=1, column=2)

        self.clo = Button(self, text="Close", command=lambda: root.destroy())
        self.clo.grid(row=1, column=3)


        self.sev = Button(self, text="7", command=lambda: self.appendToDisplay("7"))
        self.sev.grid(row=2, column=0)

        self.eig = Button(self, text="8", command=lambda: self.appendToDisplay("8"))
        self.eig.grid(row=2, column=1)

        self.nin = Button(self, text="9", command=lambda: self.appendToDisplay("9"))
        self.nin.grid(row=2, column=2)

        self.div = Button(self, text="/", command=lambda: self.appendToDisplay("/"))
        self.div.grid(row=2, column=3)


        self.fou = Button(self, text="4", command=lambda: self.appendToDisplay("4"))
        self.fou.grid(row=3, column=0)

        self.fiv = Button(self, text="5", command=lambda: self.appendToDisplay("5"))
        self.fiv.grid(row=3, column=1)

        self.six = Button(self, text="6", command=lambda: self.appendToDisplay("6"))
        self.six.grid(row=3, column=2)

        self.mul = Button(self, text="*", command=lambda: self.appendToDisplay("*"))
        self.mul.grid(row=3, column=3)


        self.one = Button(self, text="1", command=lambda: self.appendToDisplay("1"))
        self.one.grid(row=4, column=0)

        self.two = Button(self, text="2", command=lambda: self.appendToDisplay("2"))
        self.two.grid(row=4, column=1)

        self.tre = Button(self, text="3", command=lambda: self.appendToDisplay("3"))
        self.tre.grid(row=4, column=2)

        self.sub = Button(self, text="-", command=lambda: self.appendToDisplay("-"))
        self.sub.grid(row=4, column=3)


        self.dot = Button(self, text=".", command=lambda: self.appendToDisplay("."))
        self.dot.grid(row=5, column=0)

        self.zer = Button(self, text="0", command=lambda: self.appendToDisplay("0"))
        self.zer.grid(row=5, column=1)

        self.equ = Button(self, text="=", command=lambda: self.calcExpression())
        self.equ.grid(row=5, column=2)

        self.add = Button(self, text="+", command=lambda: self.appendToDisplay("+"))
        self.add.grid(row=5, column=3)

        #organizes the window
        self.pack()


            
root = Tk()
app = Calc()
root.mainloop()

        
