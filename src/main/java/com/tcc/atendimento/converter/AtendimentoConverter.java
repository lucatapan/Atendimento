package com.tcc.atendimento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.tcc.atendimento.model.HisAtendimento;
import com.tcc.atendimento.repository.HisAtendimentos;

@FacesConverter(value ="atendimentoConverter", forClass = HisAtendimento.class)
public class AtendimentoConverter implements Converter{

	@Inject
	private HisAtendimentos hisAtendimentos;
	@Override
	public Object getAsObject(FacesContext context,
			UIComponent component, String value) {
		HisAtendimento retorno = null;
		if (value != null && !"".equals(value)) {
			retorno = this.hisAtendimentos.porId(new Long(value));
		}
		return retorno;
	}
	@Override
	public String getAsString(FacesContext context,
			UIComponent component, Object value) {
		if (value != null) {
			HisAtendimento hisAtendimento = ((HisAtendimento) value);
			return hisAtendimento.getId() == null ? null
					: hisAtendimento.getId().toString();
		}
		return null;
	}
}
