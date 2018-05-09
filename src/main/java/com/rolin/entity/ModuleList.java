package com.rolin.entity;

import java.util.ArrayList;

public class ModuleList {
    public ArrayList<ModuleDetail> getModuleDetails() {
        return moduleDetails;
    }

    public void setModuleDetails(ArrayList<ModuleDetail> moduleDetails) {
        this.moduleDetails = moduleDetails;
    }

    ArrayList<ModuleDetail> moduleDetails;

}
