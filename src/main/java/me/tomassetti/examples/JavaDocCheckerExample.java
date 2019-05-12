package me.tomassetti.examples;

import checkers.JavaDocChecker;
import com.github.javaparser.JavaParser;
import com.google.common.base.Strings;
import me.tomassetti.support.DirExplorer;
import models.Issue;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class JavaDocCheckerExample {

    public static void checkDocuments(File projectDir, List<Issue> issues) {
        
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);

            try {
                JavaDocChecker dChecker = new JavaDocChecker(path);
                dChecker.visit(JavaParser.parse(file), issues);
            } catch (IOException e) {
                new RuntimeException(e);
            }
            System.out.println(Strings.repeat("=", path.length()));
        }).explore(projectDir);
    }

    public static void main(String[] args) {
        File projectDir = new File("source_to_parse/checkers");
        List<Issue> issues = new LinkedList<>();
        checkDocuments(projectDir, issues);
        System.out.println(issues);
    }
}

