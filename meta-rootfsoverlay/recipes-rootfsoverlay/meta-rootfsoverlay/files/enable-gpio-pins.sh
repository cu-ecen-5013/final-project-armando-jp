#!/bin/sh

#place me in /etc/rcS.d/ as S99server-start-stop.sh
# ORRRR /etc/init.d/ as S99server-start-stop.sh
# start the service aesdsocket
start ()
{
    echo ">>>>>>>>>>>>>>>>>>INITIALIZING GPIO"
    # echo 115 > /sys/class/gpio/export
    # echo out > /sys/class/gpio/gpio115/direction
    # echo 1 > /sys/class/gpio/gpio115/value
}

stop()
{
    echo ">>>>>>>>>>>>>>>> STOPPING GPIO"
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
