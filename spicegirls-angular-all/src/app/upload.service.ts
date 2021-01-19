import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})

export class UploadService {

  FOLDER = 'spice-sm'

  constructor(private http:HttpClient) { }

  pushFileToStorage(file: File): Observable<any> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    const req = new HttpRequest('POST', 'http://localhost:8088/file/upload', formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }

  getFileFromStorage(key: string): Observable<any>{
    return this.http.get('http://localhost:8088/file/download');
  }

  getFiles(key: string): Observable<any>{
    return this.http.get('http://localhost:8088/file/all');
  }






  // fileUpload(file){
  //   const contentType = file.type;
  //   const bucket = new S3(
  //     {
  //       accessKeyId: 'AKIAINRIWX5JUQJZOMVQ',
  //       secretAccessKey: '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',
  //       region: 'us-east-2',
  //     }
  //   );

  //   const params = {
  //     Bucket: 'spice-sm',
  //     Key: this.FOLDER + file.name,
  //     Body: file,
  //     ContentType: contentType
  //   };

  //   bucket.upload(params, function(err, data){
  //     if(err){
  //       console.log("ERROR: " + JSON.stringify(err));
  //       return false;
  //     }
  //     console.log('File Uploaded', data);
  //     return true;
    
  //   });
  // }


}
