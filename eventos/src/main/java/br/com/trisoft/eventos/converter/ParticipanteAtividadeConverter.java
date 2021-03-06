package br.com.trisoft.eventos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.trisoft.eventos.dao.ParticipanteAtividadeDAO;
import br.com.trisoft.eventos.model.relationship.ParticipanteAtividade;

@FacesConverter(forClass = ParticipanteAtividade.class)
public class ParticipanteAtividadeConverter implements Converter {

	@Inject
	private ParticipanteAtividadeDAO participanteAtividadeDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ParticipanteAtividade retorno = null;

		if (StringUtils.isNotBlank(value)) {
			Long id = new Long(value);
			retorno = participanteAtividadeDAO.buscarPeloCodigo(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((ParticipanteAtividade) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}
