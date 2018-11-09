package com.sit.cloudnative.MaterialService;

import io.minio.MinioClient;
import io.minio.errors.*;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class MinioStorageService {

    MinioClient minioClient;

    @Value("${storage.minio.url}")
    private String url;
    @Value("${storage.minio.bucket-name}")
    private String bucketName;
    @Value("${storage.minio.access-key}")
    private String accessKey;
    @Value("${storage.minio.secret-key}")
    private String secretKey;


}
