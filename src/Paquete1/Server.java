/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete1;


import java.nio.channels.Selector;
import java.nio.ByteBuffer;
import java.net.ServerSocket;
import java.util.Set;
import java.io.*;

public class Server implements Runnable{
    private int port;
    private boolean running = false;
    private Selector selector;
    private ServerSocket serverSocket;
    private ByteBuffer buffer;
    
    
    public Server(int port, int bufferSize) {
        this.port = port;
        this.buffer = ByteBuffer.allocate(bufferSize);
    }
    
    public void start() {
        new Thread(this).start();
    }
    @Override 
    public void run() {
        running = true;
        
        while(running) {
            try {
                int client = selector.select();
                
                if (client == 0) {
                    continue;
                }
                //Set<SelectionKey> keys = selector.selectedKeys();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
