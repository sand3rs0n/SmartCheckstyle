package edu.uw.csep.scs;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import checkers.DeclarationChecker;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import models.Issue;
import org.apache.commons.cli.*;


public class Main {

    public static void main(String[] args) throws ParseException {
        
        Options options = new Options();

        Option help = new Option("h", false, "options");
        options.addOption(help);

        Option input = new Option("i",true,"input file path");
        options.addOption(input);

        Option modify = new Option("m",false,"modify files");
        options.addOption(modify);

        Option checkJavadoc = new Option("j",false,"check javadoc style");
        options.addOption(checkJavadoc);

        Option checkDeclarations = new Option("d",false,"check declarations style");
        options.addOption(checkDeclarations);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("h")) {
            showOptions(options, "");
            return;
        }

        if (!cmd.hasOption("i")) {
            showOptions(options, "Missing input(-i) parameter");
            return;
        }
        
        String filePath = cmd.getOptionValue("i");
        File file = new File(filePath);
        CompilationUnit compilationUnit;
        try {
            compilationUnit = JavaParser.parse(file);
        } catch (Exception e) {
            return;
        }

        List<Issue> issues = new ArrayList();

        if (cmd.hasOption("j")) {
            System.out.println("TODO: Check javadoc...");
        }

        if (cmd.hasOption("d")) {
            DeclarationChecker declarationChecker = new DeclarationChecker(file.getName());
            declarationChecker.visit(compilationUnit, issues);
        }

        Collections.sort(issues, Comparator.comparing(Issue::getPackageName)
                .thenComparing(Issue::getFileName)
                .thenComparing(Issue::getLineNumber));

        for (Issue issue : issues) {
            System.out.println(issue);
        }
    }

    private static void showOptions(Options options, String message) {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(message);
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp(printWriter, 80, "ls", "",
                options, 4, 4,"", true);
        printWriter.flush();
    }
}
