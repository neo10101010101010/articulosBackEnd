package com.app.articulos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.articulos.models.Articulos;
import com.app.articulos.respositories.ArticulosRepository;
import org.webjars.NotFoundException;

@Service
public class ArticulosService {
	
	@Autowired
	private ArticulosRepository articulosRepository;
	
	
	public Articulos create (Articulos articulos)
	{
		return articulosRepository.save(articulos);
		
	}
	
	
	public List <Articulos> getAllArticulos()
	{
		return articulosRepository.findAll();
		
	}
	
	
	/*public void delete(Articulos articulos)
	{
		articulosRepository.delete(articulos);
	}
	*/

	public void eliminarPorId(Long id) {
		// Aquí podrías agregar lógica adicional si es necesario antes de eliminar
		articulosRepository.deleteById(id);
	}
	
	public Optional <Articulos> findById(Long id)
	{
		return articulosRepository.findById(id);
		
	}


	public Articulos editarArticulo(Long id, Articulos articulos) {
		Articulos articuloExistente = articulosRepository.findById(id).orElse(null);

		if (articuloExistente != null) {
			articuloExistente.setNombre(articulos.getNombre());
			articuloExistente.setClave(articulos.getClave());
			articuloExistente.setMedida(articulos.getMedida());
			articuloExistente.setPrecio(articulos.getPrecio());
			return articulosRepository.save(articuloExistente);
		} else {
			throw new NotFoundException("Artículo no encontrado con el ID proporcionado");
		}
	}
}
