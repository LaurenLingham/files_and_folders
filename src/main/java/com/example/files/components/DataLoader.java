package com.example.files.components;

import com.example.files.models.File;
import com.example.files.models.Folder;
import com.example.files.models.User;
import com.example.files.repositories.FileRepository;
import com.example.files.repositories.FolderRepository;
import com.example.files.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {
        User user1 = new User("Bob");
        userRepository.save(user1);

        User user2 = new User("Rita");
        userRepository.save(user2);

        Folder folder1 = new Folder("pics");
        folderRepository.save(folder1);

        Folder folder2 = new Folder("docs");
        folderRepository.save(folder2);

        Folder folder3 = new Folder("vids");
        folderRepository.save(folder3);

        Folder folder4 = new Folder("audio");
        folderRepository.save(folder4);

        File file1 = new File("blah", "txt", "16kb");
        fileRepository.save(file1);

        File file2 = new File("lalala", "js", "1mb");
        fileRepository.save(file2);

        File file3 = new File("falala", "py", "1tb");
        fileRepository.save(file3);

        File file4 = new File("tralala", "jpg", "2kb");
        fileRepository.save(file4);

        folder1.addFile(file1);
        folder1.addFile(file2);
        folder2.addFile(file3);
        folder3.addFile(file4);
        user1.addFolder(folder1);
        user1.addFolder(folder4);
        user2.addFolder(folder2);
        user2.addFolder(folder3);
    }
}