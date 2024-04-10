#!/bin/sh

echo "Current directory: $(pwd)"
echo "Contents of current directory: $(ls -la)"

# Define the path to your properties file
PROPERTIES_FILE="src/main/resources/jenkins_temp.properties"
echo "Properties file path: $PROPERTIES_FILE"

# Define the new value for the key, retrieved from Jenkins parameter
NEW_VALUE="$messageFromJenkins"  # Use the environment variable set zby Jenkins for the choice parameter
echo "New value: $NEW_VALUE"

# Check if the properties file exists
if [ ! -f "$PROPERTIES_FILE" ]; then
    echo "Properties file not found: $PROPERTIES_FILE"
    exit 1
fi

# Update the value for the key
sed -i "s|^messageFromJenkins=.*$|messageFromJenkins=$NEW_VALUE|" "$PROPERTIES_FILE"

echo "Updated value of messageFromJenkins to $NEW_VALUE in $PROPERTIES_FILE"