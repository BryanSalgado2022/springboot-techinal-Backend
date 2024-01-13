package com.technical.webapp.springboottechinal.service;

import com.technical.webapp.springboottechinal.models.Entity.Usuario;
import com.technical.webapp.springboottechinal.models.dto.UsuarioDto;

public interface IUsuario {
    Usuario saveUsuario(UsuarioDto usuario);

    Usuario findById(Integer id);

    void deleteUsuario(Usuario usuario);
}
