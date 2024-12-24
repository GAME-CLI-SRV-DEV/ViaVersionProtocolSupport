# ViaVersionProtocolSupport
![image](https://github.com/user-attachments/assets/286e9bf8-63c5-4208-83e8-34afa77ac676)

add 1.4.6-1.6.4 Support Like ProtocolSupport Used to do, and add c0.0.15-1.4.6 support which protocolsupport didn't do.\
(Fallbacks Support Only 1.0.0-1.6.4. Fallback will not function on ViaProxy Unless Use-ViaLegacy Is Disabled)\
ProtocolSupport가 지원하였던 1.4.6-1.6.4 버전을 똑같이 지원합니다. 클래식-1.4.6도 지원합니다.
# Requirements
ViaVersion, ViaBackwards, and ViaRewind(It may collide but still required).\
ViaVersion, ViaBackwards, ViaRewind(1.8버전은 충돌할 확률이 큽니다)
Spigot 1.4.4-1.6.4(VVPS-Spigot) or Paper 1.21.1(VVPS-Paper)

# Transition from ProtocolSupport
Close Server.\
서버를 닫은 뒤,\
Delete ProtocolSupport.\
ProtocolSupport 플러그인을 삭제합니다.\
Put VVPS on it's place, "plugins".\
ProtocolSupport가 있었던 플러그인 폴더에다 ViaVersionProtocolSupport를 넣으세요.\
Open Server again.\
서버를 재개장합니다. 

# Do You Support Bedrock Edition(Pocket Edition) Directly? 베드락 클라이언트 직접지원하나요?
Yes, But Only Sponge. See [This Pull](https://github.com/GeyserMC/Geyser/pull/4097) for reason Why did ViaVersionProtocolSupport-Sponge Started to Include Geyser And Floodgate.

For Other Platform such as paper, bungee, velocity, viaproxy, ViaForgeSmart(ViaForge as a Server Mod), ViaFabricPlusmart(Server side mod ViaFabric Fork With ViaLegacy), You Can Use GeyserMC for their platform.

스펀지버전만 직접적으로 Geyser를 포함했기 때문에 가능합니다. 페이퍼, 벨로시티, 번지코드, ViaProxy 같은 경우는 해당 플랫폼에 대응하는 GeyserMC를 사용해야 합니다.

ViaVersionProtocolSupport 페이퍼 전용 플러그인 <-> Geyser-Spigot 플러그인\
ViaVersionProtocolSupport ViaProxy 전용 플러그인 <-> Geyser-ViaProxy 플러그인\
ViaVersionProtocolSupport 벨로시티 전용 플러그인 <-> Geyser-Velocity 플러그인\
ViaVersionProtocolSupport 번지코드 전용 플러그인 <-> Geyser-Bungeecord 플러그인

# I made my plugin with ProtocolSupport API. is it compatible?(제 플러그인이 PS기반인데 호환되나요?)
No it does not.\
ViaVersionProtocolSupport is ViaVersion Based Rewritten Fork Version of ProtocolSupport. so it's absolutely Not Compatible.\
For Your Plugin Can Work with VVPS, You Need To Use ViaAPI/ProtocolLib.\
안됩니다.\
이 플러그인은 ViaVersion의 API를 바탕으로 ProtocolSupport를 다시 맨땅에서 만들어가지고 호환이 되지 않습니다.\
VVPS랑 작동시키려면 ViaAPI/ProtocolLib으로 교체하세요.

# 베드락 서버 지원하나요?
실험적으로 지원하긴 하는데... 저건 꼬일 확률이 엄청 큽니다. ViaBedrock은 아직 미완성 상태 거든요.
Supported But it may cause issues. 
# is ViaProxy Support Planned?
준비 중 입니다.
it's preparing, do not open the oven.

# Legacy Version Installation
you need spigot 1.4.4-1.6.4\
Download VVPS-Spigot, Put it in the plugins folder\
and restart your server. 

This Method is Not Supported Yet.

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
ViaPS allows classic to 1.8 Even Snapshot 15w31(a/b).

|MC Version Corresponding to ProtocolSupport Supported Protocol Version|status|
|--|--|
|15w31a-15w31b->1.8|ViaVersion 필요|
|1.7.2-1.7.5->1.6.4|99% 0 ERRORS REMAINING BUT DISABLED|
|1.6.2->1.6.4|-|
|1.6.2->1.6.1|0% 0 ERRORS REMAINING|
|1.6.1->1.5.0-1.5.2|0% 0 ERRORS REMAINING|
|1.5.0-1.5.2|Implemented in ViaLegacy|
|1.5.0->1.4.6-1.4.7|0% 0 ERRORS REMAINING|

# Pocket Edition Server Usage
This is the Example of ViaVersion For Nukkit.

This Method is Not Supported Yet. Proceed with caution.

1. Run a PowerNukkitX Server and Put a JAR in the plugin folder.
2. Restart Your PowerNukkitX.

# Standalone Usage
### using ViaProxy
put it in the plugins folder.\
ViaLoader is Not Supported yet.

# Inspired by ProtocolSupport
Thank you.\
but rip bozo anyway :skull:

# Note:
exclude("net/raphimc/vialegacy/**") is put on ViaProxy Subproject.
# Thanks to
[RaphiMC](https://github.com/RaphiMC) & [Lenni0451](https://github.com/Lenni0451) for making ViaLegacy(Library API for VVPS Protocol) & ViaProxy\
[lowercasebtw](https://github.com/lowercasebtw/) for making ViaSnapshot(Requires AbstractProtocol)
[ViaBackwards](https://github.com/ViaVersion/ViaBackwards) For Template(Very Cool)
[ViaRewind](https://github.com/ViaVersion/ViaRewind) For 1.7.2-5<->1.7.6-10, 1.7.6-10<->1.8, 1.8<->1.9 for ViaLegacy.

