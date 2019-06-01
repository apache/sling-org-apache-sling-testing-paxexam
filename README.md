[<img src="https://sling.apache.org/res/logos/sling.png"/>](https://sling.apache.org)

 [![Build Status](https://builds.apache.org/buildStatus/icon?job=Sling/sling-org-apache-sling-testing-paxexam/master)](https://builds.apache.org/job/Sling/job/sling-org-apache-sling-testing-paxexam/job/master) [![Test Status](https://img.shields.io/jenkins/t/https/builds.apache.org/job/Sling/job/sling-org-apache-sling-testing-paxexam/job/master.svg)](https://builds.apache.org/job/Sling/job/sling-org-apache-sling-testing-paxexam/job/master/test_results_analyzer/) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.apache.sling/org.apache.sling.testing.paxexam/badge.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.apache.sling%22%20a%3A%22org.apache.sling.testing.paxexam%22) [![JavaDocs](https://www.javadoc.io/badge/org.apache.sling/org.apache.sling.testing.paxexam.svg)](https://www.javadoc.io/doc/org.apache.sling/org.apache.sling.testing.paxexam) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0) [![testing](https://sling.apache.org/badges/group-testing.svg)](https://github.com/apache/sling-aggregator/blob/master/docs/groups/testing.md)

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
