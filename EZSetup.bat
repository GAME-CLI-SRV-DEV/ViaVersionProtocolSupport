color 17
echo off
cls
echo ViaVersionProtocolSupport Setup Utility
echo ═══════════════════════════════════════
echo.
echo Welcome to ViaVersionProtocolSupport.
echo.
echo Copyright (C) 2015~2024, Approximaster Studios 2004. All Rights Reversed.
echo This Utility Helps You Switch to ViaVersionProtocolSupport(Note that it does not supports Waterfall->Velocity!).
echo.
echo Press Any Key To Continue...
cd plugins
cls
echo ViaVersionProtocolSupport Setup Utility - Loading: Bukkit Setup
echo ═══════════════════════════════════════════════════════════════
echo.
echo The ViaVersionProtocolSupport is Not Distributed. however, you can distribute it anyways.
echo.
echo Installing ViaVersion...
powershell.exe Invoke-WebRequest https://hangarcdn.papermc.io/plugins/ViaVersion/ViaVersion/versions/5.2.0/PAPER/ViaVersion-5.2.0.jar -OutFile plugins/viaversion.jar
powershell.exe Invoke-WebRequest https://hangarcdn.papermc.io/plugins/ViaVersion/ViaVersion/versions/5.2.0/PAPER/ViaBackwards-5.2.0.jar -OutFile plugins/viabackwards.jar
powershell.exe Invoke-WebRequest https://hangarcdn.papermc.io/plugins/ViaVersion/ViaVersion/versions/4.0.4/PAPER/ViaRewind-4.0.4.jar -OutFile plugins/viarewind.jar
cls
echo ViaVersionProtocolSupport Setup Utility - Formatting PS(S) Data
echo ═══════════════════════════════════════════════════════════════
echo.
echo WARNING!
echo This Will Format All ProtocolSupportStuff Data and the JAR!
echo.
:FormatPSSD
set /p PSSPATH=PSSD:
if PSSPATH equ *.* ( echo Why Do You Want to Format Your Plugin List All Of the sudden? goto :FormatPSSD ) else ( goto :FormatPSSData )
if PSSPATH equ %SystemDrive% ( echo Why Do You Want to Nuke Your Computer All Of The Sudden? goto :FormatPSSData ) else ( goto :PSData )
:FormatPSSData
set /p PSSPATH=PSS:
if PSSPATH equ *.* ( echo Why Do You Want to Format Your Plugin List All Of the sudden? goto :FormatPSSData ) else ( goto :PSData )
if PSSPATH equ *.* ( echo Why Do You Want to Format Your Plugin List All Of the sudden? goto :FormatPSSData ) else ( goto :PSData )
:PSData
set /p PSSPATH=PSS:
if PSSPATH equ *.* ( echo Why Do You Want to Format Your Plugin List All Of the sudden? goto :PSData ) else ( goto :FORMAT )
:FORMAT
cls
echo ViaVersionProtocolSupport Setup Utility - Formatting ProtocolSupport(Stuff) Data...
echo ═══════════════════════════════════════════════════════════════════════════════════
echo.
echo          Please Wait While The Setup Utility Deletes ProtocolSupport
echo                                and it's data...
echo.
cmd /c rd /s /q %PSSPATH%
del 
