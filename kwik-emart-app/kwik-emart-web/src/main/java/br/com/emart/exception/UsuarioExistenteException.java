package br.com.emart.exception;

public class UsuarioExistenteException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioExistenteException()
	{
		super();
	}

	public UsuarioExistenteException(String message)
	{
		super(message);
	}

	public UsuarioExistenteException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public UsuarioExistenteException(Throwable cause)
	{
		super(cause);
	}

}
