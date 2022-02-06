package br.com.crinnger.ClinicasWebApi.enums;

public enum TipoProfissional {

    DIRETOR_GERAL(1),
    DIRETOR_ENSISO(2),
    EXAMINADOR(3),
    INSTRUTOR(4),
    INSTRUTOR_AUTONOMO(5),
    JUNTA_MEDICA(6),
    JUNTA_PSICOLOGICA(7),
    MEDICO(8),
    PSICOLOGO(9),
    EXAMINADOR_ESPECIAL(10);

    private Integer codigo;

    TipoProfissional(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }
}
