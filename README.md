# Apache Sling Testing PaxExam

This module is part of the [Apache Sling](https://sling.apache.org) project.


## Overview

This module provides test support for use with [Pax Exam](https://github.com/ops4j/org.ops4j.pax.exam2) to test with *real* Sling instances – no limitations or issues due to incomplete and faulty mock implementations.

See Testing PaxExam's [documentation page](https://sling.apache.org/documentation/development/testing-paxexam.html) for details and how to use.


## Features

* run integration tests in a *tailored* Sling instance in the *same module* (with the build artifact under test)
* use different versions in build (e.g. *minimal*) and tests (e.g. *latest*)
* overriding of versions
* build bundles with test content and OSGi DS services on-the-fly (no need for extra modules)
