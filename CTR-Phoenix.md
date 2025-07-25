# CTR-Electronics Phoenix 6

Please read through the requirements and basic example before utilizing the vendordep.

## Requirements

Due to the volatile nature of versions and breaking changes, the below list is provided to clarify compatible WPILib version, compatible Phoenix 6 API version and compatible firmware version.

### WPILib to Phoenix 6 API

- WPILib `2027_alpha1` compatible releases
  - Phoenix 6 `25.90.0-alpha-1`

### Phoenix 6 API to Firmware

- `25.90.0-alpha-1` compatible Phoenix 6 firmware
  - Firmware `25.90.0.0`

## Python Usage

It is highly recommended to explicitly pin the Python dependency in your `project.toml`.

```
requires = [
    "phoenix6==25.90.0a1"
]
```

## Basic Example

SystemCore CAN buses can be used by specifying their interface name. From left to right (left being closest to the power input), the buses are

- `can_s0`
- `can_s1`
- `can_s2`
- `can_s3`
- `can_s4`

So to initialize a device on the SystemCore bus, you would use 

```java
// Use the 5th (0-indexed) CAN bus
public static final TalonFX m_motor = new TalonFX(0, "can_s4");

// If no parameter is provided, it will use can_s0
public static final TalonFX m_motor = new Talonfx(0);
```

## Changelog

### 25.90.0-alpha-1

- Devices no longer implement sendable as it has been removed from WPILib.

## Erratas/Known Issues

- Alpha-1: Phoenix 5 is unavailable.
- Alpha-1: Python wheels are unavailable.
- Alpha-1: An offline installer is unavailable.
- Alpha-1: Signal logger does not auto-start on FMS.
- Alpha-1: Tuner cannot deploy a temporary diagnostic server to the SystemCore. To use Phoenix Tuner X functionality, deploy a blank robot program with a Phoenix 6 device initialized. No other Tuner functionality is affected.

## Download

* Vendordep: `https://maven.ctr-electronics.com/release/com/ctre/phoenix6/latest/Phoenix6-25.90.0-alpha-1.json`

* Firmware: Tuner -> For the year dropdown select `2027-alpha-1` -> Firmware will be automatically populated

* canivore-usb-kernel Package: https://ctre.download/files/canivore-usb-kernel_1.14_aarch64.ipk

* canivore-usb Package: https://ctre.download/files/canivore-usb_1.14_aarch64.ipk