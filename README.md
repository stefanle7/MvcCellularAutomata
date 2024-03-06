# MVC_CA
CALab is a framework for creating and simulating various types of Cellular Automata (CAs). It provides tools for modeling social systems, markets, cities, organizations, and more. This README provides an overview of the CALab framework and its components.

Overview

Cellular Automata (CAs) were introduced in the late 1940s by Stanislaw Ulam and John Von Neumann. They are infinite grids of cells where each cell transitions between states based on the states of its neighbors. CALab allows users to create and explore different types of CAs within a finite wrapping grid.

Components

Grid Class: Represents the CA and contains an NxN grid of cells. The grid is the model in the MVC framework.
Cell Class: Abstract class representing a cell in the CA. Contains methods for observing, interacting, and updating the cell's state.
GridView: Presentation layer displaying the grid of cells. Each CellView is associated with one Cell and updates its state accordingly.
Update Loop: The lifecycle of a CA consists of interacting with neighbors, updating states, and observing changes. The update loop manages these phases.

Features

Customizable CAs: Users can define different rules for observing, interacting, and updating cells, allowing for a wide range of CA simulations.
Conway's Game of Life: A popular CA simulation where cells transition between dead and alive states based on the number of living neighbors.
GUI Interface: CALab provides a GUI interface for users to interact with and visualize the CA simulations.
Project Examples: Projects like Conway Universe Lab and Rebellion Lab provide pre-defined simulations for users to explore.
Implementation
Composite Structure: Grids are composed of cells, allowing for efficient manipulation of cell states.
Interaction-Update-Observation Cycle: The update loop follows an interaction-update-observation cycle, ensuring the most current state of the grid is displayed.

Projects

Project 1: Life Lab: Includes Conway Universe Lab for exploring Conway's Game of Life.
Project 2: Rebellion Lab: Simulates civil disobedience models and social unrest scenarios.

