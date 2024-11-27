# def tabla(titulo="",*columnas):
#     tabla_columna = ""
#     for columnas_tabla in columnas:
#         tabla_columna += columnas_tabla.ljust(20) + " "
#
#     letra = 0
#     for palabras in tabla_columna:
#         for i in range (len(palabras)):
#             letra += 1
#
#     print(letra-20)
#     print(titulo.center(letra,"*"))
#     print(tabla_columna)
#
# tabla("Tienda","Nombre","Codigo","Cantidad","Precio","Queso")

def tabla(titulo="", *columnas):
    tabla_columna = ""

    index = 0
    for columna in columnas:
        if index % 2 == 0:
            tabla_columna += columna.ljust(20) + " "
        else:
            tabla_columna += columna.rjust(20)  +" "
        index += 1

    longitud_mayor = len(tabla_columna)

    # Imprimir el título centrado
    print(titulo.center(longitud_mayor, "*"))  # Centrar el título

    # Imprimir las columnas
    print(tabla_columna)
    print("*" * (longitud_mayor))

# Llamada a la función
tabla("Tienda", "Nombre", "Codigo", "Cantidad", "Precio", "Queso", "Stock", "Descuento")
