
public class Calculadora {
	private double tempServ;
	private double salarioBruto;
	private static double newPay1;
	private static double newPay2;
	
	public static boolean validarCpf(String cpf) {
		
		cpf = cpf.replace(".", "").replace("-", "");
		
		int dv1 = Integer.parseInt(String.valueOf(cpf.charAt(9)));
		int dv2 = Integer.parseInt(String.valueOf(cpf.charAt(10)));

		int soma = 0;
		int valorPos;
		
		for (int i = 0; i < 9 ; i++) {
			valorPos = Integer.parseInt(String.valueOf(cpf.charAt(i)));
			soma += (valorPos * (10-i));
		}
		int resto = soma % 11;
		int dv1Calc = ((resto < 2) ? 0: (11 - resto));

		soma = 0;
		for (int i = 0; i < 10 ; i++) {
			valorPos = Integer.parseInt(String.valueOf(cpf.charAt(i)));
			soma += (valorPos * (11-i));
		}
		resto = soma % 11;
		int dv2Calc = ((resto < 2) ? 0: (11 - resto));
		return (dv1 == dv1Calc && dv2 == dv2Calc);
		
	}
	
	public double getTempServ() {return tempServ;}
	public void setTempServ(double tempServ) {this.tempServ = tempServ;}
	
	public double getSalarioBruto() {return salarioBruto;}
	public void setSalarioBruto(double salarioBruto) {this.salarioBruto = salarioBruto;}
	
	public static double getNewPay1() {return newPay1;}
	public static void setNewPay1(double newPay1) {Calculadora.newPay1 = newPay1;}
	
	public static double getNewPay2() {return newPay2;}
	public static void setNewPay2(double newPay2) {Calculadora.newPay2 = newPay2;}

	public static double novoSalario(Colaborador f) {
			double newSalario = 0;
			double tempServ = f.tempoServicoMeses();
	
			if (tempServ < 36) {
			double salarioBru = f.getSalario();
			newSalario = salarioBru;
			newSalario += newSalario * 0.01;
			newPay1 = newSalario;
			}else 
				if (tempServ >= 36 && tempServ < 60 ) {
				double salarioBru = f.getSalario();
				newSalario = salarioBru;
				newSalario += newSalario * 0.03;
				newPay1 = newSalario;
				}else 
					if (tempServ >= 60 ) {
					double salarioBru = f.getSalario();
					newSalario = salarioBru;
					newSalario += newSalario * 0.05;
					newPay1 = newSalario;
					}
			return  newPay1;
	}
	
	public static double impostoRenda(Colaborador f) {
		double salarioB = newPay1;
        if (salarioB < 2000) {
        	salarioB -= salarioB * 0.1;
        	newPay2 = salarioB;
        }else 
        	if (salarioB >= 2000 && salarioB < 5000) {
        		salarioB -= salarioB * 0.15;
        		newPay2 = salarioB;
        	}else
		        if (salarioB >= 5000) {
		        	salarioB -= salarioB * 0.2;
		        	newPay2 = salarioB;
		        }
            return newPay2;
	}	
	
	
	
}
