from MySingleton.classes.mysingleton import MySingleton
from MySingleton.shared.funciones import clear_screen

instancia1=MySingleton()
instancia2=MySingleton()
instancia3=MySingleton()

clear_screen()
print(f"El id de instancia1 es {instancia1.getId()}")