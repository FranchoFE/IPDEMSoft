/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aisdataproxy;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ffelez
 */
public class AisDataProxy
{

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException
  {
    AisDataProxy aisDataProxy = new AisDataProxy();
    aisDataProxy.createServer(1222);
    aisDataProxy.createReceiver ("80.32.124.61", 950);
  }

  private LinkedList<Socket> mSocketsToSendData = new LinkedList<Socket>();
  
  private void createServer(int port) throws IOException
  {
    final ServerSocket serverSocket = new java.net.ServerSocket(port);

    Runnable runnable = new Runnable() 
    {
        @Override
        public void run() 
        {
          try 
          {
            while (true)
            {
              Socket socket = serverSocket.accept();         
              mSocketsToSendData.add(socket);
            }
          } 
          catch (IOException ex) 
          {
            System.err.println (ex.toString());
          }
        }
    };

    new Thread(runnable).start();
  }

  private void createReceiver(String ip, int port) throws IOException
  {
    Socket clientSocket = new Socket();
    InetSocketAddress address = new InetSocketAddress(ip, port);
    clientSocket.connect(address);
    InputStream inputStream = clientSocket.getInputStream();
    InputStreamReader is = new InputStreamReader(inputStream);
    
    BufferedReader bf = new BufferedReader(is);
    String readedLine = bf.readLine();
    
    while (readedLine != null)
    {
      for (Socket socket : mSocketsToSendData)
      {
        PrintWriter writer = new PrintWriter (socket.getOutputStream(), true);
        writer.println (readedLine);
      }
      
      readedLine = bf.readLine();
    }
  }

}
