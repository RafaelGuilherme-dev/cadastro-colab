public class Lista {
	private Colaborador[] vetor = new Colaborador[100];
    private int posicaoVaga = 0;
 
    public void adicionar(Colaborador Colaborador) {
    	vetor[posicaoVaga] = Colaborador;
    	posicaoVaga++;
    	Writer.gravacao(gravarcolaborador());
    }
    
    public void alterar(int pos, Colaborador Colaborador) {
        if (pos >= 0 && pos < posicaoVaga) {
            vetor[pos] = Colaborador;
            Writer.gravacao(gravarcolaborador());
        }
    }
 
    public void excluir(int posicao) {
        vetor[posicao] = null;
        for (int x = posicao; x < posicaoVaga - 1; x++) {
            vetor[x] = vetor[x + 1];
        }
        vetor[posicaoVaga - 1] = null;
        posicaoVaga--;
        Writer.gravacao(gravarcolaborador());
    }
 
    public int localizarPosicao(String nome) {
        for (int x = 0; x < posicaoVaga; x++) {
            if (vetor[x].getNome().equals(nome)) {
                return x;
            }
        }

        return -1;
    }
    

    public int tamanho() {
    	return posicaoVaga;
    }

    public Colaborador buscarcolaborador(int posicao){
        return  vetor[posicao];
    }
 
    private String gravarcolaborador(){
    	String colab = "";
    	Colaborador col = null;
    	
    	for (int i = 0; i < tamanho(); i++) {
    		col = vetor[i];
    		
    		colab += "Nome: " + col.getNome() + " CPF: " + col.getCpf() + " Salario Bruto: " + col.getSalario() + "\r";
    	}
    	return colab;
    	
    }
    
    	
}
    



