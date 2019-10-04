package org.woehlke.jakartaee.petclinic.oodm.view.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.woehlke.jakartaee.petclinic.oodm.entities.PetType;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.io.Serializable;


@FacesConverter(
    value = "petTypeConverter",
    managed = true
)
public class PetTypeConverter implements Converter<PetType>, Serializable {

    private static final long serialVersionUID = 4908876595996046904L;

    private static Logger log = LogManager.getLogger(PetTypeConverter.class.getName());

    @Override
    public PetType getAsObject(FacesContext context, UIComponent component, String value) {
        return new PetType(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, PetType value) {
        return value.getName();
    }


    @PostConstruct
    public void postConstruct(){
        log.trace("postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        log.trace("preDestroy");
    }

}
