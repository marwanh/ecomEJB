* sudo docker pull telegraf

* mkdir /home/marwan/telegraf

* sudo docker run --rm telegraf -sample-config > telegraf/telegraf.conf

* sudo docker run -d --restart=always -e "HOST_PROC=/rootfs/proc" -e "HOST_SYS=/rootfs/sys" -e "HOST_ETC=/rootfs/etc" -v $(pwd)/telegraf/telegraf.conf:/etc/telegraf/telegraf.conf:ro -v /var/run/docker.sock:/var/run/docker.sock:ro -v /sys:/rootfs/sys:ro -v /proc:/rootfs/proc:ro -v /etc:/rootfs/etc:ro telegraf
