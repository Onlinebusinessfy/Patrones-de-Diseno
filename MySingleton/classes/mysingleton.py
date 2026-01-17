import os
import uuid

class MySingleton:
    
    _instancia = None
    _id = None
    
    def __new__(cls):
        if cls._instancia is None:
            cls._instancia = super(MySingleton, cls).__new__(cls)
            cls._id = uuid.uuid4()
        return cls._instancia
    
    def getId(self):
        self._id
        return self._id

    
mysingleton1 = MySingleton()
mysingleton2 = MySingleton()

# print(mysingleton1.getNombre())
os.system("cls")
print(mysingleton1.getId())
print(mysingleton2.getId())

