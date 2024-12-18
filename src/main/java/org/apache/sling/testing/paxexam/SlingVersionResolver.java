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
        versions.put("biz.aQute.bnd:bndlib", "2.4.0");
        versions.put("ch.qos.logback:logback-classic", "1.2.11");
        versions.put("ch.qos.logback:logback-core", "1.2.11");
        versions.put("com.icegreen:greenmail", "2.0.0");
        versions.put("com.sun.mail:jakarta.mail", "2.0.1");
        versions.put("com.fasterxml.jackson.core:jackson-annotations", "2.14.2");
        versions.put("com.fasterxml.jackson.core:jackson-core", "2.14.2");
        versions.put("com.fasterxml.jackson.core:jackson-databind", "2.14.2");
        versions.put("org.apache.aries:org.apache.aries.util", "1.1.3");
        versions.put("org.apache.aries.jmx:org.apache.aries.jmx.api", "1.1.5");
        versions.put("org.apache.aries.jmx:org.apache.aries.jmx.core", "1.1.8");
        versions.put("org.apache.aries.jmx:org.apache.aries.jmx.whiteboard", "1.2.0");
        versions.put("org.apache.aries.spifly:org.apache.aries.spifly.dynamic.bundle", "1.3.6");
        versions.put("org.apache.commons:commons-lang3", "3.12.0");
        versions.put("org.apache.httpcomponents:httpclient-osgi", "4.5.14");
        versions.put("org.apache.httpcomponents:httpcore-osgi", "4.4.16");
        versions.put("org.apache.felix:org.apache.felix.configadmin", "1.9.26");
        versions.put("org.apache.felix:org.apache.felix.eventadmin", "1.6.4");
        versions.put("org.apache.felix:org.apache.felix.http.jetty", "5.0.0");
        versions.put("org.apache.felix:org.apache.felix.http.servlet-api", "2.1.0");
        versions.put("org.apache.felix:org.apache.felix.http.whiteboard", "4.0.0");
        versions.put("org.apache.felix:org.apache.felix.inventory", "1.1.0");
        versions.put("org.apache.felix:org.apache.felix.metatype", "1.2.4");
        versions.put("org.apache.felix:org.apache.felix.scr", "2.2.6");
        versions.put("org.apache.felix:org.apache.felix.webconsole", "4.8.4");
        versions.put("org.apache.felix:org.apache.felix.webconsole.plugins.ds", "2.2.0");
        versions.put("org.apache.groovy:groovy", "4.0.13");
        versions.put("org.apache.groovy:groovy-json", "4.0.13");
        versions.put("org.apache.groovy:groovy-xml", "4.0.13");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.hamcrest", "1.3_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.jaxb-impl", "2.2.11_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.junit", "4.12_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.tagsoup", "1.2.1_1");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.annotation-api-1.3", "1.3_3");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.activation-api-1.1", "2.9.0");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.activation-api-2.0.1", "2.0.1_1");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.stax-api-1.2", "1.2_1");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.jaxb-api-2.3", "2.3_3");
        versions.put("org.awaitility:awaitility", "3.1.6");
        versions.put("org.hamcrest:hamcrest", "2.2");
        versions.put("org.ops4j.base:ops4j-base-lang", "1.5.1");
        versions.put("org.ops4j.base:ops4j-base-store", "1.5.1");
        versions.put("org.ops4j.base:ops4j-base-util-property", "1.5.1");
        versions.put("org.ops4j.pax.logging:pax-logging-api", "2.2.1");
        versions.put("org.ops4j.pax.logging:pax-logging-log4j2", "2.2.1");
        versions.put("org.ops4j.pax.logging:pax-logging-logback", "2.2.1");
        versions.put("org.ops4j.pax.swissbox:pax-swissbox-bnd", "1.8.3");
        versions.put("org.ops4j.pax.swissbox:pax-swissbox-property", "1.8.3");
        versions.put("org.ops4j.pax.url:pax-url-classpath", "2.6.12");
        versions.put("org.ops4j.pax.url:pax-url-commons", "2.6.12");
        versions.put("org.ops4j.pax.url:pax-url-wrap", "2.6.12");
        versions.put("org.ops4j.pax.tinybundles:tinybundles", "4.0.0");
        versions.put("org.osgi:org.osgi.service.component", "1.5.1");
        versions.put("org.osgi:org.osgi.service.repository", "1.1.0");
        versions.put("org.osgi:org.osgi.util.function", "1.2.0");
        versions.put("org.osgi:org.osgi.util.promise", "1.3.0");
        versions.put("org.ow2.asm:asm", "9.4");
        versions.put("org.ow2.asm:asm-analysis", "9.4");
        versions.put("org.ow2.asm:asm-commons", "9.4");
        versions.put("org.ow2.asm:asm-util", "9.4");
        versions.put("org.ow2.asm:asm-tree", "9.4");
        versions.put("org.rnorth.duct-tape:duct-tape", "1.0.8");
        versions.put("org.slf4j:slf4j-api", "1.7.36");
        versions.put("org.slf4j:slf4j-simple", "1.7.36");
        versions.put("org.slf4j:jcl-over-slf4j", "1.7.36");
        versions.put("org.testcontainers:testcontainers", "1.17.6");
        versions.put("io.rest-assured:json-path", "5.3.0");
        versions.put("io.rest-assured:rest-assured", "5.3.0");
        versions.put("io.rest-assured:rest-assured-common", "5.3.0");
        versions.put("io.rest-assured:xml-path", "5.3.0");
        versions.put("jakarta.mail:jakarta.mail-api", "2.0.1");
        versions.put("com.composum.nodes:composum-nodes-commons", "4.1.3");
        versions.put("com.composum.nodes:composum-nodes-console", "4.1.3");
        versions.put("com.composum.nodes:composum-nodes-jslibs", "4.1.3");
        versions.put("com.composum.nodes:composum-nodes-pckgmgr", "4.1.3");
        versions.put("com.composum.nodes:composum-nodes-usermgr", "4.1.3");
        versions.put("com.google.guava:guava", "15.0");
        versions.put("com.h2database:h2-mvstore", "2.1.214");
        versions.put("com.sun.mail:jakarta.mail", "2.0.1");
        versions.put("commons-codec:commons-codec", "1.15");
        versions.put("commons-collections:commons-collections", "3.2.2");
        versions.put("commons-fileupload:commons-fileupload", "1.5");
        versions.put("commons-io:commons-io", "2.11.0");
        versions.put("commons-lang:commons-lang", "2.6");
        versions.put("io.dropwizard.metrics:metrics-core", "3.2.6");
        versions.put("jakarta.mail:jakarta.mail-api", "2.0.1");
        versions.put("javax.jcr:jcr", "2.0");
        versions.put("javax.servlet:javax.servlet-api", "3.1.0");
        versions.put("org.antlr:antlr4-runtime", "4.9.3");
        versions.put("org.apache.commons:commons-collections4", "4.4");
        versions.put("org.apache.commons:commons-lang3", "3.12.0");
        versions.put("org.apache.commons:commons-math", "2.2");
        versions.put("org.apache.commons:commons-text", "1.10.0");
        versions.put("org.apache.felix:org.apache.felix.cm.json", "1.0.8");
        versions.put("org.apache.felix:org.apache.felix.healthcheck.api", "2.0.4");
        versions.put("org.apache.felix:org.apache.felix.healthcheck.core", "2.0.14");
        versions.put("org.apache.felix:org.apache.felix.healthcheck.generalchecks", "3.0.4");
        versions.put("org.apache.felix:org.apache.felix.healthcheck.webconsoleplugin", "2.0.2");
        versions.put("org.apache.felix:org.apache.felix.inventory", "1.1.0");
        versions.put("org.apache.felix:org.apache.felix.jaas", "1.0.2");
        versions.put("org.apache.felix:org.apache.felix.prefs", "1.1.0");
        versions.put("org.apache.felix:org.apache.felix.webconsole.plugins.memoryusage", "1.0.10");
        versions.put("org.apache.felix:org.apache.felix.webconsole.plugins.packageadmin", "1.0.4");
        versions.put("org.apache.geronimo.bundles:jstl", "1.2_1");
        versions.put("org.apache.geronimo.specs:geronimo-atinject_1.0_spec", "1.2");
        versions.put("org.apache.geronimo.specs:geronimo-el_2.2_spec", "1.1");
        versions.put("org.apache.geronimo.specs:geronimo-interceptor_1.1_spec", "1.0");
        versions.put("org.apache.geronimo.specs:geronimo-jcdi_1.0_spec", "1.1");
        versions.put("org.apache.geronimo.specs:geronimo-jta_1.1_spec", "1.1.1");
        versions.put("org.apache.groovy:groovy", "4.0.13");
        versions.put("org.apache.groovy:groovy-templates", "4.0.13");
        versions.put("org.apache.httpcomponents:httpclient-osgi", "4.5.14");
        versions.put("org.apache.httpcomponents:httpcore-osgi", "4.4.16");
        versions.put("org.apache.jackrabbit:jackrabbit-data", "2.20.8");
        versions.put("org.apache.jackrabbit:jackrabbit-jcr-commons", "2.20.8");
        versions.put("org.apache.jackrabbit:jackrabbit-jcr-rmi", "2.20.8");
        versions.put("org.apache.jackrabbit:jackrabbit-spi", "2.20.8");
        versions.put("org.apache.jackrabbit:jackrabbit-spi-commons", "2.20.8");
        versions.put("org.apache.jackrabbit:jackrabbit-webdav", "2.20.8");
        versions.put("org.apache.jackrabbit:oak-api", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-authorization-principalbased", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-blob", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-blob-plugins", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-commons", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-core", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-core-spi", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-jackrabbit-api", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-jcr", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-lucene", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-query-spi", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-security-spi", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-segment-tar", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-store-composite", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-store-document", "1.48.0");
        versions.put("org.apache.jackrabbit:oak-store-spi", "1.48.0");
        versions.put("org.apache.jackrabbit.vault:org.apache.jackrabbit.vault", "3.6.8");
        versions.put("org.apache.pdfbox:fontbox", "2.0.27");
        versions.put("org.apache.pdfbox:jempbox", "1.8.17");
        versions.put("org.apache.pdfbox:pdfbox", "2.0.27");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.jasypt", "1.9.3_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.ognl", "3.2.1_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.rhino", "1.7.14_2");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.thymeleaf", "3.0.15.RELEASE_1");
        versions.put("org.apache.servicemix.bundles:org.apache.servicemix.bundles.urlrewritefilter", "4.0.4_1");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.activation-api-2.0.1", "2.0.1_1");
        versions.put("org.apache.servicemix.specs:org.apache.servicemix.specs.annotation-api-1.3", "1.3_3");
        versions.put("org.apache.sling:org.apache.sling.adapter", "2.2.0");
        versions.put("org.apache.sling:org.apache.sling.api", "2.25.4");
        versions.put("org.apache.sling:org.apache.sling.auth.core", "1.5.6");
        versions.put("org.apache.sling:org.apache.sling.auth.form", "1.0.24");
        versions.put("org.apache.sling:org.apache.sling.bundleresource.impl", "2.3.4");
        versions.put("org.apache.sling:org.apache.sling.caconfig.api", "1.3.0");
        versions.put("org.apache.sling:org.apache.sling.caconfig.impl", "1.6.0");
        versions.put("org.apache.sling:org.apache.sling.caconfig.spi", "1.4.0");
        versions.put("org.apache.sling:org.apache.sling.clam", "1.1.0");
        versions.put("org.apache.sling:org.apache.sling.commons.clam", "2.0.0");
        versions.put("org.apache.sling:org.apache.sling.commons.classloader", "1.4.4");
        versions.put("org.apache.sling:org.apache.sling.commons.compiler", "2.4.0");
        versions.put("org.apache.sling:org.apache.sling.commons.crypto", "1.1.0");
        versions.put("org.apache.sling:org.apache.sling.commons.fsclassloader", "1.0.14");
        versions.put("org.apache.sling:org.apache.sling.commons.html", "1.1.0");
        versions.put("org.apache.sling:org.apache.sling.commons.johnzon", "1.2.14");
        versions.put("org.apache.sling:org.apache.sling.commons.messaging", "1.0.2");
        versions.put("org.apache.sling:org.apache.sling.commons.messaging.mail", "2.0.0");
        versions.put("org.apache.sling:org.apache.sling.commons.metrics", "1.2.12");
        versions.put("org.apache.sling:org.apache.sling.commons.mime", "2.2.2");
        versions.put("org.apache.sling:org.apache.sling.commons.osgi", "2.4.2");
        versions.put("org.apache.sling:org.apache.sling.commons.scheduler", "2.7.12");
        versions.put("org.apache.sling:org.apache.sling.commons.threads", "3.2.22");
        versions.put("org.apache.sling:org.apache.sling.discovery.api", "1.0.4");
        versions.put("org.apache.sling:org.apache.sling.discovery.base", "2.0.14");
        versions.put("org.apache.sling:org.apache.sling.discovery.commons", "1.0.28");
        versions.put("org.apache.sling:org.apache.sling.discovery.oak", "1.2.42");
        versions.put("org.apache.sling:org.apache.sling.discovery.standalone", "1.0.2");
        versions.put("org.apache.sling:org.apache.sling.discovery.support", "1.0.6");
        versions.put("org.apache.sling:org.apache.sling.distribution.api", "0.7.0");
        versions.put("org.apache.sling:org.apache.sling.distribution.core", "0.5.0");
        versions.put("org.apache.sling:org.apache.sling.engine", "2.9.2");
        versions.put("org.apache.sling:org.apache.sling.event", "4.3.6");
        versions.put("org.apache.sling:org.apache.sling.event.dea", "1.1.4");
        versions.put("org.apache.sling:org.apache.sling.extensions.webconsolesecurityprovider", "1.2.8");
        versions.put("org.apache.sling:org.apache.sling.featureflags", "1.2.2");
        versions.put("org.apache.sling:org.apache.sling.fsresource", "2.2.0");
        versions.put("org.apache.sling:org.apache.sling.i18n", "2.5.18");
        versions.put("org.apache.sling:org.apache.sling.installer.console", "1.1.0");
        versions.put("org.apache.sling:org.apache.sling.installer.core", "3.12.0");
        versions.put("org.apache.sling:org.apache.sling.installer.factory.configuration", "1.4.2");
        versions.put("org.apache.sling:org.apache.sling.installer.factory.packages", "1.0.4");
        versions.put("org.apache.sling:org.apache.sling.installer.hc", "2.1.0");
        versions.put("org.apache.sling:org.apache.sling.installer.provider.file", "1.3.4");
        versions.put("org.apache.sling:org.apache.sling.installer.provider.jcr", "3.3.0");
        versions.put("org.apache.sling:org.apache.sling.jcr.api", "2.4.0");
        versions.put("org.apache.sling:org.apache.sling.jcr.base", "3.1.12");
        versions.put("org.apache.sling:org.apache.sling.jcr.compiler", "2.1.0");
        versions.put("org.apache.sling:org.apache.sling.jcr.contentloader", "2.5.2");
        versions.put("org.apache.sling:org.apache.sling.jcr.davex", "1.3.10");
        versions.put("org.apache.sling:org.apache.sling.jcr.jackrabbit.accessmanager", "3.1.0");
        versions.put("org.apache.sling:org.apache.sling.jcr.jackrabbit.usermanager", "2.2.24");
        versions.put("org.apache.sling:org.apache.sling.jcr.oak.server", "1.3.0");
        versions.put("org.apache.sling:org.apache.sling.jcr.repoinit", "1.1.44");
        versions.put("org.apache.sling:org.apache.sling.jcr.resource", "3.2.4");
        versions.put("org.apache.sling:org.apache.sling.jcr.webconsole", "1.1.0");
        versions.put("org.apache.sling:org.apache.sling.jcr.webdav", "2.3.8");
        versions.put("org.apache.sling:org.apache.sling.jmx.provider", "1.0.2");
        versions.put("org.apache.sling:org.apache.sling.models.api", "1.4.2");
        versions.put("org.apache.sling:org.apache.sling.models.impl", "1.5.4");
        versions.put("org.apache.sling:org.apache.sling.models.jacksonexporter", "1.1.2");
        versions.put("org.apache.sling:org.apache.sling.pipes", "4.5.0");
        versions.put("org.apache.sling:org.apache.sling.provisioning.model", "1.8.6");
        versions.put("org.apache.sling:org.apache.sling.query", "4.0.4");
        versions.put("org.apache.sling:org.apache.sling.repoinit.parser", "1.9.0");
        versions.put("org.apache.sling:org.apache.sling.resource.inventory", "1.0.8");
        versions.put("org.apache.sling:org.apache.sling.resource.presence", "0.0.2");
        versions.put("org.apache.sling:org.apache.sling.resourcemerger", "1.4.0");
        versions.put("org.apache.sling:org.apache.sling.resourceresolver", "1.9.0");
        versions.put("org.apache.sling:org.apache.sling.rewriter", "1.3.4");
        versions.put("org.apache.sling:org.apache.sling.scripting.api", "2.2.0");
        versions.put("org.apache.sling:org.apache.sling.scripting.core", "2.4.8");
        versions.put("org.apache.sling:org.apache.sling.scripting.el-api", "1.0.4");
        versions.put("org.apache.sling:org.apache.sling.scripting.freemarker", "1.0.4");
        versions.put("org.apache.sling:org.apache.sling.scripting.groovy", "1.3.0");
        versions.put("org.apache.sling:org.apache.sling.scripting.java", "2.1.6");
        versions.put("org.apache.sling:org.apache.sling.scripting.javascript", "3.1.4");
        versions.put("org.apache.sling:org.apache.sling.scripting.jsp", "2.6.2");
        versions.put("org.apache.sling:org.apache.sling.scripting.jsp-api", "1.0.2");
        versions.put("org.apache.sling:org.apache.sling.scripting.jsp.taglib", "2.4.0");
        versions.put("org.apache.sling:org.apache.sling.scripting.sightly", "1.4.22-1.4.0");
        versions.put("org.apache.sling:org.apache.sling.scripting.sightly.compiler", "1.2.14-1.4.0");
        versions.put("org.apache.sling:org.apache.sling.scripting.sightly.compiler.java", "1.2.2-1.4.0");
        versions.put("org.apache.sling:org.apache.sling.scripting.sightly.js.provider", "1.2.8");
        versions.put("org.apache.sling:org.apache.sling.scripting.sightly.runtime", "1.2.6-1.4.0");
        versions.put("org.apache.sling:org.apache.sling.scripting.spi", "1.0.4");
        versions.put("org.apache.sling:org.apache.sling.scripting.thymeleaf", "2.0.2");
        versions.put("org.apache.sling:org.apache.sling.security", "1.1.24");
        versions.put("org.apache.sling:org.apache.sling.serviceusermapper", "1.5.6");
        versions.put("org.apache.sling:org.apache.sling.servlets.get", "2.1.44");
        versions.put("org.apache.sling:org.apache.sling.servlets.post", "2.5.0");
        versions.put("org.apache.sling:org.apache.sling.servlets.resolver", "2.9.6");
        versions.put("org.apache.sling:org.apache.sling.settings", "1.4.2");
        versions.put("org.apache.sling:org.apache.sling.starter.content", "1.0.12");
        versions.put("org.apache.sling:org.apache.sling.urlrewriter", "0.0.2");
        versions.put("org.apache.sling:org.apache.sling.validation.api", "1.0.0");
        versions.put("org.apache.sling:org.apache.sling.validation.core", "1.0.4");
        versions.put("org.apache.sling:org.apache.sling.xss", "2.2.20");
        versions.put("org.apache.tika:tika-core", "1.28.5");
        versions.put("org.apache.tika:tika-parsers", "1.28.5");
        versions.put("org.attoparser:attoparser", "2.0.6.RELEASE");
        versions.put("org.freemarker:freemarker", "2.3.32");
        versions.put("org.javassist:javassist", "3.29.2-GA");
        versions.put("org.mongodb:mongo-java-driver", "3.12.12");
        versions.put("org.osgi:org.osgi.util.converter", "1.0.9");
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
