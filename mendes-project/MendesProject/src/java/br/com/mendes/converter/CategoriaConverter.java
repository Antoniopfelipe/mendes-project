package br.com.mendes.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.mendes.model.Categoria;

import br.com.mendes.service.CategoriaService;

@FacesConverter(value="categoriaConverter")
public class CategoriaConverter implements Converter {



	private CategoriaService categoriaService;
	
	public CategoriaConverter() {}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		try {
			if (arg2 != null && arg2 != "" ) {
				Long codCategoria = Long.parseLong(arg2);				
				return categoriaService.obterCategoriaPorCod(codCategoria);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null && arg2 instanceof Categoria && ((Categoria) arg2).getCodCategoria() != null) {
			Categoria categoria= (Categoria) arg2;
			return String.valueOf(categoria.getCodCategoria());
		}
		return null;
	}

}
