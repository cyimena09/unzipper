import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1. On dézippe le fichier
        File file = new File("monfichier.zip");
        File dezipped = ZipHelper.unzipFile(file);

        // 2. On lit le fichier
        List<String> ids = FileHelper.readFileLines(dezipped);

        for (String id : ids) {
            System.out.println(id);
        }

        dezipped.delete();
    }

}
