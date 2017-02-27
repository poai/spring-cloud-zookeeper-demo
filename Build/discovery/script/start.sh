#!/bin/bash
mainclass="org.discovery.App"
APP_HOME=$(cd "$(dirname "$0")";cd ..; pwd)
cd $APP_HOME
CLASSPATH=$APP_HOME
for file in "$APP_HOME"/lib/*.jar
do
CLASSPATH="$CLASSPATH":"$file"
done
java $mainclass > /dev/null &
