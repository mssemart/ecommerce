package br.com.emart.constants;

public enum EnumTipoUsuario {
	NORMAL(1,"USUARIO NORMAL"),
	ADM(2,"ADMINISTRADOR");
	
	private final Integer codigoTipoUsuario;
    private final String descricao;

    private EnumTipoUsuario(Integer codigoTipoUsuario, String descricao) {
    	this.codigoTipoUsuario = codigoTipoUsuario;
    	this.descricao = descricao;
    }

	public Integer getCodigoTipoUsuario() {
		return codigoTipoUsuario;
	}

	public String getDescricao() {
		return descricao;
	}
    
	public static EnumTipoUsuario getPorCodigo(Integer codigo) {
        for (EnumTipoUsuario tipo : EnumTipoUsuario.values()) {
            if (tipo.getCodigoTipoUsuario().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
