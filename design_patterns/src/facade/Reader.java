package facade;

public class Reader {
    private String filename;

    public Reader(String filename){
        this.filename = filename;
    }

    public  void fileConnect(){
        String msg = String.format("READER %s 로 연결합니다.", filename );
        System.out.println(msg);
    }

    public void fileRead(){
        String msg = String.format("Reader %s 의 내용을 읽어 옵니다.", filename);
    }

    public void fileDisconnect(){
        String msg = String.format("Reader %s 로 연결 종료 합니다.", filename);
        System.out.println(msg);
    }
}
