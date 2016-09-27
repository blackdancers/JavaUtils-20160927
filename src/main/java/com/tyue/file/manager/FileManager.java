package com.tyue.file.manager;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 文件操作类<p>
 * 1、删除文件夹下指定名称的文件
 *
 * @author Admin
 */
public class FileManager {

    public static void main(String[] args) throws IOException {

        Path start = Paths.get("E:","git-local-repository","pay","roncoo-pay");
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {


            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println(dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().endsWith(".classpath") || file.getFileName().endsWith(".project")){
                    Files.delete(file);
                }
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                // 访问文件失败时调用
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
                // 访问文件夹之后调用
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
