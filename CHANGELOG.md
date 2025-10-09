# Changelog

All notable changes to this project will be documented in this file.

## [1.0.1] - 2024

### Added
- `%plotowner_on_own_plot_<flag>%` placeholder to check if a specific flag is set on the current plot

### Fixed
- Fixed expansion persisting after deletion and reload
  - Removed `persist()` method override to use default behavior
  - Expansion now properly unregisters when JAR is deleted and PlaceholderAPI is reloaded

## [1.0.0] - 2024

### Added
- Initial release
- `%plotowner_on_own_plot%` placeholder to check if player is on their own plot
- Support for PlotSquared plot ownership detection
