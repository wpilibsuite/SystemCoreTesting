# Elastic 2027 Alpha

The 2027 Alpha versions of Elastic can be found [here](https://github.com/Gold872/elastic-dashboard/releases).

## Web Support

The biggest addition for 2027 Elastic is support for web browsers. The web version of Elastic is nearly identical to the desktop with the following exceptions:
- Does not allow automatic control over window sizing
- Assets can not be viewed dynamically through the settings menu
- Integers that are larger than 2^53 - 1 will be truncated to a smaller number due to internal limitations of JavaScript

## Changelog

### 2027.0.0 Alpha 3

- Fix issue where camera streams would stop cycling through URLs

### 2027.0.0 Alpha 2

- Fix issue where fonts won't load on web

### 2027.0.0 Alpha 1

Initial 2027 Alpha release of Elastic

Adds the following additions for the 2027 version of Elastic
- Support for the Web
- Remove all references to RoboRIO IP addresses
- Add ability to connect to the SystemCore's internal Network Tables server
