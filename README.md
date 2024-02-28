## Linked Transit Commission System

This repository contains Java classes for a Linked Transit Commission system, which models a transit network consisting of stations and transit lines.

### Classes:

1. **Station**: Represents a transit station with properties such as station number, name, coordinates, and connections to adjacent stations.

2. **InterchangeStation**: Extends the Station class to represent interchange stations, which have multiple connections to other stations on different transit lines.

3. **TransitLine**: Represents a transit line with a line letter and a sequence of stations.

4. **LTC**: Linked Transit Commission class acts as the main controller, managing all stations and transit lines. It also initializes the graphical user interface (GUI) for visualizing the transit network.

5. **Map**: GUI class responsible for rendering the transit network graphically, showing stations as circles and lines connecting them according to the transit lines.

### Functionality:

- **Adding Stations**: Transit lines can add stations, maintaining the sequence of stations along the line.
  
- **Interchange Stations**: Interchange stations allow connections between different transit lines.
  
- **GUI Visualization**: The Map class provides a graphical representation of the transit network, showing stations, lines, and their connections.

- **Exception Handling**: The system includes exception handling for operations that are not allowed for interchange stations.

### Usage:

To use the Linked Transit Commission system:

1. Instantiate stations and transit lines.
2. Add stations to transit lines to establish the transit network.
3. Initialize an instance of the LTC class with the stations and transit lines.
4. The GUI will visualize the transit network.

### Note:

- This system provides a basic framework for modeling a transit network. Additional features and optimizations can be implemented as needed.

- Ensure proper error handling and data validation when extending or modifying the system.
