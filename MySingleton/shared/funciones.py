# Nombre del Alumno: Samuel Domínguez López
# Grupo: 08IDPRMA
# Nombre de práctica: Menú
# Fecha 16 de enero del 2026
import os

def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')

def esNumero(valor):
    try:
        int(valor)
        return True
    except:
        return False
    
def esValido(valor, rangoInicial, rangoFinal):
    return True if (valor >= rangoInicial and valor <= rangoFinal) else False

def menu(opciones):
    clear_screen()

    for i, opcion in enumerate(opciones, 1):
        print(f"{i}. {opcion}")
    print("0. Salir")

    opcSeleccionada = input("Selecciona una opcion: ")
    if not esNumero(opcSeleccionada):
        print("Opción no valida")
        input("Presiona ENTER para continuar...")
        return menu(opciones)
    else:
        return int(opcSeleccionada)
    

def operacion(tipo):
    valor1 = input("Ingresa el primer valor: ")
    valor2 = input("Ingresa el segundo valor: ")
    
    if not esNumero(valor1) or not esNumero(valor2):
        return "Error: Debes ingresar valores numéricos!"
    
    valor1 = int(valor1)
    valor2 = int(valor2)
    
    if tipo == "suma":
        total = valor1 + valor2
        simbolo = "+"
        nombre = "suma"
    elif tipo == "resta":
        total = valor1 - valor2
        simbolo = "-"
        nombre = "resta"
    elif tipo == "division":
        if valor2 == 0:
            return "Error: No se puede dividir entre cero"
        total = valor1 / valor2
        simbolo = "/"
        nombre = "division"
    
    return f"El total de la {nombre} de {valor1} {simbolo} {valor2} es: {total}"


if __name__ == "__main__":
    opciones = ["Suma", "Resta", "Division"]
    operaciones = {1: "suma", 2: "resta", 3: "division"}
    
    seleccion = menu(opciones)
    while seleccion != 0:
        if seleccion in operaciones:
            print(operacion(operaciones[seleccion]))
            input("Presiona ENTER para continuar...")
        else:
            print("No es una opcion valida")
            input("Presiona ENTER para continuar...")
        seleccion = menu(opciones)
    print("Programa finalizado...")
