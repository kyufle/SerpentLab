# Entrenament Paint

Farem una eina per dibuixar amb **pygame**

## Exercici 0

Fes un programa **exercici_paint** que apunti les posicions per on passa el mouse en una llista anomenada **points**, i dibuixi un cercle negre per cada punt apuntat a la llista.

S'ha de guardar en format de tupla (x,y)

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici_paint00.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 1

Modifica el codi anterior, per fer que només s'apuntin els punts, quan s'apreta amb el mouse (drag)

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici_paint01.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 2

Modifica el codi anterior, per fer que es dibuixi un polígon amb aquests punts, enlloc d'un cercle a cada posició.

Si hi ha menys de dos punts, que no es dibuixi res.

Fes servir **pygame.draw.lines** perquè no tanqui el polígon.

## Exercici 3

Fes una **surface** de la mateixa mida que la finestra:

- Inicia la surface amb un fons de color *WHITE*
- Dibuixa la surface a la posició (0,0) de la finestra

Quan es fa *pygame.MOUSEBUTTONUP*:

- Canvia l'estat de mouse["pressed"]
- Si hi ha més de 2 punts a la llista *points*, dibuixa'ls a la superfície amb **pygame.draw.lines**
- Reinicia la llista *points* amb una llista buida []

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici_paint03.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 4

A partir de la següent llista de botons: 
```python
line_width = 1
buttons_width = [
    { "width": 1, "x": 25, "y": 390 },
    { "width": 2, "x": 50, "y": 390 },
    { "width": 3, "x": 25, "y": 415 },
    { "width": 4, "x": 50, "y": 415 },
    { "width": 5, "x": 25, "y": 440 },
    { "width": 6, "x": 50, "y": 440 },
]
```

Fes una funció **draw_button_width(button)** que dibuixa els botons de la llista anterior, i posa amb fons groc el botó que coincideix amb **line_width**

Fes que la mida dels botons sigui **BUTTON_SIZE = 20**

<br/>
<center><img src="./assets/exercici_paint04.png" style="max-height: 400px" alt="">
<br/></center>
<br/>
<br/>

## Exercici 5

Fes que es pogui canviar la variable global **line_width** fent click al damunt dels botons de mida.

Quan hi ha un event **pygame.MOUSEBUTTONUP** s'ha de comprovar tots els botons de **buttons_width** i si el mouse coincideix es canvia el valor del **line_width** global.

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici_paint05.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 6

Comprova que el funcionament correspon al vídeo

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici_paint06.mov" type="video/mp4">
</video>
</center>
<br/>

## Exercici 7

Fes la funció **init_color_buttons()** i crida-la al **main** abans del bucle.

Aquesta funció inicia una llista global, de botons pels colors tipus:
```python
buttons_color = [
    { "color": color, "x": x, "y": y }
]
```

Per fer-ho fa servir la funció **"utils.hsl_to_rgb(hue, 1.0, lightness)"** amb:
- 10 columnes (que defineixen el grau **hue**)
- 3 files (que defineixen **lightness**)

La lluminositat de cada fila serà: 0.25, 0.5, 0.85

Després defineix la funció **draw_button_color(button)**

<br/>
<center><img src="./assets/exercici_paint07.png" style="max-height: 400px" alt="">
<br/></center>
<br/>
<br/>

## Exercici 8

Afegeix tres botons manualment a la funció **init_color_buttons()** amb els colors:
```python
buttons_color.append({ "color": BLACK, "x": 325, "y": 25 })
buttons_color.append({ "color": (128, 128, 128), "x": 325, "y": 50 })
buttons_color.append({ "color": WHITE, "x": 325, "y": 75 })
```

Fes que el requadre blanc el dibuixi amb un requadre negre perquè no es confongui amb el fons.

<br/>
<center><img src="./assets/exercici_paint08.png" style="max-height: 400px" alt="">
<br/></center>
<br/>
<br/>

## Exercici 9

Fes que es pogui canviar la variable global **selected_color**, que per defecté és **BLACK**, fent click al damunt dels botons de mida.

Mostra el color escollit amb un rectangle al costat de la llista de colors.

- Fes que es dibuixi el poligon del color que toca
- Si el color és blanc, posa-hi un marc negre per veure'l bé

<center>
<video width="100%" controls allowfullscreen style="max-width: 90%; width: 400px; max-height: 250px">
  <source src="./assets/exercici_paint09.mov" type="video/mp4">
</video>
</center>
<br/>