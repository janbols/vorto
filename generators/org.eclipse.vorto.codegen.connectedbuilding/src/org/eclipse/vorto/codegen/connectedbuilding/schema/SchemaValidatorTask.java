/*******************************************************************************
 * Copyright (c) 2017 Bosch Software Innovations GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *   
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *   
 * Contributors:
 * Bosch Software Innovations GmbH - Please refer to git log
 *******************************************************************************/
package org.eclipse.vorto.codegen.connectedbuilding.schema;

import org.eclipse.vorto.codegen.api.GeneratorTaskFromFileTemplate;
import org.eclipse.vorto.codegen.api.ICodeGeneratorTask;
import org.eclipse.vorto.codegen.api.IGeneratedWriter;
import org.eclipse.vorto.codegen.api.InvocationContext;
import org.eclipse.vorto.codegen.connectedbuilding.schema.tasks.template.InfomodelValidationTemplate;
import org.eclipse.vorto.core.api.model.informationmodel.InformationModel;

public final class SchemaValidatorTask implements ICodeGeneratorTask<InformationModel> {
	
	@Override
	public void generate(InformationModel infomodel, InvocationContext invocationContext, IGeneratedWriter writer) {
		
		generateForInfomodel(
				infomodel, invocationContext,
				writer);
	}
	
	private void generateForInfomodel(InformationModel infomodel, InvocationContext context, IGeneratedWriter writer){
		new GeneratorTaskFromFileTemplate<>(new InfomodelValidationTemplate()).generate(infomodel, context, writer);
	}

}
