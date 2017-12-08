package com.tcc.atendimento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.tcc.atendimento.model.Atendente;
import com.tcc.atendimento.repository.Atendentes;

@FacesConverter(value ="atendenteConverter", forClass = Atendente.class)
public class AtendenteConverter implements Converter{

	@Inject
	private Atendentes atendentes;
	@Override
	public Object getAsObject(FacesContext context,
			UIComponent component, String value) {
		Atendente retorno = null;
		if (value != null && !"".equals(value)) {
			retorno = this.atendentes.porId(new Long(value));
		}
		return retorno;
	}
	@Override
	public String getAsString(FacesContext context,
			UIComponent component, Object value) {
		if (value != null) {
			Atendente atendente = ((Atendente) value);
			return atendente.getId() == null ? null
					: atendente.getId().toString();
		}
		return null;
	}
}
