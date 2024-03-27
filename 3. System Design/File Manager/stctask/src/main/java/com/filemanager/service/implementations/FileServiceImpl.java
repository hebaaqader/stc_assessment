package com.filemanager.service.implementations;

import org.springframework.stereotype.Service;

import com.filemanager.service.interfaces.FileService;

@Service
public class FileServiceImpl implements FileService {

    //  @Autowired
    // private FilesRepository filesRepository;

    // @Autowired
    // private PermissionsRepository permissionsRepository;

    // @Override
    // public File uploadFile(String spaceName, String folderName, String fileName, InputStream fileData, String userEmail, PermissionLevel permissionLevel) {
    //     // Retrieve folder
    //     Folder folder = folderRepository.findByNameAndSpace(folderName, spaceName);
    //     if (folder == null) {
    //         throw new FolderNotFoundException("Folder with name " + folderName + " not found in space " + spaceName);
    //     }

    //     // Check if user has permission to upload file
    //     Permission permission = permissionsRepository.findByUserEmailAndPermissionGroup(folder.getId(), userEmail);
    //     if (permission == null || permission.getPermissionLevel() != PermissionLevel.EDIT) {
    //         throw new UnauthorizedAccessException("User does not have permission to upload file");
    //     }

    //     // Upload file
    //     File file = new File();
    //     file.setFileName(fileName);
    //     file.setFolder(folder);
    //     file.setFileData(fileData);
    //     filesRepository.save(file);

    //     return file;
    // }

    // @Override
    // public InputStream downloadFile(String spaceName, String folderName, String fileName, String userEmail, PermissionLevel permissionLevel) {
    //     // Retrieve file
    //     File file = filesRepository.findByFileNameAndFolder(fileName, folderName, spaceName);
    //     if (file == null) {
    //         throw new FileNotFoundException("File with name " + fileName + " not found in folder " + folderName + " in space " + spaceName);
    //     }

    //     // Check if user has permission to download file
    //     Permission permission = permissionsRepository.findByUserEmailAndPermissionGroup(file.getFolder().getId(), userEmail);
    //     if (permission == null || permission.getPermissionLevel() != PermissionLevel.VIEW) {
    //         throw new UnauthorizedAccessException("User does not have permission to download file");
    //     }

    //     return new ByteArrayInputStream(file.getFileData());
    // }

}
