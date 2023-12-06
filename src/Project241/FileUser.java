package Project241;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.Writer;

public class FileUser {
    private int total = 100,score=0;

    //private int lastscore =0;
    private String name;
    public FileUser(String name,int score) {
        this.name = name;
        this.score = score;

    }
    private static List<User> userScores = new ArrayList<>();

    public static List<User> getUserScores() {
        return userScores;
    }

    public static void addUserScore(String name, int score) {
        User newUser = new User(name, score);
        userScores.add(newUser);
    }

    public static void updateUserScore(String name, int score) {
        for (User user : userScores) {
            if (user.getName().equals(name)) {
                user.setScore(score);
                break;
            }
        }
    }
    public void FileForWriter() {
        try {
            List<User> existingUsers = FileForReader();
            boolean nameExists = false;
            int minScore = Integer.MAX_VALUE;

            // ตรวจสอบว่ามีชื่อที่ซ้ำและมีคะแนนน้อยกว่ารอบแรกที่มีอยู่หรือไม่
            for (User existingUser : existingUsers) {
                if (existingUser.getName().equals(name)) {
                    nameExists = true;
                    // ตรวจสอบคะแนนน้อยที่สุด
                    minScore = Math.min(minScore, existingUser.getScore());
                }
            }

            // ถ้ามีชื่อซ้ำ
            if (nameExists) {
                // ตรวจสอบว่าคะแนนใหม่น้อยกว่ารอบที่แล้วหรือไม่
                if (score < minScore) {
                    // ลบข้อมูลเดิมที่มีชื่อซ้ำ
                    existingUsers.removeIf(user -> user.getName().equals(name));
                    // เพิ่มข้อมูลใหม่
                    existingUsers.add(new User(name, score));
                }
            } else {
                // ถ้าไม่มีชื่อซ้ำ ให้เพิ่มข้อมูลใหม่
                existingUsers.add(new User(name, score));
            }

            // เขียนข้อมูลลงในไฟล์
            FileWriter writer = new FileWriter(new File("./src/filename/user.txt"));
            BufferedWriter buffer = new BufferedWriter(writer);

            for (User user : existingUsers) {
                buffer.write(user.getName() + " " + user.getScore() + "\n");
            }

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   

    public List<User> FileForReader() {
    	List<User> userScores = new ArrayList<>();

        try {
            FileReader reader = new FileReader(new File("./src/filename/user.txt"));
            BufferedReader buffer = new BufferedReader(reader);

            String line;
            while ((line = buffer.readLine()) != null) {
                String[] userData = line.split(" ");
                String name = userData[0];
                int score = Integer.parseInt(userData[1]); // แปลง String เป็น int
                User user = new User(name, score);
                userScores.add(user);
            }

            buffer.close();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(userScores);
        return userScores;
    }
    
    public List<User> getLatestPlayer() {
    	List<User> latestPlayers = new ArrayList<>();

        try {
            FileReader reader = new FileReader(new File("./src/filename/user.txt"));
            BufferedReader buffer = new BufferedReader(reader);

            String line;
            while ((line = buffer.readLine()) != null) {
                String[] userData = line.split(" ");
                String name = userData[0];
                int score = Integer.parseInt(userData[1]);
                User user = new User(name, score);
                latestPlayers.add(user);
            }

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        return latestPlayers;
    }
    
    public void deleteLatestPlayer() {
        try {
            List<User> existingUsers = FileForReader();

            // ตรวจสอบว่ามีผู้เล่นอยู่ในระบบหรือไม่
            if (!existingUsers.isEmpty()) {
                // ลบผู้เล่นล่าสุด
                existingUsers.remove(existingUsers.size() - 1);

                // เขียนข้อมูลใหม่ลงในไฟล์
                FileWriter writer = new FileWriter(new File("./src/filename/user.txt"));
                BufferedWriter buffer = new BufferedWriter(writer);

                for (User user : existingUsers) {
                    buffer.write(user.getName() + " " + user.getScore() + "\n");
                }

                buffer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}