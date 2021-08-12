package facade;

public class SftpClient {
    private FTP ftp;
    private Reader reader;
    private Writer writer;

    public SftpClient(FTP ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    public SftpClient(String host, int port, String path, String filename) {
        this.ftp = new FTP(host, port, filename);
        this.reader = new Reader(filename);
        this.writer = new Writer(filename);
    }

    public void connect() {
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disconnect() {
        writer.fileDisconnect();
        reader.fileDisconnect();
        ftp.disconnect();
    }

    public void read() {
        reader.fileRead();
    }

    public void write() {
        writer.write();
    }

}
