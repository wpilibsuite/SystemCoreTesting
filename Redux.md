# ReduxLib

The current version of ReduxLib for SystemCore is **2027.0.0-alpha-2.**

It supports WPILib alpha version **2027.0.0-alpha-2**.

## Install

### JSON

```txt
https://frcsdk.reduxrobotics.com/ReduxLib_2027.json
```

### Offline install zip

Extract this into the root of your `wpilib/2027_alpha1` directory.

This is in `~/wpilib/2027_alpha1` on Linux/Mac, and on Windows it is typically in `C:\Users\Public\wpilib\2027_alpha1`

[ReduxLib-offline-v2027.0.0-alpha-2.zip](https://frcsdk.reduxrobotics.com/offline/ReduxLib-offline-v2027.0.0-alpha-2.zip)

## Usage

By default, if no bus is specified, devices will use SocketCAN bus **`can_s0`**.

An alternate SocketCAN bus can be specified with a bus string:

```java
Canandgyro gyro = new Canandgyro(0, "socketcan:can_s2");
```

## Known issues

* **C++ is currently unsupported.** This includes things that typically require the C++ bindings, such as Python. 
* v24 builds of Alchemist do not support the websocket/backend protocol that this vendordep uses. 
  **You will need to use a v25+ build of Alchemist.**

## Changelog

### ReduxLib v2027.0.0-alpha-2

- [General] Add support for WPILib v2027.0.0-alpha-2
- [General] Add rewritten driver backend
- [Canandgyro] `setYaw` and `setPose` now retry up to 5 times by default.
