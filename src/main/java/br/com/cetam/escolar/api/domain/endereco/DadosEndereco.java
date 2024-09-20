package br.com.cetam.escolar.api.domain.endereco;

public record DadosEndereco(
        String logradouro,
        String bairro,
        String cep,
        String numero,
        String complemento,
        String cidade,
        String uf
) {
}
