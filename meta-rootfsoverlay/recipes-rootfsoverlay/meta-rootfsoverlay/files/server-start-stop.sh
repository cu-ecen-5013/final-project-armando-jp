#!/bin/sh

#place me in /etc/rcS.d/ as S99server-start-stop.sh
# ORRRR /etc/init.d/ as S99server-start-stop.sh
# start the service aesdsocket
start ()
{
    echo "Starting final project server"
    start-stop-daemon -S -n server -a /usr/bin/server -- -d
}

stop()
{
    echo "Starting final project server"
    start-stop-daemon -K -n server
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
