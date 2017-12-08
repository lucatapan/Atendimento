package com.tcc.atendimento.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.tcc.atendimento.model.Permissao_usuario;
import com.tcc.atendimento.repository.Permissao_usuarios;

@FacesConverter(value ="permissao_usuarioConverter", forClass = Permissao_usuario.class )
public class Permissao_usuarioConverter implements Converter{
	

	@Inject
	private Permissao_usuarios permissao_usuarios;
	@Override
	public Object getAsObject(FacesContext context,
			UIComponent component, String value) {
		Permissao_usuario retorno = null;
		if (value != null && !"".equals(value)) {
			retorno = this.permissao_usuarios.porId(new Long(value));
		}
		return retorno;
	}
	@Override
	public String getAsString(FacesContext context,
			UIComponent component, Object value) {
		if (value != null) {
			Permissao_usuario permissao_usuario = ((Permissao_usuario) value);
			return permissao_usuario.getId() == null ? null
					: permissao_usuario.getId().toString();
		}
		return null;
	}
}
