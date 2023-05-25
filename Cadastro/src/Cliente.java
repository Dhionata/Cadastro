import java.io.PrintWriter;

public class Cliente {

	public Cliente(String nome, String eMail, String senha, int idade) {
		this.nome = nome;
		this.eMail = eMail;
		this.senha = senha;
		this.idade = idade;
	}

	public Cliente() {
	}

	private String nome;
	private String eMail;
	private String senha;
	private int idade;

	public String salvar() {
		if (getNome() != null) {
			try {
				PrintWriter gravarArq = new PrintWriter(getNome() + ".txt");
				gravarArq.println(getNome());
				gravarArq.println(geteMail());
				gravarArq.println(getIdade());
				gravarArq.println(getSenha());
				gravarArq.close();
				return "Deu bom!";
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return "Deu Ruim!";
			}
		} else {
			return "Deu Ruim!";
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
