#!/bin/bash



set -e







echo "=========================="



echo "🛠 Automation Test Runner"



echo "=========================="



echo "Project: Default Project"



echo "Folder: Default Project_2025-10-04T07-39-03"



echo "=========================="







# Get current directory (where this script is located)



SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"



echo "Current directory: $SCRIPT_DIR"







# Check if we're already in the project folder



if [ -f "$SCRIPT_DIR/pom.xml" ]; then



    echo "✅ Found pom.xml in current directory"



    PROJECT_DIR="$SCRIPT_DIR"



else



    # Look for pom.xml in subdirectories



    echo "Looking for pom.xml in subdirectories..."



    PROJECT_DIR=""



    for dir in "$SCRIPT_DIR"/*; do



        if [ -d "$dir" ] && [ -f "$dir/pom.xml" ]; then



            PROJECT_DIR="$dir"



            echo "✅ Found pom.xml in: $dir"



            break



        fi



    done



    



    # If not found, check Downloads folder



    if [ -z "$PROJECT_DIR" ]; then



        echo "No pom.xml found locally, checking Downloads folder..."



        DOWNLOADS_DIR="$HOME/Downloads"



        echo "Downloads folder: $DOWNLOADS_DIR"



        



        # Find latest ZIP file



        LATEST_ZIP=$(ls -t "$DOWNLOADS_DIR"/*.zip 2>/dev/null | head -n1)



        if [ -z "$LATEST_ZIP" ]; then



            echo "❌ No ZIP file found in $DOWNLOADS_DIR"



            read -p "Press Enter to exit..."



            exit 1



        fi



        echo "Latest ZIP found: $(basename "$LATEST_ZIP")"



        



        # Temp extraction folder



        TEMP_DIR="/tmp/automationRepo"



        rm -rf "$TEMP_DIR"



        mkdir -p "$TEMP_DIR"



        echo "Temp extraction folder: $TEMP_DIR"



        



        # Extract ZIP



        echo "Extracting ZIP..."



        unzip -q "$LATEST_ZIP" -d "$TEMP_DIR"



        



        # Find project folder with pom.xml



        PROJECT_DIR=$(find "$TEMP_DIR" -name "pom.xml" -type f | head -n1 | xargs dirname)



        if [ -z "$PROJECT_DIR" ]; then



            echo "❌ No project folder with pom.xml found!"



            read -p "Press Enter to exit..."



            exit 1



        fi



    fi



fi







echo "=========================="



echo "🚀 Starting Test Execution"



echo "=========================="



echo "Project directory: $PROJECT_DIR"







# Check if Maven is installed



if ! command -v mvn &> /dev/null; then



    echo "❌ Maven is not installed or not in PATH!"



    echo "Please install Maven first:"



    echo "- macOS: brew install maven"



    echo "- Ubuntu/Debian: sudo apt-get install maven"



    echo "- CentOS/RHEL: sudo yum install maven"



    read -p "Press Enter to exit..."



    exit 1



fi







# Run Maven tests



echo "Running Maven tests with verbose output..."



cd "$PROJECT_DIR"



mvn clean test -X



EXIT_CODE=$?







# Show result



echo "=========================="



if [ $EXIT_CODE -eq 0 ]; then



    echo "✅ Test execution completed successfully!"



else



    echo "❌ Test execution failed with exit code $EXIT_CODE"



fi



echo "=========================="



echo "🛑 Script finished"



echo "=========================="



read -p "Press Enter to exit..."



exit $EXIT_CODE