#!/bin/bash
PATH2DIR=/Users/michaelkunkel/WORK/GIT_HUB/clas12-offline-software

### create local mvn repo containing coat-libs and jcsg ##
mvn deploy:deploy-file -Dfile=$PATH2DIR/common-tools/coat-lib/target/coat-libs-3.0-SNAPSHOT.jar -DgroupId=org.jlab.clas -DartifactId=common-tools -Dversion=0.0 -Dpackaging=jar -Durl=file:./myLocalMvnRepo/ -DrepositoryId=myLocalMvnRepo -DupdateReleaseInfo=true
if [ $? != 0 ] ; then echo "failed to create local mvn repo" ; exit 1 ; fi
mvn deploy:deploy-file -Dfile=$PATH2DIR/common-tools/clas-jcsg/build/libs/jcsg-0.3.2.jar -DgroupId=org.jlab.clas -DartifactId=clas-jcsg -Dversion=0.0 -Dpackaging=jar -Durl=file:./myLocalMvnRepo/ -DrepositoryId=myLocalMvnRepo -DupdateReleaseInfo=true
if [ $? != 0 ] ; then echo "failed to create local mvn repo" ; exit 1 ; fi


### add dc jar to local mvn repo ###
mvn deploy:deploy-file -Dfile=$PATH2DIR/reconstruction/dc/target/clas12detector-dc-1.0-SNAPSHOT.jar -DgroupId=org.jlab.service.dc -DartifactId=clas12detector-dc -Dversion=0.0 -Dpackaging=jar -Durl=file:./myLocalMvnRepo/ -DrepositoryId=myLocalMvnRepo -DupdateReleaseInfo=true
if [ $? != 0 ] ; then echo "dc failure" ; exit 1 ; fi

#### end ###
echo "myLocalRepo SUCCESSFULLY BUILT !"
#
#mvn install:install-file -Dfile=/Users/michaelkunkel/WORK/GIT_HUB/clas12-offline-software/common-tools/coat-lib/target/coat-libs-3.0-SNAPSHOT.jar -DgroupId=org.jlab.clas -DartifactId=common-tools -Dversion=0.0 -Dpackaging=jar -DgeneratePom=true -DlocalRepositoryPath=.
