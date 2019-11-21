package com.example.workflowcli.common.core.dto;

import lombok.Data;
import org.flowable.engine.repository.ProcessDefinition;

/**
 * @author: AAS
 * @create: 周四 11月 2019
 * @description: 流程定义 DTO
 */
@Data
public class ProDefiDto {
    private String id;
    private String category;
    private String name;
    private String key;
    private String description;
    private int version;
    private String resourceName;
    private String deploymentId;
    private String diagramResourceName;
    private boolean hasStartFormKey;
    private boolean hasGraphicalNotation;
    private boolean isSuspended;
    private String tenantId;

    public ProDefiDto() {
    }

    public ProDefiDto(ProcessDefinition p) {
        this();
        getDto(p);
    }


    public void getDto(ProcessDefinition p) {
        this.id = p.getId();
        this.category = p.getCategory();
        this.name = p.getName();
        this.key = p.getKey();
        this.description = p.getDescription();
        this.version = p.getVersion();
        this.resourceName = p.getResourceName();
        this.deploymentId = p.getDeploymentId();
        this.diagramResourceName = p.getDiagramResourceName();
        this.hasStartFormKey = p.hasStartFormKey();
        this.hasGraphicalNotation = p.hasGraphicalNotation();
        this.isSuspended = p.isSuspended();
        this.tenantId = p.getTenantId();
    }
}
