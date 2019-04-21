import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDiv {

    public static void main(String[] args) 	{        
        try {
            ServerSocket server = new ServerSocket(1237);
            String str;
            while (true) {
                Socket switchserver = server.accept();
                InputStream iSwitchServer = switchserver.getInputStream();
                OutputStream oSwitchServer = switchserver.getOutputStream();
                do {
                    byte[] line = new byte[100];
                    iSwitchServer.read(line);
                    str = new String(line);
                    
                    String[] mensagem = new String[100];
                    Double resultado = 0.0;
                    
                    mensagem = str.split("\\/");
                    resultado = dividir(mensagem[0], mensagem[1]);
                                  
                    oSwitchServer.write(resultado.toString().getBytes());
                    str = new String(line);
                } while ( !str.trim().equals("bye") );
                switchserver.close();
            }
        }
        catch (Exception err){
            System.err.println(err);
        }
    }

    private static Double dividir(String string, String string0) {
        Double op1;
        Double op2;
        
        op1 = Double.parseDouble(string);
        op2 = Double.parseDouble(string0);
        
        return op1 / op2;
    }
}
