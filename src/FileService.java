import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    public static String fileReader(String filePath) throws IOException {
        byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(encodedBytes);
    }

    public static void fileSaver(String text, String fileExtension, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        String newFileName = fileName + fileExtension;
        Path newFilePath = path.resolveSibling(newFileName);
        Files.writeString(newFilePath, text);
    }
}
