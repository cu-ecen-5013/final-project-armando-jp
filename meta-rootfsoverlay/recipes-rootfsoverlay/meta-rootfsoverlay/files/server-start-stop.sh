#!/bin/sh

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
