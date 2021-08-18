package facade;

public class Writer {
    private String filename;

    public Writer(String filename) {
        this.filename = filename;
    }

    public void fileConnect() {
        String msg = String.format("Writer %s 로 연결합니다.", filename);
        System.out.println(msg);
    }

    public void write() {
        String msg = String.format("Writer %s 의 파일쓰기를합니다..", filename);
    }

    public void fileDisconnect() {
        String msg = String.format("Writer %s 로 연결 종료 합니다.", filename);
        System.out.println(msg);
    }
}
