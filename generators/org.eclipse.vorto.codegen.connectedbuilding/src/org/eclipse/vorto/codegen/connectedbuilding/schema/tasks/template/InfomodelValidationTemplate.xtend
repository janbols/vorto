package org.eclipse.vorto.codegen.connectedbuilding.schema.tasks.template;

import org.eclipse.vorto.codegen.api.IFileTemplate
import org.eclipse.vorto.codegen.api.InvocationContext
import org.eclipse.vorto.core.api.model.informationmodel.InformationModel

class InfomodelValidationTemplate implements IFileTemplate<InformationModel> {
	
	override getContent(InformationModel element, InvocationContext context) {
		'''
		{
			"$schema": "http://json-schema.org/draft-04/schema#",
			"title": "Properties validation of definition <ConnectedBuildingDevice>",
			"type": "object",
			"properties": {
			"schemaVersion": {
				"type" : "string"
			},
			"systemId": {
				"type" : "string"
			},
			"sentTime": {
				"type" : "string"
			},
			"snapshotTime": {
				"type" : "string"
			},
			"devices": {
				"type" : "array",
				"items" :
					{
						"type" : "object",
						"properties": {
							"id" : {
								"type" : "string"
							},
							"features" : {
								"type": "object",
								"properties" : {
								«FOR prop : element.properties SEPARATOR ","»
									"«prop.name»" : {
									"type" : "object",
									"properties" : {
									«EntityValidationTemplate.handleProperties(prop.type.functionblock.status.properties, context).toString.trim»
									},
									«EntityValidationTemplate.calculateRequired(prop.type.functionblock.status.properties)»
									}
								«ENDFOR»
								}
							}
						}
					}
				}
			},
			"required": ["schemaVersion","systemId","sentTime","snapshotTime","devices"]
		}
		'''
	}
	
	override getFileName(InformationModel context) {
		'''schema.json'''
	}
	
	override getPath(InformationModel context) {
		return null
	}
	
}