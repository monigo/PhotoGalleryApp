package com.photoof;

import java.util.List;

public interface IFirebaseLoadDone {
    void OnFirebaseLoadSuccess(List<UploadImage> imageList);
    void OnFirebaseLoadFailed(String message);
}
