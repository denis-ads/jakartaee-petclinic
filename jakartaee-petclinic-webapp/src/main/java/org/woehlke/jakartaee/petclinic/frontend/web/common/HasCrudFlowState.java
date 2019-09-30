package org.woehlke.jakartaee.petclinic.frontend.web.common;

import java.io.Serializable;

public interface HasCrudFlowState extends Serializable {

    long serialVersionUID = -2732706731385890693L;

    boolean isFlowStateList();
    boolean isFlowStateNew();
    boolean isFlowStateEdit();
    boolean isFlowStatDelete();
    boolean isFlowStateSearchResult();

    void setFlowStateList();
    void setFlowStateNew();
    void setFlowStateEdit();
    void setFlowStatDelete();
    void setFlowStateSearchResult();
}