package Helpers;

import java.io.*;

public class FileHelper<DT> {
    private FileOutputStream fout;
    private ObjectOutputStream oout;
    private FileInputStream fin;
    private ObjectInputStream oin;
    public FileHelper(){

    }
    public void writeObject(DT obj) throws FileNotFoundException, IOException {
        fout = new FileOutputStream("List.txt");
        oout = new ObjectOutputStream(fout);

        oout.writeObject(obj);

        oout.close();
        fout.close();
    }
    public DT readObject() throws FileNotFoundException, IOException, ClassNotFoundException {
        fin = new FileInputStream("List.txt");
        oin = new ObjectInputStream(fin);

        DT obj = (DT)oin.readObject();

        oin.close();
        fin.close();

        return obj;

    }
}
