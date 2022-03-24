import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipHelper {

    private static final String ROOT = "tempo"; // dossier des fichiers temporaires

    /**
     * Méthode permettant de dézipper un fichier .zip.
     *
     * @param file fichier zippé
     * @return fichier dézippé
     * @throws IOException
     */
    public static File unzipFile(File file) throws IOException {
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(file.getCanonicalFile())));
        ZipEntry zipEntry; // représente un fichier parmi la liste des fichiers du zip
        File outputFile = null;

        try {
            while ((zipEntry = zis.getNextEntry()) != null) {
                outputFile = new File(ROOT, zipEntry.getName());
                OutputStream fos = new BufferedOutputStream(new FileOutputStream(outputFile));

                try {
                    try {
                        // On écrit le contenu du nouveau fichier
                        final byte[] buf = new byte[8192]; // taille du buffer
                        int bytesRead;
                        while (-1 != (bytesRead = zis.read(buf)))
                            fos.write(buf, 0, bytesRead);
                    } finally {
                        fos.close();
                    }
                } catch (final IOException ioe) {
                    outputFile.delete(); // en cas d'erreur on efface le fichier
                    throw ioe;
                }
            }
            return outputFile;
        } finally {
            zis.close(); // fermeture de la ZipInputStream
        }
    }

}
