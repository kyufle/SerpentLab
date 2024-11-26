def tabla(titulo="",*columnas):
    tabla_columna = ""
    for columnas_tabla in columnas:
        tabla_columna += columnas_tabla.ljust(20) + " "

    letra = 0
    for palabras in tabla_columna:
        for i in range (len(palabras)):
            letra += 1

    print(letra-20)
    print(titulo.center(letra,"*"))
    print(tabla_columna)

tabla("Tienda","Nombre","Codigo","Cantidad","Precio","Queso")