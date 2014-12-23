import Tkinter as tk
import time

class Task:
	def __init__ (self, name):
		self.name = name
		self.done = tk.IntVar()

class Project:
	def __init__ (self, name, elements):
		self.name = name
		self.elements = elements
		
class App(tk.Tk):
	def __init__(self):
		tk.Tk.__init__(self)	
		self.remaining = 0
		self.drawElements()
		self.countdown()
		
	def drawElements (self):
		task1 = Task ('task1')

		elements1 = [task1]
		element1 = Project ('pepe', elements1)
		elements = [element1]

		for element in elements:
			w = tk.Label(self, text=element.name, font=("Helvetica", 16))
			w.pack()
			
			for task in element.elements:
				w2 = tk.Label (self, text=task.name, font=("Helvetica", 12))
				w2.pack()
				
				check = tk.Checkbutton (self, text=task.name, variable=task.done, command=self.cb)
				check.pack()
	
		now = time.strftime("%H:%M:%S")
		self.time = tk.Label (self, text=now, font=("Helvetica", 12))
		self.time.pack()
		self.var = tk.IntVar()
		check = tk.Checkbutton (self, text="Enable Tab", variable=self.var, command=self.cb)
		check.pack()

	def cb(self):
		print "variable is ", self.var.get()
		
	def countdown(self):
		now = time.strftime("%H:%M:%S")
		self.time.configure(text=now)
		self.after(1000, self.countdown)

if __name__ == "__main__":
    app = App()
    app.mainloop()