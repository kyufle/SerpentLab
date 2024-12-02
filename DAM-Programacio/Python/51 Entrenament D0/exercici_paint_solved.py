#!/usr/bin/env python3

import math
import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame
import sys
import utils

WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GRAY = (200, 200, 200)
YELLOW = (255, 255, 70)

BUTTON_SIZE = 20

pygame.init()
clock = pygame.time.Clock()

# Definir la finestra
WIDTH = 640
HEIGHT = 480
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Window Title')

# Variables globals
mouse = { 
    "x": -1, 
    "y": -1,
    "pressed": False
}
points = []
line_width = 1
selected_color = BLACK
buttons_width = [
    { "width": 1, "x": 25, "y": 25 },
    { "width": 2, "x": 50, "y": 25 },
    { "width": 3, "x": 25, "y": 50 },
    { "width": 4, "x": 50, "y": 50 },
    { "width": 5, "x": 25, "y": 75 },
    { "width": 6, "x": 50, "y": 75 },
]
buttons_color = []

surface = pygame.Surface((WIDTH, HEIGHT))

# Bucle de l'aplicació
def main():
    is_looping = True

    init_color_buttons()

    surface.fill(WHITE)

    while is_looping:
        is_looping = app_events()
        app_run()
        app_draw()

        clock.tick(60) # Limitar a 60 FPS

    # Fora del bucle, tancar l'aplicació
    pygame.quit()
    sys.exit()

# Gestionar events
def app_events():
    global mouse, points, line_width, selected_color
    mouse_inside = pygame.mouse.get_focused()
    mouse_relased = False

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            return False
        elif event.type == pygame.MOUSEBUTTONDOWN and mouse_inside:
            mouse["pressed"] = True
            mouse["x"], mouse["y"] = event.pos
        elif event.type == pygame.MOUSEBUTTONUP:
            mouse["pressed"] = False
            mouse_relased = True
            # Dibuixa la llista de punts a la superfície
            if len(points) >= 2:
                pygame.draw.lines(surface, selected_color, False, points, line_width)
            points = []  # Comença una nova llista de posicions
        elif event.type == pygame.MOUSEMOTION and mouse_inside and mouse["pressed"]:
            mouse["x"], mouse["y"] = event.pos
        else:
            mouse["x"], mouse["y"] = -1, -1

    if mouse_relased:
        for button in buttons_width:
            rect = { "x": button["x"], "y": button["y"], "width": BUTTON_SIZE, "height": BUTTON_SIZE }
            if utils.is_point_in_rect(mouse, rect):
                line_width = button["width"]
                break

        for button in buttons_color:
            rect = { "x": button["x"], "y": button["y"], "width": BUTTON_SIZE, "height": BUTTON_SIZE }
            if utils.is_point_in_rect(mouse, rect):
                selected_color = button["color"]
                break

    return True

# Fer càlculs
def app_run():
    if mouse["pressed"]:
        position_tuple = (mouse["x"], mouse["y"])
        points.append(position_tuple)

# Dibuixar
def app_draw():
    # Pintar el fons de blanc
    screen.fill(WHITE)

    # Dibuixar la surface
    surface_pos_tuple = (0, 0)
    screen.blit(surface, surface_pos_tuple)

    # Dibuixar els polygons
    if len(points) >= 2:
        pygame.draw.lines(screen, selected_color, False, points, line_width)

    # Dibuixar els botons de gruix
    for button in buttons_width:
        draw_button_width(button)

    # Dibuixar els botons de color
    for button in buttons_color:
        draw_button_color(button)

    # Dibuixar el color escollit
    color_tuple = (350, 25, 50, 70)
    pygame.draw.rect(screen, selected_color, color_tuple)
    if selected_color == WHITE:
        pygame.draw.rect(screen, BLACK, color_tuple, 2)

    # Actualitzar el dibuix a la finestra
    pygame.display.update()

def draw_button_width(button):

    color = GRAY
    if button["width"] == line_width:
        color = YELLOW

    rect_tuple = (button["x"], button["y"], BUTTON_SIZE, BUTTON_SIZE)
    pygame.draw.rect(screen, color, rect_tuple)

    line0 = (button["x"], button["y"] + BUTTON_SIZE)
    line1 = (button["x"] + BUTTON_SIZE, button["y"])
    pygame.draw.line(screen, BLACK, line0, line1, button["width"])

def draw_button_color(button):
    rect_tuple = (button["x"], button["y"], BUTTON_SIZE, BUTTON_SIZE)
    pygame.draw.rect(screen, button["color"], rect_tuple)

    if button["color"] == WHITE:
        pygame.draw.rect(screen, BLACK, rect_tuple, 2)

def init_color_buttons():
    global buttons_color

    rows = 3
    columns = 10
    hue_step = (360 / columns)

    displacement = (BUTTON_SIZE + 5)

    for row in range(0, rows):
        y = 25 + row * displacement
        lightness = 0.25
        if row == 1:
            lightness = 0.50
        elif row == 2:
            lightness = 0.85
        for column in range(0, columns):
            x = 75 + column * displacement
            hue = hue_step * column

            color = utils.hsl_to_rgb(hue, 1.0, lightness)
            buttons_color.append({ "color": color, "x": x, "y": y })

    buttons_color.append({ "color": BLACK, "x": 325, "y": 25 })
    buttons_color.append({ "color": (128, 128, 128), "x": 325, "y": 50 })
    buttons_color.append({ "color": WHITE, "x": 325, "y": 75 })

if __name__ == "__main__":
    main()