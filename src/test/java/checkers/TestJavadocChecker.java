package checkers;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import models.Issue;
import org.junit.Test;
import utils.JavadocRemover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

public class TestJavadocChecker{
    
    @Test
    public void testNoJavaDocInPublicClass() throws FileNotFoundException {
        
        ClassLoader classLoader = this.getClass().getClassLoader();
        String fileName = classLoader.getResource("checkers/DocumentChecker1.java").getFile();
        CompilationUnit cu = JavaParser.parse(new File(fileName));
        JavadocRemover jdr = new JavadocRemover();
        jdr.visit(cu, null);
    
        LinkedList<Issue> issues = new LinkedList<>();
        JavadocChecker jdc = new JavadocChecker(fileName);
        jdc.visit(cu, issues);
        
        Collections.sort(issues, Comparator.comparing(Issue::getLineNumber));
        assertEquals(issues.size(), 1);
        for (Issue issue: issues) {
            System.out.println(issue);
        }
        
        
    }
}
