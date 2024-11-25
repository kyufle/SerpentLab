menu00 = ("opcion1","opcion2","opcion3","opcion4")
def menu(tupla):
    menu = ""
    for i in range (len(tupla)):
        menu += str(i+1)+")"+tupla[i] + "\n"
    while True:
        print(menu)
        opc = input("Opcion:\n")
        if not opc.isdigit():
            print("Las opciones solo puede ser un número")
            input("Enter to continue")
        elif int(opc) < 1 or int(opc) > len(menu):
            print("Opción fuera de rango")
            input("Enter to continue")
        else:
            return int(opc)

opcion = menu(menu00)
print("el usuario ha elegido la opción",opcion)