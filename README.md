# PlotSquared PlaceholderAPI Expansion

A simple PlaceholderAPI expansion for PlotSquared that checks if a player is standing on their own plot.

## 📝 Placeholder

| Placeholder | Description | Returns |
|------------|-------------|---------|
| `%plotowner_on_own_plot%` | Checks if the player is standing on their own plot | `true` or `false` |

## 📋 Requirements

- Minecraft Server 1.21.x (Paper)
- Java 21
- [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/)
- [PlotSquared](https://www.spigotmc.org/resources/plotsquared-v7.77506/)

## 🔧 Installation

1. Download the latest release from the [Releases](../../releases) page
2. Place the JAR file in `plugins/PlaceholderAPI/expansions/`
3. Run `/papi reload`
4. Test with `/papi parse me %plotowner_on_own_plot%`

## 🛠️ Building from Source

```bash
gradle clean build
```

The compiled JAR will be in `build/libs/`

## 📖 Usage Example

```yaml
# Example: Show item only when player is on their own plot
item:
  material: DIAMOND
  name: "&aOn Own Plot!"
  view_requirement:
    requirements:
      on_plot:
        type: string equals
        input: "%plotowner_on_own_plot%"
        output: "true"
```

## 👤 Author

**AlphaBlock4k**

## 📄 License

This project is open source and available for free use.
