# ODE-Open-Weather-App-ALSEI

This app retrieves information and data from the Open Weather API, displaying various weather values on a GUI, including temperature, humidity, chance of rain, wind, and the weather condition itself.

## Developers

- Yazan Albani: ic22b093
- Johannes Seitz: ic22b086

## Project Overview

To ensure a positive conclusion, the project addresses the following points:

- JavaDoc comments in the code.
- A `readme.md` providing a rough overview of the project.
- Multiple classes with inheritance, method overriding, and possibly multiple constructors.
- Sensible access rights for classes, methods, and properties.
- Well-thought-out exception handling.
- File IO implementation (logs, CSV files, properties, XML).
- Multithreading for time-consuming calculations (not in the GUI thread).
- A well-thought-out and tidy GUI (FXML or Inline).
- Networking for communication between server and client software via TCP/UDP.

## Project Requirements

### Must-Have Features (Genügend - 4)

- Retrieves weather data from the API (Networking).
- API requests are sent by a server; the client handles the GUI and gets data from the server.
- Displays:
  - Temperature
  - Humidity
  - Chance of rain
  - Wind
  - Weather condition (cloudy, sunny, etc.).
- Displays data in a GUI (GUI + Multithreading).
- Logs data to a file in CSV or similar format (File IO).

### Should-Have Features (Befriedigend - 3)

- Ability to view data for multiple days (short term 7 days).
- Ability to see past or future days up to a limit (1 week, limited by the API).

### Nice-to-Have Features (Gut - 2)

- Location feature (determine current location or change location).
- Multiple tabs support:
  - For multiple locations.
  - For multiple time periods.

### Overkill Features (Sehr Gut - 1)

- Implementation of a map over the city in the UI (at least 3 locations).
- Additional weather information in the UI:
  - More detailed information (detailed meteorology information, at least 3).
