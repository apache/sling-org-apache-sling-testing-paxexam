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
package org.apache.sling.testing.paxexam;

import java.util.HashMap;
import java.util.Map;

import org.ops4j.pax.exam.MavenUtils;
import org.ops4j.pax.exam.options.MavenUrlReference.VersionResolver;

/**
 * Sling's Version Resolver for Sling's Options.
 *
 * <p>NOTE: This file is generated from Sling's Karaf Features
 */
@SuppressWarnings({"java:S1192", "java:S4143"})
public class SlingVersionResolver implements VersionResolver {

    public static final String SLING_GROUP_ID = "org.apache.sling";

    private final Map<String, String> versions = new HashMap<>();

    /**
     * Creates a new {@code SlingVersionResolver}.
     */
    public SlingVersionResolver() {
        versions.put("biz.aQute.bnd:biz.aQute.bndlib", "6.4.1");
        versions.put("biz.aQute.bnd:biz.aQute.bnd.util", "6.4.1");
        versions.put("ch.qos.logback:logback-classic", "1.5.12");
        versions.put("ch.qos.logback:logback-core", "1.5.12");
        versions.put("commons-fileupload:commons-fileupload", "1.5");
        versions.put("commons-io:commons-io", "2.18.0");
        versions.put("com.fasterxml.jackson.core:jackson-annotations", "2.18.2");
        versions.put("com.fasterxml.jackson.core:jackson-core", "2.18.2");
        versions.put("com.fasterxml.jackson.core:jackson-databind", "2.18.2");
        versions.put("com.icegreen:greenmail", "2.1.2");
        versions.put("io.dropwizard.metrics:metrics-core", "3.2.6");
        versions.put("io.rest-assured:json-path", "5.5.0");
        versions.put("io.rest-assured:rest-assured", "5.5.0");
        versions.put("io.rest-assured:rest-assured-common", "5.5.0");
        versions.put("io.rest-assured:xml-path", "5.5.0");
        versions.put("jakarta.activation:jakarta.activation-api", "2.1.3");
        versions.put("jakarta.mail:jakarta.mail-api", "2.1.3");
        versions.put("org.apache.aries:org.apache.aries.util", "1.1.3");
        versions.put("org.apache.aries.jmx:org.apache.aries.jmx.api", "1.1.5");
        versions.put("org.apache.aries.jmx:org.apache.aries.jmx.core", "1.1.8");
        versions.put("org.apache.aries.jmx:org.apache.aries.jmx.whiteboard", "1.2.0");
        versions.put("org.apache.aries.spifly:org.apache.aries.spifly.dynamic.framework.extension", "1.3.7");
        versions.put("org.apache.commons:commons-lang3", "3.17.0");
        versions.put("org.apache.httpcomponents:httpclient-osgi", "4.5.14");
        versions.put("org.apache.httpcomponents:httpcore-osgi", "4.4.16");
        versions.put("org.apache.felix:org.apache.felix.configadmin", "1.9.26");
        versions.put("org.apache.felix:org.apache.felix.eventadmin", "1.6.4");
        versions.put("org.apache.felix:org.apache.felix.healthcheck.api", "2.0.4");
        versions.put("org.apache.felix:org.apache.felix.healthcheck.core", "2.0.14");
        versions.put("org.apache.felix:org.apache.felix.healthcheck.generalchecks", "3.0.4");
        versions.put("org.apache.felix:org.apache.felix.healthcheck.webconsoleplugin", "2.0.2");
        versions.put("org.apache.felix:org.apache.felix.http.jetty12", "1.0.19");
        versions.put("org.apache.felix:org.apache.felix.http.servlet-api", "3.0.0");
        versions.put("org.apache.felix:org.apache.felix.http.whiteboard", "4.0.0");
        versions.put("org.apache.felix:org.apache.felix.inventory", "2.0.0");
        versions.put("org.apache.felix:org.apache.felix.metatype", "1.2.4");
        versions.put("org.apache.felix:org.apache.felix.scr", "2.2.12");
        versions.put("org.apache.felix:org.apache.felix.webconsole", "5.0.8");
        versions.put("org.apache.felix:org.apache.felix.webconsole.plugins.ds", "2.3.0");
        versions.put("org.apache.geronimo.specs:geronimo-jta_1.1_spec", "1.1.1");
        versions.put("org.apache.groovy:groovy", "4.0.24");
        versions.put("org.apache.groovy:groovy-json", "4.0.24");
        versions.put("org.apache.groovy:groovy-xml", "4.0.24");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.hamcrest", "1.3_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.jasypt", "1.9.3_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.jaxb-impl", "2.2.11_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.junit", "4.13.2_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.ognl", "3.2.1_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.tagsoup", "1.2.1_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.thymeleaf", "3.0.15.RELEASE_1");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.activation-api-1.1", "2.9.0");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.activation-api-2.0.1", "2.0.1_1");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.annotation-api-1.3", "1.3_3");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.jaxb-api-2.3", "2.3_3");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.stax-api-1.2", "1.2_1");
        versions.put("org.apache.sling:org.apache.sling.commons.crypto", "1.1.0");
        versions.put("org.apache.sling:org.apache.sling.commons.metrics", "1.2.12");
        versions.put("org.apache.sling:org.apache.sling.commons.scheduler", "2.7.12");
        versions.put("org.apache.sling:org.apache.sling.commons.threads", "3.2.22");
        versions.put("org.attoparser:attoparser", "2.0.6.RELEASE");
        versions.put("org.awaitility:awaitility", "4.2.2");
        versions.put("org.eclipse.angus:jakarta.mail", "2.0.3");
        versions.put("org.hamcrest:hamcrest", "2.2");
        versions.put("org.javassist:javassist", "3.29.2-GA");
        versions.put("org.ops4j.base:ops4j-base-lang", "1.5.1");
        versions.put("org.ops4j.base:ops4j-base-store", "1.5.1");
        versions.put("org.ops4j.base:ops4j-base-util-property", "1.5.1");
        versions.put("org.ops4j.pax.logging:pax-logging-api", "2.2.7");
        versions.put("org.ops4j.pax.logging:pax-logging-log4j2", "2.2.7");
        versions.put("org.ops4j.pax.logging:pax-logging-logback", "2.2.7");
        versions.put("org.ops4j.pax.swissbox:pax-swissbox-bnd", "1.9.0");
        versions.put("org.ops4j.pax.swissbox:pax-swissbox-property", "1.9.0");
        versions.put("org.ops4j.pax.url:pax-url-classpath", "2.6.14");
        versions.put("org.ops4j.pax.url:pax-url-commons", "2.6.14");
        versions.put("org.ops4j.pax.url:pax-url-wrap", "2.6.14");
        versions.put("org.ops4j.pax.tinybundles:tinybundles", "4.0.0");
        versions.put("org.osgi:org.osgi.service.component", "1.5.1");
        versions.put("org.osgi:org.osgi.service.repository", "1.1.0");
        versions.put("org.osgi:org.osgi.util.function", "1.2.0");
        versions.put("org.osgi:org.osgi.util.promise", "1.3.0");
        versions.put("org.owasp.encoder:encoder", "1.3.1");
        versions.put("org.rnorth.duct-tape:duct-tape", "1.0.8");
        versions.put("org.slf4j:slf4j-api", "2.0.16");
        versions.put("org.slf4j:slf4j-simple", "2.0.16");
        versions.put("org.slf4j:jcl-over-slf4j", "2.0.16");
        versions.put("org.testcontainers:testcontainers", "1.20.4");
        versions.put("org.unbescape:unbescape", "1.1.6.RELEASE");
    }

    private String key(final String groupId, final String artifactId) {
        return String.format("%s:%s", groupId, artifactId);
    }

    /**
     * Sets the version of the bundle.
     *
     * @param groupId    the group ID
     * @param artifactId the artifact ID
     * @param version    the version
     * @return the previous version, or {@code null}
     */
    public String setVersion(final String groupId, final String artifactId, final String version) {
        return versions.put(key(groupId, artifactId), version);
    }

    /**
     * Sets the version of the bundle by using the declared version from Maven project.
     *
     * @param groupId    the group ID
     * @param artifactId the artifact ID
     * @return the previous version, or {@code null}
     */
    public String setVersionFromProject(final String groupId, final String artifactId) {
        final String version = MavenUtils.getArtifactVersion(groupId, artifactId);
        return versions.put(key(groupId, artifactId), version);
    }

    /**
     * Gets the version of the bundle.
     *
     * @param groupId    the group ID
     * @param artifactId the artifact ID
     * @return the version, or {@code null}
     */
    @Override
    public String getVersion(final String groupId, final String artifactId) {
        return versions.get(key(groupId, artifactId));
    }

    /**
     * Gets the Java major version from System property {@code java.specification.version} or {@code 0} in case of error.
     *
     * @return the Java version
     */
    public static int getJavaVersion() {
        final String version = System.getProperty("java.specification.version");
        try {
            if (version.contains(".")) {
                return Integer.parseInt(version.split("\\.")[1]);
            } else {
                return Integer.parseInt(version);
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
