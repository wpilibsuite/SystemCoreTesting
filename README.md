# SystemCoreTesting
Repository for Alpha and Beta testing of Systemcore and Motioncore devices

Note that all updated documentation for 2027 WPILib changes, new features, etc. can be found on the '2027' version of the WPILib Docs site: https://docs.wpilib.org/en/2027/.

>**Software posted here is Alpha software for the 2027 season and is not compatible with Control Hub or roboRIO**

![SystemcoreTopHousing](https://ik.imagekit.io/llimi/controlsystem/tophousingcrop)

[Systemcore Specification PDF](https://downloads.limelightvision.io/documents/systemcore_specifications_june15_2025_alpha.pdf)

>**Alpha units do not have port labels**
![SystemcoreUnboxing](https://ik.imagekit.io/llimi/controlsystem/scunboxing.png)

## Beta Software Directory

### Tooling

[2027 WPILib Installer]( https://packages.wpilib.workers.dev/installer/v2027.0.0-alpha-1/)

[Limelight Hardware Manager 2.0.1](https://downloads.limelightvision.io/software/LimelightHardwareManagerSetup2_0_1.exe)

[OS Releases, Toolchain, Package Examples, Cross-Compilation Examples](https://github.com/LimelightVision/systemcore-os-public)

### Vendor Libraries

### Other
* [AdvantageScope 2027 Alpha](AdvantageScope.md)

## Alpha 1 Goals

* Maximize 'drive time' with Systemcore, ideally with Swerve Drive FRC Robots.
* Gather feedback on hardware reliability, ease-of-use, connectors, and more.
* Eliminate as many points of confusion and frustration as possible.

## Systemcore Quick Start

|  |  |
|---------|-------|
| Built-in Wi-Fi Access Point SSID | SYSTEMCORE |
| Built-in Wi-Fi Access Point Password | PASSWORD |
| Systemcore Wi-Fi Access Point IP | 172.30.0.1 |
| Systemcore USB IP (Windows) | 172.28.0.1 |
| Systemcore USB IP (Linux, Mac) | 172.29.0.1 |
| Default User | systemcore |
| Default Password | systemcore |
| Default Mount Locations for USB Storage | /U, /V ...|
| CAN Bus Interface Names| can_s0, can_s1, can_s2, can_s3, can_s4 |

### Powering On

Connect your Systemcore to your robot's power distribution board. We recommend the use of 18AWG wire with white Weidmuller ferrules.

### Flash Mode

If the USBC-port is attached before power is applied, Systemcore will boot into flash mode.

### Flashing OS Updates
Alpha Units ship with OS Release 157. Feel free to skip this step and jump right into programming if you're just getting started

[Systemcore Flash Tutorial Video (60s)](https://player.vimeo.com/video/1095423117)
<details>
<summary>Flashing OS Updates (Windows)</summary>

1. Download the latest release from the [systemcore-os-public repository](https://github.com/LimelightVision/systemcore-os-public)
2. Make sure the new [Limelight Hardware Manager 2.0.1](https://downloads.limelightvision.io/software/LimelightHardwareManagerSetup2_0_1.exe) is installed
3. Open Limelight Hardware Manager
3. Navigate to the Flash OS Tab
4. Boot Systemcore into Flash Mode (see 'power' section above). You should see activity in the log window. If you don't see anything, click the 'reinstall drivers' button at .
5. Select an OS .zip or .img to flash. Wait for extraction to complete.
6. Refresh drives and select the one marked as Limelight/Systemcore. 
7. Click the “Flash” Button after it starts flashing.
8. Once complete, remove USB and power from Systemcore


>**Full System Images will take several minutes to flash. Systemcore will soon support fast OTA updates.**

> **The new HardwareManager will soon be cross-platform. See flash instructions for other platforms below:**
</details>

<details>
<summary>Flashing OS Updates (Mac)</summary>

1. Download [Balena Etcher](https://etcher.balena.io/).
2. Spin-up RPIBoot:
    ```
    brew install libusb
    brew install pkg-config
    git clone --recurse-submodules --shallow-submodules --depth=1 https://github.com/raspberrypi/usbboot
    cd usbboot
    make
    cd mass-storage-gadget64
    sudo ../rpiboot -d .
    ```
3. Boot Systemcore into Flash Mode.
4. Flash with Etcher.

</details>

<details>
<summary>Flashing OS Updates (Ubuntu/Debian)</summary>

1. Download [Balena Etcher](https://etcher.balena.io/).
2. Spin-up RPIBoot:
    ```
    apt update
    apt install libusb-1.0-0-dev pkg-config build-essential
    git clone --recurse-submodules --shallow-submodules --depth=1 https://github.com/raspberrypi/usbboot
    cd usbboot
    make
    cd mass-storage-gadget64
    sudo ../rpiboot -d .
    ```
3. Boot Systemcore into Flash Mode.
4. Flash with Etcher.

</details>

### Accessing the Web Interface and Setting Your Team Number

1. Boot Systemcore normally.
2. Connect via USB, Ethernet, or Wi-Fi
3. Navigate to http://robot.local in a web browser. 
4. Configure your team number in the configuration tab, and click the red "Change Team Number" Button.

![](https://ik.imagekit.io/llimi/controlsystem/teamnumber.png)

6. Open the NI DriverStation and configure it with a matching team number
7. The NI DriverStation should establish communications with Systemcore at this point.

![](https://ik.imagekit.io/llimi/controlsystem/dsconnectivity.png)

### Deploying Your First Robot Program to Systemcore

1. Boot and establish connectivity with your Systemcore.
2. Ensure WPILIB 2027 has been installed.
3. Open '2027 WPILib VSCode' 
4. Make a new WPILib project as you normally would, and make sure to set the correct team number during the project creation step.
5. Deploy the project as you normally would.
6. The NI DriverStation should reflect the presence of robot code.

![](https://ik.imagekit.io/llimi/controlsystem/dscode.png)

7. You're now ready enable.

### Exploring On-Robot Telemetry with Elastic and AdvantageScope

[Package Installation Tutorial Video (30s)](https://player.vimeo.com/video/1095497571)

1. Download the Elastic and AdvantageScope IPK packages.
2. Navigate to the web interface.
3. Click the "Add Package" card. 
4. Install one package at a time.
5. Click the new "Elastic" or "AdvantageScope Lite" launch cards.
6. Use Elastic and AdvantageScope as you normally would. A quick way to add live telemetry to your robot is the use of the SmartDashboard API (subject to change soon) ```SmartDashboard.putNumber("key",value);```.
>**Elastic and AdvantageScope Lite packages will soon be pre-baked into the OS**

### Enabling CANivore Support

[Package Installation Tutorial Video (30s)](https://player.vimeo.com/video/1095497571)

1. Download the CANivore IPK packages.
2. Navigate to the web interface.
3. Click the "Add Package" card. 
4. Install the usb-kernel package, and then install the usb package.
5. Powercycle your Systemcore.


