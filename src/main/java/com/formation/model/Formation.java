package com.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Formation {

    private List<FormationElement> formationElements;

    public List<FormationElement> getFormationElements() {
        return formationElements;
    }

    public Formation(Formation.Builder builder) {
        this.formationElements = builder.formationElements;
    }

    public final static class Builder {
        private List<FormationElement> formationElements = new ArrayList();

        public Formation.Builder setFormationElements(List<FormationElement> formationElements) {
            this.formationElements = formationElements;
            return this;
        }

        public Formation.Builder addFormationElement(FormationElement formationElement) {
            this.formationElements.add(formationElement);
            return this;
        }

        public Formation createFormation() {
            return new Formation(this);
        }
    }

}
