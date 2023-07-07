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

import org.ops4j.pax.exam.options.MavenArtifactProvisionOption;
import org.ops4j.pax.exam.options.ModifiableCompositeOption;
import org.ops4j.pax.exam.util.PathUtils;

import static org.ops4j.pax.exam.CoreOptions.bootClasspathLibrary;
import static org.ops4j.pax.exam.CoreOptions.composite;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.vmOption;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.cm.ConfigurationAdminOptions.factoryConfiguration;
import static org.ops4j.pax.exam.cm.ConfigurationAdminOptions.newConfiguration;

/**
 * Sling's Options for Pax Exam created from Sling's Karaf Features.
 *
 * <p>NOTE: This file is generated from Sling's Karaf Features
 */
@SuppressWarnings("java:S1192")
public final class SlingOptions {

    @SuppressWarnings({"java:S1104", "java:S1444", "checkstyle:VisibilityModifier"})
    public static SlingVersionResolver versionResolver = new SlingVersionResolver();

    private SlingOptions() { //
    }

    public static ModifiableCompositeOption awaitility() {
        return composite(
            mavenBundle().groupId("org.awaitility").artifactId("awaitility").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.hamcrest").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption backing() {
        final int version = SlingVersionResolver.getJavaVersion();
        if (version >= 11) {
            return composite(
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.annotation-api-1.3").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.activation-api-1.1").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.stax-api-1.2").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.jaxb-api-2.3").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.jaxb-impl").version(versionResolver)
            );
        } else if (version >= 9) {
            return composite(
                vmOption("--add-modules=java.se.ee")
            );
        } else {
            return composite();
        }
    }

    public static ModifiableCompositeOption config() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.configadmin").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption eventadmin() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.eventadmin").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption greenmail() {
        final MavenArtifactProvisionOption greenmail = mavenBundle().groupId("com.icegreen").artifactId("greenmail").version(versionResolver);
        final MavenArtifactProvisionOption slf4jApi = mavenBundle().groupId("org.slf4j").artifactId("slf4j-api").version(versionResolver);
        final MavenArtifactProvisionOption slf4jSimple = mavenBundle().groupId("org.slf4j").artifactId("slf4j-simple").version(versionResolver);
        return composite(
            greenmail,
            mavenBundle().groupId("jakarta.mail").artifactId("jakarta.mail-api").version(versionResolver),
            mavenBundle().groupId("com.sun.mail").artifactId("jakarta.mail").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.activation-api-2.0.1").version(versionResolver),
            junit(),
            // add GreenMail to boot classpath *also* to allow setting ssl.SocketFactory.provider to GreenMail's DummySSLSocketFactory
            bootClasspathLibrary(greenmail).afterFramework(),
            bootClasspathLibrary(slf4jApi).afterFramework(), // GreenMail dependency
            bootClasspathLibrary(slf4jSimple).afterFramework() // GreenMail dependency
        );
    }

    public static ModifiableCompositeOption hamcrest() {
        return composite(
            mavenBundle().groupId("org.hamcrest").artifactId("hamcrest").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption http() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.http.jetty").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.http.servlet-api").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption httpWhiteboard() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.http.whiteboard").version(versionResolver),
            http()
        );
    }

    public static ModifiableCompositeOption jackson() {
        return composite(
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-annotations").version(versionResolver),
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-core").version(versionResolver),
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-databind").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption junit() {
        return composite(
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.junit").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption management() {
        return composite(
            mavenBundle().groupId("org.apache.aries").artifactId("org.apache.aries.util").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.jmx").artifactId("org.apache.aries.jmx.api").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.jmx").artifactId("org.apache.aries.jmx.core").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.jmx").artifactId("org.apache.aries.jmx.whiteboard").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption scr() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.metatype").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.scr").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.service.component").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.util.function").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.util.promise").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption spifly() {
        return composite(
            mavenBundle().groupId("org.apache.aries").artifactId("org.apache.aries.util").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.spifly").artifactId("org.apache.aries.spifly.dynamic.bundle").version(versionResolver),
            mavenBundle().groupId("org.ow2.asm").artifactId("asm").version(versionResolver),
            mavenBundle().groupId("org.ow2.asm").artifactId("asm-analysis").version(versionResolver),
            mavenBundle().groupId("org.ow2.asm").artifactId("asm-commons").version(versionResolver),
            mavenBundle().groupId("org.ow2.asm").artifactId("asm-util").version(versionResolver),
            mavenBundle().groupId("org.ow2.asm").artifactId("asm-tree").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption webconsole() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.webconsole").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.inventory").version(versionResolver),
            mavenBundle().groupId("commons-fileupload").artifactId("commons-fileupload").version(versionResolver),
            mavenBundle().groupId("commons-io").artifactId("commons-io").version(versionResolver),
            http()
        );
    }

    public static ModifiableCompositeOption paxLoggingApi() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.logging").artifactId("pax-logging-api").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption paxLoggingLog4j2(final String configurationFile) {
        return composite(
            paxLoggingApi(),
            newConfiguration("org.ops4j.pax.logging")
                .put("org.ops4j.pax.logging.log4j2.config.file", configurationFile)
                .asOption(),
            mavenBundle().groupId("org.ops4j.pax.logging").artifactId("pax-logging-log4j2").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption paxLoggingLog4j2() {
        final String filename = String.format("%s/src/test/resources/log4j2.xml", PathUtils.getBaseDir());
        return paxLoggingLog4j2(filename);
    }

    public static ModifiableCompositeOption paxLoggingLogback(final String configurationFile) {
        return composite(
            paxLoggingApi(),
            newConfiguration("org.ops4j.pax.logging")
                .put("org.ops4j.pax.logging.logback.config.file", configurationFile)
                .asOption(),
            mavenBundle().groupId("org.ops4j.pax.logging").artifactId("pax-logging-logback").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption paxLoggingLogback() {
        final String filename = String.format("%s/src/test/resources/logback.xml", PathUtils.getBaseDir());
        return paxLoggingLogback(filename);
    }

    public static ModifiableCompositeOption paxUrl() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-commons").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-lang").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util-property").version(versionResolver),
            mavenBundle().groupId("org.ops4j.pax.swissbox").artifactId("pax-swissbox-property").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption paxUrlClasspath() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-classpath").version(versionResolver),
            paxUrl()
        );
    }

    public static ModifiableCompositeOption paxUrlWrap() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-wrap").version(versionResolver),
            mavenBundle().groupId("org.ops4j.pax.swissbox").artifactId("pax-swissbox-bnd").version(versionResolver),
            mavenBundle().groupId("biz.aQute.bnd").artifactId("bndlib").version(versionResolver),
            paxUrl()
        );
    }

    public static ModifiableCompositeOption paxTinybundles() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.tinybundles").artifactId("tinybundles").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-io").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-lang").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-monitors").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-store").version(versionResolver),
            mavenBundle().groupId("biz.aQute.bnd").artifactId("biz.aQute.bndlib").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption logback() {
        final String filename = String.format("file:%s/src/test/resources/logback.xml", PathUtils.getBaseDir());
        return composite(
            systemProperty("logback.configurationFile").value(filename),
            mavenBundle().groupId("org.slf4j").artifactId("slf4j-api").version(versionResolver),
            mavenBundle().groupId("org.slf4j").artifactId("jcl-over-slf4j").version(versionResolver),
            mavenBundle().groupId("ch.qos.logback").artifactId("logback-core").version(versionResolver),
            mavenBundle().groupId("ch.qos.logback").artifactId("logback-classic").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption restassured() {
        return composite(
            config(),
            mavenBundle().groupId("io.rest-assured").artifactId("rest-assured").version(versionResolver),
            mavenBundle().groupId("io.rest-assured").artifactId("rest-assured-common").version(versionResolver),
            mavenBundle().groupId("io.rest-assured").artifactId("json-path").version(versionResolver),
            mavenBundle().groupId("io.rest-assured").artifactId("xml-path").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver),
            mavenBundle().groupId("org.apache.groovy").artifactId("groovy").version(versionResolver),
            mavenBundle().groupId("org.apache.groovy").artifactId("groovy-json").version(versionResolver),
            mavenBundle().groupId("org.apache.groovy").artifactId("groovy-xml").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.jaxb-impl").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.tagsoup").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.activation-api-1.1").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.jaxb-api-2.3").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.stax-api-1.2").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpcore-osgi").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpclient-osgi").version(versionResolver),
            hamcrest()
        );
    }

    public static ModifiableCompositeOption testcontainers() {
        return composite(
            junit(),
            paxUrlWrap(),
            wrappedBundle(mavenBundle().groupId("org.rnorth.duct-tape").artifactId("duct-tape").version(versionResolver)),
            wrappedBundle(mavenBundle().groupId("org.testcontainers").artifactId("testcontainers").version(versionResolver))
        );
    }

    public static ModifiableCompositeOption sling() {
        return composite(
            config(),
            eventadmin(),
            scr(),
            management(),
            http(),
            httpWhiteboard(),
            paxUrlClasspath(),
            slingCommonsFsclassloader(),
            slingCommonsOsgi(),
            slingCommonsScheduler(),
            slingCommonsThreads(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.auth.core").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.engine").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.resourceresolver").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.serviceusermapper").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.settings").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.johnzon").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.mime").version(versionResolver),
            mavenBundle().groupId("commons-codec").artifactId("commons-codec").version(versionResolver),
            mavenBundle().groupId("commons-collections").artifactId("commons-collections").version(versionResolver),
            mavenBundle().groupId("commons-fileupload").artifactId("commons-fileupload").version(versionResolver),
            mavenBundle().groupId("commons-io").artifactId("commons-io").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-collections4").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-math").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.util.converter").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.auth.core=[sling-readall]"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.resourceresolver:mapping=[sling-mapping]", "org.apache.sling.resourceresolver:hierarchy=[sling-readall]", "org.apache.sling.resourceresolver:observation=[sling-readall]", "org.apache.sling.resourceresolver:console=[sling-readall]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingAuthForm() {
        return composite(
            sling(),
            jackrabbitOak(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.auth.form").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsClam() {
        return composite(
            scr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.clam").version(versionResolver),
            mavenBundle().groupId("commons-io").artifactId("commons-io").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsCompiler() {
        return composite(
            scr(),
            slingCommonsClassloader(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.compiler").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsClassloader() {
        return composite(
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.classloader").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsCrypto() {
        return composite(
            scr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.crypto").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.jasypt").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsFsclassloader() {
        return composite(
            scr(),
            webconsole(),
            slingCommonsClassloader(),
            slingCommonsOsgi(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.fsclassloader").version(versionResolver),
            mavenBundle().groupId("commons-io").artifactId("commons-io").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsHtml() {
        return composite(
            scr(),
            slingCommonsOsgi(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.html").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsMessaging() {
        return composite(
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.messaging").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsMessagingMail() {
        return composite(
            scr(),
            slingCommonsCrypto(),
            slingCommonsMessaging(),
            slingCommonsThreads(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.messaging.mail").version(versionResolver),
            mavenBundle().groupId("com.sun.mail").artifactId("jakarta.mail").version(versionResolver),
            mavenBundle().groupId("jakarta.mail").artifactId("jakarta.mail-api").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.activation-api-2.0.1").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsMetrics() {
        return composite(
            scr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.metrics").version(versionResolver),
            mavenBundle().groupId("io.dropwizard.metrics").artifactId("metrics-core").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsOsgi() {
        return composite(
            eventadmin(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.osgi").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsScheduler() {
        return composite(
            scr(),
            slingCommonsMetrics(),
            slingCommonsThreads(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.scheduler").version(versionResolver),
            mavenBundle().groupId("javax.servlet").artifactId("javax.servlet-api").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-jta_1.1_spec").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsThreads() {
        return composite(
            config(),
            slingCommonsMetrics(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.threads").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingAdapter() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.adapter").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingBundleresource() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.bundleresource.impl").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCaconfig() {
        return composite(
            sling(),
            slingScripting(),
            slingXss(),
            webconsole(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.caconfig.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.caconfig.impl").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.caconfig.spi").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create path (sling:Folder) /conf"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.caconfig.impl=[sling-readall]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingClam() {
        return composite(
            sling(),
            slingCommonsClam(),
            slingEvent(),
            slingJcr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.clam").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-clam with path system/sling\n\nset principal ACL for sling-clam\n  allow     jcr:read    on /\n  allow     rep:write   on /var/clam\nend\n\ncreate path (sling:Folder) /var/clam/results(sling:OrderedFolder)"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.clam=[sling-clam]", "org.apache.sling.clam:result-writer=[sling-clam]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingDiscovery() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.api").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingDiscoveryOak() {
        return composite(
            webconsole(),
            slingDiscovery(),
            felixHealthcheck(),
            httpcomponentsClient(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.base").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.commons").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.oak").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.support").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.base.internal.LoginAdminWhitelist.fragment")
                .put("whitelist.bundles", new String[]{"org.apache.sling.discovery.commons", "org.apache.sling.discovery.base", "org.apache.sling.discovery.oak"})
                .put("whitelist.name", "sling-discovery")
                .asOption(),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-discovery with path system/sling\n\nset principal ACL for sling-discovery\n  allow   jcr:read,rep:write    on /var/discovery\nend\n\ncreate path (sling:Folder) /var/discovery\ncreate path (sling:Folder) /var/discovery/oak"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.discovery.commons=[sling-discovery]", "org.apache.sling.discovery.base=[sling-discovery]", "org.apache.sling.discovery.oak=[sling-discovery]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingDiscoveryStandalone() {
        return composite(
            slingDiscovery(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.standalone").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingDistribution() {
        return composite(
            sling(),
            slingJcr(),
            slingEvent(),
            felixHealthcheck(),
            httpcomponentsClient(),
            jackrabbitVault(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.distribution.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.distribution.core").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingEvent() {
        return composite(
            sling(),
            slingDiscovery(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.event").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.event.dea").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.inventory").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-event with path system/sling\n\nset principal ACL for sling-event\n    allow   jcr:all     on /var/eventing\nend\n\ncreate path (sling:Folder) /var/eventing"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.event=[sling-event]", "org.apache.sling.event.dea=[sling-event]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingExtensionsWebconsolesecurityprovider() {
        return composite(
            sling(),
            jackrabbit(),
            webconsole(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.extensions.webconsolesecurityprovider").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingFeatureflags() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.featureflags").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingFsresource() {
        return composite(
            sling(),
            jackrabbitVault(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.fsresource").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver),
            mavenBundle().groupId("com.google.guava").artifactId("guava").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-jackrabbit-api").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-jcr-commons").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingI18n() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.i18n").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.i18n=[sling-readall]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingJmxProvider() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jmx.provider").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingModels() {
        return composite(
            sling(),
            slingAdapter(),
            slingScripting(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.models.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.models.impl").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.annotation-api-1.3").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingModelsJacksonexporter() {
        return composite(
            slingModels(),
            jackson(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.models.jacksonexporter").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingPipes() {
        return composite(
            sling(),
            jackrabbit(),
            jackrabbitVault(),
            slingCaconfig(),
            slingEvent(),
            slingModels(),
            slingQuery(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.pipes").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingQuery() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.query").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingResourceInventory() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.resource.inventory").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.inventory").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingResourcePresence() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.resource.presence").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.resource.presence=[sling-readall]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingResourcemerger() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.resourcemerger").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingRewriter() {
        return composite(
            sling(),
            slingCommonsHtml(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.rewriter").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-text").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.rewriter=[sling-readall]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingSecurity() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.security").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingUrlrewriter() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.urlrewriter").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.urlrewritefilter").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingValidation() {
        return composite(
            sling(),
            slingI18n(),
            slingServlets(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.validation.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.validation.core").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-validation with path system/sling\n\nset principal ACL for sling-validation\n  allow   jcr:read    on /apps\n  allow   jcr:read    on /libs\nend"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.validation.core=[sling-validation]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingXss() {
        return composite(
            sling(),
            httpcomponentsClient(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.xss").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-text").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-xss with path system/sling\n\nset principal ACL for sling-xss\n  allow   jcr:read    on /apps/sling/xss\n  allow   jcr:read    on /libs/sling/xss\nend\n\ncreate path (sling:Folder) /apps/sling/xss\ncreate path (sling:Folder) /libs/sling/xss"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.xss=[sling-xss]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingInstaller() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.console").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.core").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.cm.json").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingInstallerFactoryConfiguration() {
        return composite(
            slingInstaller(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.factory.configuration").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingInstallerFactoryPackages() {
        return composite(
            slingInstaller(),
            slingJcr(),
            jackrabbitVault(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.factory.packages").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-installer-factory-packages with path system/sling\n\nset principal ACL for sling-installer-factory-packages\n    allow   jcr:all     on    /\n    allow   jcr:namespaceManagement,jcr:nodeTypeDefinitionManagement on :repository\nend"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.installer.factory.packages=[sling-installer-factory-packages]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingInstallerHealthcheck() {
        return composite(
            slingInstaller(),
            felixHealthcheck(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.hc").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingInstallerProviderFile() {
        return composite(
            slingInstaller(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.provider.file").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingInstallerProviderJcr() {
        return composite(
            slingInstaller(),
            slingJcr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.provider.jcr").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-installer-provider-jcr with path system/sling\n\nset principal ACL for sling-installer-provider-jcr\n    allow   jcr:read    on /\n    allow   rep:write   on /apps/sling/install\nend\n\ncreate path (sling:Folder) /apps/sling/install"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.installer.provider.jcr=[sling-installer-provider-jcr]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingJcr() {
        return composite(
            webconsole(),
            sling(),
            jackrabbit(),
            jackrabbitOak(),
            tika(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.base").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.contentloader").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.davex").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.resource").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.webconsole").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.webdav").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.base.internal.LoginAdminWhitelist.fragment")
                .put("whitelist.bundles", new String[]{"org.apache.sling.jcr.base", "org.apache.sling.jcr.classloader", "org.apache.sling.jcr.oak.server", "org.apache.sling.jcr.repoinit", "org.apache.sling.jcr.webconsole"})
                .put("whitelist.name", "sling-jcr")
                .asOption(),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-jcr-contentloader with path system/sling\n\nset principal ACL for sling-jcr-contentloader\n  allow   jcr:all    on /\nend"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.jcr.resource:observation=[sling-readall]", "org.apache.sling.jcr.resource:validation=[sling-readall]"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.jcr.contentloader=[sling-jcr-contentloader]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingJcrCompiler() {
        return composite(
            sling(),
            slingJcr(),
            slingCommonsCompiler(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.compiler").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingJcrJackrabbitAccessmanager() {
        return composite(
            slingJcr(),
            slingServlets(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.jackrabbit.accessmanager").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingJcrJackrabbitUsermanager() {
        return composite(
            slingJcr(),
            slingServlets(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.jackrabbit.usermanager").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-jcr-jackrabbit-usermanager with path system/sling\n\nset principal ACL for sling-jcr-jackrabbit-usermanager\n  allow jcr:read,jcr:readAccessControl,jcr:modifyAccessControl,rep:write,rep:userManagement on /home\nend"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.jcr.jackrabbit.usermanager=[sling-jcr-jackrabbit-usermanager]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingJcrRepoinit() {
        return composite(
            sling(),
            slingJcr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.repoinit").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.repoinit.parser").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.provisioning.model").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingQuickstartOak() {
        return composite(
            webconsole(),
            sling(),
            slingServlets(),
            slingJcr(),
            slingJcrRepoinit(),
            slingAdapter(),
            slingDiscoveryStandalone(),
            felixHealthcheck(),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.prefs").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.webconsole.plugins.memoryusage").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.webconsole.plugins.packageadmin").version(versionResolver),
            factoryConfiguration("org.apache.felix.jaas.Configuration.factory")
                .put("jaas.classname", "org.apache.jackrabbit.oak.spi.security.authentication.GuestLoginModule")
                .put("jaas.controlFlag", "optional")
                .put("jaas.ranking", 300)
                .asOption(),
            factoryConfiguration("org.apache.felix.jaas.Configuration.factory")
                .put("jaas.classname", "org.apache.jackrabbit.oak.security.authentication.user.LoginModuleImpl")
                .put("jaas.controlFlag", "required")
                .asOption(),
            factoryConfiguration("org.apache.felix.jaas.Configuration.factory")
                .put("jaas.classname", "org.apache.jackrabbit.oak.security.authentication.token.TokenLoginModule")
                .put("jaas.controlFlag", "sufficient")
                .put("jaas.ranking", 200)
                .asOption(),
            newConfiguration("org.apache.felix.jaas.ConfigurationSpi")
                .put("jaas.configProviderName", "FelixJaasProvider")
                .put("jaas.defaultRealmName", "jackrabbit.oak")
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.security.authentication.AuthenticationConfigurationImpl")
                .put("org.apache.jackrabbit.oak.authentication.configSpiName", "FelixJaasProvider")
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.security.authorization.AuthorizationConfigurationImpl")
                .put("importBehavior", "besteffort")
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.security.internal.SecurityProviderRegistration")
                .put("requiredServicePids", new String[]{"org.apache.jackrabbit.oak.security.authorization.AuthorizationConfigurationImpl", "org.apache.jackrabbit.oak.security.principal.PrincipalConfigurationImpl", "org.apache.jackrabbit.oak.security.authentication.token.TokenConfigurationImpl", "org.apache.jackrabbit.oak.spi.security.user.action.DefaultAuthorizableActionProvider", "org.apache.jackrabbit.oak.security.authorization.restriction.RestrictionProviderImpl", "org.apache.jackrabbit.oak.security.user.UserAuthenticationFactoryImpl", "org.apache.jackrabbit.oak.spi.security.authorization.principalbased.impl.PrincipalBasedAuthorizationConfiguration"})
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.security.user.UserConfigurationImpl")
                .put("defaultDepth", 1)
                .put("groupsPath", "/home/groups")
                .put("importBehavior", "besteffort")
                .put("usersPath", "/home/users")
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.security.user.RandomAuthorizableNodeName")
                .put("length", 21)
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.spi.security.authorization.principalbased.impl.FilterProviderImpl")
                .put("path", "/home/users/system/sling")
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.spi.security.authorization.principalbased.impl.PrincipalBasedAuthorizationConfiguration")
                .put("enableAggregationFilter", true)
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.spi.security.user.action.DefaultAuthorizableActionProvider")
                .put("enabledActions", new String[]{"org.apache.jackrabbit.oak.spi.security.user.action.AccessControlAction"})
                .put("groupPrivilegeNames", new String[]{"jcr:read"})
                .put("userPrivilegeNames", new String[]{"jcr:all"})
                .asOption(),
            newConfiguration("org.apache.jackrabbit.vault.packaging.impl.PackagingImpl")
                .put("authIdsForHookExecution", new String[]{"sling-installer-factory-packages"})
                .put("authIdsForRootInstallation", new String[]{"sling-installer-factory-packages"})
                .put("packageRoots", new String[]{"/var/packages"})
                .asOption(),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create path (sling:Folder) /apps\ncreate path (sling:Folder) /libs\ncreate path (sling:Folder) /var\ncreate path (sling:OrderedFolder) /content"})
                .asOption(),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-mapping with path system/sling\n\nset principal ACL for sling-mapping\n  allow   jcr:read    on /\nend"})
                .asOption(),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-readall with path system/sling\n\nset principal ACL for sling-readall\n  allow   jcr:read    on /\nend"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingQuickstartOakTar() {
        return composite(
            slingQuickstartOak(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-lucene").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-segment-tar").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-store-document").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.oak.server").version(versionResolver),
            newConfiguration("org.apache.jackrabbit.oak.plugins.index.lucene.LuceneIndexProviderService")
                .put("localIndexDir", "sling/repository/index")
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.segment.SegmentNodeStoreService")
                .put("name", "Default NodeStore")
                .put("repository.home", "sling/repository")
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingQuickstartOakMongo() {
        return composite(
            slingQuickstartOak(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-lucene").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-store-document").version(versionResolver),
            mavenBundle().groupId("com.h2database").artifactId("h2-mvstore").version(versionResolver),
            mavenBundle().groupId("org.mongodb").artifactId("mongo-java-driver").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.oak.server").version(versionResolver),
            newConfiguration("org.apache.jackrabbit.oak.plugins.index.lucene.LuceneIndexProviderService")
                .put("localIndexDir", "sling/repository/index")
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.plugins.document.DocumentNodeStoreService")
                .put("db", "sling")
                .put("mongouri", "mongodb://localhost:27017")
                .put("repository.home", "sling/repository")
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingScripting() {
        return composite(
            sling(),
            slingCommonsCompiler(),
            webconsole(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.spi").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.core").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-scripting with path system/sling\n\nset principal ACL for sling-scripting\n  allow   jcr:read    on /apps\n  allow   jcr:read    on /libs\nend"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.scripting.core=[sling-scripting]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingScriptingFreemarker() {
        return composite(
            sling(),
            slingAdapter(),
            slingScripting(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.freemarker").version(versionResolver),
            mavenBundle().groupId("org.freemarker").artifactId("freemarker").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingScriptingGroovy() {
        return composite(
            sling(),
            slingScripting(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.groovy").version(versionResolver),
            mavenBundle().groupId("org.apache.groovy").artifactId("groovy").version(versionResolver),
            mavenBundle().groupId("org.apache.groovy").artifactId("groovy-templates").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingScriptingJava() {
        return composite(
            sling(),
            slingScripting(),
            slingCommonsCompiler(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.java").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingScriptingJavascript() {
        return composite(
            slingScripting(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.javascript").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.rhino").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingScriptingJsp() {
        return composite(
            slingScripting(),
            slingCommonsCompiler(),
            slingCaconfig(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.jsp").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.jsp.taglib").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.el-api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.jsp-api").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.bundles").artifactId("jstl").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingScriptingHtl() {
        return composite(
            sling(),
            slingJcr(),
            slingScripting(),
            slingScriptingJavascript(),
            slingI18n(),
            slingModels(),
            slingXss(),
            slingCommonsCompiler(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly.compiler").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly.compiler.java").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly.js.provider").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly.runtime").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.rhino").version(versionResolver),
            mavenBundle().groupId("org.antlr").artifactId("antlr4-runtime").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.scripting.sightly.js.provider=[sling-scripting]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingScriptingThymeleaf() {
        return composite(
            thymeleaf(),
            sling(),
            slingScripting(),
            slingI18n(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.thymeleaf").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.scripting.thymeleaf=[sling-scripting]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingServlets() {
        return composite(
            sling(),
            slingScripting(),
            slingXss(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.servlets.get").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.servlets.post").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.servlets.resolver").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.base.internal.LoginAdminWhitelist.fragment")
                .put("whitelist.bundles", new String[]{"org.apache.sling.servlets.post"})
                .put("whitelist.name", "sling-servlets")
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.servlets.resolver:console=[sling-readall]", "org.apache.sling.servlets.resolver:scripts=[sling-scripting]"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingStarterContent() {
        return composite(
            sling(),
            slingAuthForm(),
            slingScriptingJavascript(),
            composumNodes(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.starter.content").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create path (sling:OrderedFolder) /content/starter\n\nset ACL for everyone\n  allow     jcr:read    on /content/starter\nend"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption felixHealthcheck() {
        return composite(
            eventadmin(),
            scr(),
            webconsole(),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.api").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.core").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.generalchecks").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.webconsoleplugin").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption httpcomponentsClient() {
        return composite(
            config(),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpclient-osgi").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpcore-osgi").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption jackrabbit() {
        return composite(
            httpcomponentsClient(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-jackrabbit-api").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-data").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-jcr-commons").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-jcr-rmi").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-spi").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-spi-commons").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-webdav").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver),
            mavenBundle().groupId("javax.servlet").artifactId("javax.servlet-api").version(versionResolver),
            mavenBundle().groupId("commons-codec").artifactId("commons-codec").version(versionResolver),
            mavenBundle().groupId("commons-fileupload").artifactId("commons-fileupload").version(versionResolver),
            mavenBundle().groupId("commons-io").artifactId("commons-io").version(versionResolver),
            mavenBundle().groupId("commons-lang").artifactId("commons-lang").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-collections4").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-atinject_1.0_spec").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-el_2.2_spec").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-interceptor_1.1_spec").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-jcdi_1.0_spec").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-jta_1.1_spec").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption jackrabbitOak() {
        return composite(
            scr(),
            slingCommonsMetrics(),
            slingCommonsThreads(),
            jackrabbit(),
            tika(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-api").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-authorization-principalbased").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-blob").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-blob-plugins").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-commons").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-core").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-core-spi").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-jcr").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-query-spi").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-security-spi").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-store-composite").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-store-spi").version(versionResolver),
            mavenBundle().groupId("com.google.guava").artifactId("guava").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.jaas").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption jackrabbitVault() {
        return composite(
            scr(),
            jackrabbit(),
            mavenBundle().groupId("org.apache.jackrabbit.vault").artifactId("org.apache.jackrabbit.vault").version(versionResolver),
            mavenBundle().groupId("commons-collections").artifactId("commons-collections").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption tika() {
        return composite(
            mavenBundle().groupId("org.apache.tika").artifactId("tika-core").version(versionResolver),
            mavenBundle().groupId("org.apache.tika").artifactId("tika-parsers").version(versionResolver),
            mavenBundle().groupId("org.apache.pdfbox").artifactId("pdfbox").version(versionResolver),
            mavenBundle().groupId("org.apache.pdfbox").artifactId("fontbox").version(versionResolver),
            mavenBundle().groupId("org.apache.pdfbox").artifactId("jempbox").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption composumNodes() {
        return composite(
            sling(),
            slingI18n(),
            slingJcr(),
            slingScriptingJsp(),
            slingServlets(),
            slingEvent(),
            jackrabbitVault(),
            mavenBundle().groupId("com.composum.nodes").artifactId("composum-nodes-commons").version(versionResolver),
            mavenBundle().groupId("com.composum.nodes").artifactId("composum-nodes-console").version(versionResolver),
            mavenBundle().groupId("com.composum.nodes").artifactId("composum-nodes-jslibs").version(versionResolver),
            mavenBundle().groupId("com.composum.nodes").artifactId("composum-nodes-pckgmgr").version(versionResolver),
            mavenBundle().groupId("com.composum.nodes").artifactId("composum-nodes-usermgr").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.base.internal.LoginAdminWhitelist.fragment")
                .put("whitelist.bundles", new String[]{"com.composum.nodes.commons", "com.composum.nodes.pckgmgr", "com.composum.nodes.usermgr"})
                .put("whitelist.name", "composum-nodes")
                .asOption()
        );
    }

    public static ModifiableCompositeOption thymeleaf() {
        return composite(
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.thymeleaf").version(versionResolver),
            mavenBundle().groupId("org.attoparser").artifactId("attoparser").version(versionResolver),
            mavenBundle().groupId("org.unbescape").artifactId("unbescape").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.ognl").version(versionResolver),
            mavenBundle().groupId("org.javassist").artifactId("javassist").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingQuickstartOakTar(final String workingDirectory, final int httpPort) {
        final String slingHome = String.format("%s/sling", workingDirectory);
        final String repositoryHome = String.format("%s/repository", slingHome);
        final String localIndexDir = String.format("%s/index", repositoryHome);
        return composite(
            slingQuickstartOak(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-lucene").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-segment-tar").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-store-document").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.oak.server").version(versionResolver),
            newConfiguration("org.apache.felix.http")
                .put("org.osgi.service.http.port", httpPort)
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.segment.SegmentNodeStoreService")
                .put("repository.home", repositoryHome)
                .put("name", "Default NodeStore")
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.plugins.index.lucene.LuceneIndexProviderService")
                .put("localIndexDir", localIndexDir)
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingQuickstartOakMongo(final String workingDirectory, final int httpPort, final String mongouri) {
        final String slingHome = String.format("%s/sling", workingDirectory);
        final String repositoryHome = String.format("%s/repository", slingHome);
        final String localIndexDir = String.format("%s/index", repositoryHome);
        return composite(
            slingQuickstartOak(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-lucene").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-store-document").version(versionResolver),
            mavenBundle().groupId("org.mongodb").artifactId("mongo-java-driver").version(versionResolver),
            mavenBundle().groupId("com.h2database").artifactId("h2-mvstore").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.oak.server").version(versionResolver),
            newConfiguration("org.apache.felix.http")
                .put("org.osgi.service.http.port", httpPort)
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.plugins.index.lucene.LuceneIndexProviderService")
                .put("localIndexDir", localIndexDir)
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.plugins.document.DocumentNodeStoreService")
                .put("db", "sling")
                .put("mongouri", mongouri)
                .asOption()
        );
    }

}
