package ee.jakarta.tck.faces.test.javaee8.ajax;

import ee.jakarta.tck.faces.test.util.selenium.BaseITNG;
import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

import static java.lang.System.setProperty;

/**
 * Given Arquilian has no single deployment testsuite
 * mechanism we have to rely on a third party library.
 * This improves the performance in a major area, namely
 * we are only deploying once and then run all tests
 * on the same deployment (cuts down by 95% the test time)
 */
@ArquillianSuiteDeployment
public class Deployments {
    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return BaseITNG.getWebArchive();
    }
}

