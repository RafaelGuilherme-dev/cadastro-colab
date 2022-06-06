import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Writer {
	public static void gravacao(String funcionario){
        Path p = Paths.get("C:\\Users\\T-GAMER\\Documents\\xaxa.txt");

        try {
            Files.write(p, funcionario.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    public static List<String> lerArquivo(String nomeArquivo){
        Path p = Paths.get("C:\\Users\\T-GAMER\\Documents\\xaxa.txt"); 

        try {
            return Files.readAllLines(p, StandardCharsets.UTF_8); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
}
