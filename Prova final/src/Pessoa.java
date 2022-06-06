import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class  Pessoa {
	private String nome;
	private String cpf;
	private String dataRecebida;
	private LocalDate dtNasci;
	
	public Pessoa(String nome, String cpf, String dataDigitadaPeloUsuario) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataRecebida = dataDigitadaPeloUsuario;
		this.dtNasci = LocalDate.parse(dataDigitadaPeloUsuario, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public String getNome(){return nome;}
	public void setNome(String nome){this.nome = nome;}

	public String getCpf(){return cpf;}
	public void setCpf(String cpf){this.cpf = cpf;}

	public LocalDate getDtNasci(){return dtNasci;}
	public void setDtNasci(LocalDate dtNasci) {this.dtNasci = dtNasci;}

}
	


	
	

