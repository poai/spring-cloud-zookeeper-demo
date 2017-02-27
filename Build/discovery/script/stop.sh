mainclass="org.discovery.App"
pids=$(jps |grep TvcCloudToJM | cut -d ' ' -f  1)
for pid in $pids
do
    kill -9 $pid
done


