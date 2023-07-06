# Automated Irrigation System

A SpringBoot App that automates the irrigation of land plots.
The Application has the following features:
* The Admin adds/updates/deletes/reads all the land plots as desired
* Each occurrence of irrigation of a specific land plot will automatically push the next land irrigation by 1 day.
* The time slot is updated based on the land's time slot


## Technologies used were:
- Java 
- Spring Boot
- Junit 

## Endpoints
* GET /api/readall/              returns a list of land plots
* GET /api/read/{id}             returns the land plot of specific id
* POST /api/addplot              Creates land plot as desired
* PUT /api/updateplot/{id}       Updates land plot as desired
* DELETE /api/deleteplot/{id}}   Deletes land plot based on an id
* PUT /api/irrigate/{id}         Irrigates land plot and pushes time slot to the next day

## Testing
- Unit Testing for Controller, LandPlotService, and IrrigationService are implemented using SpringRunner.Class

## Extra Important Notes

  * All endpoints are done manually, if you want to automate, uncomment the @EnableScheduling in the main app and check the SchedulerMain class for the implementation
