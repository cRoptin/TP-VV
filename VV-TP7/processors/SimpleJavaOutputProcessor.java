package org.apache.commons.math4.processors;

import java.io.File;

import spoon.reflect.declaration.CtSimpleType;
import spoon.reflect.visitor.PrettyPrinter;
import spoon.support.JavaOutputProcessor;

/**
 * Created by Simon on 02/09/14.
 */
public class SimpleJavaOutputProcessor extends JavaOutputProcessor {


    public SimpleJavaOutputProcessor(File outputDirectory, PrettyPrinter printer) {
        super(outputDirectory, printer);
    }

    /**
     * Creates a source file for each processed top-level type and pretty prints
     * its contents.
     */
    public void process(CtSimpleType<?> type) {
        if (type.isTopLevel())
            createJavaFile(type);
    }
}
