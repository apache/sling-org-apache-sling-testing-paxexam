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

import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.util.PathUtils;

import static org.ops4j.pax.exam.CoreOptions.composite;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.systemPackages;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.cm.ConfigurationAdminOptions.factoryConfiguration;
import static org.ops4j.pax.exam.cm.ConfigurationAdminOptions.newConfiguration;

/**
 * NOTE: This file is generated from Sling's Karaf Features
 */
public class SlingOptions {

    public static SlingVersionResolver versionResolver = new SlingVersionResolver();

    public static Option config() {
        return mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.configadmin").version(versionResolver);
    }

    public static Option eventadmin() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.eventadmin").version(versionResolver),
            config()
        );
    }

    public static Option http() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.http.jetty").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.http.servlet-api").version(versionResolver),
            config()
        );
    }

    public static Option httpWhiteboard() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.http.whiteboard").version(versionResolver),
            http()
        );
    }

    public static Option management() {
        return composite(
            mavenBundle().groupId("org.apache.aries").artifactId("org.apache.aries.util").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.jmx").artifactId("org.apache.aries.jmx.api").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.jmx").artifactId("org.apache.aries.jmx.core").version(versionResolver),
            mavenBundle().groupId("org.apache.aries.jmx").artifactId("org.apache.aries.jmx.whiteboard").version(versionResolver),
            config()
        );
    }

    public static Option scr() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.metatype").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.scr").version(versionResolver),
            config()
        );
    }

    public static Option webconsole() {
        return composite(
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.webconsole").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.inventory").version(versionResolver),
            mavenBundle().groupId("commons-fileupload").artifactId("commons-fileupload").version(versionResolver),
            mavenBundle().groupId("commons-io").artifactId("commons-io").version(versionResolver),
            http()
        );
    }

    public static Option paxUrl() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-commons").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-lang").version(versionResolver),
            mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util-property").version(versionResolver),
            mavenBundle().groupId("org.ops4j.pax.swissbox").artifactId("pax-swissbox-property").version(versionResolver),
            config()
        );
    }

    public static Option paxUrlClasspath() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-classpath").version(versionResolver),
            paxUrl()
        );
    }

    public static Option paxTinybundles() {
        return composite(
            mavenBundle().groupId("org.ops4j.pax.tinybundles").artifactId("tinybundles").version(versionResolver),
            mavenBundle().groupId("biz.aQute.bnd").artifactId("biz.aQute.bndlib").version(versionResolver)
        );
    }

    public static Option logback() {
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

    public static Option sling() {
        return composite(
            config(),
            eventadmin(),
            scr(),
            management(),
            http(),
            httpWhiteboard(),
            slingCommonsClassloader(),
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
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.osgi").version(versionResolver),
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

    public static Option slingAuthForm() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.auth.form").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver)
        );
    }

    public static Option slingAuthOpenid() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.auth.openid").version(versionResolver)
        );
    }

    public static Option slingAuthSelector() {
        return composite(
            slingAuthForm(),
            slingAuthOpenid(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.auth.selector").version(versionResolver)
        );
    }

    public static Option slingCommonsCompiler() {
        return composite(
            scr(),
            slingCommonsClassloader(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.compiler").version(versionResolver)
        );
    }

    public static Option slingCommonsClassloader() {
        return composite(
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.classloader").version(versionResolver)
        );
    }

    public static Option slingCommonsFsclassloader() {
        return composite(
            scr(),
            webconsole(),
            slingCommonsClassloader(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.fsclassloader").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.osgi").version(versionResolver),
            mavenBundle().groupId("commons-io").artifactId("commons-io").version(versionResolver),
            mavenBundle().groupId("org.apache.commons").artifactId("commons-lang3").version(versionResolver)
        );
    }

    public static Option slingCommonsHtml() {
        return composite(
            scr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.html").version(versionResolver)
        );
    }

    public static Option slingCommonsMetrics() {
        return composite(
            scr(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.metrics").version(versionResolver),
            mavenBundle().groupId("io.dropwizard.metrics").artifactId("metrics-core").version(versionResolver)
        );
    }

    public static Option slingCommonsScheduler() {
        return composite(
            scr(),
            slingCommonsThreads(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.scheduler").version(versionResolver),
            mavenBundle().groupId("javax.servlet").artifactId("javax.servlet-api").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-jta_1.1_spec").version(versionResolver),
            mavenBundle().groupId("io.dropwizard.metrics").artifactId("metrics-core").version(versionResolver)
        );
    }

    public static Option slingCommonsThreads() {
        return composite(
            config(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.commons.threads").version(versionResolver)
        );
    }

    public static Option slingAdapter() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.adapter").version(versionResolver)
        );
    }

    public static Option slingBundleresource() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.bundleresource.impl").version(versionResolver)
        );
    }

    public static Option slingDiscovery() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.base").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.commons").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.support").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpcore-osgi").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpclient-osgi").version(versionResolver)
        );
    }

    public static Option slingDiscoveryImpl() {
        return composite(
            webconsole(),
            slingDiscovery(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.impl").version(versionResolver)
        );
    }

    public static Option slingDiscoveryOak() {
        return composite(
            webconsole(),
            slingDiscovery(),
            slingHealthcheck(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.oak").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-discovery\n\n  create path (sling:Folder) /var/discovery\n\n  create path (sling:Folder) /var/discovery/oak\n\n  set ACL for sling-discovery\n\n    allow   jcr:read    on /var/discovery\n\n    allow   rep:write   on /var/discovery\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.discovery.commons=sling-discovery", "org.apache.sling.discovery.base=sling-discovery", "org.apache.sling.discovery.oak=sling-discovery"})
                .asOption()
        );
    }

    public static Option slingDiscoveryStandalone() {
        return composite(
            slingDiscovery(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.discovery.standalone").version(versionResolver)
        );
    }

    public static Option slingDistribution() {
        return composite(
            sling(),
            slingJcr(),
            slingEvent(),
            slingHealthcheck(),
            jackrabbitVault(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.distribution.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.distribution.core").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpcore-osgi").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpclient-osgi").version(versionResolver)
        );
    }

    public static Option slingEvent() {
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

    public static Option slingFeatureflags() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.featureflags").version(versionResolver)
        );
    }

    public static Option slingFsresource() {
        return composite(
            sling(),
            jackrabbitVault(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.fsresource").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-api").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("jackrabbit-jcr-commons").version(versionResolver),
            mavenBundle().groupId("com.google.guava").artifactId("guava").version(versionResolver)
        );
    }

    public static Option slingHealthcheck() {
        return composite(
            sling(),
            slingJcr(),
            slingScripting(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.hc.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.hc.core").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.hc.support").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.hc.webconsole").version(versionResolver)
        );
    }

    public static Option slingI18n() {
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

    public static Option slingJmxProvider() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jmx.provider").version(versionResolver)
        );
    }

    public static Option slingModels() {
        return composite(
            sling(),
            slingScripting(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.models.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.models.impl").version(versionResolver)
        );
    }

    public static Option slingModelsJacksonexporter() {
        return composite(
            slingModels(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.models.jacksonexporter").version(versionResolver),
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-annotations").version(versionResolver),
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-core").version(versionResolver),
            mavenBundle().groupId("com.fasterxml.jackson.core").artifactId("jackson-databind").version(versionResolver)
        );
    }

    public static Option slingPipes() {
        return composite(
            sling(),
            jackrabbit(),
            slingEvent(),
            slingModels(),
            slingQuery(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.pipes").version(versionResolver)
        );
    }

    public static Option slingQuery() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.query").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver)
        );
    }

    public static Option slingResourceInventory() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.resource.inventory").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.inventory").version(versionResolver)
        );
    }

    public static Option slingResourcePresence() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.resource.presence").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.resource.presence=sling-readall"})
                .asOption()
        );
    }

    public static Option slingResourcemerger() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.resourcemerger").version(versionResolver)
        );
    }

    public static Option slingRewriter() {
        return composite(
            sling(),
            slingCommonsHtml(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.rewriter").version(versionResolver)
        );
    }

    public static Option slingSecurity() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.security").version(versionResolver)
        );
    }

    public static Option slingExtensionsThreaddump() {
        return composite(
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.extensions.threaddump").version(versionResolver)
        );
    }

    public static Option slingUrlrewriter() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.urlrewriter").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.urlrewritefilter").version(versionResolver)
        );
    }

    public static Option slingValidation() {
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
    public static Option slingXss() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.xss").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.bundles").artifactId("commons-httpclient").version(versionResolver),
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

    public static Option slingInstaller() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.console").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.core").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.factory.configuration").version(versionResolver)
        );
    }

    public static Option slingInstallerHealthcheck() {
        return composite(
            slingInstaller(),
            slingHealthcheck(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.hc").version(versionResolver)
        );
    }

    public static Option slingInstallerProviderFile() {
        return composite(
            slingInstaller(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.installer.provider.file").version(versionResolver)
        );
    }

    public static Option slingInstallerProviderJcr() {
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

    public static Option slingJcr() {
        return composite(
            webconsole(),
            sling(),
            jackrabbit(),
            jackrabbitOak(),
            tika(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.base").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.classloader").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.contentloader").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.davex").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.registration").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.resource").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.webconsole").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.webdav").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.base.internal.LoginAdminWhitelist.fragment")
                .put("whitelist.bundles", new String[]{"org.apache.sling.discovery.commons", "org.apache.sling.discovery.base", "org.apache.sling.discovery.oak", "org.apache.sling.jcr.base", "org.apache.sling.jcr.classloader", "org.apache.sling.jcr.contentloader", "org.apache.sling.jcr.jackrabbit.usermanager", "org.apache.sling.jcr.oak.server", "org.apache.sling.jcr.repoinit", "org.apache.sling.jcr.webconsole"})
                .put("whitelist.name", "sling")
                .asOption(),
            factoryConfiguration("org.apache.sling.jcr.repoinit.RepositoryInitializer")
                .put("scripts", new String[]{"create service user sling-mapping\n\n  create service user sling-readall\n\n  create path (sling:Folder) /apps\n\n  create path (sling:Folder) /libs\n\n  create path (sling:Folder) /var\n\n  create path (sling:OrderedFolder) /content\n\n  set ACL for everyone\n\n       allow   jcr:read    on /\n\n  end\n\n  set ACL for sling-mapping\n\n      allow   jcr:read    on /\n\n  end\n\n  set ACL for sling-readall\n\n      allow   jcr:read    on /\n\n  end"})
                .asOption(),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.jcr.resource:observation=sling-readall", "org.apache.sling.jcr.resource:validation=sling-readall"})
                .asOption()
        );
    }

    public static Option slingJcrCompiler() {
        return composite(
            sling(),
            slingJcr(),
            slingCommonsCompiler(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.compiler").version(versionResolver)
        );
    }

    public static Option slingJcrJackrabbitSecurity() {
        return composite(
            slingJcr(),
            slingServlets(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.jackrabbit.accessmanager").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.jackrabbit.usermanager").version(versionResolver)
        );
    }

    public static Option slingJcrRepoinit() {
        return composite(
            sling(),
            slingJcr(),
            slingJcrJackrabbitSecurity(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.repoinit").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.repoinit.parser").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.provisioning.model").version(versionResolver)
        );
    }

    public static Option slingLaunchpadContent() {
        return composite(
            sling(),
            slingAuthForm(),
            composum(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.launchpad.content").version(versionResolver)
        );
    }

    public static Option slingNosqlGeneric() {
        return composite(
            sling(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.nosql.generic").version(versionResolver)
        );
    }

    public static Option slingNosqlCouchbase() {
        return composite(
            slingNosqlGeneric(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.nosql.couchbase-client").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.nosql.couchbase-resourceprovider").version(versionResolver),
            mavenBundle().groupId("io.wcm.osgi.wrapper").artifactId("io.wcm.osgi.wrapper.rxjava").version(versionResolver)
        );
    }

    public static Option slingNosqlMongodb() {
        return composite(
            slingNosqlGeneric(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.nosql.mongodb-resourceprovider").version(versionResolver),
            mavenBundle().groupId("org.mongodb").artifactId("mongo-java-driver").version(versionResolver)
        );
    }

    public static Option slingQuickstartNosqlCouchbase() {
        return composite(
            slingNosqlCouchbase(),
            factoryConfiguration("org.apache.sling.nosql.couchbase.resourceprovider.CouchbaseNoSqlResourceProviderFactory.factory.config")
                .put("provider.roots", new String[]{"/"})
                .asOption(),
            factoryConfiguration("org.apache.sling.nosql.couchbase.client.CouchbaseClient.factory.config")
                .put("bucketName", "sling")
                .put("clientId", "sling-resourceprovider-couchbase")
                .put("couchbaseHosts", "localhost:8091")
                .put("enabled", true)
                .asOption()
        );
    }

    public static Option slingQuickstartNosqlMongodb() {
        return composite(
            slingNosqlMongodb(),
            factoryConfiguration("org.apache.sling.nosql.mongodb.resourceprovider.MongoDBNoSqlResourceProviderFactory.factory.config")
                .put("collection", "resources")
                .put("connectionString", "localhost:27017")
                .put("database", "sling")
                .put("provider.roots", new String[]{"/"})
                .asOption()
        );
    }

    public static Option slingQuickstartOak() {
        return composite(
            webconsole(),
            sling(),
            slingServlets(),
            slingInstaller(),
            slingJcr(),
            slingJcrRepoinit(),
            slingAdapter(),
            slingBundleresource(),
            slingDiscoveryOak(),
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

    public static Option slingQuickstartOakTar() {
        return composite(
            slingQuickstartOak(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-segment-tar").version(versionResolver),
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

    public static Option slingQuickstartOakMongo() {
        return composite(
            slingQuickstartOak(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-lucene").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-store-document").version(versionResolver),
            mavenBundle().groupId("org.mongodb").artifactId("mongo-java-driver").version(versionResolver),
            mavenBundle().groupId("com.h2database").artifactId("h2-mvstore").version(versionResolver),
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

    public static Option slingScripting() {
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

    public static Option slingScriptingGroovy() {
        return composite(
            sling(),
            slingScripting(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.groovy").version(versionResolver),
            mavenBundle().groupId("org.codehaus.groovy").artifactId("groovy").version(versionResolver),
            mavenBundle().groupId("org.codehaus.groovy").artifactId("groovy-json").version(versionResolver),
            mavenBundle().groupId("org.codehaus.groovy").artifactId("groovy-templates").version(versionResolver)
        );
    }

    public static Option slingScriptingJava() {
        return composite(
            sling(),
            slingScripting(),
            slingCommonsCompiler(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.java").version(versionResolver)
        );
    }

    public static Option slingScriptingJavascript() {
        return composite(
            slingScripting(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.javascript").version(versionResolver),
            mavenBundle().groupId("javax.jcr").artifactId("jcr").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.rhino").version(versionResolver)
        );
    }

    // DO NOT REMOVE org.apache.sling.scripting.jsp-api and org.apache.sling.scripting.el-api
    public static Option slingScriptingJsp() {
        return composite(
            slingScripting(),
            slingCommonsCompiler(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.jsp").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.jsp.taglib").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.jsp-api").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.el-api").version(versionResolver)
        );
    }

    public static Option slingScriptingSightly() {
        return composite(
            sling(),
            slingJcr(),
            slingScripting(),
            slingScriptingJavascript(),
            slingI18n(),
            slingModels(),
            slingXss(),
            slingCommonsCompiler(),
            slingCommonsFsclassloader(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly.compiler").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly.compiler.java").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly.js.provider").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.sightly.models.provider").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.rhino").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.scripting.sightly.js.provider=sling-scripting"})
                .asOption()
        );
    }

    public static Option slingScriptingThymeleaf() {
        return composite(
            sling(),
            slingScripting(),
            slingI18n(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.scripting.thymeleaf").version(versionResolver),
            mavenBundle().groupId("org.attoparser").artifactId("attoparser").version(versionResolver),
            mavenBundle().groupId("org.unbescape").artifactId("unbescape").version(versionResolver),
            mavenBundle().groupId("org.apache.servicemix.bundles").artifactId("org.apache.servicemix.bundles.ognl").version(versionResolver),
            mavenBundle().groupId("org.javassist").artifactId("javassist").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.scripting.thymeleaf=sling-scripting"})
                .asOption()
        );
    }

    public static Option slingServlets() {
        return composite(
            sling(),
            slingXss(),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.servlets.get").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.servlets.post").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.servlets.resolver").version(versionResolver),
            factoryConfiguration("org.apache.sling.serviceusermapping.impl.ServiceUserMapperImpl.amended")
                .put("user.mapping", new String[]{"org.apache.sling.servlets.resolver:console=sling-readall", "org.apache.sling.servlets.resolver:scripts=sling-scripting"})
                .asOption()
        );
    }

    public static Option jackrabbit() {
        return composite(
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
            mavenBundle().groupId("com.google.guava").artifactId("guava").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.bundles").artifactId("commons-httpclient").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-atinject_1.0_spec").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-el_2.2_spec").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-interceptor_1.1_spec").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-jcdi_1.0_spec").version(versionResolver),
            mavenBundle().groupId("org.apache.geronimo.specs").artifactId("geronimo-jta_1.1_spec").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpcore-osgi").version(versionResolver),
            mavenBundle().groupId("org.apache.httpcomponents").artifactId("httpclient-osgi").version(versionResolver)
        );
    }

    public static Option jackrabbitOak() {
        return composite(
            scr(),
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
            mavenBundle().groupId("io.dropwizard.metrics").artifactId("metrics-core").version(versionResolver),
            mavenBundle().groupId("com.google.guava").artifactId("guava").version(versionResolver),
            mavenBundle().groupId("org.apache.felix").artifactId("org.apache.felix.jaas").version(versionResolver)
        );
    }

    // DO NOT REMOVE additional system packages
    public static Option jackrabbitVault() {
        return composite(
            scr(),
            jackrabbit(),
            mavenBundle().groupId("org.apache.jackrabbit.vault").artifactId("org.apache.jackrabbit.vault").version(versionResolver),
            systemPackages(
                "org.w3c.dom.html"
            )
        );
    }

    public static Option tika() {
        return composite(
            mavenBundle().groupId("org.apache.tika").artifactId("tika-core").version(versionResolver),
            mavenBundle().groupId("org.apache.tika").artifactId("tika-bundle").version(versionResolver)
        );
    }

    public static Option composum() {
        return composite(
            sling(),
            slingJcr(),
            slingScriptingJsp(),
            slingEvent(),
            jackrabbitVault(),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-core-commons").version(versionResolver),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-core-console").version(versionResolver),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-core-jslibs").version(versionResolver),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-user-management").version(versionResolver),
            mavenBundle().groupId("com.composum.sling.core").artifactId("composum-sling-package-manager").version(versionResolver),
            factoryConfiguration("org.apache.sling.jcr.base.internal.LoginAdminWhitelist.fragment")
                .put("whitelist.bundles", new String[]{"com.composum.core.commons", "com.composum.core.pckgmgr"})
                .put("whitelist.name", "composum")
                .asOption()
        );
    }

    public static Option slingQuickstartOakTar(final String workingDirectory, final int httpPort) {
        final String slingHome = String.format("%s/sling", workingDirectory);
        final String repositoryHome = String.format("%s/repository", slingHome);
        final String localIndexDir = String.format("%s/index", repositoryHome);
        return composite(
            slingQuickstartOak(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-segment-tar").version(versionResolver),
            mavenBundle().groupId("org.apache.sling").artifactId("org.apache.sling.jcr.oak.server").version(versionResolver),
            newConfiguration("org.apache.felix.http")
                .put("org.osgi.service.http.port", httpPort)
                .asOption(),
            newConfiguration("org.apache.jackrabbit.oak.segment.SegmentNodeStoreService")
                .put("repository.home", repositoryHome)
                .put("name", "Default NodeStore")
                .asOption()
        );
    }

    public static Option slingQuickstartOakMongo(final String workingDirectory, final int httpPort, final String mongouri) {
        final String slingHome = String.format("%s/sling", workingDirectory);
        final String repositoryHome = String.format("%s/repository", slingHome);
        final String localIndexDir = String.format("%s/index", repositoryHome);
        return composite(
            slingQuickstartOak(),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-store-document").version(versionResolver),
            mavenBundle().groupId("org.apache.jackrabbit").artifactId("oak-lucene").version(versionResolver),
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
