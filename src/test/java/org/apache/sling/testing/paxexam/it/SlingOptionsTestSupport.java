/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.testing.paxexam.it;

import java.io.File;
import java.util.UUID;

import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.util.PathUtils;

import static org.apache.sling.testing.paxexam.SlingOptions.backing;
import static org.ops4j.pax.exam.CoreOptions.bundle;
import static org.ops4j.pax.exam.CoreOptions.composite;
import static org.ops4j.pax.exam.CoreOptions.keepCaches;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.when;

public abstract class SlingOptionsTestSupport {

    private final String workingDirectory = String.format("%s/target/paxexam/%s/%s", PathUtils.getBaseDir(), getClass().getSimpleName(), UUID.randomUUID());

    protected String workingDirectory() {
        return workingDirectory;
    }

    protected Option baseConfiguration() {
        return composite(
            failOnUnresolvedBundles(),
            keepCaches(),
            localMavenRepo(),
            CoreOptions.workingDirectory(workingDirectory()),
            testBundle("bundle.filename"),
            backing()
        );
    }

    protected Option failOnUnresolvedBundles() {
        return systemProperty("pax.exam.osgi.unresolved.fail").value("true");
    }

    protected Option localMavenRepo() {
        final String localRepository = System.getProperty("maven.repo.local", ""); // PAXEXAM-543
        return when(localRepository.length() > 0).useOptions(
            systemProperty("org.ops4j.pax.url.mvn.localRepository").value(localRepository)
        );
    }

    protected Option testBundle(final String systemProperty) {
        final String filename = System.getProperty(systemProperty);
        final File file = new File(filename);
        return bundle(file.toURI().toString());
    }

}
