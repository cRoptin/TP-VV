package org.apache.commons.math4.processors;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.cu.CompilationUnit;
import spoon.reflect.cu.SourceCodeFragment;
import spoon.reflect.cu.SourcePosition;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtMethod;

public class TestProcessors extends AbstractProcessor<CtMethod> {
	
	/**
	 * Count number of test 
	 */
	private static int sCountTest = 0;
	
	@Override
	public void process(CtMethod element) {
		Object argument = null;
        if (element.getParent().getAnnotations() != null && element.getParent().getAnnotations().size() > 0) {
        	for (CtAnnotation anno : element.getParent().getAnnotations()) {
        		if (anno.getSignature().contains("Test")) {
        			sCountTest++;
        		}
        	}
        	argument = element.getAnnotations();
        }
	}
	
	@Override
	public void processingDone() {
		System.out.println("Nombre de test : " + sCountTest);
	}
}
