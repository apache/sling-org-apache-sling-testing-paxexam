[![Apache Sling](https://sling.apache.org/res/logos/sling.png)](https://sling.apache.org)

&#32;[![Build Status](https://ci-builds.apache.org/job/Sling/job/modules/job/sling-org-apache-sling-testing-paxexam/job/master/badge/icon)](https://ci-builds.apache.org/job/Sling/job/modules/job/sling-org-apache-sling-testing-paxexam/job/master/)&#32;[![Test Status](https://img.shields.io/jenkins/tests.svg?jobUrl=https://ci-builds.apache.org/job/Sling/job/modules/job/sling-org-apache-sling-testing-paxexam/job/master/)](https://ci-builds.apache.org/job/Sling/job/modules/job/sling-org-apache-sling-testing-paxexam/job/master/test/?width=800&height=600)&#32;[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=apache_sling-org-apache-sling-testing-paxexam&metric=coverage)](https://sonarcloud.io/dashboard?id=apache_sling-org-apache-sling-testing-paxexam)&#32;[![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=apache_sling-org-apache-sling-testing-paxexam&metric=alert_status)](https://sonarcloud.io/dashboard?id=apache_sling-org-apache-sling-testing-paxexam)&#32;[![JavaDoc](https://www.javadoc.io/badge/org.apache.sling/org.apache.sling.testing.paxexam.svg)](https://www.javadoc.io/doc/org.apache.sling/org.apache.sling.testing.paxexam)&#32;[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.apache.sling/org.apache.sling.testing.paxexam/badge.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.apache.sling%22%20a%3A%22org.apache.sling.testing.paxexam%22)&#32;[![testing](https://sling.apache.org/badges/group-testing.svg)](https://github.com/apache/sling-aggregator/blob/master/docs/groups/testing.md) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

# Apache Sling Testing PaxExam

This module is part of the [Apache Sling](https://sling.apache.org) project.


## Overview

This module provides test support for use with [Pax Exam](https://github.com/ops4j/org.ops4j.pax.exam2) to test with *real* Sling instances – no limitations or issues due to incomplete and faulty mock implementations.

See Testing PaxExam's [documentation page](https://sling.apache.org/documentation/development/testing-paxexam.html) for details and how to use.


## Features

* Run integration tests in a *tailored* Sling instance in the *same module* (with the build artifact under test)
* Use different versions in build (e.g. *minimal*) and tests (e.g. *latest*)
* Overriding of versions
* Adjusting of provided Options (`ModifiableCompositeOption`s)
* Build bundles with test content and OSGi DS services on-the-fly (no need for extra modules)
* Start Docker containers via [Testcontainers](https://www.testcontainers.org/)
