**NOTE:Always make sure kafka-server is running**
---
**Useful Links:**

- https://docs.conduktor.io/desktop/kafka-cluster-connection/setting-up-a-connection-to-kafka/connecting-to-kafka-running-on-windows-wsl-2/
- https://stackoverflow.com/questions/64177422/unable-to-produce-to-kafka-topic-that-is-running-on-wsl-2-from-windows/65553634#65553634

---
PreRequisite
-   

    Disable IPv6 on WSL2:
    ----------------------
    sudo sysctl -w net.ipv6.conf.all.disable_ipv6=1
    sudo sysctl -w net.ipv6.conf.default.disable_ipv6=1

---
Section - 1
-
---

    --------------------------------------------------
    Step 1 - Import the project
    ----------------------------
    Dependencies added - 
    1. Web
    2. Kafka
    3. Devtools
    --------------------------------------------------
    Step 2 - Configure kafka producer and consumer
    ----------------------------------------------
        -   https://docs.spring.io/spring-kafka/reference/quick-tour.html
    --------------------------------------------------
    Step 3 - Create Kafka topic - "matuga"
    --------------------------------------------------
    Step 4 - Crete Kafka Producer 
    --------------------------------------------------
    Step 5 - Create Rest Endpoint
    --------------------------------------------------
    Step 6 - Create Consumer
    --------------------------------------------------
---
Section - 2
-

    --------------------------------------------------
    Kafka Producer and Consumer for JSON Message
    --------------------------------------------------
    Step 1 - Configure JSON Serializer and Deserializer
    --------------------------------------------------    
---
