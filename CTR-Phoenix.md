# CTR-Electronics Phoenix 6

Please read through the requirements and basic example before utilizing the vendordep.

## Requirements

Due to the volatile nature of versions and breaking changes, the below list is provided to clarify compatible WPILib version, compatible Phoenix 6 API version and compatible firmware version.

### WPILib to Phoenix 6 API

- WPILib 2027_alpha1 compatible releases
  - Phoenix 6 `25.90.0-alpha-1`

### Phoenix 6 API to Firmware

- `25.90.0-alpha-1` compatible Phoenix 6 firmware
  - Firmware `25.90.0.0`

## Basic Example

SystemCore CAN buses can be used by specifying their interface name. From left to right (left being closest to the power input), the buses are

- `can_s0`
- `can_s1`
- `can_s2`
- `can_s3`
- `can_s4`

So to initialize a device on the SystemCore bus, you would use 

```java
public static final TalonFX m_motor = new TalonFX(0, "can_s0");
```

## Changelog

### 25.90.0-alpha-1
- no user facing changes since 25.4.0

## Erratas/Known Issues

- Alpha-1: Phoenix 5 is unavailable.
- Alpha-1: Python wheels are unavailable.
- Alpha-1: Tuner cannot deploy a temporary diagnostic server to the SystemCore. To use Phoenix Tuner X functionality, deploy a blank robot program with a Phoenix 6 device initialized. No other Tuner functionality is affected.

## Download
- Vendordep is available at https://raw.githubusercontent.com/wpilibsuite/SystemCoreTesting/refs/heads/main/vendordeps/Phoenix6-frc2027-alpha-1.json
- Firmware is available at ...
