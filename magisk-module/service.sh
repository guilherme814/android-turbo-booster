#!/system/bin/sh

# Performance governor
echo performance > /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor

# Limpa cache (drop_caches)
sync
echo 3 > /proc/sys/vm/drop_caches

# Dexopt
cmd package bg-dexopt-job
