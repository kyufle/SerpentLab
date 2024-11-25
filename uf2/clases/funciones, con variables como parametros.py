# def funcion_ejemplo(a,b=1):
#     print("a:",a)
#     print("b:",b)
#
# funcion_ejemplo(2,10)

#
# def funcion_ejemplo1(a,b,*c,d):
#     print("a=",a)
#     print("b=",b)
#     print("c",c)
#     print((type(c)))
# funcion_ejemplo1(1,2,3,"ws","sadf",True)
#
# #no se puede poner 3 a solas, porque al ser una tupla, si no le ponemos coma, python entenderá que es un entero
#


# lista_numeros = []
# def media(num):
#
# numeros = input("Que números quieres meter: ")
#
# while not numeros.isdigit():
#     print("Tienen que ser números")
#     numeros = input("Que números quieres meter: ")
# numeros = int(numeros)
# lista_numeros.append(numeros)

#funcion que puedan tener uno, dos o infinitos números y calcule la media de los que metamos
# PARAMETROS ARBITRARIOS
#tuplas
# def funcion_ejemplo(a,b,*c):

#diccionarios
# def funcion_ejemplo(a,b,**c):
#     print("a=", a)
#     print("b=",b)
#     print("c",c)
#     print((type(c)))
# funcion_ejemplo(1,2,clave1="valor1",aa=3)

# def funcion_ejemplo(a,b,*c):
#     suma = a+b
#     for numero in c:
#         suma += numero
#     media = suma / (2+len(c))
#     return media
# print(funcion_ejemplo(1,2,3,4,5,6,7,8))
#     print("c",c)
#     print((type(c)))
# funcion_ejemplo(1,2,clave1="valor1",aa=3)

def funcion_menucito(titulo="",*opciones):
    menu = ""
    for i in range (len(opciones)):
        menu += str(i+1)+")"+opciones[i] + "\n"

    while True:
        if titulo != "":
            print(titulo.center(20, "*"))
        print(menu)
        opc = input("Opción: ")

        if not opc.isdigit():
            print("Tienen que ser digitos")
        elif int(opc) not in range(1,len(opciones)+1):
            print("Opción fuera de rango")
        else:
            opc = int(opc)
            return opc

funcion_menucito("titulo","opcion1","opcion2","opcion3")