from tkinter import *

def function():
  print ("Adios")
  v.set("Adios")

frame = Frame()
button = Button(frame, text="hola", command=function)
button.pack(side=LEFT)
button.pack(ipadx=10)
button.pack(ipady=10)

v=StringVar()
text=Entry(frame,textvariable=v)
text.pack(side=LEFT)
text.pack(padx=20)
text.pack(pady=20)

frame.pack()
frame.mainloop()