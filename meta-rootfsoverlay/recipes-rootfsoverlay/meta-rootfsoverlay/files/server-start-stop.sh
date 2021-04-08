#!/bin/sh

#place me in /etc/rcS.d/ as S99server-start-stop.sh
# ORRRR /etc/init.d/ as S99server-start-stop.sh
# start the service aesdsocket
start ()
{
    echo ">>>>>>>>>>>>>>>> STARTING FINAL PROJECT SERVER"
    echo 115 > /sys/class/gpio/export
    echo out > /sys/class/gpio/gpio115/direction
    echo 1 > /sys/class/gpio/gpio115/value
    #start-stop-daemon -S -n server -a /usr/bin/server -- -d
}

stop()
{
    echo ">>>>>>>>>>>>>>>> STOPPING FINAL PROJECT SERVER"
    #start-stop-daemon -K -n server
}

# main logic
case "$1" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    *)
        echo $"Usage: $0 {start|stop}"
    exit 1
esac

exit 0
