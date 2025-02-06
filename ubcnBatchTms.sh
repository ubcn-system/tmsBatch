#!/bin/sh
. ~/.bash_profile

#2023.03.28 twkim 최신 실행 스크립트
SERVICE_NAME=ubcnBatchTms
SERVICE_PATH=/app/vmms/Batch/jar
PATH_TO_JAR=$SERVICE_PATH/$SERVICE_NAME.jar
PID_PATH_NAME=./$SERVICE_NAME.pid
JAVA_OPT="-Xms1024m -Xmx2048m"

case $1 in
    start)
        echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            nohup java -jar $JAVA_OPT $PATH_TO_JAR > /dev/null 2>&1 &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is already running ..."
        fi
    ;;
    stop)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stoping ..."
            kill -9 $PID;
            echo "$SERVICE_NAME stopped ..."
            rm -f $PID_PATH_NAME
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
    restart)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stopping ...";
            kill -9 $PID;
            echo "$SERVICE_NAME stopped ...";
            rm -f $PID_PATH_NAME
            echo "$SERVICE_NAME starting ..."
            nohup java -jar $JAVA_OPT $PATH_TO_JAR  > /dev/null 2>&1 &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
esac
