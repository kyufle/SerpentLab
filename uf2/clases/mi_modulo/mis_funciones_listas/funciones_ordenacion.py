def mi_burbuja(lista,order="desc"):
    for pasada in range (len(lista)-1):
        cambio = False
        for i in range (len(lista)-pasada-1):
            if order == "desc":
                cambio = True
                if lista[i] > lista[i+1]:
                    lista[i],lista[i+1] = lista[i+1],lista[i]

            else:
                cambio = True
                if lista[i] < lista[i+1]:
                    lista[i],lista[i+1] = lista[i+1],lista[i]
        if not cambio:
            return

