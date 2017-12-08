package com.tcc.atendimento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.tcc.atendimento.model.Pendencia;
import com.tcc.atendimento.repository.Pendencias;

@FacesConverter(value ="pendenciaConverter", forClass = Pendencia.class)
public class PendenciaConverter implements Converter{

	@Inject
	private Pendencias pendencias;
	@Override
	public Object getAsObject(FacesContext context,
			UIComponent component, String value) {
		Pendencia retorno = null;
		if (value != null && !"".equals(value)) {
			retorno = this.pendencias.porId(new Long(value));
		}
		return retorno;
	}
	@Override
	public String getAsString(FacesContext context,
			UIComponent component, Object value) {
		if (value != null) {
			Pendencia pendencia = ((Pendencia) value);
			return pendencia.getId() == null ? null
					: pendencia.getId().toString();
		}
		return null;
	}
}
