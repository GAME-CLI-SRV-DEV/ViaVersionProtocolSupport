# ViaVersionProtocolSupport

![ViaVersionProtocolSupport](https://github.com/user-attachments/assets/286e9bf8-63c5-4208-83e8-34afa77ac676)

ViaVersionProtocolSupport adds compatibility for Minecraft versions 1.4.6–1.6.4, similar to what ProtocolSupport provided, and extends support to classic versions (c0.0.15–1.4.6), which ProtocolSupport did not cover. 

> **Note:** Fallback support is limited to versions 1.0.0–1.6.4 and may not work with ViaProxy unless `Use-ViaLegacy` is disabled.

---

## Requirements

- **Plugins:** ViaVersion, ViaBackwards, ViaRewind (conflicts are possible but required).
- **Server:** Spigot 1.4.4–1.6.4 (VVPS-Spigot) or Paper 1.21.1 (VVPS-Paper).

---

## Transitioning from ProtocolSupport

1. Stop your server.
2. Remove the ProtocolSupport plugin.
3. Add `ViaVersionProtocolSupport` to the `plugins` folder.
4. Restart the server.

---

## Bedrock Edition Support

### Direct Support:
- **Supported:** Sponge platform with Geyser and Floodgate integration.
- **Unsupported:** For Paper, BungeeCord, Velocity, and other platforms, use GeyserMC tailored to each platform.

| Platform                     | Geyser Plugin Required           |
|------------------------------|-----------------------------------|
| ViaVersionProtocolSupport - Paper | Geyser-Spigot                  |
| ViaVersionProtocolSupport - ViaProxy | Geyser-ViaProxy               |
| ViaVersionProtocolSupport - Velocity | Geyser-Velocity               |

---

## Plugin Compatibility with ProtocolSupport API

Plugins using ProtocolSupport API are **not compatible** with ViaVersionProtocolSupport.  
To ensure compatibility, rewrite your plugin using `ViaAPI` or `ProtocolLib`.

---

## Legacy Version Installation

To install on legacy servers (1.4.4–1.6.4):
1. Download `VVPS-Spigot`.
2. Place it in the `plugins` folder.
3. Restart the server.

**Note:** This method is experimental and may not be fully supported.

---

## BungeeCord and Waterfall Support

- **Waterfall Support:** Not planned. Use Velocity or install VVPS on the backend servers.
- **Transition from ProtocolSupportBungee:**
  1. Install Velocity.
  2. Download `ViaVersionProtocolSupportVelocity`.
  3. Configure Velocity for use with 1.6.4–1.4.6 clients.

---

## Supported Minecraft Versions

| MC Version                     | Status                             |
|--------------------------------|-------------------------------------|
| 15w31a–15w31b -> 1.8           | Requires ViaVersion                |
| 1.7.2–1.7.5 -> 1.6.4           | 99% compatibility, fallback disabled |
| 1.6.2 -> 1.6.4                 | Fully functional                   |
| 1.6.2 -> 1.6.1                 | Fully functional                   |
| 1.6.1 -> 1.5.0–1.5.2           | Fully functional                   |
| 1.5.0–1.5.2                    | Available via ViaLegacy            |
| 1.5.0 -> 1.4.6–1.4.7           | Fully functional                   |

---

## Pocket Edition Server Usage

**Note:** This method is experimental. Use with caution.  
Example setup for PowerNukkitX servers:
1. Install PowerNukkitX and place the jar in the `plugins` folder.
2. Restart the server.

---

## Standalone Usage

For standalone usage with ViaProxy:
1. Place `ViaVersionProtocolSupport` in the `plugins` folder.
2. **Note:** `ViaLoader` is not supported yet.

---

## Inspired by ProtocolSupport

This project is inspired by ProtocolSupport.  
Thanks to the original developers for their contributions!

---

## Special Thanks

- [RaphiMC](https://github.com/RaphiMC) & [Lenni0451](https://github.com/Lenni0451): Developers of ViaLegacy (library API for VVPS protocol) and ViaProxy.
- [lowercasebtw](https://github.com/lowercasebtw/): Creator of ViaSnapshot (requires AbstractProtocol).
- [ViaBackwards](https://github.com/ViaVersion/ViaBackwards): Provided templates and platform code.
- [ViaRewind](https://github.com/ViaVersion/ViaRewind): Supported compatibility between 1.7 and 1.8 for ViaLegacy.

