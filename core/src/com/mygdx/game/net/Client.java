package com.mygdx.game.net;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.player.Player;
import static com.mygdx.game.Screens.Menu.main_login;
import static com.mygdx.game.Screens.Menu.successful_login;


public class Client implements Disposable {

    public Socket socket;
    private ClientThread thread;
    private String ip;
    private int port;
    private static String msg;
    private Player player;


    public Client(String msg){
        ip = "192.168.1.72";
        port = 8091;
        this.msg = msg;
        thread = new ClientThread();
        thread.start();
    }

    public class ClientThread extends Thread{
        @Override
        public void run() {
            SocketHints hints = new SocketHints();
            hints.connectTimeout = 5000;
            socket = Gdx.net.newClientSocket(Net.Protocol.TCP, ip, port, hints);
            if (socket != null) {
                try {
                    byte[] read = new byte[32768];
                    socket.getOutputStream().write(msg.getBytes()); // send msg
                    String[] part_pf_msg = msg.split("@");
                    if (part_pf_msg[0].equals("login")){boolean t = true;while(t){try{socket.getInputStream().read(read);t = false;}catch (Exception e){}}
                        String json_player = new String(read).trim();
                        Json js = new Json();
                        if (!json_player.equals("UnknownUser")){
                            player = js.fromJson(Player.class,json_player);
                            System.out.println("Good!");
                            socket.dispose();
                            main_login = part_pf_msg[1];
                            successful_login = true;
                        }else{
                            System.out.println("UnknownUser");
                            socket.dispose();
                        }
                    }
                    if (part_pf_msg[0].equals("reg")){boolean t = true;while(t){try{socket.getInputStream().read(read);t = false;}catch (Exception e){}}
                        String inf_about_reg = new String(read).trim();
                        if (inf_about_reg.equals("This user registered")){
                            System.out.println("This user registered");
                            socket.dispose();
                            main_login = part_pf_msg[1];
                            successful_login = true;
                        }else{
                            System.out.println("This user already registered");
                            socket.dispose();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void dispose() {

    }
}
