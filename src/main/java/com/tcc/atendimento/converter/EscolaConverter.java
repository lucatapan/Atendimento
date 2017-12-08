package com.tcc.atendimento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.tcc.atendimento.model.Escola;
import com.tcc.atendimento.repository.Escolas;

@FacesConverter(value ="escolaConverter", forClass = Escola.class)
public class EscolaConverter implements Converter{

	@Inject
	private Escolas escolas;
	@Override
	public Object getAsObject(FacesContext context,
			UIComponent component, String value) {
		Escola retorno = null;
		if (value != null && !"".equals(value)) {
			retorno = this.escolas.porId(new Long(value));
		}
		return retorno;
	}
	@Override
	public String getAsString(FacesContext context,
			UIComponent component, Object value) {
		if (value != null) {
			Escola escola = ((Escola) value);
			return escola.getId() == null ? null
					: escola.getId().toString();
		}
		return null;
	}
}

