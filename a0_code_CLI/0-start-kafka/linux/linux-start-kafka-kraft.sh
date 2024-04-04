################################
##                            ##
##        NO ZOOKEEPER        ##
##                            ##
################################


# create Kafka data directory
mkdir data/kafka-kraft

# Edit config/kraft/server.properties

# change lines to 
# log.dirs=/your/path/to/data/kafka
# example
# log.dirs=/home/kafka_2.13-3.1.0/data/kafka-kraft


# generate a Kafka UUID
kafka-storage.sh random-uuid

# This returns a UUID, for example 76BLQI7sT_ql1mBfKsOk9Q
kafka-storage.sh format -t {uuid} -c ~/kafka_2.13-3.1.0/config/kraft/server.properties

# kafka-storage.sh format -t z_1l56bVTPqswO8m8FjFHg -c ~/kafka_2.13-3.6.0/config/kraft/server.properties
# Response --> Formatting /tmp/kraft-combined-logs with metadata.version 3.6-IV2.


# This will format the directory that is in the log.dirs in the config/kraft/server.properties file

# start Kafka
kafka-server-start.sh ~/kafka_2.13-3.1.0/config/kraft/server.properties

# Kafka is running! 
# Keep the terminal window opened