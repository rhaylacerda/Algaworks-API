package br.com.rhayana.springrestalgaworks.domain.service;

import br.com.rhayana.springrestalgaworks.domain.exception.NegocioException;
import br.com.rhayana.springrestalgaworks.domain.model.Cliente;
import br.com.rhayana.springrestalgaworks.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        if (clienteExistente != null && !clienteExistente.equals(cliente)) {
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
        }
        return clienteRepository.save(cliente);
    }

    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}