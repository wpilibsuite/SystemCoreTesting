# AdvantageScope 2027 Alpha

**Downloads for the 2027 alpha releases of AdvantageScope can be found [here](https://github.com/Mechanical-Advantage/AdvantageScope/releases).** The changelog below lists the available releases along with related compatibility information. See also the [known issues](#known-issues) section below.

### [v27.0.0-alpha-2](https://github.com/Mechanical-Advantage/AdvantageScope/releases/tag/v27.0.0-alpha-2)

- **Fixed rendering of WPILOGs with timestamp ranges starting after zero** (addresses the [known issue](#log-files-are-very-zoomed-out-by-default) below)
- **Fixed functionality of in-app menus on Windows and Linux**
- Added support for unit conversion with byte values
- Improved stability of YouTube and TBA video downloading
- Fixed visual artifacts on line graph tab with differentiated fields
- Fixed handling of `ELECTRON_RUN_AS_NODE` environment variable
- Fixed rendering of very large raw and array values

### [v27.0.0-alpha-1](https://github.com/Mechanical-Advantage/AdvantageScope/releases/tag/v27.0.0-alpha-1)

- Initial release for SystemCore

## 2027 Updates

The 2027 releases of AdvantageScope include several features to improve compatibility with SystemCore, which are listed below. Most of these changes are not documented yet, so please ask any questions on the [discussions page](https://github.com/wpilibsuite/SystemCoreTesting/discussions).

- Added log downloading support for SystemCore using SFTP
- Added support for the system NT server on SystemCore, including DS and joystick data (select "NetworkTables 4 (SystemCore)")
  - We plan to allow simultaneous connections to the primary and system NT server, but this feature is not currently available.
- Added optional support for the unified 2027 coordinate system (disabled by default)
  - This new coordinate system uses a center-field origin facing away from the red alliance, and is consistent across FRC and FTC. The default coordinate system remains unchanged to ease the transition when porting existing FRC code, but this can be changed in the preferences menu.
- Removed shortcut for the USB roboRIO address
  - Adjust the "Robot Address" in the preferences menu when connecting to SystemCore via USB. A shortcut for the SystemCore USB address(es) may be added in a future release.
- Removed support for legacy numeric array format ([docs](https://docs.advantagescope.org/legacy-formats))

### AdvantageScope Lite

This release also adds support for AdvantageScope Lite, a browser-based version of AdvantageScope accessible from the SystemCore web interface and intended for on-robot development ([video](https://youtu.be/lHsak9Mmx2M)). Most features of the AdvantageScope desktop app are included in AdvantageScope Lite, with the following **omissions**:

- Downloading & viewing local log files
  - Log files can be opened _directly_ from SystemCore and accessed in the browser, but they cannot be saved for "offline" use.
- Support for some logging formats, including [Hoot](https://v6.docs.ctr-electronics.com/en/stable/docs/api-reference/api-usage/signal-logging.html) and [Phoenix Diagnostics](https://docs.advantagescope.org/more-features/phoenix-diagnostics)
  - Some version of these features will likely be available in a future release of AdvantageScope Lite.
- Pop-out visualization windows (viewing multiple tabs at once)
- Exporting and importing tab layouts from a JSON file
- All features of the [video tab](https://docs.advantagescope.org/tab-reference/video)
- Integration with [AdvantageScope XR](https://docs.advantagescope.org/more-features/advantagescope-xr)

AdvantageScope Lite will be included in the SystemCore image, and can also be installed/updated separately by downloading the "SystemCore" version of AdvantageScope from the GitHub releases page. Additional assets (e.g. robot models) can be manually placed in the `/home/systemcore/ascope_assets` directory (this process will be streamlined in a future release).

## 2026 Updates

Many of the changes included in the 2027 alpha of AdvantageScope will _also_ be included in the 2026 beta of AdvantageScope later this year, as they are unrelated to the control system transition. These changes are listed below, as they differ from the 2025 version of AdvantageScope teams may be familiar with.

_Note that some of these features are incomplete or subject to change._

- Added support for FTC fields and robots
- Improved handling of coordinate systems for FTC compatibility
- Improved color options for robot bumpers
- Added partial support for 2D mechanisms on the YZ axis of 3D robots
- Added support for unit conversion with byte values
- Added support for 3D view antialiasing
- Renamed odometry tab to "2D Field" for consistency & accuracy
- Reorganized menu bar for consistency across platforms
- Removed "experimental" warning for AdvantageScope XR
- Removed support for Zebra MotionWorks (no longer in use at events)
- Restrict update checking to the current major version
- Improved the efficiency of line graph plotting
- Improved stability of YouTube and TBA video downloading
- Fixed handling of WPILOGs with timestamp ranges starting after zero
- Fixed rendering of very large raw and array values
- Fixed edge cases with "Zoom to Enabled Range" function
- Fixed visual artifacts on line graph tab with differentiated fields
- Fixed translucency of ghost objects on the 2D field
- Fixed a bug causing invalid 3D camera positions when reopening AdvantageScope
- Fixed the ordering of AdvantageKit logs with randomized names in the download window
- Fixed handling of default values and empty arrays in Protobuf messages
- Fixed handling of `ELECTRON_RUN_AS_NODE` environment variable

## Known Issues

### URCL is not supported

There is currently no 2027 alpha release for [URCL](https://docs.advantagescope.org/more-features/urcl) due to the limited featureset of the CAN API in the first 2027 alpha of WPILib. A 2027 alpha of URCL will be released at a later date.

### Joystick visualization with POVs is inaccurate

SystemCore and the 2027 alpha of WPILib use a new format for joystick POV values that is not currently compatible with AdvantageScope, causing the joystick visualization to display inaccurate data. This issue will be fixed in a future release.

### Keyboard shortcuts do not function consistently in AdvantageScope Lite

The menu bar in AdvantageScope Lite displays keyboard shortcut information, but these shortcuts may function inconsistently depending on the OS and browser. This issue is being investigated and will be fixed in a future release (see https://github.com/Mechanical-Advantage/AdvantageScope/issues/390).

### Log files are very zoomed out by default

_Fixed by [v27.0.0-alpha-2](#v2700-alpha-2)_

~~By default, log files from SystemCore currently use [epoch timestamps](https://en.wikipedia.org/wiki/Unix_time) that are not properly handled by AdvantageScope. This causes the timeline to be very zoomed out when opening log files, so significant zooming is required to access data. There are also various visual artifacts throughout the UI. This issue will be fixed in future releases of AdvantageScope and WPILib (see https://github.com/wpilibsuite/allwpilib/issues/8041).~~
