import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    /**
     * Lis chaque ligne d'un fichier et retourne les lignes dans un objet List<String>
     *
     * @return Liste des lignes
     */
    public static List<String> readFileLines(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        br.close();

        return lines;
    }

}
