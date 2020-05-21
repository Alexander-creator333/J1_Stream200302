package com.geekbrains.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private String nickname;
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public String getNickname() {
        return nickname;
    }

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        // /auth login1 pass1
                        if (msg.startsWith("/auth ")) {
                            String[] tokens = msg.split("\\s");
                            String nick = server.getAuthService().getNicknameByLoginAndPassword(tokens[1], tokens[2]);
                                sendMsg("/authok " + nick);
                                nickname = nick;
                                server.subscribe(this);
                                erver.broadcastMsg(nickname + " присоединился к чату");
                                break;
                            }
                        }
                    }
                    while (true) {
                        String msg = in.readUTF();
                        if(msg.startsWith("/")) {
                            if (msg.equals("/end")) {
                                sendMsg("/end");
                                break;
                            }
                            if(msg.startsWith("/w ")) {
                                String[] tokens = msg.split("\\s", 3);
                                server.privateMsg(this, tokens[1], tokens[2]);
                            }
                            if (msg.startsWith("/change ")){
                                String[] tokens = msg.split("\\s");
                                int chek = server.getAuthService().
                                        changeNickname(nickname, tokens[1]);
                                if (chek == 1){
//                                    sendMsg("/authok " + tokens[2]);
                                    nickname = tokens[1];
                                    server.changeNick(this);
                                }
                            }
                        } else {
                            server.broadcastMsg(nickname + ": " + msg);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    ClientHandler.this.disconnect();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeNick(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        clients.add(clientHandler);
        broadcastClientsList();
    }


    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
