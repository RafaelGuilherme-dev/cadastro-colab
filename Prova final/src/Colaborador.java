import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Colaborador extends Pessoa{
	
	private LocalDateTime dtRegistro = LocalDateTime.now();
	private String dtUsuario;
	private LocalDate dtAdmisao;
	private double salario;
	private Status status;
	double salariox;
	
	public Colaborador(String nome, String cpf, String dataDigitadaPeloUsuario, String dtUsuario, double salario, Status status) {
		super(nome, cpf, dataDigitadaPeloUsuario);
		this.dtUsuario = dtUsuario;
		this.dtAdmisao =  LocalDate.parse(dtUsuario, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.salario = salario;
		this.status = status;
	}
	
	public LocalDateTime getDtRegistro(){return dtRegistro;}
	public void setDtRegistro(LocalDateTime dtRegistro) {this.dtRegistro = dtRegistro;}
	
	
	public double getSalaAl(){return salariox;}
	public void setSalaAl(double salaAl){this.salariox = salaAl;}


	public LocalDate getDtAdmisao(){return dtAdmisao;}
	public void setDtdtAdmisao(LocalDate dtAdmi){this.dtAdmisao = dtAdmi;}
	
	public double getSalario(){return salario;}
	public void setSalario(double salario){this.salario = salario;}

	public Status getStatus(){return status;}
	public void setStatus(Status status){this.status = status;}


	public int tempoServicoMeses(){
		 return ((LocalDate.now().getYear() - dtAdmisao.getYear()) * 12) + (LocalDate.now().getMonthValue());
		}
	
	@Override 
	public String toString() { 
	return "nome: " + this.getNome() + "\r" +  "CPF: " + this.getCpf() + "\r" + "Salario: " + this.salario;

	} 
	
}

