# Daniele Autizi's personal website ![alt text](http://www.danieleautizi.com/static/images/ico/apple-touch-icon-57x57.png "daniele-autizi")

This is a personal website which is intended to be a playground env other than personal info window. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

You need MongoDB up and running.

### Building

```
gradle build
```

### Running

```
gradle bootRun
```

### Debugging

```
gradle debug
```

### Storage
This website has one dedicated mongodb database composed of the following collections:
1. log
2. mail


## Services 

This web application consumes personal-data-service endpoints in order to fetch data.
The service configuration is made via spring-cloud-starter-ribbon and configured with 
spring-cloud-starter-hystrix.
