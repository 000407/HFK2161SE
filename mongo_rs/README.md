# Mongo DB Replica Set in Docker

1. Run `docker-compose up -d` from the command prompt in the directory where you have the `docker-compose.yml` file saved.
2. Once the docker containers are up and running, bash into `localmongo1` with the command `docker exec -ti localmongo1 /bin/bash`
3. Type `mongo` and press enter.
4. Copy the command in `rs_init.js` file and paste it into the terminal. Then press enter.
5. The following should be the output

```cmd
Microsoft Windows [Version 10.0.19042.1165]
(c) Microsoft Corporation. All rights reserved.

D:\01Academic\02Lecturing\APIIT\03_EIRLSS\demo\mongo_rs>docker-compose up -d
Creating network "mongo_rs_default" with the default driver
Pulling mongo1 (mongo:4.0-xenial)...
4.0-xenial: Pulling from library/mongo
58690f9b18fc: Pull complete
b51569e7c507: Pull complete
da8ef40b9eca: Pull complete
fb15d46c38dc: Pull complete
8c5b4403b3cc: Pull complete
a336ecd37208: Pull complete
12c733cd45a4: Pull complete
0500d06255ed: Pull complete
166a5a996686: Pull complete
709f9e8f3eb4: Pull complete
92d1205971e6: Pull complete
c1ddc3e3ad82: Pull complete
bc30d42d189d: Pull complete
Digest: sha256:09018609dd0e386d025ab93aed513335f80aec08473367fff6f7aa1e91a192da
Status: Downloaded newer image for mongo:4.0-xenial
Creating localmongo1 ... done
Creating localmongo2 ... done
Creating localmongo3 ... done

D:\01Academic\02Lecturing\APIIT\03_EIRLSS\demo\mongo_rs>docker exec -ti localmongo1 /bin/bash
root@mongo1:/# mongo
MongoDB shell version v4.0.26
connecting to: mongodb://127.0.0.1:27017/?gssapiServiceName=mongodb
Implicit session: session { "id" : UUID("71d52e62-d658-41fd-bae4-e4c500e27bd5") }
MongoDB server version: 4.0.26
Welcome to the MongoDB shell.
For interactive help, type "help".
For more comprehensive documentation, see
        http://docs.mongodb.org/
Questions? Try the support group
        http://groups.google.com/group/mongodb-user
Server has startup warnings:
2021-09-04T07:27:14.453+0000 I STORAGE  [initandlisten]
2021-09-04T07:27:14.453+0000 I STORAGE  [initandlisten] ** WARNING: Using the XFS filesystem is strongly recommended with the WiredTiger storage engine
2021-09-04T07:27:14.453+0000 I STORAGE  [initandlisten] **          See http://dochub.mongodb.org/core/prodnotes-filesystem
2021-09-04T07:27:15.264+0000 I CONTROL  [initandlisten]
2021-09-04T07:27:15.264+0000 I CONTROL  [initandlisten] ** WARNING: Access control is not enabled for the database.
2021-09-04T07:27:15.264+0000 I CONTROL  [initandlisten] **          Read and write access to data and configuration is unrestricted.
2021-09-04T07:27:15.264+0000 I CONTROL  [initandlisten] ** WARNING: You are running this process as the root user, which is not recommended.
2021-09-04T07:27:15.264+0000 I CONTROL  [initandlisten]
2021-09-04T07:27:15.264+0000 I CONTROL  [initandlisten]
2021-09-04T07:27:15.264+0000 I CONTROL  [initandlisten] ** WARNING: /sys/kernel/mm/transparent_hugepage/enabled is 'always'.
2021-09-04T07:27:15.264+0000 I CONTROL  [initandlisten] **        We suggest setting it to 'never'
2021-09-04T07:27:15.264+0000 I CONTROL  [initandlisten]
---
Enable MongoDB's free cloud-based monitoring service, which will then receive and display
metrics about your deployment (disk utilization, CPU, operation statistics, etc).

The monitoring data will be available on a MongoDB website with a unique URL accessible to you
and anyone you share the URL with. MongoDB may use this information to make product
improvements and to suggest MongoDB products and deployment options to you.

To enable free monitoring, run the following command: db.enableFreeMonitoring()
To permanently disable this reminder, run the following command: db.disableFreeMonitoring()
---

> rs.initiate({_id : 'rs0',members: [{ _id : 0, host : "mongo1:27017" },{ _id : 1, host : "mongo2:27017" },{ _id : 2, host : "mongo3:27017" }]})
{ "ok" : 1 }
rs0:SECONDARY> exit
bye
root@mongo1:/# exit
exit

D:\01Academic\02Lecturing\APIIT\03_EIRLSS\demo\mongo_rs>
```