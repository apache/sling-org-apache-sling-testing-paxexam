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

import org.ops4j.pax.exam.options.ModifiableCompositeOption;
import org.ops4j.pax.exam.options.WrappedUrlProvisionOption;
import org.ops4j.pax.exam.util.PathUtils;

import static org.ops4j.pax.exam.CoreOptions.composite;
import static org.ops4j.pax.exam.CoreOptions.junitBundles;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.systemPackages;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.vmOption;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.cm.ConfigurationAdminOptions.factoryConfiguration;
import static org.ops4j.pax.exam.cm.ConfigurationAdminOptions.newConfiguration;

/**
 * NOTE: This file is generated from Sling's Karaf Features
 */
public class SlingOptions {

    public static SlingVersionResolver versionResolver = new SlingVersionResolver();

    public static ModifiableCompositeOption awaitility() {
        return composite(
            mavenBundle().groupId("org.awaitility").artifactId("awaitility").version(versionResolver),
            mavenBundle().groupId("org.hamcrest").artifactId("hamcrest").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption backing() {
        final int version = SlingVersionResolver.getJavaVersion();
        if (version >= 11) {
            return composite(
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.annotation-api-1.3").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.activation-api-1.1").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.stax-api-1.2").version(versionResolver),
                mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.jaxb-api-2.2").version(versionResolver),
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
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.util.function").version(versionResolver),
            mavenBundle().groupId("org.osgi").artifactId("org.osgi.util.promise").version(versionResolver),
            config()
        );
    }

    public static ModifiableCompositeOption spyfly() {
        return composite(
            mavenBundle().groupId("org.apache.aries").artifactId("org.apache.aries.util").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.spifly").artifactId("org.apache.aries.spifly.dynamic.bundle").version(versionResolver),
            mavenBundle().groupId("org.ow2.asm").artifactId("asm").version(versionResolver)
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
            mavenBundle().groupId("org.codehaus.groovy").artifactId("groovy").version(versionResolver),
            mavenBundle().groupId("org.codehaus.groovy").artifactId("groovy-json").version(versionResolver),
            mavenBundle().groupId("org.codehaus.groovy").artifactId("groovy-xml").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.jaxb-impl").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.tagsoup").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.activation-api-1.1").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.jaxb-api-2.2").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.specs").artifactId("org.apache.servicemix.specs.stax-api-1.2").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpcore-osgi").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpclient-osgi").version(versionResolver),
            mavenBundle().groupId("org.hamcrest").artifactId("hamcrest").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption testcontainers() {
        return composite(
            junitBundles(),
            paxUrlWrap(),
            wrappedBundle(mavenBundle().groupId("org.rnorth.duct-tape").artifactId("duct-tape").version(versionResolver)),
            wrappedBundle(mavenBundle().groupId("org.testcontainers").artifactId("testcontainers").version(versionResolver)).imports("org.junit.rules").overwriteManifest(WrappedUrlProvisionOption.OverwriteMode.MERGE)
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
            mavenBundle().groupId("commons-lang").artifactId("commons-lang").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-collections4").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-math").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.resourceresolver:mapping=sling-mapping", "org.apache.sling.resourceresolver:hierarchy=sling-readall", "org.apache.sling.resourceresolver:observation=sling-readall", "org.apache.sling.resourceresolver:console=sling-readall"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingAuthForm() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.auth.form").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver)
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
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.html").version(versionResolver),
            slingCommonsOsgi()
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
            mavenBundle().groupId("com.sun.mail").artifactId("javax.mail").version(versionResolver),
            mavenBundle().groupId("javax.mail").artifactId("javax.mail-api").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingCommonsMetrics() {
        return composite(
            scr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.metrics").version(versionResolver),
            mavenBundle().groupId("io.dropwizard.metrics").artifactId("metrics-core").version(versionResolver)
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
                .put("user.mapping", new String[]{"org.apache.sling.caconfig.impl=sling-readall"})
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
                .put("scripts", new String[]{"create service user sling-clam\n\n  create path (sling:Folder) /var/clam/results(sling:OrderedFolder)\n\n  set ACL for sling-clam\n\n    allow   jcr:read    on /\n\n    allow   rep:write   on /var/clam\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.clam=sling-clam", "org.apache.sling.clam:result-writer=sling-clam"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingDiscovery() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.support").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingDiscoveryOak() {
        return composite(
            webconsole(),
            slingDiscovery(),
            slingHealthcheck(),
            httpcomponentsClient(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.base").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.commons").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.oak").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-discovery\n\n  create path (sling:Folder) /var/discovery\n\n  create path (sling:Folder) /var/discovery/oak\n\n  set ACL for sling-discovery\n\n    allow   jcr:read    on /var/discovery\n\n    allow   rep:write   on /var/discovery\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.discovery.commons=sling-discovery", "org.apache.sling.discovery.base=sling-discovery", "org.apache.sling.discovery.oak=sling-discovery"})
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
            slingHealthcheck(),
            jackrabbitVault(),
            httpcomponentsClient(),
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
                .put("scripts", new String[]{"create service user sling-event\n\n  create path (sling:Folder) /var/eventing\n\n  set ACL for sling-event\n\n    allow   jcr:all     on /var/eventing\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.event=sling-event", "org.apache.sling.event.dea=sling-event"})
                .asOption()
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
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-api").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-jcr-commons").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingHealthcheck() {
        return composite(
            felixHealthcheck(),
            sling(),
            slingJcr(),
            slingScripting(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.hc.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.hc.support").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingI18n() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.i18n").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-i18n\n\n  set ACL for sling-i18n\n\n    allow   jcr:read    on /\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.i18n=sling-i18n"})
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
            slingScripting(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.models.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.models.impl").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingModelsJacksonexporter() {
        return composite(
            slingModels(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.models.jacksonexporter").version(versionResolver),
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-annotations").version(versionResolver),
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-core").version(versionResolver),
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-databind").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingPipes() {
        return composite(
            sling(),
            jackrabbit(),
            jackrabbitVault(),
            slingEvent(),
            slingModels(),
            slingQuery(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.pipes").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.bundles").artifactId("commons-httpclient").version(versionResolver)
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
                .put("user.mapping", new String[]{"org.apache.sling.resource.presence=sling-readall"})
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
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.rewriter=sling-readall"})
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
                .put("scripts", new String[]{"create service user sling-validation\n\n  create path (sling:Folder) /apps\n\n  create path (sling:Folder) /libs\n\n  set ACL for sling-validation\n\n    allow   jcr:read    on /apps\n\n    allow   jcr:read    on /libs\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.validation.core=sling-validation"})
                .asOption()
        );
    }

    // DO NOT REMOVE additional system packages
    public static ModifiableCompositeOption slingXss() {
        return composite(
            sling(),
            httpcomponentsClient(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.xss").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-xss\n\n  create path (sling:Folder) /apps/sling/xss\n\n  create path (sling:Folder) /libs/sling/xss\n\n  set ACL for sling-xss\n\n    allow   jcr:read    on /apps/sling/xss\n\n    allow   jcr:read    on /libs/sling/xss\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.xss=sling-xss"})
                .asOption(),
            systemPackages(
                "org.w3c.dom.css",
                "org.w3c.dom.html",
                "org.w3c.dom.ranges",
                "org.w3c.dom.traversal"
            )
        );
    }

    public static ModifiableCompositeOption slingInstaller() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.console").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.core").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.factory.configuration").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingInstallerHealthcheck() {
        return composite(
            slingInstaller(),
            slingHealthcheck(),
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
                .put("scripts", new String[]{"create service user sling-jcr-install\n\n  create path (sling:Folder) /apps/sling/install\n\n  set ACL for sling-jcr-install\n\n    allow   jcr:read    on /\n\n    allow   rep:write   on /apps/sling/install\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.installer.provider.jcr=sling-jcr-install"})
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
                .put("whitelist.bundles", new String[]{"org.apache.sling.discovery.commons", "org.apache.sling.discovery.base", "org.apache.sling.discovery.oak", "org.apache.sling.jcr.base", "org.apache.sling.jcr.classloader", "org.apache.sling.jcr.contentloader", "org.apache.sling.jcr.jackrabbit.usermanager", "org.apache.sling.jcr.oak.server", "org.apache.sling.jcr.repoinit", "org.apache.sling.jcr.webconsole"})
                .put("whitelist.name", "sling")
                .asOption(),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-mapping\n\n  create service user sling-readall\n\n  create path (sling:Folder) /apps\n\n  create path (sling:Folder) /libs\n\n  create path (sling:Folder) /var\n\n  create path (sling:OrderedFolder) /content\n\n  set ACL for everyone\n\n      allow   jcr:read    on /content\n\n  end\n\n  set ACL for sling-mapping\n\n      allow   jcr:read    on /\n\n  end\n\n  set ACL for sling-readall\n\n      allow   jcr:read    on /\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.jcr.resource:observation=sling-readall", "org.apache.sling.jcr.resource:validation=sling-readall"})
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

    public static ModifiableCompositeOption slingJcrJackrabbitSecurity() {
        return composite(
            slingJcr(),
            slingServlets(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.jackrabbit.accessmanager").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.jackrabbit.usermanager").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption slingJcrRepoinit() {
        return composite(
            sling(),
            slingJcr(),
            slingJcrJackrabbitSecurity(),
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
            slingInstaller(),
            slingJcr(),
            slingJcrRepoinit(),
            slingAdapter(),
            slingBundleresource(),
            slingDiscoveryStandalone(),
            slingHealthcheck(),
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
            newConfiguration("org.apache.jackrabbit.oak.security.user.UserConfigurationImpl")
                .put("defaultDepth", 1)
                .put("groupsPath", "/home/groups")
                .put("importBehavior", "besteffort")
                .put("usersPath", "/home/users")
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.security.user.RandomAuthorizableNodeName")
                .put("length", 21)
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.spi.security.user.action.DefaultAuthorizableActionProvider")
                .put("enabledActions", new String[]{"org.apache.jackrabbit.oak.spi.security.user.action.AccessControlAction"})
                .put("groupPrivilegeNames", new String[]{"jcr:read"})
                .put("userPrivilegeNames", new String[]{"jcr:all"})
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
            webconsole(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.core").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-scripting\n\n  create path (sling:Folder) /apps\n\n  create path (sling:Folder) /libs\n\n  set ACL for sling-scripting\n\n    allow   jcr:read    on /apps\n\n    allow   jcr:read    on /libs\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.scripting.core=sling-scripting"})
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
            mavenBundle().groupId("org.codehaus.groovy").artifactId("groovy").version(versionResolver),
            mavenBundle().groupId("org.codehaus.groovy").artifactId("groovy-json").version(versionResolver),
            mavenBundle().groupId("org.codehaus.groovy").artifactId("groovy-templates").version(versionResolver)
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

    // DO NOT REMOVE org.apache.sling.scripting.jsp-api and org.apache.sling.scripting.el-api
    public static ModifiableCompositeOption slingScriptingJsp() {
        return composite(
            slingScripting(),
            slingCommonsCompiler(),
            slingCaconfig(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.jsp").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.jsp.taglib").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.jsp-api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.el-api").version(versionResolver)
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
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly.models.provider").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly.runtime").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.rhino").version(versionResolver),
            mavenBundle().groupId("org.antlr").artifactId("antlr4-runtime").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.scripting.sightly.js.provider=sling-scripting"})
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
                .put("user.mapping", new String[]{"org.apache.sling.scripting.thymeleaf=sling-scripting"})
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
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.servlets.resolver:console=sling-readall", "org.apache.sling.servlets.resolver:scripts=sling-scripting"})
                .asOption()
        );
    }

    public static ModifiableCompositeOption slingStarterContent() {
        return composite(
            sling(),
            slingAuthForm(),
            composumNodes(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.starter.content").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption felixHealthcheck() {
        return composite(
            scr(),
            webconsole(),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.api").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.core").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.generalchecks").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.healthcheck.webconsoleplugin").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver)
        );
    }

    public static ModifiableCompositeOption jackrabbit() {
        return composite(
            httpcomponentsClient(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-api").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-data").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-jcr-commons").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-jcr-rmi").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-spi").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-spi-commons").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-webdav").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver),
            mavenBundle().groupId("javax.servlet").artifactId("javax.servlet-api").version(versionResolver),
            mavenBundle().groupId("commons-codec").artifactId("commons-codec").version(versionResolver),
            mavenBundle().groupId("commons-collections").artifactId("commons-collections").version(versionResolver),
            mavenBundle().groupId("commons-fileupload").artifactId("commons-fileupload").version(versionResolver),
            mavenBundle().groupId("commons-io").artifactId("commons-io").version(versionResolver),
            mavenBundle().groupId("commons-lang").artifactId("commons-lang").version(versionResolver),
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

    // DO NOT REMOVE additional system packages
    public static ModifiableCompositeOption jackrabbitVault() {
        return composite(
            scr(),
            jackrabbit(),
            mavenBundle().groupId("org.apache.jackrabbit.vault").artifactId("org.apache.jackrabbit.vault").version(versionResolver),
            systemPackages(
                "org.w3c.dom.html"
            )
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
            slingJcr(),
            slingScriptingJsp(),
            slingEvent(),
            jackrabbitVault(),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-core-commons").version(versionResolver),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-core-config").version(versionResolver),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-core-console").version(versionResolver),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-core-jslibs").version(versionResolver),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-user-management").version(versionResolver),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-package-manager").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.base.internal.LoginAdminWhitelist.fragment")
                .put("whitelist.bundles", new String[]{"com.composum.core.commons", "com.composum.core.pckgmgr"})
                .put("whitelist.name", "composum-nodes")
                .asOption()
        );
    }

    public static ModifiableCompositeOption httpcomponentsClient() {
        return composite(
            config(),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpcore-osgi").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpclient-osgi").version(versionResolver)
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
