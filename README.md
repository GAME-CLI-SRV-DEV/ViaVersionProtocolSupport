# ViaVersionProtocolSupport
![image](https://github.com/user-attachments/assets/286e9bf8-63c5-4208-83e8-34afa77ac676)

add 1.4.6-1.6.4 Support Like ProtocolSupport Used to do.

# Requirements
ViaVersion, ViaBackwards, and ViaRewind(It may collide but still required).
Craftbukkit/Spigot 1.6.4 or Paper 1.21.1

# Transition from ProtocolSupport
It's Easy. Put the plugin, Enable it.
Config is easy to use.
but i dont know what to put in
so... idk about ps config
# Do You Support Bedrock Edition(Pocket Edition) Directly?
Yes, But Only Sponge. See [This Pull](https://github.com/GeyserMC/Geyser/pull/4097) Why did ViaVersionProtocolSupport-Sponge Started to Include Geyser And Floodgate.

For Other Platform You Can Use GeyserMC for their platform.

# is ViaProxy Support Planned?
it's preparing, but do not open the oven.

# Are you going to Support Bungee?
Waterfall Support is not going to happen. install VVPS Core on Backend or Use Velocity.
Transitioning From [Waterfall 1.18.2](https://github.com/PaperMC/Waterfall/commit/55a77b6355d200913fc5fa8715142d22b46abd416fe64e7902726ce4a53f21df) and ProtocolSupportBungee(https://github.com/ProtocolSupport/ProtocolSupportBungee) is explained below

# Transitioning From ProtocolSupportBungee
You Need ViaVersionProtocolSupportVelocity or you need to install them on backend.
1. Download Velocity.
2. Download ViaVersionProtocolSupportVelocity
3. Velocity will initialize.
4. Join with 1.6.4-1.4.6 client(Currently Supports 1.6.4)

# Code From
ViaBackwards(Protocol template and Platform Code)
# ViaVersionProtocolSupport Allows:
ViaPS allows classic to 1.6-1.7

|MC Version Corresponding to ProtocolSupport Supported Protocol Version|status|
|--|--|
|1.7.2->1.6.4/2|70%|
|1.6.4/2|Implemented in ViaLegacy|
|1.6.2->1.6.1|0%|
|1.6.1->1.5.2|0%|
|1.5.0/1|Implemented in ViaLegacy|
|1.5.0->1.4.7/6|0%|

# Pocket Edition Usage
Warning: it is intended to work as Extension of Geyser. Spigot and Sponge is not supported because ViaBedrock Which makes that plugin functional is for BE Servers.
it is also unstable!!! 

it also uses ViaLoader, so you can use Anykind of Geyser versions :skull:.\
but i dont recommend using randumb geyser versions as it would look very outdated.\

The GeyserMC Version Includes [Only Pocket Edition](https://github.com/KejonaMC/GeyserBlockJavaPlayers) Bypasser called ViaBedrock.\
Download VVPS-Geyser, put it in the GeyserMC Folder, Start the Geyser, Then you can use ViaBedrock On VIAaaS. :haha:
This Extension dont work with inventory. so, you have to get ViaVersionProtocolSupportGeyserStuff(Uses Commands to equip inventory)


# Standalone Usage
### using ViaProxy
put it in the plugins folder
ViaLoader is Not Supported yet.
# Inspired by ProtocolSupport
Thank you!

# Note:
exclude("io/lenni0451/optconfig/**") is put on ViaProxy Subproject
# Thanks to
[RaphiMC](https://github.com/RaphiMC) & [Lenni0451](https://github.com/Lenni0451) for making ViaLegacy(Library API for VVPS Protocol) & ViaBedrock(Library API for VVPSGE Protocol)\
[ViaBackwards](https://github.com/ViaVersion/ViaBackwards) For Template(Very Cool)

