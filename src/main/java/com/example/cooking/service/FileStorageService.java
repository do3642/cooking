package com.example.cooking.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String storeFile(MultipartFile file) {
        // 파일이 비어 있으면 예외 발생
        if (file.isEmpty()) {
            throw new IllegalArgumentException("파일이 비어 있습니다.");
        }

        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename != null && originalFilename.contains(".")
                ? originalFilename.substring(originalFilename.lastIndexOf("."))
                : ".jpg";  // 기본 확장자 .jpg 처리

        String filename = UUID.randomUUID().toString() + extension;

        // 파일이 저장될 경로
        Path targetLocation = Paths.get(uploadDir).resolve(filename);

        try {
            // 디렉토리가 없다면 생성
            if (!Files.exists(targetLocation.getParent())) {
                Files.createDirectories(targetLocation.getParent());
            }

            // 파일 저장
            Files.copy(file.getInputStream(), targetLocation);
            
            
        } catch (IOException e) {
            // 오류를 로그로 남기기
            e.printStackTrace(); // 로그에 오류 출력
            throw new RuntimeException("파일을 저장하는 중 오류가 발생했습니다.", e);
        }

        // 저장된 파일명 반환
        return filename;
    }
}
