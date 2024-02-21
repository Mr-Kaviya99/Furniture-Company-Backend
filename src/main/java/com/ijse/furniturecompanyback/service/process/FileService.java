package com.ijse.furniturecompanyback.service.process;



import com.ijse.furniturecompanyback.dto.responsedto.core.CommonFileSavedBinaryDataDTO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public CommonFileSavedBinaryDataDTO createResource(MultipartFile file, String directory, String bucket, String prefix, int keyLength);
    public void deleteResource(String bucket,String directory, String fileName);
    public byte[] downloadFile(String bucket, String fileName);
}
