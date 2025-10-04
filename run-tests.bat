@echo off



setlocal enabledelayedexpansion







echo ==========================



echo 🛠 Automation Test Runner  



echo ==========================



echo Project: Default Project



echo Folder: Default Project_2025-10-04T07-39-03



echo ==========================







:: Set the project directory directly to Downloads folder



set "PROJECT_DIR=%USERPROFILE%\Downloads\Default Project_2025-10-04T07-39-03"



echo Project directory: %PROJECT_DIR%







:: Verify pom.xml exists in the project directory



if not exist "%PROJECT_DIR%\pom.xml" (



    echo ❌ pom.xml not found in %PROJECT_DIR%



    echo Please make sure you have extracted the project ZIP file to your Downloads folder



    echo.



    echo Press any key to exit...



    pause >nul



    exit /b 1



)



echo ✅ Found pom.xml in project directory







echo.



echo Changing to project directory: %PROJECT_DIR%



cd /d "%PROJECT_DIR%"







echo.



echo Current working directory: %CD%



echo Contents of current directory:



dir /b







echo.



echo ==========================



echo 🚀 Running Maven Clean Test



echo ==========================



echo Command: mvn clean test



echo.







:: Run Maven tests with error handling



mvn clean test



set "EXIT_CODE=%ERRORLEVEL%"







echo.



echo Maven command completed with exit code: %EXIT_CODE%







:: Show detailed result



echo.



echo ==========================



if %EXIT_CODE%==0 (



    echo ✅ Test execution completed successfully!



    echo All tests passed without errors.



) else (



    echo ❌ Test execution failed with exit code %EXIT_CODE%



    echo.



    echo Common issues and solutions:



    echo - Check if all dependencies are available



    echo - Verify Java version compatibility  



    echo - Check test configuration in pom.xml



    echo - Review error messages above for specific issues



    echo.



    echo If you see compilation errors, make sure:



    echo - Java JDK is installed (not just JRE)



    echo - JAVA_HOME environment variable is set



    echo - Java version matches project requirements



)



echo ==========================



echo 🛑 Script finished



echo ==========================



echo.



echo Press any key to exit...



pause >nul



exit /b %EXIT_CODE%