import java.util.List;

public class File{
    private String fileName;
    private Long size;

    public File(List<String> splitLine) {
        this.size = Long.valueOf(splitLine.get(0));
        this.fileName = splitLine.get(1);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}